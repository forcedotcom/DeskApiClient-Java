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

import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * <p> Unit tests for {@link Customer} </p>
 *
 * Created by Matt Kranzler on 6/24/16.
 * Copyright (c) 2016 Desk.com. All rights reserved.
 */
public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer();
    }

    @Test
    public void getNameDoesReturnEmptyWithNoFirstOrLastName() throws Exception {
        customer.setFirstName(null);
        customer.setLastName(null);
        assertEquals("", customer.getName());
    }

    @Test
    public void getNameDoesReturnFirstName() throws Exception {
        customer.setFirstName("first");
        assertEquals("first", customer.getName());
    }

    @Test
    public void getNameDoesReturnFirstAndLastName() throws Exception {
        customer.setFirstName("first");
        customer.setLastName("last");
        assertEquals("first last", customer.getName());
    }

    @Test
    public void getEmailsDoesNotReturnNull() throws Exception {
        assertNotNull(customer.getEmails());
        customer.setEmails(null);
        assertNotNull(customer.getEmails());
    }

    @Test
    public void getAddressesDoesNotReturnNull() throws Exception {
        assertNotNull(customer.getAddresses());
        customer.setAddresses(null);
        assertNotNull(customer.getAddresses());
    }

    @Test
    public void getPhoneNumbersDoesNotReturnNull() throws Exception {
        assertNotNull(customer.getPhoneNumbers());
        customer.setPhoneNumbers(null);
        assertNotNull(customer.getPhoneNumbers());
    }

    @Test
    public void getLinksDoesNotReturnNull() throws Exception {
        assertNotNull(customer.getLinks());
        customer.setLinks(null);
        assertNotNull(customer.getLinks());
    }

    @Test
    public void getCustomFieldsDoesNotReturnNull() throws Exception {
        assertNotNull(customer.getCustomFields());
        customer.setCustomFields(null);
        assertNotNull(customer.getCustomFields());
    }

    @Test
    public void setEmbeddedDoesNotReturnNull() throws Exception {
        assertNotNull(customer.getEmbedded());
        customer.setEmbedded(null);
        assertNotNull(customer.getEmbedded());
    }

    @Test
    public void getFirstEmailDoesReturnFirstEmail() throws Exception {
        CustomerContact[] emails = {
                new CustomerContact("email", "email1@email.com"),
                new CustomerContact("email", "email2@email.com"),
                new CustomerContact("email", "email3@email.com")
        };
        customer.setEmails(emails);
        assertEquals("email1@email.com", customer.getFirstEmail());
    }

    @Test
    public void getFirstPhoneDoesReturnFirstPhone() throws Exception {
        CustomerContact[] phoneNumbers = {
                new CustomerContact("phone", "111-111-1111"),
                new CustomerContact("phone", "222-222-2222"),
                new CustomerContact("phone", "333-333-3333")
        };
        customer.setPhoneNumbers(phoneNumbers);
        assertEquals("111-111-1111", customer.getFirstPhone());
    }

    @Test
    public void getFirstTwitterHandleDoesGetTwitterHandle() throws Exception {
        TwitterUser twitterUser = mock(TwitterUser.class);
        when(twitterUser.getHandle()).thenReturn("@twitter");
        customer.getEmbedded().setTwitterUser(twitterUser);
        assertEquals("@twitter", customer.getTwitterHandle());
    }

    @Test
    public void getFacebookUserDoesGetEmbeddedUser() throws Exception {
        FacebookUser facebookUser = mock(FacebookUser.class);
        when(facebookUser.getProfileUrl()).thenReturn("facebook.com");
        customer.getEmbedded().setFacebookUser(facebookUser);
        assertNotNull(customer.getFacebookUser());
        assertEquals("facebook.com", customer.getFacebookUser().getProfileUrl());
    }

    @Test
    public void getTwitterUserDoesGetEmbeddedUser() throws Exception {
        TwitterUser twitterUser = mock(TwitterUser.class);
        when(twitterUser.getHandle()).thenReturn("@twitter");
        customer.getEmbedded().setTwitterUser(twitterUser);
        assertNotNull(customer.getTwitterUser());
        assertEquals("@twitter", customer.getTwitterUser().getHandle());
    }
}