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


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

public class Filter implements Serializable {

    public static final int NONE = 0;

    private static final long serialVersionUID = 92239016721005170L;

    private int id;
    private String name;
    private int position;
    private boolean active;
    private String sortField;
    private String sortDirection;
    private FilterLinks _links;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int p) {
        this.position = p;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean a) {
        this.active = a;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sf) {
        this.sortField = sf;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sd) {
        this.sortDirection = sd;
    }

    @NotNull
    public FilterLinks getLinks() {
        return _links == null ? _links = new FilterLinks() : _links;
    }

    public void setLinks(FilterLinks l) {
        this._links = l;
    }

    /**
     * Gets the cases count or {#NONE} if there are no cases
     * @return the cases count or {#NONE}
     */
    public int getCaseCount() {
        if (getCasesLink() == null) {
            return NONE;
        }
        return getCasesLink().getCount();
    }

    /**
     * Gets the cases link
     * @return the cases link or null
     */
    @Nullable
    public Link getCasesLink() {
        return getLinks().getCases();
    }

    /**
     * Gets the companies count or {#NONE} if there are no companies
     * @return the companies count or {#NONE}
     */
    public int getCompanyCount() {
        if (getCompaniesLink() == null) {
            return NONE;
        }
        return getCompaniesLink().getCount();
    }

    /**
     * Gets the companies link
     * @return the companies link or null
     */
    @Nullable
    public Link getCompaniesLink() {
        return getLinks().getCompanies();
    }

    /**
     * Gets the customer count or {#NONE} if there are no customers
     * @return the customer count or {#NONE}
     */
    public int getCustomerCount() {
        if (getCustomersLink() == null) {
            return NONE;
        }
        return getCustomersLink().getCount();
    }

    /**
     * Gets the customers link
     * @return the customers link or null
     */
    @Nullable
    public Link getCustomersLink() {
        return getLinks().getCustomers();
    }

    /**
     * Gets the opportunities link
     * @return the opportunities link or null
     */
    @Nullable
    public Link getOpportunitiesLink() {
        return getLinks().getOpportunities();
    }

    /**
     * Gets the opportunity count or {#NONE} if there are no opportunities
     * @return the opportunity count or {#NONE}
     */
    public int getOpportunityCount() {
        if (getOpportunitiesLink() == null) {
            return NONE;
        }
        return getOpportunitiesLink().getCount();
    }

}
