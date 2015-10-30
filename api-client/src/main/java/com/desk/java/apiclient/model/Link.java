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

package com.desk.java.apiclient.model;

import com.desk.java.apiclient.util.StringUtils;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Link implements Serializable {

    private static final long serialVersionUID = 1594593024595715789L;

    private String href;
    private int count;
    @SerializedName("class")
    private String className;

    public Link() {
    }

    public Link(String h) {
        this.href = h;
    }

    @NotNull
    public String getUrl() {
        return href;
    }

    public void setHref(String h) {
        this.href = h;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int c) {
        this.count = c;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String c) {
        this.className = c;
    }

    /**
     * Returns the integer value of the last path segment
     *
     * @return the integer value if exists and is numeric, 0 if it doesn't exist or is not numeric
     */
    public int getLinkId() {
        if (StringUtils.isEmpty(href)) {
            return 0;
        }
        String segment = StringUtils.getLastPathSegment(href);
        if (StringUtils.isEmpty(segment)
                || !StringUtils.isDigitsOnly(segment)) {
            return 0;
        }
        return Integer.valueOf(segment);
    }
}
