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

import com.desk.java.apiclient.model.ApiResponse;
import com.desk.java.apiclient.model.IOpportunityActivity;
import com.desk.java.apiclient.model.Opportunity;
import com.desk.java.apiclient.model.OpportunityTimeline;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * <p>
 *     Service to interact with Desk Opportunities endpoint.
 * </p>
 *
 * Created by Matt Kranzler on 12/28/15.
 * Copyright (c) 2015 Desk.com. All rights reserved.
 */
public interface OpportunityService {

    String FILTERS_URI = "opportunity_filters";
    String OPPORTUNITIES_URI = "opportunities";
    String HISTORY_URI = "history";
    String ACTIVITIES_URI = "activities";

    /**
     * Retrieve a paginated list of opportunities by filter
     *
     * @param filterId the id of the filter
     * @param perPage the amount per page
     * @param page the page to retrieve
     * @return an opportunity api response
     */
    @GET(FILTERS_URI + "/{id}/" + OPPORTUNITIES_URI)
    Call<ApiResponse<Opportunity>> getOpportunitiesByFilter(@Path("id") int filterId,
                                                            @Query("per_page") int perPage,
                                                            @Query("page") int page);

    /**
     * Retrieve an opportunity by id
     *
     * @param id the id of the opportunity
     * @return the opportunity
     */
    @GET(OPPORTUNITIES_URI + "/{id}")
    Call<Opportunity> getOpportunity(@Path("id") int id);

    /**
     * Retrieve the opportunity timeline (history)
     *
     * @param opportunityId the opportunity id
     * @return the opportunity timeline
     */
    @GET(OPPORTUNITIES_URI + "/{id}/" + HISTORY_URI)
    Call<OpportunityTimeline> getOpportunityTimeline(@Path("id") int opportunityId);

    /**
     * Retrieve opportunity activities and events.
     *
     * @param opportunityId the opportunity id
     * @return the activities and events api response
     */
    @GET(OPPORTUNITIES_URI + "/{id}/" + ACTIVITIES_URI)
    Call<ApiResponse<IOpportunityActivity>> getOpportunityActivities(@Path("id") int opportunityId);
}
