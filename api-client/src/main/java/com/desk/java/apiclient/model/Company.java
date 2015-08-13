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

import java.util.Collections;
import java.util.HashMap;

public class Company implements Serializable {

    private static final long serialVersionUID = 7792122326436126561L;

    private String name;
    private String[] domains;
    private CompanyLinks _links;
    private HashMap<String, String> customFields;

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    @NotNull
    public String[] getDomains() {
        return domains != null ? domains : new String[0];
    }

    public void setDomains(String[] d) {
        this.domains = d;
    }

    @NotNull
    public CompanyLinks getLinks() {
        return _links == null ? _links = new CompanyLinks() : _links;
    }

    public void setLinks(CompanyLinks l) {
        this._links = l;
    }

    @NotNull
    public HashMap<String, String> getCustomFields() {
        return customFields != null ? customFields : new HashMap<String, String>();
    }

    public void setCustomFields(HashMap<String, String> cf) {
        this.customFields = cf;
    }

    public String getDomainsForDisplay() {
        String domainsStr = "";
        String[] domains;
        if ((domains = getDomains()) != null) {
            for (String domain : domains) {
                domainsStr += domain + " ";
            }
        }

        return domainsStr;
    }
}
