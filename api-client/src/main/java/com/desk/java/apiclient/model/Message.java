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


import com.desk.java.apiclient.service.CaseService;
import com.desk.java.apiclient.util.StringUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    public static final int NO_ID = 0;

    private static final long serialVersionUID = 7987793767800204017L;

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
    private boolean isBestAnswer;
    private String hiddenAt;
    private String fromFacebookName;
    private String answersDisallowedAt;
    private String disallowCommunityAnswers;
    private String areAnswersDisallowed;
    private String clientType;
    private Date enteredAt;
    private Date createdAt;
    private Date updatedAt;
    private MessageEmbedded _embedded;
    private MessageLinks _links;

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getSubject() {
        return (this.subject == null) ? "" : this.subject;
    }

    public void setSubject(String s) {
        this.subject = s;
    }

    public String getBody() {
        return (this.body == null) ? "" : this.body;
    }

    public void setBody(String b) {
        this.body = b;
    }

    public MessageDirection getDirection() {
        return this.direction;
    }

    public void setDirection(MessageDirection d) {
        this.direction = d;
    }

    public MessageStatus getStatus() {
        return this.status;
    }

    public void setStatus(MessageStatus s) {
        this.status = s;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String t) {
        this.to = t;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String f) {
        this.from = f;
    }

    public String getCc() {
        return this.cc;
    }

    public void setCc(String c) {
        this.cc = c;
    }

    public String getBcc() {
        return this.bcc;
    }

    public void setBcc(String b) {
        this.bcc = b;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String t) {
        this.type = t;
    }

    public boolean isBestAnswer() {
        return isBestAnswer;
    }

    public void setIsBestAnswer(boolean isBestAnswer) {
        this.isBestAnswer = isBestAnswer;
    }

    public String getHidden() {
        return this.hidden;
    }

    public void setHidden(String h) {
        this.hidden = h;
    }

    public boolean getHiddenBoolean() {
        return (StringUtils.isEmpty(this.hidden)) ?
                false : Boolean.parseBoolean(this.hidden);
    }

    public String getHiddenAt() {
        return this.hiddenAt;
    }

    public void setHiddenAt(String ha) {
        this.hiddenAt = ha;
    }

    public String getAnswersDisallowedAt() {
        return this.answersDisallowedAt;
    }

    public void setAnswersDisallowedAt(String ad) {
        this.answersDisallowedAt = ad;
    }

    public String getDisallowCommunityAnswers() {
        return this.disallowCommunityAnswers;
    }

    public void setDisallowCommunityAnswers(String dca) {
        this.disallowCommunityAnswers = dca;
    }

    public String getAreAnswersDisallowed() {
        return this.areAnswersDisallowed;
    }

    public void setAreAnswersDisallowed(String dca) {
        this.areAnswersDisallowed = dca;
    }

    public String getFromFacebookName() {
        return this.fromFacebookName;
    }

    public void setFromFacebookName(String f) {
        this.fromFacebookName = f;
    }

    public String getClientType() {
        return this.clientType;
    }

    public void setClientType(String ct) {
        this.clientType = ct;
    }

    public Date getEnteredAt() {
        return this.enteredAt;
    }

    public void setEnteredAt(Date ea) {
        this.enteredAt = ea;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date ca) {
        this.createdAt = ca;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date ua) {
        this.updatedAt = ua;
    }

    @NotNull
    public MessageEmbedded getEmbedded() {
        return _embedded == null ? _embedded = new MessageEmbedded() : _embedded;
    }

    public void setEmbedded(MessageEmbedded m) {
        this._embedded = m;
    }

    @NotNull
    public MessageLinks getLinks() {
        return _links == null ? _links = new MessageLinks() : _links;
    }

    public void setLinks(MessageLinks l) {
        this._links = l;
    }

    public void setOutgoingStatus(CaseType caseType) {
        if (CaseType.PHONE.equals(caseType) || CaseType.QNA.equals(caseType)) {
            setStatus(MessageStatus.SENT);
            setEnteredAt(new Date());
        } else {
            setStatus(MessageStatus.PENDING);
        }
    }

    /**
     * Tries to find a user link url for the message first by looking at the sent by link,
     * then the entered by link and finally the user link
     * @return the user link if one is found, an empty string if none found
     */
    @NotNull
    public String findUserLinkUrl() {
        String userLink = "";
        if (getSentByLink() != null) {
            userLink = getSentByLink().getUrl();
        } else if (getEnteredByLink() != null) {
            userLink = getEnteredByLink().getUrl();
        } else if (getUserLink() != null) {
            userLink = getUserLink().getUrl();
        }
        return userLink;
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

    @Nullable
    public Link getSentByLink() {
        return getLinks().getSentBy();
    }

    @Nullable
    public Link getEnteredByLink() {
        return getLinks().getEnteredBy();
    }

    @Nullable
    public Link getUserLink() {
        return getLinks().getUser();
    }

    @Nullable
    public Link getOutboundMailboxLink() {
        return getLinks().getOutboundMailbox();
    }

    public CaseStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(CaseStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    /**
     * Gets the id of the outbound mailbox or {@link #NO_ID} if there is no outbound mailbox
     * @return the id or {@link #NO_ID}
     */
    public int getOutboundMailboxId() {
        if (getOutboundMailboxLink() == null) {
            return NO_ID;
        }
        return getOutboundMailboxLink().getLinkId();
    }

    @Nullable
    public Link getCaseLink() {
        return getLinks().getCaseLink();
    }

    /**
     * Gets the id of the case or {@link #NO_ID} if there is no case
     * @return the id or {@link #NO_ID}
     */
    public int getCaseId() {
        if (getCaseLink() == null) {
            return NO_ID;
        }
        return getCaseLink().getLinkId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message that = (Message) o;

        return id == that.id;

    }

    public boolean isReply() {
        return getSelfLinkUrl().contains(CaseService.REPLIES_URI);
    }

    @Override
    public int hashCode() {
        return id;
    }

    public enum MessageType {REPLY, NOTE, DRAFT, MESSAGE}
}
