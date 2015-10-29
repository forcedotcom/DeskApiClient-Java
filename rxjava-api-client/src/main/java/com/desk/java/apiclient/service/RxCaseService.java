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

import com.desk.java.apiclient.RxDeskClient;
import com.desk.java.apiclient.model.ApiResponse;
import com.desk.java.apiclient.model.Attachment;
import com.desk.java.apiclient.model.Case;
import com.desk.java.apiclient.model.CaseLock;
import com.desk.java.apiclient.model.Embed;
import com.desk.java.apiclient.model.Fields;
import com.desk.java.apiclient.model.MacroResponse;
import com.desk.java.apiclient.model.Message;
import com.desk.java.apiclient.model.SortDirection;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.PATCH;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

import static com.desk.java.apiclient.service.CaseService.ATTACHMENTS_URI;
import static com.desk.java.apiclient.service.CaseService.CASES_URI;
import static com.desk.java.apiclient.service.CaseService.DRAFT_URI;
import static com.desk.java.apiclient.service.CaseService.FILTERS_URI;
import static com.desk.java.apiclient.service.CaseService.MACROS_URI;
import static com.desk.java.apiclient.service.CaseService.NOTE_URI;
import static com.desk.java.apiclient.service.CaseService.REPLIES_URI;

/**
 * <p>
 * Service interfacing with the Desk Cases endpoint. {@link #createCaseObservable(Case, Embed, Fields)}
 * &amp; {@link #createCaseObservable(Case, Embed, Fields)} support
 * {@link RxDeskClient.AuthType#API_TOKEN} authentication
 * </p>
 * <p>
 * Created by Matt Kranzler on 5/1/15.
 * Copyright (c) 2015 Desk.com. All rights reserved.
 *
 * @see <a href="http://dev.desk.com/API/cases/">http://dev.desk.com/API/cases/</a>
 */
public interface RxCaseService {

    /**
     * Retrieves cases for a given filter
     *
     * @param filterId      the id of the filter
     * @param perPage       the total filters per page
     * @param page          the page requested
     * @param sortField     the field to sort on
     * @param sortDirection the direction to sort
     * @param embed         what to embed
     * @param fields        the fields requested
     * @return a case api response
     * @see <a href="http://dev.desk.com/API/cases/#list">http://dev.desk.com/API/cases/#list</a>
     */
    @GET(FILTERS_URI + "/{id}/" + CASES_URI)
    Observable<ApiResponse<Case>> getCasesByFilterObservable(@Path("id") int filterId, @Query("per_page") int perPage, @Query("page") int page,
                                                             @Query("sort_field") String sortField, @Query("sort_direction") SortDirection sortDirection,
                                                             @Query("embed") Embed embed, @Query("fields") Fields fields);

    /**
     * Searches for cases provided a query
     *
     * @param query         the query to search for
     * @param perPage       the total cases per page
     * @param page          the page requested
     * @param sortField     the field to sort on
     * @param sortDirection the direction to sort
     * @param embed         what to embed
     * @param fields        the fields requested
     * @return a case api response
     * @see <a href="http://dev.desk.com/API/cases/#search">http://dev.desk.com/API/cases/#search</a>
     */
    @GET(CASES_URI + "/search")
    Observable<ApiResponse<Case>> searchCasesObservable(@Query("q") String query, @Query("per_page") int perPage, @Query("page") int page,
                                                        @Query("sort_field") String sortField, @Query("sort_direction") SortDirection sortDirection,
                                                        @Query("embed") Embed embed, @Query("fields") Fields fields);

    /**
     * Gets the case by id
     *
     * @param caseId the id of the case
     * @param embed  what to embed
     * @param fields the fields requested
     * @return a case
     * @see <a href="http://dev.desk.com/API/cases/#show">http://dev.desk.com/API/cases/#show</a>
     */
    @GET(CASES_URI + "/{id}")
    Observable<Case> getCaseByIdObservable(@Path("id") int caseId, @Query("embed") Embed embed, @Query("fields") Fields fields);

    /**
     * Locks or unlocks a case
     *
     * @param caseId   the id of the case
     * @param caseLock the case lock
     * @return a case
     * @see <a href="http://dev.desk.com/API/cases/#update">http://dev.desk.com/API/cases/#update</a>
     */
    @PATCH(CASES_URI + "/{id}")
    Observable<Case> updateCaseLockObservable(@Path("id") int caseId, @Body CaseLock caseLock);

    /**
     * Updates a case
     *
     * @param caseId      the id of the case
     * @param updatedCase the updated case
     * @return a case
     * @see <a href="http://dev.desk.com/API/cases/#update">http://dev.desk.com/API/cases/#update</a>
     */
    @PATCH(CASES_URI + "/{id}")
    Observable<Case> updateCaseObservable(@Path("id") int caseId, @Body Case updatedCase);

    /**
     * Updates a case
     *
     * @param caseId      the id of the case
     * @param updatedCase the updated case
     * @param embed       what to embed in the response
     * @param fields      the fields requested in the response
     * @return a case
     * @see <a href="http://dev.desk.com/API/cases/#update">http://dev.desk.com/API/cases/#update</a>
     */
    @PATCH(CASES_URI + "/{id}")
    Observable<Case> updateCaseObservable(@Path("id") int caseId, @Body Case updatedCase, @Query("embed") Embed embed,
                                          @Query("fields") Fields fields);

    /**
     * Creates a case
     *
     * @param newCase the case to create
     * @param embed   the fields to embed in the case response
     * @param fields  the fields to return in the case response
     * @return the created case
     */
    @POST(CASES_URI)
    Observable<Case> createCaseObservable(@Body Case newCase, @Query("embed") Embed embed, @Query("fields") Fields fields);

    /**
     * Updates a case message
     *
     * @param caseId         the id of the case
     * @param updatedMessage the updated message
     * @return a message
     * @see <a href="http://dev.desk.com/API/cases/#message-update">http://dev.desk.com/API/cases/#message-update</a>
     */
    @PATCH(CASES_URI + "/{id}/message")
    Observable<Message> updateCaseMessageObservable(@Path("id") int caseId, @Body Message updatedMessage);

    /**
     * Updates a case reply
     *
     * @param caseId       the id of the case
     * @param replyId      the id of the reply
     * @param updatedReply the updated reply
     * @return a message
     * @see <a href="http://dev.desk.com/API/cases/#replies-update">http://dev.desk.com/API/cases/#replies-update</a>
     */
    @PATCH(CASES_URI + "/{caseId}/" + REPLIES_URI + "/{replyId}")
    Observable<Message> updateCaseReplyObservable(@Path("caseId") int caseId, @Path("replyId") int replyId, @Body Message updatedReply);

    /**
     * Retrieves a case's feed
     *
     * @param caseId        the id of the case
     * @param perPage       the total filters per page
     * @param page          the page requested
     * @param sortDirection the direction to sort
     * @return a response
     * @see <a href="http://dev.desk.com/API/cases/#feed">http://dev.desk.com/API/cases/#feed</a>
     */
    @GET(CASES_URI + "/{id}/feed")
    Observable<ApiResponse<Message>> getCaseFeedObservable(@Path("id") int caseId, @Query("per_page") int perPage, @Query("page") int page,
                                                           @Query("sort_direction") SortDirection sortDirection);

    /**
     * Retrieves a draft for a case if it exists
     *
     * @param caseId the id of the case
     * @param embed  what to embed
     * @return a message
     * @see <a href="http://dev.desk.com/API/cases/#drafts-show">http://dev.desk.com/API/cases/#drafts-show</a>
     */
    @GET(CASES_URI + "/{id}/" + DRAFT_URI)
    Observable<Message> getDraftObservable(@Path("id") int caseId, @Query("embed") Embed embed);

    /**
     * Creates a draft
     *
     * @param caseId the id of the case
     * @return a message
     * @see <a href="http://dev.desk.com/API/cases/#drafts-create">http://dev.desk.com/API/cases/#drafts-create</a>
     */
    @POST(CASES_URI + "/{id}/" + DRAFT_URI)
    Observable<Message> createDraftObservable(@Path("id") int caseId);

    /**
     * Updates a draft
     *
     * @param caseId the id of the case
     * @param draft  the updated draft
     * @return a message
     * @see <a href="http://dev.desk.com/API/cases/#drafts-update">http://dev.desk.com/API/cases/#drafts-update</a>
     */
    @PATCH(CASES_URI + "/{id}/" + DRAFT_URI)
    Observable<Message> updateDraftObservable(@Path("id") int caseId, @Body Message draft);

    /**
     * Creates a note
     *
     * @param caseId the id of the case
     * @param note   the note to create
     * @return a message
     * @see <a href="http://dev.desk.com/API/cases/#notes-create">http://dev.desk.com/API/cases/#notes-create</a>
     */
    @POST(CASES_URI + "/{id}/" + NOTE_URI)
    Observable<Message> createNoteObservable(@Path("id") int caseId, @Body Message note);

    /**
     * Retrieves a preview for applying a set of macros to a case
     *
     * @param caseId the id of the case
     * @param body   the desk case body
     * @return a macro response
     * @see <a href="http://dev.desk.com/API/cases/#macros-preview">http://dev.desk.com/API/cases/#macros-preview</a>
     */
    @POST(CASES_URI + "/{id}/" + MACROS_URI + "/preview")
    Observable<MacroResponse> previewMacroObservable(@Path("id") int caseId, @Body Case body);

    /**
     * Retrieves a paginated list of all attachments for a case
     *
     * @param caseId  the id of the case
     * @param perPage the total attachments per page
     * @param page    the page requested
     * @return an attachment api response
     * @see <a href="http://dev.desk.com/API/cases/#attachments-list">http://dev.desk.com/API/cases/#attachments-list</a>
     */
    @GET(CASES_URI + "/{id}/" + ATTACHMENTS_URI)
    Observable<ApiResponse<Attachment>> getAttachmentsObservable(@Path("id") int caseId, @Query("per_page") int perPage, @Query("page") int page);
}
