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

import org.junit.Before;
import org.junit.Test;
import retrofit.RestAdapter;

import java.net.URI;

import static com.desk.java.apiclient.DeskClient.*;
import static org.junit.Assert.*;

/**
 * Created by Matt Kranzler on 6/18/15.
 * Copyright (c) 2015 Desk.com. All rights reserved.
 */
public class DeskClientTest {

    private static final String TEST_HOST_NAME = "test.test.com";

    private DeskClient oAuthDeskClient;
    private DeskClient apiTokenDeskClient;

    @Before
    public void setup() {
        oAuthDeskClient = new DeskClient.Builder(
                TEST_HOST_NAME,
                "1234",
                "5678",
                "1234",
                "5678"
        ).create();
        apiTokenDeskClient = new DeskClient.Builder(
                TEST_HOST_NAME,
                "1234"
        ).create();
    }

    @Test
    public void setIsDebugSetsLogLevelToFull() throws Exception {
        oAuthDeskClient.setIsDebug(true);
        assertEquals(RestAdapter.LogLevel.FULL, oAuthDeskClient.getRestAdapter().getLogLevel());
    }

    @Test
    public void setIsDebugSetsLogLevelToNone() throws Exception {
        oAuthDeskClient.setIsDebug(false);
        assertEquals(RestAdapter.LogLevel.NONE, oAuthDeskClient.getRestAdapter().getLogLevel());
    }

    @Test
    public void getHostNameReturnsHostName() throws Exception {
        assertEquals(TEST_HOST_NAME, oAuthDeskClient.getHostname());
    }

    @Test
    public void signUrlSignsUrl() throws Exception {
        final String url = "http://test.desk.com";
        String signed = oAuthDeskClient.signUrl(url);
        assertNotEquals(url, signed);
        URI uri = new URI(signed);
        assertTrue(uri.getQuery().contains("oauth_signature"));
    }

    @Test
    public void signUrlDoesNotSignUrl() throws Exception {
        final String url = "http://test.desk.com";
        String signed = apiTokenDeskClient.signUrl(url);
        assertEquals(url, signed);
    }

    @Test
    public void usersIsNotNull() throws Exception {
        assertNotNull(apiTokenDeskClient.users());
    }

    @Test
    public void sitesIsNotNull() throws Exception {
        assertNotNull(apiTokenDeskClient.sites());
    }

    @Test
    public void labelsIsNotNull() throws Exception {
        assertNotNull(apiTokenDeskClient.labels());
    }

    @Test
    public void customFieldsIsNotNull() throws Exception {
        assertNotNull(apiTokenDeskClient.customFields());
    }

    @Test
    public void groupsIsNotNull() throws Exception {
        assertNotNull(apiTokenDeskClient.groups());
    }

    @Test
    public void macrosIsNotNull() throws Exception {
        assertNotNull(apiTokenDeskClient.macros());
    }

    @Test
    public void outboundMailboxesIsNotNull() throws Exception {
        assertNotNull(apiTokenDeskClient.outboundMailboxes());
    }

    @Test
    public void filtersIsNotNull() throws Exception {
        assertNotNull(apiTokenDeskClient.filters());
    }

    @Test
    public void casesIsNotNull() throws Exception {
        assertNotNull(apiTokenDeskClient.cases());
    }

    @Test
    public void companiesIsNotNull() throws Exception {
        assertNotNull(apiTokenDeskClient.companies());
    }

    @Test
    public void customersIsNotNull() throws Exception {
        assertNotNull(apiTokenDeskClient.customers());
    }

    @Test
    public void permissionsIsNotNull() throws Exception {
        assertNotNull(apiTokenDeskClient.permissions());
    }

    @Test
    public void twitterUsersIsNotNull() throws Exception {
        assertNotNull(apiTokenDeskClient.twitterUsers());
    }

    @Test
    public void oAuthRequestUrlReturnsCorrectUrl() throws Exception {
        final String requestUrl = DeskClient.oAuthRequestUrl(TEST_HOST_NAME);
        assertEquals(PROTOCOL_CONNECT + TEST_HOST_NAME + OAUTH_REQUEST_URL, requestUrl);
    }

    @Test
    public void oAuthAccessUrlReturnsCorrectUrl() throws Exception {
        final String accessUrl = DeskClient.oAuthAccessUrl(TEST_HOST_NAME);
        assertEquals(PROTOCOL_CONNECT + TEST_HOST_NAME + OAUTH_ACCESS_URL, accessUrl);
    }

    @Test
    public void oAuthAuthorizeUrlReturnsCorrectUrl() throws Exception {
        final String authorizeUrl = DeskClient.oAuthAuthorizeUrl(TEST_HOST_NAME);
        assertEquals(PROTOCOL_CONNECT + TEST_HOST_NAME + OAUTH_AUTHORIZE_URL, authorizeUrl);
    }

    @Test
    public void getUrlReturnsCorrectUrl() throws Exception {
        assertEquals(PROTOCOL_CONNECT + TEST_HOST_NAME + "/testpath", apiTokenDeskClient.getUrl("/testpath"));
    }
}