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

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Matt Kranzler on 6/22/15.
 * Copyright (c) 2015 Desk.com. All rights reserved.
 */
public class HttpRequestAdapterTest {

    private static final String[] HEADER_1 = new String[] {"header1", "value1"};
    private static final String[] HEADER_2 = new String[] {"header2", "value2"};
    private static final String[] HEADER_3 = new String[] {"header3", "value3"};
    private static final String CONTENT_TYPE = "application/json";
    private static final String METHOD = "GET";
    private static final String URL = "http://test.desk.com/";

    private Request request;
    private HttpRequestAdapter requestAdapter;

    @Before
    public void setUp() {
        request = new Request.Builder()
                .url(URL)
                .addHeader("header1", "value1")
                .addHeader("header2", "value2")
                .addHeader("header3", "value3")
                .build();
        requestAdapter = new HttpRequestAdapter(request);
    }

    @Test
    public void getAllHeadersReturnsAllHeaders() throws Exception {
        Map<String, String> allHeaders = requestAdapter.getAllHeaders();
        assertTrue(allHeaders.containsKey(HEADER_1[0]));
        assertTrue(allHeaders.containsKey(HEADER_2[0]));
        assertTrue(allHeaders.containsKey(HEADER_3[0]));
    }

    @Test
    public void getContentTypeReturnsContentType() throws Exception {
        assertEquals(CONTENT_TYPE, requestAdapter.getContentType());
    }

    @Test
    public void getHeaderReturnsHeader() throws Exception {
        assertEquals(requestAdapter.getHeader(HEADER_1[0]), HEADER_1[1]);
        assertEquals(requestAdapter.getHeader(HEADER_2[0]), HEADER_2[1]);
        assertEquals(requestAdapter.getHeader(HEADER_3[0]), HEADER_3[1]);
    }

    @Test
    public void getMethodReturnsMethod() throws Exception {
        assertEquals(METHOD, requestAdapter.getMethod());
    }

    @Test
    public void getRequestUrl() throws Exception {
        assertEquals(URL, requestAdapter.getRequestUrl());
    }

    @Test
    public void setHeaderDoesSetHeader() throws Exception {
        assertEquals(requestAdapter.getHeader("new_header"), null);
        requestAdapter.setHeader("new_header", "new_value");
        assertEquals(requestAdapter.getHeader("new_header"), "new_value");
    }

    @Test
    public void setRequestUrlSetsRequestUrl() throws Exception {
        String newUrl = "http://test2.desk.com/";
        assertNotEquals(newUrl, requestAdapter.getRequestUrl());
        requestAdapter.setRequestUrl(newUrl);
        assertEquals(newUrl, requestAdapter.getRequestUrl());
    }

    @Test
    public void unwrapDoesReturnRequest() throws Exception {
        assertEquals(request, requestAdapter.unwrap());
    }
}