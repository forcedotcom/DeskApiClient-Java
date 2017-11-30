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

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Matt Kranzler on 6/25/15.
 * Copyright (c) 2016 Desk.com. All rights reserved.
 */
public class Article implements Serializable {

    private static final long serialVersionUID = 530764642092575583L;

    private long id;
    private String locale;
    private String subject;
    private String body;
    private String bodyEmail;
    private boolean bodyEmailAuto;
    private String bodyChat;
    private boolean bodyChatAuto;
    private String bodyWebCallback;
    private boolean bodyWebCallbackAuto;
    private String bodyTwitter;
    private boolean bodyTwitterAuto;
    private String bodyQna;
    private boolean bodyQnaAuto;
    private String bodyPhone;
    private boolean bodyPhoneAuto;
    private String bodyFacebook;
    private boolean bodyFacebookAuto;
    private int rating;
    private int ratingCount;
    private int ratingScore;
    private String keywords;
    private int position;
    private String quickcode;
    private Date publishAt;
    private Date updatedAt;
    private Date createdAt;
    private boolean inSupportCenter;
    private String internalNotes;
    private String publicUrl;
    private ArticleLinks _links;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public String getLocale() {
        return locale;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getBodyEmail() {
        return bodyEmail;
    }

    public boolean isBodyEmailAuto() {
        return bodyEmailAuto;
    }

    public String getBodyChat() {
        return bodyChat;
    }

    public boolean isBodyChatAuto() {
        return bodyChatAuto;
    }

    public String getBodyWebCallback() {
        return bodyWebCallback;
    }

    public boolean isBodyWebCallbackAuto() {
        return bodyWebCallbackAuto;
    }

    public String getBodyTwitter() {
        return bodyTwitter;
    }

    public boolean isBodyTwitterAuto() {
        return bodyTwitterAuto;
    }

    public String getBodyQna() {
        return bodyQna;
    }

    public boolean isBodyQnaAuto() {
        return bodyQnaAuto;
    }

    public String getBodyPhone() {
        return bodyPhone;
    }

    public boolean isBodyPhoneAuto() {
        return bodyPhoneAuto;
    }

    public String getBodyFacebook() {
        return bodyFacebook;
    }

    public boolean isBodyFacebookAuto() {
        return bodyFacebookAuto;
    }

    public int getRating() {
        return rating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public int getRatingScore() {
        return ratingScore;
    }

    public String getKeywords() {
        return keywords;
    }

    public int getPosition() {
        return position;
    }

    public String getQuickcode() {
        return quickcode;
    }

    public Date getPublishAt() {
        return publishAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public boolean isInSupportCenter() {
        return inSupportCenter;
    }

    public String getInternalNotes() {
        return internalNotes;
    }

    public String getPublicUrl() {
        return publicUrl;
    }

    public ArticleLinks getLinks() {
        return _links;
    }
}

