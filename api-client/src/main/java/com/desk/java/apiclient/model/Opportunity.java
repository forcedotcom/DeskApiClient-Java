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

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Created by Matt Kranzler on 12/28/15.
 * Copyright (c) 2015 Desk.com. All rights reserved.
 */
public class Opportunity implements Serializable {

    private static final long serialVersionUID = -6465935225027203799L;

    private int id;
    private String name;
    private int probability;
    private Date createdAt;
    private Date updatedAt;
    private BigDecimal amount;
    private int amountCents;
    private String amountFormat;
    private String currencyIsoCode;
    private String description;
    private String[] labels;
    private int[] labelIds;
    private Date closeDate;
    private Map<String, String> customFields;
    @SerializedName("_links")
    private OpportunityLinks links;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProbability() {
        return probability;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getAmountCents() {
        return amountCents;
    }

    public String getAmountFormat() {
        return amountFormat;
    }

    public String getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public String getDescription() {
        return description;
    }

    public String[] getLabels() {
        return labels;
    }

    public int[] getLabelIds() {
        return labelIds;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public Map<String, String> getCustomFields() {
        return customFields;
    }

    public OpportunityLinks getLinks() {
        return links;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Opportunity that = (Opportunity) o;

        return id == that.id;

    }

    @Override public int hashCode() {
        return id;
    }
}
