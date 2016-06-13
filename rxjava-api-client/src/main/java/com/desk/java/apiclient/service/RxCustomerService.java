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

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import static com.desk.java.apiclient.service.CustomerService.FILTERS_URI;
import static com.desk.java.apiclient.service.CustomerService.COMPANIES_URI;
import static com.desk.java.apiclient.service.CustomerService.CUSTOMERS_URI;

/**
 * <p>
 *     Service interfacing with the Desk Customers endpoint
 * </p>
 *
 * @see <a href="http://dev.desk.com/API/customers/">http://dev.desk.com/API/customers/</a>
 *
 * Created by Jerrell Mardis
 * Copyright (c) 2016 Desk.com. All rights reserved.
 */
public interface RxCustomerService {

    /**
     * Checks to see if the customer 360 enhancements are enabled for the site.
     *
     * @return a feature check object indicating if it's enabled or disabled
     */
    @GET(CUSTOMERS_URI + "/enhancements_enabled")
    Observable<FeatureCheck> areEnhancementsEnabled();

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
    Observable<ApiResponse<Customer>> getCustomersByFilterObservable(@Path("id") int filterId, @Query("per_page") int perPage, @Query("page") int page,
                                                             @Query("sort_field") String sortField, @Query("sort_direction") SortDirection sortDirection,
                                                             @Query("embed") Embed embed, @Query("fields") Fields fields);

    /**
     * Retrieve a single customer
     *
     * @param customerId the customer id
     * @param embed      the objects to embed
     * @return a customer
     * @see <a href="http://dev.desk.com/API/customers/#show">http://dev.desk.com/API/customers/#show</a>
     */
    @GET(CUSTOMERS_URI + "/{id}")
    Observable<Customer> getCustomerObservable(@Path("id") int customerId, @Query("embed") Embed embed);

    /**
     * Updates a customer
     *
     * @param customerId      the customer id
     * @param updatedCustomer the updated customer
     * @return a customer
     * @see <a href="http://dev.desk.com/API/customers/#update">http://dev.desk.com/API/customers/#update</a>
     */
    @PATCH(CUSTOMERS_URI + "/{id}")
    Observable<Customer> updateCustomerObservable(@Path("id") int customerId, @Body Customer updatedCustomer);

    /**
     * Creates a customer
     *
     * @param newCustomer the customer to create
     * @return a customer
     * @see <a href="http://dev.desk.com/API/customers/#create">http://dev.desk.com/API/customers/#create</a>
     */
    @POST(CUSTOMERS_URI)
    Observable<Customer> createCustomerObservable(@Body Customer newCustomer);

    /**
     * Creates a case for the customer
     *
     * @param customerId the customer id
     * @param deskCase   the case to create
     * @return a case
     * @see <a href="http://dev.desk.com/API/cases/#create">http://dev.desk.com/API/cases/#create</a>
     */
    @POST(CUSTOMERS_URI + "/{id}/cases")
    Observable<Case> createCaseForCustomerObservable(@Path("id") int customerId, @Body Case deskCase);

    /**
     * Searches for customers
     *
     * @param query the query searching across the following fields: firstname, lastname, name, email &amp; phone
     * @param embed the fields to embed
     * @param perPage       the total customers per page
     * @param page          the page requested
     * @param sortField     the field to sort on
     * @param sortDirection the direction to sort
     * @return a customer api response
     * @see <a href="http://dev.desk.com/API/customers/#search">http://dev.desk.com/API/customers/#search</a>
     */
    @GET(CUSTOMERS_URI + "/search")
    Observable<ApiResponse<Customer>> searchCustomersObservable(@Query("q") String query, @Query("embed") Embed embed,
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
    Observable<ApiResponse<Customer>> getCustomersByCompany(@Path("id") int companyId, @Query("per_page") int perPage, @Query("page") int page);
}
