/*
 * Copyright (c) 2016, Salesforce.com, Inc.
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


import com.desk.java.apiclient.util.ISO8601DateAdapter;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Matt Kranzler on 5/4/15.
 * Copyright (c) 2016 Desk.com. All rights reserved.
 */
public class CaseLock implements Serializable {

    public static final TypeAdapter<CaseLock> TYPE_ADAPTER = new GsonTypeAdapter();

    private static final long serialVersionUID = 4453493194458243006L;

    private CaseLockLinks _links;
    private Date lockedUntil;

    private CaseLock(Date until, CaseLockLinks links) {
        this.lockedUntil = until;
        this._links = links;
    }

    public static CaseLock lock(Date until, Link userLink) {
        return new CaseLock(until, new CaseLockLinks(userLink));
    }

    public static CaseLock unlock() {
        return new CaseLock(null, new CaseLockLinks());
    }

    /**
     * Custom type adapter which serializes nulls so it updates the case properly to lock/unlock
     */
    private static class GsonTypeAdapter extends TypeAdapter<CaseLock> {

        private Gson mGson;

        public GsonTypeAdapter() {
            mGson = new GsonBuilder()
                    .registerTypeAdapter(Date.class, ISO8601DateAdapter.TYPE_ADAPTER)
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .serializeNulls().create();
        }

        @Override
        public void write(JsonWriter out, CaseLock value) throws IOException {
            mGson.toJson(value, CaseLock.class, out);
        }

        @Override
        public CaseLock read(JsonReader in) throws IOException {
            return mGson.fromJson(in, CaseLock.class);
        }
    }
}
