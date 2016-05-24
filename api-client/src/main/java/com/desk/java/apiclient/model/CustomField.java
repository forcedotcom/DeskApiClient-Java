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

import static com.desk.java.apiclient.model.CustomFieldType.COMPANY;
import static com.desk.java.apiclient.model.CustomFieldType.CUSTOMER;
import static com.desk.java.apiclient.model.CustomFieldType.TICKET;

/**
 * Created by sashi.bommakanty on 7/10/14.
 */
public class CustomField implements Serializable {

    private static final long serialVersionUID = 6359839085671163834L;

    private String name;
    private String label;
    private CustomFieldType type;
    private boolean active;
    private CustomFieldData data;

    public String getName() {
        return this.name;
    }

    public String getLabel() {
        return this.label;
    }

    public CustomFieldType getType() {
        return this.type;
    }

    public boolean typeIsCustomer() {
        return CUSTOMER.equals(type);
    }

    public boolean typeIsCompany() {
        return COMPANY.equals(type);
    }

    public boolean typeIsTicket() {
        return TICKET.equals(type);
    }

    public boolean getActive() {
        return this.active;
    }

    public CustomFieldData getData() {
        return this.data;
    }
}
