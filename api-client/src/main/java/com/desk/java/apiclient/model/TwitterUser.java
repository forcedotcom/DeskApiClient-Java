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
import org.jetbrains.annotations.NotNull;

public class TwitterUser implements Serializable {

    private static final long serialVersionUID = -3929305699776740086L;

    private String handle;
    private String imageUrl;
    private String followersCount;
    private String createdAt;
    private String updatedAt;
    private TwitterUserLinks _links;
    private boolean verified;

    public String getHandle() {
        return "@" + this.handle;
    }

    public void setHandle(String h) {
        this.handle = h;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String iu) {
        this.imageUrl = iu;
    }

    public String getFollowersCount() {
        return this.followersCount;
    }

    public void setFollowersCount(String fc) {
        this.followersCount = fc;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String ca) {
        this.createdAt = ca;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String ua) {
        this.updatedAt = ua;
    }

    public boolean getVerified() {
        return this.verified;
    }

    public void setVerified(boolean v) {
        this.verified = v;
    }

    @NotNull
    public TwitterUserLinks getLinks() {
        return _links == null ? _links = new TwitterUserLinks() : _links;
    }

    public void setLinks(TwitterUserLinks links) {
        this._links = links;
    }

}
