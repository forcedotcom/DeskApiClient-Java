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


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

public class CaseLinks extends Links implements Serializable {

    private static final long serialVersionUID = 56094253911864534L;

    private Link replies;
    private Link message;
    private Link draft;
    private Link notes;
    private Link attachments;
    private Link lockedBy;
    private Link assignedGroup;
    private Link assignedUser;
    private Link macroPreview;
    private Link customer;
    private Link[] macros;

    @Nullable
    public Link getReplies() {
        return replies;
    }

    public void setReplies(@Nullable Link r) {
        this.replies = r;
    }

    @NotNull
    public Link getMessage() {
        return (message == null) ? new Link() : message;
    }

    public void setMessage(@Nullable Link m) {
        this.message = m;
    }

    @Nullable
    public Link getDraft() {
        return draft;
    }

    public void setDraft(@Nullable Link d) {
        this.draft = d;
    }

    @Nullable
    public Link getNotes() {
        return notes;
    }

    public void setNotes(@Nullable Link n) {
        this.notes = n;
    }

    @Nullable
    public Link getLockedBy() {
        return lockedBy;
    }

    public void setLockedBy(@Nullable Link u) {
        this.lockedBy = u;
    }

    @Nullable
    public Link getCustomer() {
        return customer;
    }

    public void setCustomer(@Nullable Link customer) {
        this.customer = customer;
    }

    @Nullable
    public Link getAssignedGroup() {
        return assignedGroup;
    }

    public void setAssignedGroup(@Nullable Link g) {
        this.assignedGroup = g;
    }

    @Nullable
    public Link getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(@Nullable Link u) {
        this.assignedUser = u;
    }

    @Nullable
    public Link getMacroPreview() {
        return macroPreview;
    }

    public void setMacroPreview(@Nullable Link mp) {
        this.macroPreview = mp;
    }

    @NotNull
    public Link[] getMacros() {
        return macros != null ? macros : new Link[0];
    }

    public void setMacros(@Nullable Link[] m) {
        this.macros = m;
    }

    @Nullable
    public Link getAttachments() {
        return attachments;
    }

    public void setAttachments(@Nullable Link a) {
        this.attachments = a;
    }

}
