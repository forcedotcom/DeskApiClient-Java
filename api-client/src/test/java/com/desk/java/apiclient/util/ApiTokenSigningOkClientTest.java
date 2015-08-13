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

package com.desk.java.apiclient.util;

import com.squareup.okhttp.OkHttpClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import retrofit.client.Header;
import retrofit.client.Request;

import java.util.List;

import static com.desk.java.apiclient.util.ApiTokenSigningOkClient.AUTHORIZATION_HEADER;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Matt Kranzler on 6/19/15.
 * Copyright (c) 2015 Desk.com. All rights reserved.
 */
@RunWith(MockitoJUnitRunner.class)
public class ApiTokenSigningOkClientTest {

    private static final String API_TOKEN = "api-token";

    @Mock
    OkHttpClient mockOkHttpClient;

    private ApiTokenSigningOkClient okClient;

    @Before
    public void setUp() {
        okClient = new ApiTokenSigningOkClient(mockOkHttpClient, API_TOKEN);
    }

    @Test
    public void authorizeRequestDoesAddAuthorizationHeader() throws Exception {
        Request unauthorizedRequest = new Request("GET", "https://test.desk.com", null, null);
        assertFalse(doesHaveAuthorizationHeader(unauthorizedRequest));
        Request authorizedRequest = okClient.authorizeRequest(unauthorizedRequest);
        assertTrue(doesHaveAuthorizationHeader(authorizedRequest));
    }

    private boolean doesHaveAuthorizationHeader(Request request) {
        List<Header> headers = request.getHeaders();
        for (Header header : headers) {
            if (AUTHORIZATION_HEADER.equals(header.getName())) {
                return true;
            }
        }
        return false;
    }
}