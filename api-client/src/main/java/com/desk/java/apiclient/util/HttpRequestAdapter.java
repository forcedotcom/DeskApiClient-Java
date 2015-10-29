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

import com.squareup.okhttp.Request;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import oauth.signpost.http.HttpRequest;
import okio.Buffer;

/**
 * <p>
 * A {@link HttpRequest} used by oauth-signpost to sign requests.
 * </p>
 * <p>
 * Created by Jerrell Mardis
 * Copyright (c) 2015 Desk.com. All rights reserved.
 */
public class HttpRequestAdapter implements HttpRequest {

    private static final String DEFAULT_CONTENT_TYPE = "application/json";

    private Request request;
    private String contentType = DEFAULT_CONTENT_TYPE;

    /**
     * Constructs a new {@code OkHttpRequestAdapter}.
     *
     * @param request the {@link Request} that is to be signed.
     */
    public HttpRequestAdapter(Request request) {
        this.request = request;
    }

    public HttpRequestAdapter(Request request, String contentType) {
        this.request = request;
        this.contentType = contentType;
    }

    @Override
    public Map<String, String> getAllHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        for (String key : request.headers().names()) {
            headers.put(key, request.header(key));
        }
        return headers;
    }

    @Override
    public String getContentType() {
        if (request.body() != null && request.body().contentType() != null) {
            return request.body().contentType().toString();
        }
        return contentType;
    }

    @Override
    public String getHeader(String key) {
        return request.header(key);
    }

    @Override
    public InputStream getMessagePayload() throws IOException {
        if (request.body() == null) {
            return null;
        }
        Buffer buf = new Buffer();
        request.body().writeTo(buf);
        return buf.inputStream();
    }

    @Override
    public String getMethod() {
        return request.method();
    }

    @Override
    public String getRequestUrl() {
        return request.urlString();
    }

    @Override
    public void setHeader(String key, String value) {
        request = request.newBuilder().header(key, value).build();
    }

    @Override
    public void setRequestUrl(String url) {
        request = request.newBuilder().url(url).build();
    }

    @Override
    public Object unwrap() {
        return request;
    }
}