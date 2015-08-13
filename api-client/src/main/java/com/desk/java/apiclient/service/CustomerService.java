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
 *     Service interfacing with the Desk Customers endpoint
 * </p>
 *
 * Created by Matt Kranzler on 5/6/15.
 * Copyright (c) 2015 Desk.com. All rights reserved.
 *
 * @see <a href="http://dev.desk.com/API/customers/">http://dev.desk.com/API/customers/</a>
 */
public interface CustomerService {

    // URIs
    String CUSTOMERS_URI = "/customers";

    // Embeds
    String EMBED_FACEBOOK_USER = "facebook_user";
    String EMBED_TWITTER_USER = "twitter_user";

    /**
     * Retrieve a single customer
     * @see <a href="http://dev.desk.com/API/customers/#show">http://dev.desk.com/API/customers/#show</a>
     *
     * @param customerId the customer id
     * @param embed the objects to embed
     * @param callback the callback upon success or failure
     */
    @GET(CUSTOMERS_URI + "/{id}")
    void getCustomer(@Path("id") int customerId, @Query("embed") Embed embed, Callback<Customer> callback);

    /**
     * Retrieve a single customer
     * @see <a href="http://dev.desk.com/API/customers/#show">http://dev.desk.com/API/customers/#show</a>
     *
     * @param customerId the customer id
     * @param embed the objects to embed
     * @return a customer
     */
    @GET(CUSTOMERS_URI + "/{id}")
    Customer getCustomer(@Path("id") int customerId, @Query("embed") Embed embed);

    /**
     * Updates a customer
     * @see <a href="http://dev.desk.com/API/customers/#update">http://dev.desk.com/API/customers/#update</a>
     *
     * @param customerId the customer id
     * @param updatedCustomer the updated customer
     * @param callback the callback upon success or failure
     */
    @PATCH(CUSTOMERS_URI + "/{id}")
    void updateCustomer(@Path("id") int customerId, @Body Customer updatedCustomer, Callback<Customer> callback);

    /**
     * Updates a customer
     * @see <a href="http://dev.desk.com/API/customers/#update">http://dev.desk.com/API/customers/#update</a>
     *
     * @param customerId the customer id
     * @param updatedCustomer the updated customer
     * @return a customer
     */
    @PATCH(CUSTOMERS_URI + "/{id}")
    Customer updateCustomer(@Path("id") int customerId, @Body Customer updatedCustomer);

    /**
     * Creates a customer
     * @see <a href="http://dev.desk.com/API/customers/#create">http://dev.desk.com/API/customers/#create</a>
     *
     * @param newCustomer the customer to create
     * @param callback the callback upon success or failure
     */
    @POST(CUSTOMERS_URI)
    void createCustomer(@Body Customer newCustomer, Callback<Customer> callback);

    /**
     * Creates a customer
     * @see <a href="http://dev.desk.com/API/customers/#create">http://dev.desk.com/API/customers/#create</a>
     *
     * @param newCustomer the customer to create
     * @return a customer
     */
    @POST(CUSTOMERS_URI)
    Customer createCustomer(@Body Customer newCustomer);

    /**
     * Creates a case for the customer
     * @see <a href="http://dev.desk.com/API/cases/#create">http://dev.desk.com/API/cases/#create</a>
     *
     * @param customerId the customer id
     * @param deskCase the case to create
     * @param callback the callback upon success or failure
     */
    @POST(CUSTOMERS_URI + "/{id}/cases")
    void createCaseForCustomer(@Path("id") int customerId, @Body Case deskCase, Callback<Case> callback);

    /**
     * Creates a case for the customer
     * @see <a href="http://dev.desk.com/API/cases/#create">http://dev.desk.com/API/cases/#create</a>
     *
     * @param customerId the customer id
     * @param deskCase the case to create
     * @return a case
     */
    @POST(CUSTOMERS_URI + "/{id}/cases")
    Case createCaseForCustomer(@Path("id") int customerId, @Body Case deskCase);

    /**
     * Searches for customers
     * @see <a href="http://dev.desk.com/API/customers/#search">http://dev.desk.com/API/customers/#search</a>
     *
     * @param query the query searching across the following fields: firstname, lastname, name, email &amp; phone
     * @param embed the fields to embed
     * @param callback the callback upon success or failure
     */
    @GET(CUSTOMERS_URI + "/search")
    void searchCustomers(@Query("q") String query, @Query("embed") Embed embed, Callback<ApiResponse<Customer>> callback);

    /**
     * Searches for customers
     * @see <a href="http://dev.desk.com/API/customers/#search">http://dev.desk.com/API/customers/#search</a>
     *
     * @param query the query searching across the following fields: firstname, lastname, name, email &amp; phone
     * @param embed the fields to embed
     * @return a customer api response
     */
    @GET(CUSTOMERS_URI + "/search")
    ApiResponse<Customer> searchCustomers(@Query("q") String query, @Query("embed") Embed embed);
}
