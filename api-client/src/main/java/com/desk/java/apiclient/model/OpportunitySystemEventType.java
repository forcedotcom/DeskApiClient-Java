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

import com.google.gson.annotations.SerializedName;

/**
 * Created by Matt Kranzler on 12/29/15.
 * Copyright (c) 2016 Desk.com. All rights reserved.
 */
public enum OpportunitySystemEventType {

    @SerializedName("opportunity_created")
    OPPORTUNITY_CREATED,

    @SerializedName("opportunity_updated")
    OPPORTUNITY_UPDATED,

    @SerializedName("opportunity_closed")
    OPPORTUNITY_CLOSED,

    @SerializedName("opportunity_time_rule")
    OPPORTUNITY_TIME_RULE,

    @SerializedName("opportunity_note_created")
    OPPORTUNITY_NOTE_CREATED,

    @SerializedName("opportunity_call_created")
    OPPORTUNITY_CALL_CREATED,

    @SerializedName("opportunity_task_created")
    OPPORTUNITY_TASK_CREATED,

    @SerializedName("opportunity_event_created")
    OPPORTUNITY_EVENT_CREATED,

    @SerializedName("opportunity_email_created")
    OPPORTUNITY_EMAIL_CREATED,

    @SerializedName("opportunity_attachment_created")
    OPPORTUNITY_ATTACHMENT_CREATED,

    @SerializedName("opportunity_rule_applied")
    OPPORTUNITY_RULE_APPLIED,

    @SerializedName("opportunity_item_active")
    OPPORTUNITY_ITEM_ACTIVE,

    @SerializedName("opportunity_item_available")
    OPPORTUNITY_ITEM_AVAILABLE

}
