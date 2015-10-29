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
import com.desk.java.apiclient.model.Group;
import com.desk.java.apiclient.model.User;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

import static com.desk.java.apiclient.service.GroupService.GROUPS_URI;

/**
 * <p>
 * Service interfacing with the Desk Groups endpoint
 * </p>
 * <p>
 * Created by Matt Kranzler on 4/28/15.
 * Copyright (c) 2015 Desk.com. All rights reserved.
 *
 * @see <a href="http://dev.desk.com/API/groups/">http://dev.desk.com/API/groups/</a>
 */
public interface RxGroupService {

    /**
     * Retrieve a paginated list of all groups
     *
     * @param perPage the amount of groups per page
     * @param page    the page
     * @return a group api response
     * @see <a href="http://dev.desk.com/API/groups/#list">http://dev.desk.com/API/groups/#list</a>
     */
    @GET(GROUPS_URI)
    Observable<ApiResponse<Group>> getGroupsObservable(@Query("per_page") int perPage, @Query("page") int page);

    /**
     * Retrieve a paginated list of all users for the given group
     *
     * @param groupId the group id
     * @param perPage the amount of users per page
     * @return a user api response
     * @see <a href="http://dev.desk.com/API/groups/#list-users">http://dev.desk.com/API/groups/#list-users</a>
     */
    @GET(GROUPS_URI + "/{id}/users")
    Observable<ApiResponse<User>> getUsersForGroupObservable(@Path("id") int groupId, @Query("per_page") int perPage);

    /**
     * Retrieve a single group
     *
     * @param groupId the group id
     * @return a group
     * @see <a href="http://dev.desk.com/API/groups/#show">http://dev.desk.com/API/groups/#show</a>
     */
    @GET(GROUPS_URI + "/{id}")
    Observable<Group> getGroupObservable(@Path("id") int groupId);
}
