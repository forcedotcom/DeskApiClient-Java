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

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * <p>
 * Unit tests for {@link Message}
 * </p>
 *
 * Created by Matt Kranzler on 6/28/16.
 * Copyright (c) 2016 Desk.com. All rights reserved.
 */
public class MessageTest {

    private Message message;

    @Before
    public void setUp() throws Exception {
        message = new Message();
    }

    @Test
    public void getIsBestAnswerBooleanDoesReturnTrue() throws Exception {
        message.setIsBestAnswer("true");
        assertEquals(true, message.getIsBestAnswerBoolean());
        message.setIsBestAnswer("TRUE");
        assertEquals(true, message.getIsBestAnswerBoolean());
        message.setIsBestAnswer("True");
        assertEquals(true, message.getIsBestAnswerBoolean());
    }

    @Test
    public void getIsBestAnswerBooleanDoesReturnFalse() throws Exception {
        message.setIsBestAnswer("false");
        assertEquals(false, message.getIsBestAnswerBoolean());
        message.setIsBestAnswer("FALSE");
        assertEquals(false, message.getIsBestAnswerBoolean());
        message.setIsBestAnswer("False");
        assertEquals(false, message.getIsBestAnswerBoolean());
        message.setIsBestAnswer("");
        assertEquals(false, message.getIsBestAnswerBoolean());
    }

    @Test
    public void getHiddenBooleanDoesReturnTrue() throws Exception {
        message.setHidden("true");
        assertEquals(true, message.getHiddenBoolean());
        message.setHidden("TRUE");
        assertEquals(true, message.getHiddenBoolean());
        message.setHidden("True");
        assertEquals(true, message.getHiddenBoolean());
    }

    @Test
    public void getHiddenBooleanDoesReturnFalse() throws Exception {
        message.setHidden("false");
        assertEquals(false, message.getHiddenBoolean());
        message.setHidden("FALSE");
        assertEquals(false, message.getHiddenBoolean());
        message.setHidden("False");
        assertEquals(false, message.getHiddenBoolean());
        message.setHidden("");
        assertEquals(false, message.getHiddenBoolean());
    }

    @Test
    public void getEmbeddedDoesNotReturnNull() throws Exception {
        assertNotNull(message.getEmbedded());
        message.setEmbedded(null);
        assertNotNull(message.getEmbedded());
    }

    @Test
    public void getLinksDoeNotReturnNull() throws Exception {
        assertNotNull(message.getLinks());
        message.setLinks(null);
        assertNotNull(message.getLinks());
    }

    @Test
    public void setOutgoingStatusDoesSetStatusToSentWhenPhone() throws Exception {
        message.setOutgoingStatus(CaseType.PHONE);
        assertEquals(MessageStatus.SENT, message.getStatus());
    }

    @Test
    public void setOutgoingStatusDoesSetStatusToSentWhenQNA() throws Exception {
        message.setOutgoingStatus(CaseType.QNA);
        assertEquals(MessageStatus.SENT, message.getStatus());
    }

    @Test
    public void setOutgoingStatusDoesSetStatusToPending() throws Exception {
        message.setOutgoingStatus(CaseType.EMAIL);
        assertEquals(MessageStatus.PENDING, message.getStatus());
    }

    @Test
    public void getMessageTypeDoesReturnNote() throws Exception {
        Link self = mock(Link.class);
        when(self.getClassName()).thenReturn(Message.MessageType.NOTE.name());
        MessageLinks links = mock(MessageLinks.class);
        when(links.getSelf()).thenReturn(self);
        message.setLinks(links);
        assertEquals(Message.MessageType.NOTE, message.getMessageType());
    }

    @Test
    public void getMessageTypeDoesReturnReply() throws Exception {
        Link self = mock(Link.class);
        when(self.getClassName()).thenReturn(Message.MessageType.REPLY.name());
        MessageLinks links = mock(MessageLinks.class);
        when(links.getSelf()).thenReturn(self);
        message.setLinks(links);
        assertEquals(Message.MessageType.REPLY, message.getMessageType());
    }

    @Test
    public void isReplyReturnsTrueWhenContainsRepliesUri() throws Exception {
        MessageLinks links = mock(MessageLinks.class);
        when(links.getSelfUrl()).thenReturn("/replies/5");
        message.setLinks(links);
        assertTrue(message.isReply());
    }

    @Test
    public void isReplyReturnsFalseWhenDoesNotContainRepliesUri() throws Exception {
        MessageLinks links = mock(MessageLinks.class);
        when(links.getSelfUrl()).thenReturn("/message/5");
        message.setLinks(links);
        assertFalse(message.isReply());
    }
}