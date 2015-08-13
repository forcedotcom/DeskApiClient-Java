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
import retrofit.client.Header;
import retrofit.client.OkClient;
import retrofit.client.Request;
import retrofit.client.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a helper class, a {@code retrofit.client.OkClient} to use
 * when building your {@code retrofit.RestAdapter}.
 */
public class ApiTokenSigningOkClient extends OkClient {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER = "Bearer";

    private final Header authorizationHeader;

    public ApiTokenSigningOkClient(OkHttpClient client, String apiToken) {
        super(client);
        authorizationHeader = new Header(AUTHORIZATION_HEADER, BEARER + " " + apiToken);
    }

    @Override
    public Response execute(Request request) throws IOException {
        return super.execute(authorizeRequest(request));
    }

    /**
     * Creates a new request copying over all values from existing request and adds an authorization header.
     * @param request the request
     * @return the authorized request
     */
    Request authorizeRequest(Request request) {
        List<Header> headers = new ArrayList<Header>(request.getHeaders());
        headers.add(authorizationHeader);
        return new Request(
                request.getMethod(),
                request.getUrl(),
                headers,
                request.getBody()
        );
    }
}