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

import java.util.Date;
import java.util.HashMap;

import static com.desk.java.apiclient.model.Case.*;
import static org.junit.Assert.*;

/**
 * <p>
 *     Unit tests for {@link Case}
 * </p>
 *
 * Created by Matt Kranzler on 6/21/16.
 * Copyright (c) 2016 Desk.com. All rights reserved.
 */
@SuppressWarnings("ConstantConditions")
public class CaseTest {

    private Case c;

    @Before
    public void setUp() throws Exception {
        c = new Case();
    }

    @Test
    public void setIdDoesSetId() throws Exception {
        assertEquals(0, c.getId());
        c.setId(10);
        assertEquals(10, c.getId());
    }

    @Test
    public void setCustomerNameDoesSetCustomerName() throws Exception {
        assertNull(c.getCustomerName());
        c.setCustomerName("name");
        assertEquals("name", c.getCustomerName());
    }

    @Test
    public void setSubjectDoesSetSubject() throws Exception {
        assertNull(c.getSubject());
        c.setSubject("subject");
        assertEquals("subject", c.getSubject());
    }

    @Test
    public void setPriorityDoesSetPriority() throws Exception {
        assertNull(c.getPriority());
        c.setPriority("10");
        assertEquals("10", c.getPriority());
    }

    @Test
    public void setDescriptionDoesSetDescription() throws Exception {
        assertNull(c.getDescription());
        c.setDescription("desc");
        assertEquals("desc", c.getDescription());
    }

    @Test
    public void setBlurbDoesSetBlurb() throws Exception {
        assertNull(c.getBlurb());
        c.setBlurb("blurb");
        assertEquals("blurb", c.getBlurb());
    }

    @Test
    public void setStatusDoesSetStatus() throws Exception {
        assertNull(c.getStatus());
        c.setStatus(CaseStatus.NEW);
        assertEquals(CaseStatus.NEW, c.getStatus());
    }

    @Test
    public void setLockedUntilDoesSetLockedUntil() throws Exception {
        Date lockedUntil = new Date();
        assertNull(c.getLockedUntil());
        c.setLockedUntil(lockedUntil);
        assertEquals(lockedUntil, c.getLockedUntil());
    }

    @Test
    public void getLabelsDoesNotReturnNull() throws Exception {
        assertNotNull(c.getLabels());
        c.setLabels(null);
        assertNotNull(c.getLabels());
    }

    @Test
    public void setLabelsDoesSetLabels() throws Exception {
        String[] labels = new String[] {"one", "two", "three"};
        assertEquals(0, c.getLabels().length);
        c.setLabels(labels);
        assertEquals(3, c.getLabels().length);
        assertEquals("one", c.getLabels()[0]);
        assertEquals("two", c.getLabels()[1]);
        assertEquals("three", c.getLabels()[2]);
    }

    @Test
    public void getLabelIdsDoesNotReturnNull() throws Exception {
        assertNotNull(c.getLabelIds());
        c.setLabelIds(null);
        assertNotNull(c.getLabelIds());
    }

    @Test
    public void setLabelIdsDoesSetLabeIds() throws Exception {
        int[] labelIds = new int[] {1, 2, 3};
        assertEquals(0, c.getLabelIds().length);
        c.setLabelIds(labelIds);
        assertEquals(3, c.getLabelIds().length);
        assertEquals(1, c.getLabelIds()[0]);
        assertEquals(2, c.getLabelIds()[1]);
        assertEquals(3, c.getLabelIds()[2]);
    }

    @Test
    public void setLabelActionDoesSetLabelAction() throws Exception {
        assertNull(c.getLabelAction());
        c.setLabelAction(LabelAction.APPEND);
        assertEquals(LabelAction.APPEND, c.getLabelAction());
    }

    @Test
    public void getAgentNameDoesReturnNullWithNoAssignedUser() throws Exception {
        c.setAssignedUser(null);
        assertNull(c.getAgentName());
    }

    @Test
    public void getAgentNameDoesReturnNameWithAssignedUser() throws Exception {
        User agent = new User();
        agent.setName("Agenty McAgentface");
        c.setAssignedUser(agent);
        assertEquals("Agenty McAgentface", c.getAgentName());
    }

    @Test
    public void getGroupNameReturnsNullWithNoAssignedGroup() throws Exception {
        c.setAssignedGroup(null);
        assertNull(c.getGroupName());
    }

    @Test
    public void getGroupNameReturnsGroupWithAssignedGroup() throws Exception {
        Group group = new Group();
        group.setName("Groupy McGroupface");
        c.setAssignedGroup(group);
        assertEquals("Groupy McGroupface", c.getGroupName());
    }

    @Test
    public void getCustomFieldsDoesNotReturnNull() throws Exception {
        assertNotNull(c.getCustomFields());
        assertTrue(c.getCustomFields().isEmpty());
    }

    @Test
    public void setCustomFieldsDoesSetCustomFields() throws Exception {
        HashMap<String, String> customFields = new HashMap<>();
        customFields.put("key1", "value1");
        customFields.put("key2", "value2");
        customFields.put("key3", "value3");
        c.setCustomFields(customFields);
        assertEquals(3, c.getCustomFields().size());
        assertEquals("value1", c.getCustomFields().get("key1"));
        assertEquals("value2", c.getCustomFields().get("key2"));
        assertEquals("value3", c.getCustomFields().get("key3"));
    }

    @Test
    public void getEmbeddedDoesNotReturnNull() throws Exception {
        assertNotNull(c.getEmbedded());
        c.setEmbedded(null);
        assertNotNull(c.getEmbedded());
    }

    @Test
    public void setEmbeddedDoesSetEmbedded() throws Exception {
        CaseEmbedded caseEmbedded = new CaseEmbedded();
        Group group = new Group();
        group.setId(5);
        caseEmbedded.setAssignedGroup(group);
        User user = new User();
        user.setId(10);
        caseEmbedded.setAssignedUser(user);
        c.setEmbedded(caseEmbedded);
        assertEquals(5, c.getEmbedded().getAssignedGroup().getId());
        assertEquals(10, c.getEmbedded().getAssignedUser().getId());
    }

    @Test
    public void getLinksDoesNotReturnNull() throws Exception {
        assertNotNull(c.getLinks());
        c.setLinks(null);
        assertNotNull(c.getLinks());
    }

    @Test
    public void setLinksDoesSetLinks() throws Exception {
        CaseLinks links = new CaseLinks();
        Link groupLink = new Link("/groups/1");
        links.setAssignedGroup(groupLink);
        Link userLink = new Link("/users/1");
        links.setAssignedUser(userLink);
        c.setLinks(links);
        assertEquals("/groups/1", c.getLinks().getAssignedGroup().getUrl());
        assertEquals("/users/1", c.getLinks().getAssignedUser().getUrl());
    }

    @Test
    public void setReplyDoesSetReply() throws Exception {
        assertNull(c.getReply());
        Message reply = new Message();
        reply.setId(10);
        c.setReply(reply);
        assertEquals(10, c.getReply().getId());
    }

    @Test
    public void setCustomFieldDoesPutCustomField() throws Exception {
        assertTrue(c.getCustomFields().isEmpty());
        assertNull(c.getCustomFields().get("key"));
        c.setCustomField("key", "value");
        assertEquals("value", c.getCustomFields().get("key"));
    }

    @Test
    public void getMessageLinkUrlReturnsNullWhenNoMessageLink() throws Exception {
        assertNull(c.getMessageLinkUrl());
    }

    @Test
    public void getMessageLinkUrlDoesReturnMessageLinkUrl() throws Exception {
        Link message = new Link("/message/1");
        CaseLinks links = new CaseLinks();
        links.setMessage(message);
        c.setLinks(links);
        assertEquals("/message/1", c.getMessageLinkUrl());
    }

    @Test
    public void getMessageLinkDoesNotReturnNull() throws Exception {
        assertNotNull(c.getMessageLink());
    }

    @Test
    public void getMessageLinkDoesReturnMessageLink() throws Exception {
        Link message = new Link("/message/1");
        CaseLinks links = new CaseLinks();
        links.setMessage(message);
        c.setLinks(links);
        assertNotNull(c.getMessageLink());
        assertEquals(1, c.getMessageLink().getLinkId());
    }

    @Test
    public void getAttachmentLinksUrlDoesReturnNull() throws Exception {
        assertNull(c.getAttachmentsLinkUrl());
    }

    @Test
    public void getAttachmentsLinkUrlDoesReturnAttachmentsLinkUrl() throws Exception {
        Link attachments = new Link("/attachments");
        CaseLinks links = new CaseLinks();
        links.setAttachments(attachments);
        c.setLinks(links);
        assertEquals("/attachments", c.getAttachmentsLinkUrl());
    }

    @Test
    public void getAttachmentsLinkDoesReturnAttachmentsLink() throws Exception {
        Link attachments = new Link("/attachments");
        CaseLinks links = new CaseLinks();
        links.setAttachments(attachments);
        c.setLinks(links);
        assertEquals("/attachments", c.getAttachmentsLink().getUrl());
    }

    @Test
    public void getEmbeddedMessageDoesReturnNull() throws Exception {
        assertNull(c.getEmbeddedMessage());
    }

    @Test
    public void getEmbeddedMessageDoesReturnEmbeddedMessage() throws Exception {
        Message message = new Message();
        message.setId(20);
        CaseEmbedded caseEmbedded = new CaseEmbedded();
        caseEmbedded.setMessage(message);
        c.setEmbedded(caseEmbedded);
        assertNotNull(c.getEmbeddedMessage());
        assertEquals(20, c.getEmbeddedMessage().getId());
    }

    @Test
    public void getEmbeddedDraftDoesReturnNull() throws Exception {
        assertNull(c.getEmbeddedDraft());
    }

    @Test
    public void getEmbeddedDraftDoesReturnEmbeddedDraft() throws Exception {
        Message draft = new Message();
        draft.setId(25);
        CaseEmbedded caseEmbedded = new CaseEmbedded();
        caseEmbedded.setDraft(draft);
        c.setEmbedded(caseEmbedded);
        assertNotNull(c.getEmbeddedDraft());
        assertEquals(25, c.getEmbeddedDraft().getId());
    }

    @Test
    public void isQnaDoesReturnTrueForQnaType() throws Exception {
        c.setType(CaseType.QNA);
        assertTrue(c.isQna());
    }

    @Test
    public void isQnaDoesReturnFalseForNonQnaType() throws Exception {
        c.setType(CaseType.TWITTER);
        assertFalse(c.isQna());
    }

    @Test
    public void isEmailDoesReturnTrueForEmailType() throws Exception {
        c.setType(CaseType.EMAIL);
        assertTrue(c.isEmail());
    }

    @Test
    public void isEmailDoesReturnFalseForNonEmailType() throws Exception {
        c.setType(CaseType.TWITTER);
        assertFalse(c.isEmail());
    }

    @Test
    public void areAnswersDisallowedDoesReturnFalseWithNullEmbeddedMessage() throws Exception {
        assertNull(c.getEmbeddedMessage());
        assertFalse(c.areAnswersDisallowed());
    }

    @Test
    public void areAnswersDisallowedDoesReturnTrue() throws Exception {
        Message message = new Message();
        message.setAreAnswersDisallowed("true");
        CaseEmbedded embedded = new CaseEmbedded();
        embedded.setMessage(message);
        c.setEmbedded(embedded);
        assertTrue(c.areAnswersDisallowed());
    }

    @Test
    public void getAssignedUserLinkUrlDoesReturnNull() throws Exception {
        assertNull(c.getAssignedUserLinkUrl());
    }

    @Test
    public void getAssignedUserLinkUrlDoesReturnAssignedUserLinkUrl() throws Exception {
        Link user = new Link("/users/5");
        CaseLinks links = new CaseLinks();
        links.setAssignedUser(user);
        c.setLinks(links);
        assertEquals("/users/5", c.getAssignedUserLinkUrl());
    }

    @Test
    public void getAssignedUserLinkDoesReturnAssignedUserLink() throws Exception {
        Link user = new Link("/users/5");
        CaseLinks links = new CaseLinks();
        links.setAssignedUser(user);
        c.setLinks(links);
        assertNotNull(c.getAssignedUserLink());
        assertEquals(5, c.getAssignedUserLink().getLinkId());
    }

    @Test
    public void setAssignedUserLinkDoesSetAssignedUserLink() throws Exception {
        Link user = new Link("/users/5");
        c.setAssignedUserLink(user);
        assertNotNull(c.getAssignedUserLink());
        assertEquals(5, c.getAssignedUserLink().getLinkId());
    }

    @Test
    public void getAssignedUserIdDoesReturnNoId() throws Exception {
        assertEquals(NO_ID, c.getAssignedUserId());
    }

    @Test
    public void getAssignedUserIdDoesReturnId() throws Exception {
        Link user = new Link("/users/5");
        c.setAssignedUserLink(user);
        assertEquals(5, c.getAssignedUserId());
    }

    @Test
    public void getAssignedGroupLinkUrlDoesReturnNull() throws Exception {
        assertNull(c.getAssignedGroupLinkUrl());
    }

    @Test
    public void getAssignedGroupLinkUrlDoesReturnAssignedGroupLinkUrl() throws Exception {
        Link group = new Link("/groups/50");
        CaseLinks links = new CaseLinks();
        links.setAssignedGroup(group);
        c.setLinks(links);
        assertEquals("/groups/50", c.getAssignedGroupLinkUrl());
    }

    @Test
    public void getAssignedGroupLinkDoesReturnAssignedGroupLink() throws Exception {
        Link group = new Link("/groups/50");
        CaseLinks links = new CaseLinks();
        links.setAssignedGroup(group);
        c.setLinks(links);
        assertNotNull(c.getAssignedGroupLink());
        assertEquals(50, c.getAssignedGroupLink().getLinkId());
    }

    @Test
    public void setAssignedGroupLinkDoesSetAssignedGroupLink() throws Exception {
        Link group = new Link("/groups/55");
        c.setAssignedGroupLink(group);
        assertNotNull(c.getAssignedGroupLink());
        assertEquals(55, c.getAssignedGroupLink().getLinkId());
    }

    @Test
    public void getAssignedGroupIdDoesReturnNoId() throws Exception {
        assertEquals(NO_ID, c.getAssignedGroupId());
    }

    @Test
    public void getAssignedGroupIdDoesReturnAssignedGroupId() throws Exception {
        Link group = new Link("/groups/55");
        c.setAssignedGroupLink(group);
        assertEquals(55, c.getAssignedGroupId());
    }

    @Test
    public void getCustomerLinkDoesReturnCustomerLink() throws Exception {
        Link customer = new Link("/customers/100");
        CaseLinks links = new CaseLinks();
        links.setCustomer(customer);
        c.setLinks(links);
        assertNotNull(c.getCustomerLink());
        assertEquals(100, c.getCustomerLink().getLinkId());
    }

    @Test
    public void getCustomerIdDoesReturnNoId() throws Exception {
        assertEquals(NO_ID, c.getCustomerId());
    }

    @Test
    public void getCustomerIdDoesReturnCustomerId() throws Exception {
        Link customer = new Link("/customers/105");
        CaseLinks links = new CaseLinks();
        links.setCustomer(customer);
        c.setLinks(links);
        assertEquals(105, c.getCustomerId());
    }

    @Test
    public void getCustomerDoesReturnNull() throws Exception {
        assertNull(c.getCustomer());
    }

    @Test
    public void getCustomerDoesReturnEmbeddedCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setId(110);
        CaseEmbedded embedded = new CaseEmbedded();
        embedded.setCustomer(customer);
        c.setEmbedded(embedded);
        assertNotNull(c.getCustomer());
        assertEquals(110, c.getCustomer().getId());
    }

    @Test
    public void getCustomerCompanyIdDoesReturnNoId() throws Exception {
        assertNull(c.getCustomer());
        assertEquals(NO_ID, c.getCustomerCompanyId());
    }

    @Test
    public void getCustomerCompanyIdDoesReturnCustomerCompanyId() throws Exception {
        Customer customer = new Customer();
        customer.setId(110);
        Link company = new Link("/companies/12");
        CustomerLinks links = new CustomerLinks();
        links.setCompany(company);
        customer.setLinks(links);
        CaseEmbedded embedded = new CaseEmbedded();
        embedded.setCustomer(customer);
        c.setEmbedded(embedded);
        assertEquals(12, c.getCustomerCompanyId());
    }

    @Test
    public void getAssignedUserDoesReturnNull() throws Exception {
        assertNull(c.getAssignedUser());
    }

    @Test
    public void getAssignedUserDoesReturnAssignedUser() throws Exception {
        User user = new User();
        user.setId(13);
        CaseEmbedded embedded = new CaseEmbedded();
        embedded.setAssignedUser(user);
        c.setEmbedded(embedded);
        assertNotNull(c.getAssignedUser());
        assertEquals(13, c.getAssignedUser().getId());
    }

    @Test
    public void getAssignedGroupDoesReturnNull() throws Exception {
        assertNull(c.getAssignedGroup());
    }

    @Test
    public void getAssignedGroupDoesReturnAssignedGroup() throws Exception {
        Group group = new Group();
        group.setId(14);
        CaseEmbedded embedded = new CaseEmbedded();
        embedded.setAssignedGroup(group);
        c.setEmbedded(embedded);
        assertNotNull(c.getAssignedGroup());
        assertEquals(14, c.getAssignedGroup().getId());
    }

    @Test
    public void getLockedByLinkUrlDoesReturnLockedByLinkUrl() throws Exception {
        Link lockedBy = new Link("/users/111");
        CaseLinks links = new CaseLinks();
        links.setLockedBy(lockedBy);
        c.setLinks(links);
        assertEquals("/users/111", c.getLockedByLinkUrl());
    }

    @Test
    public void getLockedByLinkDoesReturnLockedByLink() throws Exception {
        Link lockedBy = new Link("/users/112");
        CaseLinks links = new CaseLinks();
        links.setLockedBy(lockedBy);
        c.setLinks(links);
        assertNotNull(c.getLockedByLink());
        assertEquals(112, c.getLockedByLink().getLinkId());
    }

    @Test
    public void setLockedByLinkDoesSetLockedByLink() throws Exception {
        Link lockedBy = new Link("/users/113");
        c.setLockedByLink(lockedBy);
        assertEquals(113, c.getLockedByLink().getLinkId());
    }

    @Test
    public void equalsDoesReturnTrueIfSameId() throws Exception {
        Case caseOne = new Case();
        caseOne.setId(1);
        Case caseTwo = new Case();
        caseTwo.setId(1);
        assertTrue(caseOne.equals(caseTwo));
        assertTrue(caseTwo.equals(caseOne));
    }

    @Test
    public void equalsDoesReturnFalseIfDifferentId() throws Exception {
        Case caseOne = new Case();
        caseOne.setId(1);
        Case caseTwo = new Case();
        caseTwo.setId(2);
        assertFalse(caseOne.equals(caseTwo));
        assertFalse(caseTwo.equals(caseOne));
    }

    @Test
    public void hashCodeDoesEqualId() throws Exception {
        Case caseOne = new Case();
        caseOne.setId(1);
        assertEquals(1, caseOne.hashCode());
    }
}