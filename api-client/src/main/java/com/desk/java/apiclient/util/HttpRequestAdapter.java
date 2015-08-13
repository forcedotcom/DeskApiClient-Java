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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import oauth.signpost.http.HttpRequest;
import retrofit.client.Header;
import retrofit.client.Request;

public class HttpRequestAdapter implements HttpRequest {

	private static final String DEFAULT_CONTENT_TYPE = "application/json";
	
	private Request request;

	private String contentType;

	public HttpRequestAdapter(Request request) {
		this(request, request.getBody() != null ? request.getBody().mimeType() : DEFAULT_CONTENT_TYPE);
	}

	public HttpRequestAdapter(Request request, String contentType) {
		this.request = request;
		this.contentType = contentType;
	}
	
	@Override
	public Map<String, String> getAllHeaders() {
		HashMap<String, String> headers = new HashMap<String, String>(); 
		for(Header header : request.getHeaders()) {
			headers.put(header.getName(), header.getValue());
		}
		return headers;
	}

	@Override
	public String getContentType() {
		return contentType;
	}

	@Override
	public String getHeader(String key) {
		for(Header header : request.getHeaders()) {
			if(key.equals(header.getName())) {
				return header.getValue();
			}
		}
		return null;
	}

	@Override
	public InputStream getMessagePayload() throws IOException {
		final String contentType = getContentType();
		if (null != contentType && contentType.startsWith("application/x-www-form-urlencoded")) {
			long contentLength = request.getBody().length();
			ByteArrayOutputStream output = new ByteArrayOutputStream(Long.valueOf(contentLength)
					.intValue());
			request.getBody().writeTo(output);
			return new ByteArrayInputStream(output.toByteArray());
		}

		throw new UnsupportedOperationException("The content type" + (contentType != null ? " " +
					contentType : "") + " is not supported.");
	}

	@Override
	public String getMethod() {
		return request.getMethod();
	}

	@Override
	public String getRequestUrl() {
		return request.getUrl();
	}

	@Override
	public void setHeader(String key, String value) {
		ArrayList<Header> headers = new ArrayList<Header>();
		headers.addAll(request.getHeaders());
		headers.add(new Header(key, value));
		Request copy = new Request(request.getMethod(), request.getUrl(), headers, request.getBody());
		request = copy;
	}

	@Override
	public void setRequestUrl(String url) {
		Request copy = new Request(request.getMethod(), url, request.getHeaders(), request.getBody());
		request = copy;
	}

	@Override
	public Object unwrap() {
		return request;
	}

}