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


import com.desk.java.apiclient.service.CaseService;
import com.desk.java.apiclient.util.StringUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    public static final int NO_ID = 0;

    private static final long serialVersionUID = -5356300171602080000L;

    private int id;
    private String subject;
    private String body;
    private MessageDirection direction;
    private MessageStatus status;
    private CaseStatus ticketStatus;
    private String to;
    private String from;
    private String cc;
    private String bcc;
    private String type;
    private String hidden;
    private String isBestAnswer;
    private String hiddenAt;
    private String fromFacebookName;
    private String answersDisallowedAt;
    private String disallowCommunityAnswers;
    private String areAnswersDisallowed;
    private String clientType;
    private Date enteredAt;
    private Date createdAt;
    private Date updatedAt;
    private MessageEventType eventType;
    private MessageEmbedded _embedded;
    private MessageLinks _links;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public MessageDirection getDirection() {
        return this.direction;
    }

    public void setDirection(MessageDirection direction) {
        this.direction = direction;
    }

    public MessageStatus getStatus() {
        return this.status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getCc() {
        return this.cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return this.bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsBestAnswer() {
        return this.isBestAnswer;
    }

    public void setIsBestAnswer(String isBestAnswer) {
        this.isBestAnswer = isBestAnswer;
    }

    public boolean getIsBestAnswerBoolean() {
        return !StringUtils.isEmpty(this.isBestAnswer) && Boolean.parseBoolean(this.isBestAnswer);
    }

    public String getHidden() {
        return this.hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    public boolean getHiddenBoolean() {
        return !StringUtils.isEmpty(this.hidden) && Boolean.parseBoolean(this.hidden);
    }

    public String getHiddenAt() {
        return this.hiddenAt;
    }

    public void setHiddenAt(String hiddenAt) {
        this.hiddenAt = hiddenAt;
    }

    public String getAnswersDisallowedAt() {
        return this.answersDisallowedAt;
    }

    public void setAnswersDisallowedAt(String answersDisallowedAt) {
        this.answersDisallowedAt = answersDisallowedAt;
    }

    public String getDisallowCommunityAnswers() {
        return this.disallowCommunityAnswers;
    }

    public void setDisallowCommunityAnswers(String disallowCommunityAnswers) {
        this.disallowCommunityAnswers = disallowCommunityAnswers;
    }

    public String getAreAnswersDisallowed() {
        return this.areAnswersDisallowed;
    }

    public void setAreAnswersDisallowed(String areAnswersDisallowed) {
        this.areAnswersDisallowed = areAnswersDisallowed;
    }

    public String getFromFacebookName() {
        return this.fromFacebookName;
    }

    public void setFromFacebookName(String fromFacebookName) {
        this.fromFacebookName = fromFacebookName;
    }

    public String getClientType() {
        return this.clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public Date getEnteredAt() {
        return this.enteredAt;
    }

    public void setEnteredAt(Date enteredAt) {
        this.enteredAt = enteredAt;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public MessageEventType getEventType() {
        return eventType;
    }

    public void setEventType(MessageEventType eventType) {
        this.eventType = eventType;
    }

    @NotNull
    public MessageEmbedded getEmbedded() {
        return _embedded == null ? _embedded = new MessageEmbedded() : _embedded;
    }

    public void setEmbedded(MessageEmbedded embedded) {
        this._embedded = embedded;
    }

    @NotNull
    public MessageLinks getLinks() {
        return _links == null ? _links = new MessageLinks() : _links;
    }

    public void setLinks(MessageLinks links) {
        this._links = links;
    }

    public void setOutgoingStatus(CaseType caseType) {
        if (CaseType.PHONE.equals(caseType) || CaseType.QNA.equals(caseType)) {
            setStatus(MessageStatus.SENT);
            setEnteredAt(new Date());
        } else {
            setStatus(MessageStatus.PENDING);
        }
    }

    public String getClassName() {
        return getSelfLink().getClassName();
    }

    public MessageType getMessageType() {
        if (getClassName().equalsIgnoreCase(MessageType.NOTE.name())) {
            return MessageType.NOTE;
        }
        return MessageType.REPLY;
    }

    public CaseStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(CaseStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public boolean isReply() {
        return getSelfLinkUrl().contains(CaseService.REPLIES_URI);
    }

    @Nullable
    public User getUser() {
        return getEmbedded().getUser();
    }

    @NotNull
    public String getSelfLinkUrl() {
        return getLinks().getSelfUrl();
    }

    @NotNull
    public Link getSelfLink() {
        return getLinks().getSelf();
    }

    public int getSelfLinkId() {
        return getLinks().getSelfId();
    }

    @NotNull
    public Link getSentByLink() {
        return getLinks().getSentBy();
    }

    @NotNull
    public Link getEnteredByLink() {
        return getLinks().getEnteredBy();
    }

    @NotNull
    public Link getCreatedByLink() {
        return getLinks().getCreatedBy();
    }

    @NotNull
    public Link getUserLink() {
        return getLinks().getUser();
    }

    @NotNull
    public Link getOutboundMailboxLink() {
        return getLinks().getOutboundMailbox();
    }

    /**
     * Gets the id of the outbound mailbox or {@link #NO_ID} if there is no outbound mailbox
     * @return the id or {@link #NO_ID}
     */
    public int getOutboundMailboxId() {
        return getOutboundMailboxLink().getLinkId();
    }

    @NotNull
    public Link getCaseLink() {
        return getLinks().getCaseLink();
    }

    /**
     * Gets the id of the case or {@link #NO_ID} if there is no case
     * @return the id or {@link #NO_ID}
     */
    public int getCaseId() {
        return getCaseLink().getLinkId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message that = (Message) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    public enum MessageType {REPLY, NOTE, DRAFT, MESSAGE}
}
