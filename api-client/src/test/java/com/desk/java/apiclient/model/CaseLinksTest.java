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

/**
 * <p>
 * Unit tests for {@link CaseLinks}
 * </p>
 * <p>
 * Created by Matt Kranzler on 6/27/16.
 * Copyright (c) 2016 Desk.com. All rights reserved.
 */
public class CaseLinksTest {

    private CaseLinks links;

    @Before
    public void setUp() throws Exception {
        links = new CaseLinks();
    }

    @Test
    public void getRepliesDoesNotReturnNull() throws Exception {
        assertNotNull(links.getReplies());
        links.setReplies(null);
        assertNotNull(links.getReplies());
    }

    @Test
    public void getMessageDoesNotReturnNull() throws Exception {
        assertNotNull(links.getMessage());
        links.setMessage(null);
        assertNotNull(links.getMessage());
    }

    @Test
    public void getDraftDoesNotReturnNull() throws Exception {
        assertNotNull(links.getDraft());
        links.setDraft(null);
        assertNotNull(links.getDraft());
    }

    @Test
    public void getNotesDoesNotReturnNull() throws Exception {
        assertNotNull(links.getNotes());
        links.setNotes(null);
        assertNotNull(links.getNotes());
    }

    @Test
    public void getLockedByDoesNotReturnNull() throws Exception {
        assertNotNull(links.getLockedBy());
        links.setLockedBy(null);
        assertNotNull(links.getLockedBy());
    }

    @Test
    public void getCustomerDoesNotReturnNull() throws Exception {
        assertNotNull(links.getCustomer());
        links.setCustomer(null);
        assertNotNull(links.getCustomer());
    }

    @Test
    public void getAssignedGroupDoesNotReturnNull() throws Exception {
        assertNotNull(links.getAssignedGroup());
        links.setAssignedGroup(null);
        assertNotNull(links.getAssignedGroup());
    }

    @Test
    public void getAssignedUserDoesNotReturnNull() throws Exception {
        assertNotNull(links.getAssignedUser());
        links.setAssignedUser(null);
        assertNotNull(links.getAssignedUser());
    }

    @Test
    public void getMacroPreviewDoesNotReturnNull() throws Exception {
        assertNotNull(links.getMacroPreview());
        links.setMacroPreview(null);
        assertNotNull(links.getMacroPreview());
    }

    @Test
    public void getMacrosDoesNotReturnNull() throws Exception {
        assertNotNull(links.getMacros());
        links.setMacros(null);
        assertNotNull(links.getMacros());
    }

    @Test
    public void getAttachmentsDoesNotReturnNull() throws Exception {
        assertNotNull(links.getAttachments());
        links.setAttachments(null);
        assertNotNull(links.getAttachments());
    }

}