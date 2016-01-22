package com.desk.java.apiclient;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

import static com.desk.java.apiclient.DeskClientBuilder.AuthType.API_TOKEN;
import static com.desk.java.apiclient.DeskClientBuilder.AuthType.OAUTH;

/**
 * <p>
 *     Builder class to assist in create a desk client instance
 * </p>
 *
 * Created by Jerrell Mardis
 * Copyright (c) 2015 Desk.com. All rights reserved.
 */
public class DeskClientBuilder {

    public static final String OAUTH_REQUEST_URL = "/oauth/request_token";
    public static final String OAUTH_ACCESS_URL = "/oauth/access_token";
    public static final String OAUTH_AUTHORIZE_URL = "/oauth/authorize";
    public static final String PROTOCOL_CONNECT = "https://";
    public static final String API_BASE_PATH = "/api/v2/";

    public enum AuthType {
        OAUTH,
        API_TOKEN
    }

    Cache responseCache;
    List<Interceptor> applicationInterceptors;
    List<Interceptor> networkInterceptors;
    String hostname;
    String apiToken;
    String consumerKey;
    String consumerSecret;
    String accessToken;
    String accessTokenSecret;
    String userAgent;
    AuthType authType;
    List<CallAdapter.Factory> callAdapters;

    /**
     * Creates a builder to create a desk client that uses api token authentication
     * @param hostname the Desk site (ex: yourcompany.desk.com)
     * @param apiToken the api token to be used to authenticate
     */
    public DeskClientBuilder(@NotNull String hostname, @NotNull String apiToken) {
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
    public DeskClientBuilder(@NotNull String hostname, @NotNull String consumerKey, @NotNull String consumerSecret,
                   @NotNull String accessToken, @NotNull String accessTokenSecret) {
        this.hostname = hostname;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.accessToken = accessToken;
        this.accessTokenSecret = accessTokenSecret;
        this.authType = OAUTH;
    }

    /**
     * Sets the user agent header
     * @param userAgent the user agent
     * @return the builder instance
     */
    public DeskClientBuilder userAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    /**
     * Appends the provided interceptors to the end of the list of internal application interceptors.
     * @param interceptors the application interceptors
     * @return the builder instance
     */
    public DeskClientBuilder applicationInterceptors(List<Interceptor> interceptors) {
        this.applicationInterceptors = interceptors;
        return this;
    }

    /**
     * Appends the provided interceptors to the end of the list of internal network interceptors.
     * @param interceptors the application interceptors
     * @return the builder instance
     */
    public DeskClientBuilder networkInterceptors(List<Interceptor> interceptors) {
        this.networkInterceptors = interceptors;
        return this;
    }

    /**
     * Sets the response cache for HTTP responses for the {@link OkHttpClient} backed by the client
     * @param responseCache the response cache
     * @return the builder instance
     */
    public DeskClientBuilder responseCache(Cache responseCache) {
        this.responseCache = responseCache;
        return this;
    }

    /**
     * Adds the provided list of {@link CallAdapter.Factory}s to {@link Retrofit}.
     * @param callAdapters the list of {@link CallAdapter.Factory}s
     * @return the builder instance
     */
    public DeskClientBuilder callAdapters(List<CallAdapter.Factory> callAdapters) {
        this.callAdapters = callAdapters;
        return this;
    }
}
