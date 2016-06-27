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

    private static final long serialVersionUID = 6289826179576172039L;

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

    @NotNull
    public Link getReplies() {
        return replies == null ? new Link() : replies;
    }

    public void setReplies(@Nullable Link replies) {
        this.replies = replies;
    }

    @NotNull
    public Link getMessage() {
        return message == null ? new Link() : message;
    }

    public void setMessage(@Nullable Link message) {
        this.message = message;
    }

    @NotNull
    public Link getDraft() {
        return draft == null ? new Link() : draft;
    }

    public void setDraft(@Nullable Link draft) {
        this.draft = draft;
    }

    @NotNull
    public Link getNotes() {
        return notes == null ? new Link() : notes;
    }

    public void setNotes(@Nullable Link notes) {
        this.notes = notes;
    }

    @NotNull
    public Link getLockedBy() {
        return lockedBy == null ? new Link() : lockedBy;
    }

    public void setLockedBy(@Nullable Link lockedBy) {
        this.lockedBy = lockedBy;
    }

    @NotNull
    public Link getCustomer() {
        return customer == null ? new Link() : customer;
    }

    public void setCustomer(@Nullable Link customer) {
        this.customer = customer;
    }

    @NotNull
    public Link getAssignedGroup() {
        return assignedGroup == null ? new Link() : assignedGroup;
    }

    public void setAssignedGroup(@Nullable Link assignedGroup) {
        this.assignedGroup = assignedGroup;
    }

    @NotNull
    public Link getAssignedUser() {
        return assignedUser == null ? new Link() : assignedUser;
    }

    public void setAssignedUser(@Nullable Link assignedUser) {
        this.assignedUser = assignedUser;
    }

    @NotNull
    public Link getMacroPreview() {
        return macroPreview == null ? new Link() : macroPreview;
    }

    public void setMacroPreview(@Nullable Link macroPreview) {
        this.macroPreview = macroPreview;
    }

    @NotNull
    public Link[] getMacros() {
        return macros != null ? macros : new Link[0];
    }

    public void setMacros(@Nullable Link[] macros) {
        this.macros = macros;
    }

    @NotNull
    public Link getAttachments() {
        return attachments == null ? new Link() : attachments;
    }

    public void setAttachments(@Nullable Link attachments) {
        this.attachments = attachments;
    }

}
