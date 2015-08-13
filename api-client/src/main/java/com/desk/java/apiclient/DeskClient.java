/*
 * Copyright (c) 2015, Salesforce.com, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 *
 *    Redistributions of source code must retain the above copyright notice, this list of conditions and the
 *    following disclaimer.
 *
 *    Redistributions in binary form must reproduce the above copyright notice, this list of conditions and
 *    the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 *    Neither the name of Salesforce.com, Inc. nor the names of its contributors may be used to endorse or
 *    promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package com.desk.java.apiclient;

import com.desk.java.apiclient.model.CaseLock;
import com.desk.java.apiclient.service.*;
import com.desk.java.apiclient.util.ApiTokenSigningOkClient;
import com.desk.java.apiclient.util.ISO8601DateAdapter;
import com.desk.java.apiclient.util.OAuthSigningOkClient;
import com.desk.java.apiclient.util.RetrofitHttpOAuthConsumer;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.jetbrains.annotations.NotNull;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

import java.io.IOException;
import java.util.Date;

import static com.desk.java.apiclient.DeskClient.AuthType.API_TOKEN;
import static com.desk.java.apiclient.DeskClient.AuthType.OAUTH;

/**
 * <p>Client which interfaces with the Desk API</p>
 *
 * Created by Matt Kranzler on 4/27/15.
 * Copyright (c) 2015 Desk.com. All rights reserved.
 */
public class DeskClient {

    public enum AuthType {
        OAUTH,
        API_TOKEN
    }

    // oauth urls
    public static final String OAUTH_REQUEST_URL = "/oauth/request_token";
    public static final String OAUTH_ACCESS_URL = "/oauth/access_token";
    public static final String OAUTH_AUTHORIZE_URL = "/oauth/authorize";

    public static final String PROTOCOL_CONNECT = "https://";
    public static final String API_BASE_PATH = "/api/v2";

    private final String hostname;
    private final String apiToken;
    private final String consumerKey;
    private final String consumerSecret;
    private final String accessToken;
    private final String accessTokenSecret;
    private final Cache responseCache;
    private final RequestInterceptor requestInterceptor;
    private final AuthType authType;

    private RestAdapter restAdapter;
    private RetrofitHttpOAuthConsumer oAuthConsumer;

    private UserService userService;
    private SiteService siteService;
    private LabelService labelService;
    private CustomFieldsService customFieldsService;
    private GroupService groupService;
    private MacroService macroService;
    private OutboundMailboxService outboundMailboxService;
    private FilterService filterService;
    private CaseService caseService;
    private CompanyService companyService;
    private CustomerService customerService;
    private PermissionService permissionService;
    private TwitterUserService twitterUserService;
    private TopicService topicService;
    private ArticleService articleService;
    private InboundMailboxService inboundMailboxService;

    private boolean isDebug;

    private DeskClient(Builder builder) {
        this.authType = builder.authType;
        this.apiToken = builder.apiToken;
        this.hostname = builder.hostname;
        this.consumerKey = builder.consumerKey;
        this.consumerSecret = builder.consumerSecret;
        this.accessToken = builder.accessToken;
        this.accessTokenSecret = builder.accessTokenSecret;
        this.responseCache = builder.responseCache;
        this.requestInterceptor = builder.requestInterceptor;
        this.isDebug = builder.isDebug;
        this.oAuthConsumer = createOAuthConsumer();
        this.restAdapter = createRestAdapter();
    }

    /**
     * Set the {@link retrofit.RestAdapter} log level.
     *
     * @param isDebug If true, the log level is set to {@link retrofit.RestAdapter.LogLevel#FULL}. Otherwise {@link
     * retrofit.RestAdapter.LogLevel#NONE}.
     */
    public void setIsDebug(boolean isDebug) {
        this.isDebug = isDebug;
        if (restAdapter != null) {
            restAdapter.setLogLevel(isDebug ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE);
        }
    }

    /**
     * Returns the current hostname for this client
     * @return the hostname
     */
    public String getHostname() {
        return this.hostname;
    }

    /**
     * Gets the url with the path provided.
     * @param path the path
     * @return the url
     */
    public String getUrl(String path) {
        return buildUrl(hostname, path);
    }

    /**
     * Signs the provided URL with OAuth credentials
     * @param url the url to sign
     * @return the signed url
     * @throws OAuthCommunicationException if an error occurs communicating with the OAuth server
     * @throws OAuthExpectationFailedException if consumer key or consumer secret are not set in the OAuthConsumer
     * @throws OAuthMessageSignerException if an error occurs while signing the url
     */
    public String signUrl(String url) throws OAuthCommunicationException, OAuthExpectationFailedException, OAuthMessageSignerException {
        if (OAUTH == authType) {
            return oAuthConsumer.sign(url);
        } else {
            return url;
        }
    }

    /**
     * Clears all cached response objects from the response cache if one exists.
     */
    public void clearResponseCache() {
        if (responseCache != null) {
            try {
                responseCache.evictAll();
            } catch (IOException e) {
                // ignore
            }
        }
    }

    /**
     * Get the Desk User service
     * @return the default Desk User service
     */
    @NotNull
    public UserService users() {
        if (userService == null) {
            userService = restAdapter.create(UserService.class);
        }
        return userService;
    }

    /**
     * Get the Desk Site service
     * @return the default Desk Site service
     */
    @NotNull
    public SiteService sites() {
        if (siteService == null) {
            siteService = restAdapter.create(SiteService.class);
        }
        return siteService;
    }

    /**
     * Get the Desk Label service
     * @return the default Desk Label service
     */
    @NotNull
    public LabelService labels() {
        if (labelService == null) {
            labelService = restAdapter.create(LabelService.class);
        }
        return labelService;
    }

    /**
     * Get the Desk Custom Fields service
     * @return the default Desk Custom Fields service
     */
    @NotNull
    public CustomFieldsService customFields() {
        if (customFieldsService == null) {
            customFieldsService = restAdapter.create(CustomFieldsService.class);
        }
        return customFieldsService;
    }

    /**
     * Get the Desk Group service
     * @return the default Desk Group service
     */
    @NotNull
    public GroupService groups() {
        if (groupService == null) {
            groupService = restAdapter.create(GroupService.class);
        }
        return groupService;
    }

    /**
     * Get the Desk Macro service
     * @return the default Desk Macro service
     */
    @NotNull
    public MacroService macros() {
        if (macroService == null) {
            macroService = restAdapter.create(MacroService.class);
        }
        return macroService;
    }

    /**
     * Get the Desk Outbound Mailbox service
     * @return the default Desk Outbound Mailbox service
     */
    @NotNull
    public OutboundMailboxService outboundMailboxes() {
        if (outboundMailboxService == null) {
            outboundMailboxService = restAdapter.create(OutboundMailboxService.class);
        }
        return outboundMailboxService;
    }

    /**
     * Get the Desk Filter service
     * @return the default Desk Filter service
     */
    @NotNull
    public FilterService filters() {
        if (filterService == null) {
            filterService = restAdapter.create(FilterService.class);
        }
        return filterService;
    }

    /**
     * Get the Desk Case service
     * @return the default Desk Case service
     */
    @NotNull
    public CaseService cases() {
        if (caseService == null) {
            caseService = restAdapter.create(CaseService.class);
        }
        return caseService;
    }

    /**
     * Get the Desk Company service
     * @return the default Desk Company service
     */
    @NotNull
    public CompanyService companies() {
        if (companyService == null) {
            companyService = restAdapter.create(CompanyService.class);
        }
        return companyService;
    }

    /**
     * Get the Desk Customer service
     * @return the default Desk Customer service
     */
    @NotNull
    public CustomerService customers() {
        if (customerService == null) {
            customerService = restAdapter.create(CustomerService.class);
        }
        return customerService;
    }

    /**
     * Get the Desk Permission service
     * @return the default Desk Permission service
     */
    @NotNull
    public PermissionService permissions() {
        if (permissionService == null) {
            permissionService = restAdapter.create(PermissionService.class);
        }
        return permissionService;
    }

    /**
     * Get the Desk Twitter User service
     * @return the default Desk Twitter User service
     */
    @NotNull
    public TwitterUserService twitterUsers() {
        if (twitterUserService == null) {
            twitterUserService = restAdapter.create(TwitterUserService.class);
        }
        return twitterUserService;
    }

    /**
     * Get the Desk Topic service
     * @return the default Desk Topic service
     */
    @NotNull
    public TopicService topics() {
        if (topicService == null) {
            topicService = restAdapter.create(TopicService.class);
        }
        return topicService;
    }

    /**
     * Get the Desk Article service
     * @return the default Desk Article service
     */
    @NotNull
    public ArticleService articles() {
        if (articleService == null) {
            articleService = restAdapter.create(ArticleService.class);
        }
        return articleService;
    }

    /**
     * Get the Desk Inbound Mailbox service
     * @return the default Desk Inbound Mailbox service
     */
    @NotNull
    public InboundMailboxService inboundMailboxes() {
        if (inboundMailboxService == null) {
            inboundMailboxService = restAdapter.create(InboundMailboxService.class);
        }
        return inboundMailboxService;
    }

    /**
     * Returns the OAuth request url for the given Desk site
     * @param hostname the Desk site
     * @return the OAuth request url
     */
    public static String oAuthRequestUrl(String hostname) {
        return buildUrl(hostname, OAUTH_REQUEST_URL);
    }

    /**
     * Returns the OAuth access url for the given Desk site
     * @param hostname the Desk site
     * @return the OAuth access url
     */
    public static String oAuthAccessUrl(String hostname) {
        return buildUrl(hostname, OAUTH_ACCESS_URL);
    }

    /**
     * Returns the OAuth authorization url for the given Desk site
     * @param hostname the Desk site
     * @return the OAuth authorization url
     */
    public static String oAuthAuthorizeUrl(String hostname) {
        return buildUrl(hostname, OAUTH_AUTHORIZE_URL);
    }

    private static String buildBaseUrl(String hostname) {
        return PROTOCOL_CONNECT + hostname;
    }

    private static String buildUrl(String hostname, String path) {
        return buildBaseUrl(hostname) + path;
    }

    /**
     * Package access for testing purposes
     */
    RestAdapter getRestAdapter() {
        return restAdapter;
    }

    private RestAdapter createRestAdapter() {
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(getUrl(API_BASE_PATH))
                .setClient(createOkClient())
                .setConverter(new GsonConverter(createGson()));

        // if debug is set turn on logging
        if (isDebug) {
            builder.setLogLevel(RestAdapter.LogLevel.FULL);
        }

        // add the request interceptor of we have one
        if (requestInterceptor != null) {
            builder.setRequestInterceptor(requestInterceptor);
        }

        return builder.build();
    }

    private OkClient createOkClient() {
        switch (authType) {

            case OAUTH:
                if (oAuthConsumer == null) {
                    throw new IllegalStateException("a RetrofitHttpOAuthConsumer must be created before creating OKClient");
                }
                return new OAuthSigningOkClient(createHttpClient(), oAuthConsumer);
            case API_TOKEN:
                return new ApiTokenSigningOkClient(createHttpClient(), apiToken);
            default:
                throw new IllegalStateException("AuthType " + authType + " isn't supported.");
        }
    }

    private Gson createGson() {
        return new GsonBuilder()
                .registerTypeAdapter(Date.class, new ISO8601DateAdapter())
                .registerTypeAdapter(CaseLock.class, CaseLock.TYPE_ADAPTER)
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    private OkHttpClient createHttpClient() {
        OkHttpClient httpClient = new OkHttpClient();

        // if we have response cache let's use it!
        if (responseCache != null) {
            httpClient.setCache(responseCache);
        }

        return httpClient;
    }

    private RetrofitHttpOAuthConsumer createOAuthConsumer() {
        if (OAUTH == authType) {
            RetrofitHttpOAuthConsumer consumer = new RetrofitHttpOAuthConsumer(consumerKey, consumerSecret);
            consumer.setTokenWithSecret(accessToken, accessTokenSecret);
            return consumer;
        } else {
            return null;
        }
    }

    /**
     * Builder class to assist in create a desk client instance
     */
    public static class Builder {

        private Cache responseCache;
        private RequestInterceptor requestInterceptor;
        private String hostname;
        private String apiToken;
        private String consumerKey;
        private String consumerSecret;
        private String accessToken;
        private String accessTokenSecret;
        private AuthType authType;
        private boolean isDebug;

        /**
         * Creates a builder to create a desk client that uses api token authentication
         * @param hostname the Desk site (ex: yourcompany.desk.com)
         * @param apiToken the api token to be used to authenticate
         */
        public Builder(@NotNull String hostname, @NotNull String apiToken) {
            this.hostname = hostname;
            this.apiToken = apiToken;
            this.authType = API_TOKEN;
        }

        /**
         * Creates a builder to create a client that uses OAuth 1.0 authentication
         * @param hostname the Desk site (ex: yourcompany.desk.com)
         * @param consumerKey the Desk API consumer key for OAuth
         * @param consumerSecret the Desk API consumer secret for OAuth
         * @param accessToken the oauth access token
         * @param accessTokenSecret the oauth access token secret
         */
        public Builder(@NotNull String hostname, @NotNull String consumerKey, @NotNull String consumerSecret,
                       @NotNull String accessToken, @NotNull String accessTokenSecret) {
            this.hostname = hostname;
            this.consumerKey = consumerKey;
            this.consumerSecret = consumerSecret;
            this.accessToken = accessToken;
            this.accessTokenSecret = accessTokenSecret;
            this.authType = OAUTH;
        }

        /**
         * Sets the request interceptor for the {@link RestAdapter} backed by the client
         * @param requestInterceptor the request interceptor
         * @return the builder instance
         */
        public Builder requestInterceptor(RequestInterceptor requestInterceptor) {
            this.requestInterceptor = requestInterceptor;
            return this;
        }

        /**
         * Sets the response cache for HTTP responses for the {@link OkClient} backed by the client
         * @param responseCache the response cache
         * @return the builder instance
         */
        public Builder responseCache(Cache responseCache) {
            this.responseCache = responseCache;
            return this;
        }

        /**
         * Set the {@link retrofit.RestAdapter} log level.
         *
         * @param isDebug If true, the log level is set to {@link retrofit.RestAdapter.LogLevel#FULL}. Otherwise {@link
         * retrofit.RestAdapter.LogLevel#NONE}.
         * @return the builder instance
         */
        public Builder isDebug(boolean isDebug) {
            this.isDebug = isDebug;
            return this;
        }

        /**
         * Creates the desk client
         * @return the desk client
         */
        public DeskClient create() {
            return new DeskClient(this);
        }
    }
}
