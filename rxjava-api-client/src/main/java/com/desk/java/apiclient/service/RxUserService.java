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

package com.desk.java.apiclient.service;

import com.desk.java.apiclient.model.*;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import static com.desk.java.apiclient.service.UserService.*;

/**
 * <p>
 * Service interfacing with the Desk Users endpoint
 * </p>
 *
 * @see <a href="http://dev.desk.com/API/users/">http://dev.desk.com/API/users/</a>
 * <p>
 * Created by Jerrell Mardis
 * Copyright (c) 2016 Desk.com. All rights reserved.
 */
public interface RxUserService {

    /**
     * Retrieve a paginated list of all users
     *
     * @param perPage the amount of labels per page
     * @param page    the page
     * @return a user api response
     * @see <a href="http://dev.desk.com/API/users/#list">http://dev.desk.com/API/users/#list</a>
     */
    @GET(USERS_URI)
    Observable<ApiResponse<User>> getUsersObservable(@Query("per_page") int perPage, @Query("page") int page);

    /**
     * Retrieves the current user (API authentication must be present)
     *
     * @return a user
     * @see <a href="http://dev.desk.com/API/users/#show">http://dev.desk.com/API/users/#show</a>
     */
    @GET(USERS_URI + "/current")
    Observable<User> getCurrentUserObservable();

    /**
     * Logs out the current user (undocumented)
     *
     * @return Void
     */
    @POST(USERS_URI + "/me/logout")
    Observable<Void> logoutCurrentUserObservable();

    /**
     * Retrieve a single user
     *
     * @param userId the user id
     * @return a user
     * @see <a href="http://dev.desk.com/API/users/#show">http://dev.desk.com/API/users/#show</a>
     */
    @GET(USERS_URI + "/{id}")
    Observable<User> getUserObservable(@Path("id") int userId);

    /**
     * List all of the user's mobile devices.
     *
     * @param userId the user id
     * @return a mobile device api response
     * @see <a href="http://dev.desk.com/API/users/#mobile-devices-list">http://dev.desk.com/API/users/#mobile-devices-list</a>
     */
    @GET(USERS_URI + "/{id}/" + MOBILE_DEVICES_URI)
    Observable<ApiResponse<MobileDevice>> getMobileDevicesForUserObservable(@Path("id") int userId);

    /**
     * Creates a mobile device for the current user
     *
     * @param device the device to create with token
     * @return a mobile device
     */
    @POST(USERS_URI + "/current/" + MOBILE_DEVICES_URI)
    Observable<MobileDevice> createMobileDeviceObservable(@Body MobileDevice device);

    /**
     * Deletes a mobile device for the current user
     *
     * @param id the device id to delete
     * @return nothing
     */
    @DELETE(USERS_URI + "/current/" + MOBILE_DEVICES_URI + "/{id}")
    Observable<Void> deleteMobileDeviceObservable(@Path("id") int id);

    /**
     * Retrieve a list of mobile device settings.
     *
     * @param userId   the user id
     * @param deviceId the device id
     * @return a setting api response
     * @see <a href="http://dev.desk.com/API/users/#mobile-devices-settings-list">http://dev.desk.com/API/users/#mobile-devices-settings-list</a>
     */
    @GET(USERS_URI + "/{userId}/" + MOBILE_DEVICES_URI + "/{deviceId}/" + SETTINGS_URI)
    Observable<ApiResponse<Setting>> getMobileDevicesSettingsObservable(@Path("userId") int userId, @Path("deviceId") int deviceId);

    /**
     * Update a mobile device setting
     *
     * @param userId    the user id
     * @param deviceId  the device id
     * @param settingId the setting id
     * @param update    the setting update body
     * @return a setting
     * @see <a href="http://dev.desk.com/API/users/#mobile-devices-settings-update">http://dev.desk.com/API/users/#mobile-devices-settings-update</a>
     */
    @PATCH(USERS_URI + "/{userId}/" + MOBILE_DEVICES_URI + "/{deviceId}/" + SETTINGS_URI + "/{settingId}")
    Observable<Setting> updateMobileDeviceSettingObservable(@Path("userId") int userId, @Path("deviceId") int deviceId,
                                                            @Path("settingId") int settingId, @Body SettingUpdate update);

    /**
     * Retrieves case filters for the current user.
     *
     * @param perPage the total filters per page
     * @param page    the page requested
     * @param fields  the fields requested
     * @return a filter api response
     * @see <a href="http://dev.desk.com/API/filters/#list">http://dev.desk.com/API/filters/#list</a>
     */
    @GET(USERS_URI + "/current/" + FILTERS_URI)
    Observable<ApiResponse<Filter>> getCaseFiltersObservable(@Query("per_page") int perPage, @Query("page") int page, @Query("fields") Fields fields);


    /**
     * Retrieves company filters for the current user.
     *
     * @param perPage the total filters per page
     * @param page    the page requested
     * @param fields  the fields requested
     * @return a filter api response
     */
    @GET(USERS_URI + "/current/" + COMPANY_FILTERS_URI)
    Observable<ApiResponse<Filter>> getCompanyFiltersObservable(@Query("per_page") int perPage, @Query("page") int page, @Query("fields") Fields fields);

    /**
     * Retrieves customer filters for the current user.
     *
     * @param perPage the total filters per page
     * @param page    the page requested
     * @param fields  the fields requested
     * @return a filter api response
     */
    @GET(USERS_URI + "/current/" + CUSTOMER_FILTERS_URI)
    Observable<ApiResponse<Filter>> getCustomerFiltersObservable(@Query("per_page") int perPage, @Query("page") int page, @Query("fields") Fields fields);

    /**
     * Retrieves opportunity filters for the current user.
     *
     * @param perPage the total filters per page
     * @param page    the page requested
     * @param fields  the fields requested
     * @return a filter api response
     */
    @GET(USERS_URI + "/current/" + OPPORTUNITY_FILTERS_URI)
    Observable<ApiResponse<Filter>> getOpportunityFiltersObservable(@Query("per_page") int perPage, @Query("page") int page, @Query("fields") Fields fields);
}
