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

package com.desk.java.apiclient.service;

import com.desk.java.apiclient.DeskClientBuilder;
import com.desk.java.apiclient.model.ApiResponse;
import com.desk.java.apiclient.model.InboundMailbox;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

import static com.desk.java.apiclient.service.InboundMailboxService.INBOUND_MAILBOX_URI;

/**
 * <p>
 *     Service interfacing with the Desk Inbound Mailboxes endpoint.
 *     This service supports {@link DeskClientBuilder.AuthType#API_TOKEN} authentication.
 * </p>
 *
 * @see <a href="http://dev.desk.com/API/inbound-mailboxes/">http://dev.desk.com/API/inbound-mailboxes/</a>
 *
 * Created by Jerrell Mardis
 * Copyright (c) 2015 Desk.com. All rights reserved.
 */
public interface RxInboundMailboxService {

    /**
     * Retrieve a paginated list of inbound mailboxes
     *
     * @param perPage the amount of labels per page
     * @param page    the page
     * @return an inbound mailbox api response
     * @see <a href="http://dev.desk.com/API/inbound-mailboxes/#list">http://dev.desk.com/API/inbound-mailboxes/#list</a>
     */
    @GET(INBOUND_MAILBOX_URI)
    Observable<ApiResponse<InboundMailbox>> getInboundMailboxesObservable(@Query("per_page") int perPage, @Query("page") int page);
}
