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

import com.desk.java.apiclient.model.ApiResponse;
import com.desk.java.apiclient.model.Case;
import com.desk.java.apiclient.model.Customer;
import com.desk.java.apiclient.model.Embed;
import com.desk.java.apiclient.model.FeatureCheck;
import com.desk.java.apiclient.model.Fields;
import com.desk.java.apiclient.model.SortDirection;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * <p>
 *     Service interfacing with the Desk Customers endpoint
 * </p>
 *
 * Created by Matt Kranzler on 5/6/15.
 * Copyright (c) 2016 Desk.com. All rights reserved.
 *
 * @see <a href="http://dev.desk.com/API/customers/">http://dev.desk.com/API/customers/</a>
 */
public interface CustomerService {

    // URIs
    String COMPANIES_URI = "companies";
    String CUSTOMERS_URI = "customers";
    String FILTERS_URI = "customer_filters";

    // Fields
    String FIELD_ID = "id";
    String FIELD_FIRST_NAME = "first_name";
    String FIELD_LAST_NAME = "last_name";
    String FIELD_COMPANY = "company";
    String FIELD_TITLE = "title";
    String FIELD_EMAILS = "emails";
    String FIELD_PHONE_NUMBERS = "phone_numbers";
    String FIELD_ADDRESSES = "addresses";
    String FIELD_CUSTOM_FIELDS = "custom_fields";
    String FIELD_DISPLAY_NAME = "display_name";

    // Sorts fields
    String SORT_FIELD_CREATED_AT = "created_at";
    String SORT_FIELD_UPDATED_AT = "updated_at";
    String SORT_FIELD_EXTERNAL_ID = "external_id";

    // Embeds
    String EMBED_FACEBOOK_USER = "facebook_user";
    String EMBED_TWITTER_USER = "twitter_user";

    /**
     * Checks to see if the customer 360 enhancements are enabled for the site.
     *
     * @return a feature check object indicating if it's enabled or disabled
     */
    @GET(CUSTOMERS_URI + "/enhancements_enabled")
    Call<FeatureCheck> areEnhancementsEnabled();

    /**
     * Retrieves customers for a given filter
     *
     * @param filterId      the id of the filter
     * @param perPage       the total filters per page
     * @param page          the page requested
     * @param sortField     the field to sort on
     * @param sortDirection the direction to sort
     * @param embed         what to embed
     * @param fields        the fields requested
     * @return a customer api response
     * @see <a href="http://dev.desk.com/API/customers/#list">http://dev.desk.com/API/customers/#list</a>
     */
    @GET(FILTERS_URI + "/{id}/" + CUSTOMERS_URI)
    Call<ApiResponse<Customer>> getCustomersByFilterObservable(@Path("id") int filterId, @Query("per_page") int perPage, @Query("page") int page,
                                                                 @Query("sort_field") String sortField, @Query("sort_direction") SortDirection sortDirection,
                                                                 @Query("embed") Embed embed, @Query("fields") Fields fields);

    /**
     * Retrieve a single customer
     * @see <a href="http://dev.desk.com/API/customers/#show">http://dev.desk.com/API/customers/#show</a>
     *
     * @param customerId the customer id
     * @param embed the objects to embed
     * @return a customer
     */
    @GET(CUSTOMERS_URI + "/{id}")
    Call<Customer> getCustomer(@Path("id") int customerId, @Query("embed") Embed embed);

    /**
     * Updates a customer
     * @see <a href="http://dev.desk.com/API/customers/#update">http://dev.desk.com/API/customers/#update</a>
     *
     * @param customerId the customer id
     * @param updatedCustomer the updated customer
     * @return a customer
     */
    @PATCH(CUSTOMERS_URI + "/{id}")
    Call<Customer> updateCustomer(@Path("id") int customerId, @Body Customer updatedCustomer);

    /**
     * Creates a customer
     * @see <a href="http://dev.desk.com/API/customers/#create">http://dev.desk.com/API/customers/#create</a>
     *
     * @param newCustomer the customer to create
     * @return a customer
     */
    @POST(CUSTOMERS_URI)
    Call<Customer> createCustomer(@Body Customer newCustomer);

    /**
     * Creates a case for the customer
     * @see <a href="http://dev.desk.com/API/cases/#create">http://dev.desk.com/API/cases/#create</a>
     *
     * @param customerId the customer id
     * @param deskCase the case to create
     * @return a case
     */
    @POST(CUSTOMERS_URI + "/{id}/cases")
    Call<Case> createCaseForCustomer(@Path("id") int customerId, @Body Case deskCase);

    /**
     * Searches for customers
     * @see <a href="http://dev.desk.com/API/customers/#search">http://dev.desk.com/API/customers/#search</a>
     *
     * @param query the query searching across the following fields: firstname, lastname, name, email &amp; phone
     * @param embed the fields to embed
     * @param perPage       the total customers per page
     * @param page          the page requested
     * @param sortField     the field to sort on
     * @param sortDirection the direction to sort
     * @return a customer api response
     */
    @GET(CUSTOMERS_URI + "/search")
    Call<ApiResponse<Customer>> searchCustomers(@Query("q") String query, @Query("embed") Embed embed,
                                                @Query("per_page") int perPage, @Query("page") int page,
                                                @Query("sort_field") String sortField,
                                                @Query("sort_direction") SortDirection sortDirection);

    /**
     * Retrieves customers by the company provided.
     *
     * @param companyId the company Id
     * @param perPage the total cases per page
     * @param page the page requested
     * @return a customer response
     */
    @GET(COMPANIES_URI + "/{id}/" + CUSTOMERS_URI)
    Call<ApiResponse<Customer>> getCustomersByCompany(@Path("id") int companyId, @Query("per_page") int perPage, @Query("page") int page);
}
