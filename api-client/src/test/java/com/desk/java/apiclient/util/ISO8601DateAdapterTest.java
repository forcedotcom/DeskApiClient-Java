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

package com.desk.java.apiclient.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Unit tests for {@link ISO8601DateAdapter}
 *
 * Created by Matt Kranzler on 6/22/15.
 * Copyright (c) 2015 Desk.com. All rights reserved.
 */
@RunWith(MockitoJUnitRunner.class)
public class ISO8601DateAdapterTest {

    private static final String ISO_8601_TIMESTAMP = "2020-05-20T11:20:14Z";

    private ISO8601DateAdapter dateAdapter;
    private DateFormat dateFormat;

    @Before
    public void setUp() throws Exception {
        dateAdapter = ISO8601DateAdapter.TYPE_ADAPTER;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Test
    public void formatDoesReturnCorrectlyFormattedString() throws Exception {
        Date date = dateFormat.parse(ISO_8601_TIMESTAMP);
        String formatted = dateAdapter.formatDate(date);
        assertEquals(ISO_8601_TIMESTAMP, formatted);
    }

    @Test
    public void parseDoesReturnDateWithISO8601Timestamp() throws Exception {
        Date parsed = dateAdapter.parse(ISO_8601_TIMESTAMP);
        assertNotNull(parsed);
    }

    @Test(expected = ParseException.class)
    public void parseDoesThrowParseExceptionWithNonISO8601Timestamp() throws Exception {
        Date parsed = dateAdapter.parse("05/20/2020");
        assertNull(parsed);
    }

    @Test
    public void serializeDoesSerializeToISO8601Format() throws Exception {
        JsonElement element = dateAdapter.serialize(
                dateFormat.parse(ISO_8601_TIMESTAMP),
                Date.class,
                Mockito.mock(JsonSerializationContext.class)
        );
        assertEquals(element.getAsString(), ISO_8601_TIMESTAMP);
    }

    @Test
    public void deserializeDoesDeserializeToDate() throws Exception {
        JsonElement element = new JsonPrimitive(ISO_8601_TIMESTAMP);
        Date date = dateAdapter.deserialize(element, Date.class, Mockito.mock(JsonDeserializationContext.class));
        assertEquals(date, dateFormat.parse(ISO_8601_TIMESTAMP));
    }
}