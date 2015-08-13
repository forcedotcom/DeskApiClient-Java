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

/**
 * Created by Matt Kranzler on 6/19/15.
 * Copyright (c) 2015 Desk.com. All rights reserved.
 */
public class Topic implements Serializable {

    private static final long serialVersionUID = 6754682995113092903L;

    private int id;
    private int position;
    private boolean allowQuestions;
    private Date createdAt;
    private Date updatedAt;
    private String description;
    private boolean inSupportCenter;
    private String name;
    private String locale;
    private TopicLinks _links;

    public int getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public boolean isAllowQuestions() {
        return allowQuestions;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public boolean isInSupportCenter() {
        return inSupportCenter;
    }

    public String getName() {
        return name;
    }

    public String getLocale() {
        return locale;
    }

    public TopicLinks get_links() {
        return _links;
    }
}
