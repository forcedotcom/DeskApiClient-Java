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

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Matt Kranzler on 6/22/15.
 * Copyright (c) 2015 Desk.com. All rights reserved.
 */
public class StringUtilsTest {

    @Test
    public void isEmptyReturnsTrueOnEmptyString() throws Exception {
        assertTrue(StringUtils.isEmpty(""));
    }

    @Test
    public void isEmptyReturnsTrueOnNullString() throws Exception {
        assertTrue(StringUtils.isEmpty(null));
    }

    @Test
    public void isEmptyReturnsFalseOnNonEmptyString() throws Exception {
        assertFalse(StringUtils.isEmpty("non-empty"));
    }

    @Test
    public void getLastPathSegmentReturnsLastPathSegment() throws Exception {
        String url = "http://support.desk.com/api/v2/cases/1";
        String lastPathSegment = StringUtils.getLastPathSegment(url);
        assertEquals("1", lastPathSegment);
    }

    @Test
    public void isDigitsOnlyReturnsTrue() throws Exception {
        String digitsOnly = "1234567890";
        assertTrue(StringUtils.isDigitsOnly(digitsOnly));
    }

    @Test
    public void isDigitsOnlyReturnsFalseWithCharacter() throws Exception {
        String digitsOnly = "1234567890.";
        assertFalse(StringUtils.isDigitsOnly(digitsOnly));
    }

    @Test
    public void isDigitsOnlyReturnsFalseWithLetter() throws Exception {
        String digitsOnly = "1234567890a";
        assertFalse(StringUtils.isDigitsOnly(digitsOnly));
    }

    @Test
    public void joinDoesJoinWithDelimiter() throws Exception {
        String[] strings = {"string_1", "string_2", "string_3"};
        String delimiter = "|";
        String joined = StringUtils.join(delimiter, strings);
        assertEquals("string_1|string_2|string_3", joined);
    }
}