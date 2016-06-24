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
    public void setIdDoesSetId() throws Exception {
        assertEquals(0, customer.getId());
        customer.setId(10);
        assertEquals(10, customer.getId());
    }

    @Test
    public void setFirstNameSetsFirstName() throws Exception {
        assertNull(customer.getFirstName());
        customer.setFirstName("first");
        assertEquals("first", customer.getFirstName());
    }

    @Test
    public void setLastNameSetsLastName() throws Exception {
        assertNull(customer.getLastName());
        customer.setLastName("last");
        assertEquals("last", customer.getLastName());
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
    public void setTitleDoesSetTitle() throws Exception {
        assertNull(customer.getTitle());
        customer.setTitle("title");
        assertEquals("title", customer.getTitle());
    }

    @Test
    public void setLanguageDoesSetLanguage() throws Exception {
        assertNull(customer.getLanguage());
        customer.setLanguage("language");
        assertEquals("language", customer.getLanguage());
    }

    @Test
    public void setBackgroundDoesSetBackground() throws Exception {
        assertNull(customer.getBackground());
        customer.setBackground("background");
        assertEquals("background", customer.getBackground());
    }

    @Test
    public void setCompanyNameDoesSetCompanyName() throws Exception {
        assertNull(customer.getCompanyName());
        customer.setCompanyName("company name");
        assertEquals("company name", customer.getCompanyName());
    }

    @Test
    public void setDisplayNameDoesSetDisplayName() throws Exception {
        assertNull(customer.getDisplayName());
        customer.setDisplayName("display name");
        assertEquals("display name", customer.getDisplayName());
    }

    @Test
    public void setAvatarDoesSetAvatar() throws Exception {
        assertNull(customer.getAvatar());
        customer.setAvatar("avatar");
        assertEquals("avatar", customer.getAvatar());
    }

    @Test
    public void getEmailsDoesNotReturnNull() throws Exception {
        assertNotNull(customer.getEmails());
        customer.setEmails(null);
        assertNotNull(customer.getEmails());
    }

    @Test
    public void setEmailsDoesSetEmails() throws Exception {
        CustomerContact[] emails = {
                new CustomerContact("email", "email1@email.com"),
                new CustomerContact("email", "email2@email.com"),
                new CustomerContact("email", "email3@email.com")
        };
        customer.setEmails(emails);
        assertEquals(3, customer.getEmails().length);
        assertEquals("email1@email.com", customer.getEmails()[0].getValue());
        assertEquals("email2@email.com", customer.getEmails()[1].getValue());
        assertEquals("email3@email.com", customer.getEmails()[2].getValue());
    }

    @Test
    public void getAddressesDoesNotReturnNull() throws Exception {
        assertNotNull(customer.getAddresses());
        customer.setAddresses(null);
        assertNotNull(customer.getAddresses());
    }

    @Test
    public void setAddressesDoesSetAddresses() throws Exception {
        CustomerContact[] addresses = {
                new CustomerContact("address", "123 street ave"),
                new CustomerContact("address", "456 street ave"),
                new CustomerContact("address", "789 street ave")
        };
        customer.setAddresses(addresses);
        assertEquals(3, customer.getAddresses().length);
        assertEquals("123 street ave", customer.getAddresses()[0].getValue());
        assertEquals("456 street ave", customer.getAddresses()[1].getValue());
        assertEquals("789 street ave", customer.getAddresses()[2].getValue());
    }

    @Test
    public void getPhoneNumbersDoesNotReturnNull() throws Exception {
        assertNotNull(customer.getPhoneNumbers());
        customer.setPhoneNumbers(null);
        assertNotNull(customer.getPhoneNumbers());
    }

    @Test
    public void setPhoneNumbersDoesSetPhoneNumbers() throws Exception {
        CustomerContact[] phoneNumbers = {
                new CustomerContact("phone", "111-111-1111"),
                new CustomerContact("phone", "222-222-2222"),
                new CustomerContact("phone", "333-333-3333")
        };
        customer.setPhoneNumbers(phoneNumbers);
        assertEquals(3, customer.getPhoneNumbers().length);
        assertEquals("111-111-1111", customer.getPhoneNumbers()[0].getValue());
        assertEquals("222-222-2222", customer.getPhoneNumbers()[1].getValue());
        assertEquals("333-333-3333", customer.getPhoneNumbers()[2].getValue());
    }

    @Test
    public void getLinksDoesNotReturnNull() throws Exception {
        assertNotNull(customer.getLinks());
        customer.setLinks(null);
        assertNotNull(customer.getLinks());
    }

    @Test
    public void setLinksDoesSetLinks() throws Exception {
        CustomerLinks links = new CustomerLinks();
        Link company = new Link("/customer/10/company/5");
        links.setCompany(company);
        customer.setLinks(links);
        assertEquals(5, customer.getLinks().getCompany().getLinkId());
    }

    @Test
    public void getCustomFieldsDoesNotReturnNull() throws Exception {
        assertNotNull(customer.getCustomFields());
        customer.setCustomFields(null);
        assertNotNull(customer.getCustomFields());
    }

    @Test
    public void setCustomFieldsDoesSetCustomFields() throws Exception {
        HashMap<String, String> customFields = new HashMap<>();
        customFields.put("key1", "value1");
        customFields.put("key2", "value2");
        customFields.put("key3", "value3");
        customer.setCustomFields(customFields);
        assertEquals(3, customer.getCustomFields().size());
        assertEquals("value1", customer.getCustomFields().get("key1"));
        assertEquals("value2", customer.getCustomFields().get("key2"));
        assertEquals("value3", customer.getCustomFields().get("key3"));
    }

    @Test
    public void setEmbeddedDoesNotReturnNull() throws Exception {
        assertNotNull(customer.getEmbedded());
        customer.setEmbedded(null);
        assertNotNull(customer.getEmbedded());
    }

    @Test
    public void setEmbeddedDoesSetEmbedded() throws Exception {
        CustomerEmbedded embedded = new CustomerEmbedded();
        TwitterUser twitterUser = mock(TwitterUser.class);
        when(twitterUser.getHandle()).thenReturn("@twitter");
        FacebookUser facebookUser = mock(FacebookUser.class);
        when(facebookUser.getProfileUrl()).thenReturn("facebook.com");
        embedded.setTwitterUser(twitterUser);
        embedded.setFacebookUser(facebookUser);
        customer.setEmbedded(embedded);
        assertEquals("@twitter", customer.getEmbedded().getTwitterUser().getHandle());
        assertEquals("facebook.com", customer.getEmbedded().getFacebookUser().getProfileUrl());
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