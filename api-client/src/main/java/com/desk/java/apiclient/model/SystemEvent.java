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

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Matt Kranzler on 12/29/15.
 * Copyright (c) 2015 Desk.com. All rights reserved.
 */
public class SystemEvent implements Serializable {

    private static final long serialVersionUID = 5024045018751443965L;

    private long id;
    private EventType type;
    private String context;
    private Date createdAt;
    private List<SystemEventChange> changes;
    private SystemEventLinks _links;

    public long getId() {
        return id;
    }

    public EventType getType() {
        return type;
    }

    public String getContext() {
        return context;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public List<SystemEventChange> getChanges() {
        return changes;
    }

    public SystemEventLinks getLinks() {
        return _links;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SystemEvent systemEvent = (SystemEvent) o;

        return id == systemEvent.id;

    }

    @Override public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
