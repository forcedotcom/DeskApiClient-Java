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

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ApiResponse<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = -2252937250041149579L;

    private int totalEntries;
    private int page;
    private Links _links;
    private Entries<T> _embedded;

    public int getTotalEntries() {
        return totalEntries;
    }

    public void setTotalEntries(int entries) {
        this.totalEntries = entries;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int p) {
        this.page = p;
    }

    @NotNull
    public Links getLinks() {
        return _links == null ? _links = new Links() : _links;
    }

    public void setLinks(Links lnks) {
        this._links = lnks;
    }

    public Entries<T> getEmbeddedList() {
        return _embedded;
    }

    public void setEmbeddedList(Entries<T> list) {
        this._embedded = list;
    }

    /**
     * Get the entries
     *
     * @return the entries if there are any, null if there are no entries
     */
    @Nullable
    public T[] getEntries() {
        return _embedded != null ? _embedded.getEntries() : null;
    }

    /**
     * Get the entries as a list
     *
     * @return the list of entries or an empty list if there are no entries
     */
    @NotNull
    public List<T> getEntriesAsList() {
        T[] entries = getEntries();
        if (entries != null) {
            return Arrays.asList(entries);
        } else {
            return Collections.emptyList();
        }
    }

    public boolean hasNextPage() {
        return getLinks().getNext() != null;
    }

    public boolean isFirstPage() {
        return (page == 1);
    }
}
