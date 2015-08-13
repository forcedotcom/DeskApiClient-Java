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

public class OutboundMailbox implements Serializable {

    private static final long serialVersionUID = -5908829481620433364L;

    private int id;
    private String fromName;
    private String fromEmail;
    private boolean enabled;
    private Links _links;

    public int getId() {
        return id;
    }

    public String getFromName() {
        return this.fromName;
    }

    public void setFromName(String fn) {
        this.fromName = fn;
    }

    public String getFromEmail() {
        return this.fromEmail;
    }

    public void setFromEmail(String fe) {
        this.fromEmail = fe;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean e) {
        this.enabled = e;
    }

    @NotNull
    public Links getLinks() {
        return _links == null ? _links = new Links() : _links;
    }

    public void setLinks(Links l) {
        this._links = l;
    }

    @NotNull
    public Link getSelfLink() {
        return getLinks().getSelf();
    }

}
