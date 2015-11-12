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

import com.desk.java.apiclient.DeskClientBuilder;
import com.desk.java.apiclient.model.ApiResponse;
import com.desk.java.apiclient.model.Article;
import com.desk.java.apiclient.model.SortDirection;
import com.desk.java.apiclient.model.Topic;

import org.jetbrains.annotations.Nullable;

import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

import static com.desk.java.apiclient.service.TopicService.TOPICS_URI;

/**
 * <p>
 *     Service interfacing with the Desk Topics endpoint. This service supports
 *     {@link DeskClientBuilder.AuthType#API_TOKEN} authentication.
 * </p>
 *
 * @see <a href="http://dev.desk.com/API/topics/">http://dev.desk.com/API/topics/</a>
 *
 * Created by Jerrell Mardis
 * Copyright (c) 2015 Desk.com. All rights reserved.
 */
public interface RxTopicService {

    /**
     * Retrieve a list of all topics.
     *
     * @param language        the ISO language code. If null default to en
     * @param inSupportCenter true to include only articles that are in the support center
     * @param brandId         the brand ID to limit results to or null for all brands
     * @param sortField       the field to sort the topics on
     * @param sortDirection   the direction to sort the topics
     * @return a topic api response
     * @see <a href="http://dev.desk.com/API/topics/#list">http://dev.desk.com/API/topics/#list</a>
     */
    @GET(TOPICS_URI)
    Observable<ApiResponse<Topic>> getTopicsObservable(@Nullable @Header("Accept-Language") String language,
                                                       @Nullable @Query("in_support_center") Boolean inSupportCenter,
                                                       @Nullable @Query("brand_id") Integer brandId,
                                                       @Nullable @Query("sort_field") String sortField,
                                                       @Nullable @Query("sort_direction") SortDirection sortDirection);

    /**
     * Retrieve a list of all articles within a topic
     *
     * @param language        the ISO language code. If null default to en
     * @param topicId         the topic ID to get the articles for
     * @param inSupportCenter true to include only articles that are in the support center
     * @return a article api response
     */
    @GET(TOPICS_URI + "/{topicId}/articles")
    Observable<ApiResponse<Article>> getArticlesOfTopicObservable(@Nullable @Header("Accept-Language") String language,
                                                                  @Path("topicId") int topicId,
                                                                  @Nullable @Query("in_support_center") Boolean inSupportCenter);
}
