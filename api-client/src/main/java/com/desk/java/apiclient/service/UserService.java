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

import com.desk.java.apiclient.model.*;
import retrofit.Callback;
import retrofit.http.*;

/**
 * <p>
 *     Service interfacing with the Desk Users endpoint
 * </p>
 *
 * Created by Matt Kranzler on 4/28/15.
 * Copyright (c) 2015 Desk.com. All rights reserved.
 *
 * @see <a href="http://dev.desk.com/API/users/">http://dev.desk.com/API/users/</a>
 */
public interface UserService {

    String USERS_URI = "/users";
    String MOBILE_DEVICES_URI = "/mobile_devices";
    String SETTINGS_URI = "/settings";

    int MAX_PER_PAGE = 100;

    /**
     * Retrieve a paginated list of all users
     * @see <a href="http://dev.desk.com/API/users/#list">http://dev.desk.com/API/users/#list</a>
     *
     * @param perPage the amount of labels per page
     * @param page the page
     * @param callback the callback upon success or failure
     */
    @GET(USERS_URI)
    void getUsers(@Query("per_page") int perPage, @Query("page") int page, Callback<ApiResponse<User>> callback);

    /**
     * Retrieve a paginated list of all users
     * @see <a href="http://dev.desk.com/API/users/#list">http://dev.desk.com/API/users/#list</a>
     *
     * @param perPage the amount of labels per page
     * @param page the page
     * @return a user api response
     */
    @GET(USERS_URI)
    ApiResponse<User> getUsers(@Query("per_page") int perPage, @Query("page") int page);

    /**
     * Retrieves the current user (API authentication must be present)
     * @see <a href="http://dev.desk.com/API/users/#show">http://dev.desk.com/API/users/#show</a>
     *
     * @param callback the callback upon success or failure
     */
    @GET(USERS_URI + "/current")
    void getCurrentUser(Callback<User> callback);

    /**
     * Retrieves the current user (API authentication must be present)
     * @see <a href="http://dev.desk.com/API/users/#show">http://dev.desk.com/API/users/#show</a>
     *
     * @return a user
     */
    @GET(USERS_URI + "/current")
    User getCurrentUser();

    /**
     * Logs out the current user (undocumented)
     *
     * @param callback the callback upon success or failure
     */
    @POST(USERS_URI + "/me/logout")
    void logoutCurrentUser(Callback<Void> callback);

    /**
     * Logs out the current user (undocumented)
     *
     * @return Void
     */
    @POST(USERS_URI + "/me/logout")
    Void logoutCurrentUser();

    /**
     * Retrieve a single user
     * @see <a href="http://dev.desk.com/API/users/#show">http://dev.desk.com/API/users/#show</a>
     *
     * @param userId the user id
     * @param callback the callback upon success or failure
     */
    @GET(USERS_URI + "/{id}")
    void getUser(@Path("id") int userId, Callback<User> callback);

    /**
     * Retrieve a single user
     * @see <a href="http://dev.desk.com/API/users/#show">http://dev.desk.com/API/users/#show</a>
     *
     * @param userId the user id
     * @return a user
     */
    @GET(USERS_URI + "/{id}")
    User getUser(@Path("id") int userId);

    /**
     * List all of the user's mobile devices.
     * @see <a href="http://dev.desk.com/API/users/#mobile-devices-list">http://dev.desk.com/API/users/#mobile-devices-list</a>
     *
     * @param userId the user id
     * @param callback the callback upon success or failure
     */
    @GET(USERS_URI + "/{id}" + MOBILE_DEVICES_URI)
    void getMobileDevicesForUser(@Path("id") int userId, Callback<ApiResponse<MobileDevice>> callback);

    /**
     * List all of the user's mobile devices.
     * @see <a href="http://dev.desk.com/API/users/#mobile-devices-list">http://dev.desk.com/API/users/#mobile-devices-list</a>
     *
     * @param userId the user id
     * @return a mobile device api response
     */
    @GET(USERS_URI + "/{id}" + MOBILE_DEVICES_URI)
    ApiResponse<MobileDevice> getMobileDevicesForUser(@Path("id") int userId);

    /**
     * Creates a mobile device for the current user
     *
     * @param device the device to create with token
     * @param callback the callback upon success or failure
     */
    @POST(USERS_URI + "/current" + MOBILE_DEVICES_URI)
    void createMobileDevice(@Body MobileDevice device, Callback<MobileDevice> callback);

    /**
     * Creates a mobile device for the current user
     *
     * @param device the device to create with token
     * @return a mobile device
     */
    @POST(USERS_URI + "/current" + MOBILE_DEVICES_URI)
    MobileDevice createMobileDevice(@Body MobileDevice device);

    /**
     * Deletes a mobile device for the current user
     *
     * @param id the device id to delete
     * @return nothing
     */
    @DELETE(USERS_URI + "/current" + MOBILE_DEVICES_URI + "/{id}")
    Void deleteMobileDevice(@Path("id") int id);

    /**
     * Deletes a mobile device for the current user
     *
     * @param id the device id to delete
     * @param callback the callback upon success or failure
     */
    @DELETE(USERS_URI + "/current" + MOBILE_DEVICES_URI + "/{id}")
    void deleteMobileDevice(@Path("id") int id, Callback<Void> callback);

    /**
     * Retrieve a list of mobile device settings.
     * @see <a href="http://dev.desk.com/API/users/#mobile-devices-settings-list">http://dev.desk.com/API/users/#mobile-devices-settings-list</a>
     *
     * @param userId the user id
     * @param deviceId the device id
     * @param callback the callback upon success or failure
     */
    @GET(USERS_URI + "/{userId}" + MOBILE_DEVICES_URI + "/{deviceId}" + SETTINGS_URI)
    void getMobileDevicesSettings(@Path("userId") int userId, @Path("deviceId") int deviceId, Callback<ApiResponse<Setting>> callback);

    /**
     * Retrieve a list of mobile device settings.
     * @see <a href="http://dev.desk.com/API/users/#mobile-devices-settings-list">http://dev.desk.com/API/users/#mobile-devices-settings-list</a>
     *
     * @param userId the user id
     * @param deviceId the device id
     * @return a setting api response
     */
    @GET(USERS_URI + "/{userId}" + MOBILE_DEVICES_URI + "/{deviceId}" + SETTINGS_URI)
    ApiResponse<Setting> getMobileDevicesSettings(@Path("userId") int userId, @Path("deviceId") int deviceId);

    /**
     * Update a mobile device setting
     * @see <a href="http://dev.desk.com/API/users/#mobile-devices-settings-update">http://dev.desk.com/API/users/#mobile-devices-settings-update</a>
     *
     * @param userId the user id
     * @param deviceId the device id
     * @param settingId the setting id
     * @param update the setting update body
     * @param callback the callback upon success or failure
     */
    @PATCH(USERS_URI + "/{userId}" + MOBILE_DEVICES_URI + "/{deviceId}" + SETTINGS_URI + "/{settingId}")
    void updateMobileDeviceSetting(@Path("userId") int userId, @Path("deviceId") int deviceId,
                                   @Path("settingId") int settingId, @Body SettingUpdate update, Callback<Setting> callback);

    /**
     * Update a mobile device setting
     * @see <a href="http://dev.desk.com/API/users/#mobile-devices-settings-update">http://dev.desk.com/API/users/#mobile-devices-settings-update</a>
     *
     * @param userId the user id
     * @param deviceId the device id
     * @param settingId the setting id
     * @param update the setting update body
     * @return a setting
     */
    @PATCH(USERS_URI + "/{userId}" + MOBILE_DEVICES_URI + "/{deviceId}" + SETTINGS_URI + "/{settingId}")
    Setting updateMobileDeviceSetting(@Path("userId") int userId, @Path("deviceId") int deviceId,
                                   @Path("settingId") int settingId, @Body SettingUpdate update);
}
