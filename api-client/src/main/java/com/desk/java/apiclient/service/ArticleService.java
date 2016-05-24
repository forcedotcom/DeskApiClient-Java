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
import com.desk.java.apiclient.model.Article;
import com.desk.java.apiclient.model.BrandIds;
import com.desk.java.apiclient.model.SortDirection;
import com.desk.java.apiclient.model.TopicIds;

import org.jetbrains.annotations.Nullable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * <p>
 * Service interfacing with the Desk Article endpoint. This service supports {@link com.desk.java.apiclient.DeskClientBuilder.AuthType#API_TOKEN} authentication
 * </p>
 *
 * Created by Matt Kranzler on 6/25/15.
 * Copyright (c) 2016 Desk.com. All rights reserved.
 *
 * @see <a href="http://dev.desk.com/API/articles">http://dev.desk.com/API/articles</a>
 */
public interface ArticleService {

    // URIs
    String ARTICLES_URI = "articles";

    // Fields
    String FIELD_ID = "id";
    String FIELD_CREATED_AT = "created_at";
    String FIELD_UPDATED_AT = "updated_at";
    String FIELD_SUBJECT = "subject";
    String FIELD_POSITION = "position";
    String FIELD_VIEWS = "views";
    String FIELD_RATING = "rating";
    String FIELD_SCORE = "score";

    /**
     * Retrieve a list of all articles.
     * @see <a href="http://dev.desk.com/API/articles/#list">http://dev.desk.com/API/articles/#list</a>
     *
     * @param language the ISO language code. If null default to en
     * @param page the page to retrieve
     * @param perPage how many entries per page
     * @param inSupportCenter true to include only articles that are in the support center
     * @return an article api response
     */
    @GET(ARTICLES_URI)
    Call<ApiResponse<Article>> getArticles(
            @Header("Accept-Language") String language, @Query("page") int page, @Query("per_page") int perPage,
            @Nullable @Query("in_support_center") Boolean inSupportCenter);

    /**
     * Retrieve a list of all articles filtered by topics and/or brands
     *
     * @param language the ISO language code. If null default to en
     * @param page the page to retrieve
     * @param perPage how many entries per page
     * @param inSupportCenter true to include only articles that are in the support center
     * @param topicIds the topic IDs to limit results to or null for all topics
     * @param brandIds the brand IDs to limit results to or null for all brands
     * @param sortField the field to sort the results on
     * @param sortDirection the direction to sort the results
     * @return an article api response
     */
    @GET(ARTICLES_URI + "/search")
    Call<ApiResponse<Article>> getArticles(@Header("Accept-Language") String language,
                                     @Query("page") int page, @Query("per_page") int perPage,
                                     @Nullable @Query("in_support_center") Boolean inSupportCenter,
                                     @Nullable @Query("topic_ids") TopicIds topicIds,
                                     @Nullable @Query("brand_ids") BrandIds brandIds,
                                     @Nullable @Query("sort_field") String sortField,
                                     @Nullable @Query("sort_direction") SortDirection sortDirection);

    /**
     * Perform a search across all public articles.
     * @see <a href="http://dev.desk.com/API/articles/#search">http://dev.desk.com/API/articles/#search</a>
     *
     * @param language the ISO language code. If null default to en
     * @param page the page to retrieve
     * @param perPage how many entries per page
     * @param topicIds the topic IDs to limit results to or null for all topics
     * @param brandIds the brand IDs to limit results to or null for all brands
     * @param inSupportCenter true to include only articles that are in the support center
     * @param sortField the field to sort the results on
     * @param sortDirection the direction to sort the results
     * @param searchTerm Search terms. Can be any text and will search across subject, body_text, keywords, question, answer
     * @return an article api response
     */
    @GET(ARTICLES_URI + "/search")
    Call<ApiResponse<Article>> searchArticles(@Header("Accept-Language") String language,
                                        @Query("page") int page, @Query("per_page") int perPage,
                                        @Nullable @Query("topic_ids") TopicIds topicIds,
                                        @Nullable @Query("brand_ids") BrandIds brandIds,
                                        @Nullable @Query("in_support_center") Boolean inSupportCenter,
                                        @Nullable @Query("sort_field") String sortField,
                                        @Nullable @Query("sort_direction") SortDirection sortDirection,
                                        @Query("text") String searchTerm);
}
