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

import org.junit.Before;
import org.junit.Test;
import retrofit.client.Header;
import retrofit.client.Request;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Matt Kranzler on 6/22/15.
 * Copyright (c) 2015 Desk.com. All rights reserved.
 */
public class HttpRequestAdapterTest {

    private static final Header HEADER_1 = new Header("header1", "value1");
    private static final Header HEADER_2 = new Header("header2", "value2");
    private static final Header HEADER_3 = new Header("header3", "value3");
    private static final String CONTENT_TYPE = "application/json";
    private static final String METHOD = "GET";
    private static final String URL = "http://test.desk.com";

    private Request request;
    private HttpRequestAdapter requestAdapter;

    @Before
    public void setUp() {
        List<Header> headers = Arrays.asList(HEADER_1, HEADER_2, HEADER_3);
        request = new Request(METHOD, URL, headers, null);
        requestAdapter = new HttpRequestAdapter(request, CONTENT_TYPE);
    }

    @Test
    public void getAllHeadersReturnsAllHeaders() throws Exception {
        Map<String, String> allHeaders = requestAdapter.getAllHeaders();
        assertTrue(allHeaders.containsKey(HEADER_1.getName()));
        assertTrue(allHeaders.containsKey(HEADER_2.getName()));
        assertTrue(allHeaders.containsKey(HEADER_3.getName()));
    }

    @Test
    public void getContentTypeReturnsContentType() throws Exception {
        assertEquals(requestAdapter.getContentType(), CONTENT_TYPE);
    }

    @Test
    public void getHeaderReturnsHeader() throws Exception {
        assertEquals(requestAdapter.getHeader(HEADER_1.getName()), HEADER_1.getValue());
        assertEquals(requestAdapter.getHeader(HEADER_2.getName()), HEADER_2.getValue());
        assertEquals(requestAdapter.getHeader(HEADER_3.getName()), HEADER_3.getValue());
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
        Header newHeader = new Header("new_header", "new_value");
        assertEquals(requestAdapter.getHeader(newHeader.getName()), null);
        requestAdapter.setHeader(newHeader.getName(), newHeader.getValue());
        assertEquals(requestAdapter.getHeader(newHeader.getName()), newHeader.getValue());
    }

    @Test
    public void setRequestUrlSetsRequestUrl() throws Exception {
        String newUrl = "http://test2.desk.com";
        assertNotEquals(newUrl, requestAdapter.getRequestUrl());
        requestAdapter.setRequestUrl(newUrl);
        assertEquals(newUrl, requestAdapter.getRequestUrl());
    }

    @Test
    public void unwrapDoesReturnRequest() throws Exception {
        assertEquals(request, requestAdapter.unwrap());
    }
}