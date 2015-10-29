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

import com.desk.java.apiclient.service.ArticleService;
import com.desk.java.apiclient.service.CaseService;
import com.desk.java.apiclient.service.CompanyService;
import com.desk.java.apiclient.service.CustomFieldsService;
import com.desk.java.apiclient.service.CustomerService;
import com.desk.java.apiclient.service.FilterService;
import com.desk.java.apiclient.service.GroupService;
import com.desk.java.apiclient.service.InboundMailboxService;
import com.desk.java.apiclient.service.LabelService;
import com.desk.java.apiclient.service.MacroService;
import com.desk.java.apiclient.service.OutboundMailboxService;
import com.desk.java.apiclient.service.PermissionService;
import com.desk.java.apiclient.service.SiteService;
import com.desk.java.apiclient.service.TopicService;
import com.desk.java.apiclient.service.TwitterUserService;
import com.desk.java.apiclient.service.UserService;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import retrofit.CallAdapter.Factory;
import retrofit.Retrofit;

import static com.desk.java.apiclient.DeskClient.AuthType.API_TOKEN;
import static com.desk.java.apiclient.DeskClient.AuthType.OAUTH;

/**
 * <p>
 *     Client which interfaces with the Desk API.
 * </p>
 *
 * Created by Matt Kranzler on 4/27/15.
 * Copyright (c) 2015 Desk.com. All rights reserved.
 */
public interface DeskClient {

    String OAUTH_REQUEST_URL = "/oauth/request_token";
    String OAUTH_ACCESS_URL = "/oauth/access_token";
    String OAUTH_AUTHORIZE_URL = "/oauth/authorize";
    String PROTOCOL_CONNECT = "https://";
    String API_BASE_PATH = "/api/v2/";

    enum AuthType {
        OAUTH,
        API_TOKEN
    }

    /**
     * Gets the hostname
     * @return the hostname
     */
    String getHostname();

    /**
     * Gets the url with the path provided.
     * @param path the path
     * @return the url
     */
    String getUrl(String path);

    /**
     * Signs the provided URL with OAuth credentials
     * @param url the url to sign
     * @return the signed url
     * @throws OAuthCommunicationException if an error occurs communicating with the OAuth server
     * @throws OAuthExpectationFailedException if consumer key or consumer secret are not set in the OAuthConsumer
     * @throws OAuthMessageSignerException if an error occurs while signing the url
     */
    String signUrl(String url) throws OAuthCommunicationException, OAuthExpectationFailedException, OAuthMessageSignerException;

    /**
     * Clears all cached response objects from the response cache if one exists.
     */
    void clearResponseCache();

    /**
     * Get the Desk User service
     *
     * @return the default Desk User service
     */
    @NotNull
    UserService users();

    /**
     * Get the Desk Site service
     *
     * @return the default Desk Site service
     */
    @NotNull
    SiteService sites();

    /**
     * Get the Desk Label service
     *
     * @return the default Desk Label service
     */
    @NotNull
    LabelService labels();

    /**
     * Get the Desk Custom Fields service
     *
     * @return the default Desk Custom Fields service
     */
    @NotNull
    CustomFieldsService customFields();

    /**
     * Get the Desk Group service
     *
     * @return the default Desk Group service
     */
    @NotNull
    GroupService groups();

    /**
     * Get the Desk Macro service
     *
     * @return the default Desk Macro service
     */
    @NotNull
    MacroService macros();

    /**
     * Get the Desk Outbound Mailbox service
     *
     * @return the default Desk Outbound Mailbox service
     */
    @NotNull
    OutboundMailboxService outboundMailboxes();

    /**
     * Get the Desk Filter service
     *
     * @return the default Desk Filter service
     */
    @NotNull
    FilterService filters();

    /**
     * Get the Desk Case service
     *
     * @return the default Desk Case service
     */
    @NotNull
    CaseService cases();

    /**
     * Get the Desk Company service
     *
     * @return the default Desk Company service
     */
    @NotNull
    CompanyService companies();

    /**
     * Get the Desk Customer service
     *
     * @return the default Desk Customer service
     */
    @NotNull
    CustomerService customers();

    /**
     * Get the Desk Permission service
     *
     * @return the default Desk Permission service
     */
    @NotNull
    PermissionService permissions();

    /**
     * Get the Desk Twitter User service
     *
     * @return the default Desk Twitter User service
     */
    @NotNull
    TwitterUserService twitterUsers();

    /**
     * Get the Desk Topic service
     *
     * @return the default Desk Topic service
     */
    @NotNull
    TopicService topics();

    /**
     * Get the Desk Article service
     *
     * @return the default Desk Article service
     */
    @NotNull
    ArticleService articles();

    /**
     * Get the Desk Inbound Mailbox service
     *
     * @return the default Desk Inbound Mailbox service
     */
    @NotNull
    InboundMailboxService inboundMailboxes();

    /**
     * Builder class to assist in create a desk client instance
     */
    class Builder {

        Cache responseCache;
        List<Interceptor> applicationInterceptors;
        List<Interceptor> networkInterceptors;
        String hostname;
        String apiToken;
        String consumerKey;
        String consumerSecret;
        String accessToken;
        String accessTokenSecret;
        AuthType authType;
        List<Factory> callAdapters;

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
         * Appends the provided interceptors to the end of the list of internal application interceptors.
         * @param interceptors the application interceptors
         * @return the builder instance
         */
        public Builder applicationInterceptors(List<Interceptor> interceptors) {
            this.applicationInterceptors = interceptors;
            return this;
        }

        /**
         * Appends the provided interceptors to the end of the list of internal network interceptors.
         * @param interceptors the application interceptors
         * @return the builder instance
         */
        public Builder networkInterceptors(List<Interceptor> interceptors) {
            this.networkInterceptors = interceptors;
            return this;
        }

        /**
         * Sets the response cache for HTTP responses for the {@link OkHttpClient} backed by the client
         * @param responseCache the response cache
         * @return the builder instance
         */
        public Builder responseCache(Cache responseCache) {
            this.responseCache = responseCache;
            return this;
        }

        /**
         * Adds the provided list of {@link Factory}s to {@link Retrofit}.
         * @param callAdapters the list of {@link Factory}s
         * @return the builder instance
         */
        public Builder callAdapters(List<Factory> callAdapters) {
            this.callAdapters = callAdapters;
            return this;
        }

        /**
         * Creates the desk client
         * @return the desk client
         */
        public DeskClient create() {
            return new DefaultDeskClient(this);
        }
    }
}
