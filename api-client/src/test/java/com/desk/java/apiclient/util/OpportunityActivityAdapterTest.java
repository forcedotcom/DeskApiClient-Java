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

package com.desk.java.apiclient.util;

import com.desk.java.apiclient.model.IOpportunityActivity;
import com.desk.java.apiclient.model.OpportunityAttachment;
import com.desk.java.apiclient.model.OpportunityCall;
import com.desk.java.apiclient.model.OpportunityEmail;
import com.desk.java.apiclient.model.OpportunityNote;
import com.desk.java.apiclient.model.OpportunitySystemEvent;
import com.desk.java.apiclient.model.OpportunityTask;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * <p>
 *     Unit tests for {@link OpportunityActivityAdapter}
 * </p>
 *
 * Created by Matt Kranzler on 12/30/15.
 * Copyright (c) 2016 Desk.com. All rights reserved.
 */
public class OpportunityActivityAdapterTest {

    private OpportunityActivityAdapter adapter;

    @Before
    public void setUp() throws Exception {
        adapter = new OpportunityActivityAdapter();
    }

    @Test
    public void deserializeDoesReturnOpportunitySystemEvent() throws Exception {
        JsonObject json = TestUtils.readMockJsonFile(
                new TypeToken<JsonObject>(){}.getType(),
                "mock_opportunity_system_event.json"
        );
        IOpportunityActivity activity = adapter.deserialize(json, null, null);
        assertNotNull(activity);
        assertTrue(activity instanceof OpportunitySystemEvent);
    }

    @Test
    public void deserializeDoesReturnOpportunityCall() throws Exception {
        JsonObject json = TestUtils.readMockJsonFile(
                new TypeToken<JsonObject>(){}.getType(),
                "mock_opportunity_call.json"
        );
        IOpportunityActivity activity = adapter.deserialize(json, null, null);
        assertNotNull(activity);
        assertTrue(activity instanceof OpportunityCall);
    }

    @Test
    public void deserializeDoesReturnOpportunityEmail() throws Exception {
        JsonObject json = TestUtils.readMockJsonFile(
                new TypeToken<JsonObject>(){}.getType(),
                "mock_opportunity_email.json"
        );
        IOpportunityActivity activity = adapter.deserialize(json, null, null);
        assertNotNull(activity);
        assertTrue(activity instanceof OpportunityEmail);
    }

    @Test
    public void deserializeDoesReturnOpportunityNote() throws Exception {
        JsonObject json = TestUtils.readMockJsonFile(
                new TypeToken<JsonObject>(){}.getType(),
                "mock_opportunity_note.json"
        );
        IOpportunityActivity activity = adapter.deserialize(json, null, null);
        assertNotNull(activity);
        assertTrue(activity instanceof OpportunityNote);
    }

    @Test
    public void deserializeDoesReturnOpportunityTask() throws Exception {
        JsonObject json = TestUtils.readMockJsonFile(
                new TypeToken<JsonObject>(){}.getType(),
                "mock_opportunity_task.json"
        );
        IOpportunityActivity activity = adapter.deserialize(json, null, null);
        assertNotNull(activity);
        assertTrue(activity instanceof OpportunityTask);
    }

    @Test
    public void deserializeDoesReturnOpportunityAttachment() throws Exception {
        JsonObject json = TestUtils.readMockJsonFile(
                new TypeToken<JsonObject>(){}.getType(),
                "mock_opportunity_attachment.json"
        );
        IOpportunityActivity activity = adapter.deserialize(json, null, null);
        assertNotNull(activity);
        assertTrue(activity instanceof OpportunityAttachment);
    }
}