package com.desk.java.apiclient.util;

import com.desk.java.apiclient.DeskClient;

import static com.desk.java.apiclient.DeskClientBuilder.OAUTH_ACCESS_URL;
import static com.desk.java.apiclient.DeskClientBuilder.OAUTH_AUTHORIZE_URL;
import static com.desk.java.apiclient.DeskClientBuilder.OAUTH_REQUEST_URL;
import static com.desk.java.apiclient.DeskClientBuilder.PROTOCOL_CONNECT;

/**
 * <p>
 *     Utility class for {@link DeskClient}.
 * </p>
 *
 * Created by Jerrell Mardis
 * Copyright (c) 2016 Desk.com. All rights reserved.
 */
public final class DeskClientUtils {

    private DeskClientUtils() {
        // prevent instantiation
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

    /**
     * Builds a fully qualified URL based on the hostname and path provided.
     * @param hostname the Desk site
     * @param path the path
     * @return the fully qualified url
     */
    public static String buildUrl(String hostname, String path) {
        return buildBaseUrl(hostname) + path;
    }

    private static String buildBaseUrl(String hostname) {
        return PROTOCOL_CONNECT + hostname;
    }
}
