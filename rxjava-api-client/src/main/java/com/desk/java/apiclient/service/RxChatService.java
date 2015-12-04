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

import com.desk.java.apiclient.model.chat.CustomerInfo;
import com.desk.java.apiclient.model.chat.PollInfo;
import com.desk.java.apiclient.model.chat.SessionInfo;

import retrofit.http.DELETE;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * <p>
 *     Service interfacing with the Desk Chat endpoint.
 * </p>
 *
 * Created by Jerrell Mardis
 * Copyright (c) 2015 Desk.com. All rights reserved.
 */
@SuppressWarnings({"JavaDoc", "unused"})
public interface RxChatService {

    String CUSTOMERS = "customers";
    String CHAT_SESSIONS = "chat_sessions";
    String REPLIES = "replies";
    String POLL = "poll";

    /**
     * Creates a guest customer.
     *
     * @param name
     * @param chatToken
     * @param fields
     * @return
     */
    @POST(CUSTOMERS)
    Observable<CustomerInfo> createCustomer(@Query("first_name") String name,
                                            @Query("chat_token") String chatToken,
                                            @Query("fields") String fields);

    /**
     * Starts a session.
     *
     * @param guestCustomerId
     * @param chatToken
     * @param customerToken
     * @return
     */
    @POST(CUSTOMERS + "/{id}/" + CHAT_SESSIONS)
    Observable<SessionInfo> startSession(@Path("id") long guestCustomerId,
                                          @Query("chat_token") String chatToken,
                                          @Query("customer_token") String customerToken);

    /**
     * Sends a message.
     *
     * @param guestCustomerId
     * @param body
     * @param chatToken
     * @param customerToken
     * @return
     */
    @POST(CUSTOMERS + "/{id}/" + REPLIES)
    Observable<SessionInfo> sendMessage(@Path("id") long guestCustomerId,
                                        @Query("body") String body,
                                        @Query("chat_token") String chatToken,
                                        @Query("customer_token") String customerToken);

    /**
     * Checks for new messages.
     *
     * @param guestCustomerId
     * @param chatSessionId
     * @param chatToken
     * @param customerToken
     * @param requestor
     * @return
     */
    @POST(CUSTOMERS + "/{id}/" + CHAT_SESSIONS + "/{chat_session_id}/" + POLL)
    Observable<PollInfo> poll(@Path("id") long guestCustomerId,
                              @Path("chat_session_id") long chatSessionId,
                              @Query("chat_token") String chatToken,
                              @Query("customer_token") String customerToken,
                              @Query("requestor") String requestor);

    /**
     * Ends a chat session.
     *
     * @param guestCustomerId
     * @param chatSessionId
     * @param chatToken
     * @param customerToken
     * @param requestor
     * @return
     */
    @DELETE(CUSTOMERS + "/{id}/" + CHAT_SESSIONS + "/{chat_session_id}")
    Observable<Void> endSession(@Path("id") long guestCustomerId,
                                @Path("chat_session_id") long chatSessionId,
                                @Query("chat_token") String chatToken,
                                @Query("customer_token") String customerToken,
                                @Query("requestor") String requestor);
}
