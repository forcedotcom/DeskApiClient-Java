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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * <p>
 *     Unit tests for {@link User}
 * </p>
 *
 * Created by Jerrell Mardis
 * Copyright (c) 2016 Desk.com. All rights reserved.
 */
public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
    }

    @Test
    public void getNameDoesNotReturnNull() {
        assertNotNull(user.getName());
        user.setName(null);
        assertNotNull(user.getName());
    }

    @Test
    public void getAvatarDoesNotReturnNull() {
        assertNotNull(user.getAvatar());
        user.setAvatar(null);
        assertNotNull(user.getAvatar());
    }

    @Test
    public void getLinksDoesNotReturnNull() {
        assertNotNull(user.getLinks());
        user.setLinks(null);
        assertNotNull(user.getLinks());
    }

    @Test
    public void getFiltersUrlReturnsUrlWhenSet() {
        UserLinks userLinks = new UserLinks();
        String url = "foo.com";
        Link filters = new Link(url);
        userLinks.setFilters(filters);
        user.setLinks(userLinks);
        assertEquals(url, user.getFiltersUrl());
    }

    @Test
    public void getFiltersUrlReturnsNullWhenNotSet() {
        user.setLinks(null);
        assertNull(user.getFiltersUrl());
    }

    @Test
    public void getSelfLinkUrlDoesNotReturnNull() {
        user.setLinks(null);
        assertNotNull(user.getSelfLink());
    }

    @Test
    public void getSelfLinkUrlDoesReturnSelfUrlWhenSet() {
        UserLinks userLinks = new UserLinks();
        String url = "foo.com";
        Link self = new Link(url);
        userLinks.setSelf(self);
        user.setLinks(userLinks);
        assertEquals(url, user.getSelfLinkUrl());
    }
}