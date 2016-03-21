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

package com.desk.java.apiclient;

import com.desk.java.apiclient.service.RxArticleService;
import com.desk.java.apiclient.service.RxCaseService;
import com.desk.java.apiclient.service.RxCompanyService;
import com.desk.java.apiclient.service.RxCustomFieldsService;
import com.desk.java.apiclient.service.RxCustomerService;
import com.desk.java.apiclient.service.RxFilterService;
import com.desk.java.apiclient.service.RxGroupService;
import com.desk.java.apiclient.service.RxInboundMailboxService;
import com.desk.java.apiclient.service.RxLabelService;
import com.desk.java.apiclient.service.RxMacroService;
import com.desk.java.apiclient.service.RxOpportunityService;
import com.desk.java.apiclient.service.RxOpportunityStageService;
import com.desk.java.apiclient.service.RxOutboundMailboxService;
import com.desk.java.apiclient.service.RxPermissionService;
import com.desk.java.apiclient.service.RxSiteService;
import com.desk.java.apiclient.service.RxTopicService;
import com.desk.java.apiclient.service.RxTwitterAccountService;
import com.desk.java.apiclient.service.RxTwitterUserService;
import com.desk.java.apiclient.service.RxUserService;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;

import retrofit2.CallAdapter.Factory;
import retrofit2.RxJavaCallAdapterFactory;

/**
 * <p>
 *     Client which interfaces with the Desk API and exposes RxJava services.
 * </p>
 *
 * Created by Jerrell Mardis
 * Copyright (c) 2015 Desk.com. All rights reserved.
 */
public class RxDeskClient extends DeskClient {

    private RxUserService rxUserService;
    private RxSiteService rxSiteService;
    private RxLabelService rxLabelService;
    private RxCustomFieldsService rxCustomFieldsService;
    private RxGroupService rxGroupService;
    private RxMacroService rxMacroService;
    private RxOutboundMailboxService rxOutboundMailboxService;
    private RxFilterService rxFilterService;
    private RxCaseService rxCaseService;
    private RxCompanyService rxCompanyService;
    private RxCustomerService rxCustomerService;
    private RxPermissionService rxPermissionService;
    private RxTwitterUserService rxTwitterUserService;
    private RxTopicService rxTopicService;
    private RxArticleService rxArticleService;
    private RxInboundMailboxService rxInboundMailboxService;
    private RxOpportunityStageService rxOpportunityStageService;
    private RxOpportunityService rxOpportunityService;
    private RxTwitterAccountService rxTwitterAccountService;

    /**
     * Creates a {@link RxDeskClient} using the builder provided and adds a {@link RxJavaCallAdapterFactory}.
     *
     * @param builder the builder to use to build the {@link RxDeskClient}
     * @return a {@link RxDeskClient}
     */
    public static RxDeskClient create(DeskClientBuilder builder) {
        if (builder == null) {
            throw new IllegalStateException("DeskClientBuilder cannot be null.");
        }
        builder.callAdapters(Collections.singletonList((Factory) RxJavaCallAdapterFactory.create()));
        return new RxDeskClient(builder);
    }

    private RxDeskClient(DeskClientBuilder builder) {
        super(builder);
    }

    @NotNull
    public RxUserService usersRx() {
        if (rxUserService == null) {
            rxUserService = getRestAdapter().create(RxUserService.class);
        }
        return rxUserService;
    }

    @NotNull
    public RxSiteService sitesRx() {
        if (rxSiteService == null) {
            rxSiteService = getRestAdapter().create(RxSiteService.class);
        }
        return rxSiteService;
    }

    @NotNull
    public RxLabelService labelsRx() {
        if (rxLabelService == null) {
            rxLabelService = getRestAdapter().create(RxLabelService.class);
        }
        return rxLabelService;
    }

    @NotNull
    public RxCustomFieldsService customFieldsRx() {
        if (rxCustomFieldsService == null) {
            rxCustomFieldsService = getRestAdapter().create(RxCustomFieldsService.class);
        }
        return rxCustomFieldsService;
    }

    @NotNull
    public RxGroupService groupsRx() {
        if (rxGroupService == null) {
            rxGroupService = getRestAdapter().create(RxGroupService.class);
        }
        return rxGroupService;
    }

    @NotNull
    public RxMacroService macrosRx() {
        if (rxMacroService == null) {
            rxMacroService = getRestAdapter().create(RxMacroService.class);
        }
        return rxMacroService;
    }

    @NotNull
    public RxOutboundMailboxService outboundMailboxesRx() {
        if (rxOutboundMailboxService == null) {
            rxOutboundMailboxService = getRestAdapter().create(RxOutboundMailboxService.class);
        }
        return rxOutboundMailboxService;
    }

    @NotNull
    public RxFilterService filtersRx() {
        if (rxFilterService == null) {
            rxFilterService = getRestAdapter().create(RxFilterService.class);
        }
        return rxFilterService;
    }

    @NotNull
    public RxCaseService casesRx() {
        if (rxCaseService == null) {
            rxCaseService = getRestAdapter().create(RxCaseService.class);
        }
        return rxCaseService;
    }

    @NotNull
    public RxCompanyService companiesRx() {
        if (rxCompanyService == null) {
            rxCompanyService = getRestAdapter().create(RxCompanyService.class);
        }
        return rxCompanyService;
    }

    @NotNull
    public RxCustomerService customersRx() {
        if (rxCustomerService == null) {
            rxCustomerService = getRestAdapter().create(RxCustomerService.class);
        }
        return rxCustomerService;
    }

    @NotNull
    public RxPermissionService permissionsRx() {
        if (rxPermissionService == null) {
            rxPermissionService = getRestAdapter().create(RxPermissionService.class);
        }
        return rxPermissionService;
    }

    @NotNull
    public RxTwitterUserService twitterUsersRx() {
        if (rxTwitterUserService == null) {
            rxTwitterUserService = getRestAdapter().create(RxTwitterUserService.class);
        }
        return rxTwitterUserService;
    }

    @NotNull
    public RxTopicService topicsRx() {
        if (rxTopicService == null) {
            rxTopicService = getRestAdapter().create(RxTopicService.class);
        }
        return rxTopicService;
    }

    @NotNull
    public RxArticleService articlesRx() {
        if (rxArticleService == null) {
            rxArticleService = getRestAdapter().create(RxArticleService.class);
        }
        return rxArticleService;
    }

    @NotNull
    public RxInboundMailboxService inboundMailboxesRx() {
        if (rxInboundMailboxService == null) {
            rxInboundMailboxService = getRestAdapter().create(RxInboundMailboxService.class);
        }
        return rxInboundMailboxService;
    }

    @NotNull
    public RxOpportunityStageService opportunityStagesRx() {
        if (rxOpportunityStageService == null) {
            rxOpportunityStageService = getRestAdapter().create(RxOpportunityStageService.class);
        }
        return rxOpportunityStageService;
    }

    @NotNull
    public RxOpportunityService opportunitiesRx() {
        if (rxOpportunityService == null) {
            rxOpportunityService = getRestAdapter().create(RxOpportunityService.class);
        }
        return rxOpportunityService;
    }

    @NotNull
    public RxTwitterAccountService twitterAccountsRx() {
        if (rxTwitterAccountService == null) {
            rxTwitterAccountService = getRestAdapter().create(RxTwitterAccountService.class);
        }
        return rxTwitterAccountService;
    }
}
