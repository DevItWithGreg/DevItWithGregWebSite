import './vendor.ts';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Ng2Webstorage } from 'ng2-webstorage';

import { DevItWithGregWebSiteSharedModule, UserRouteAccessService } from './shared';
import { DevItWithGregWebSiteHomeModule } from './home/home.module';
import { DevItWithGregWebSiteAdminModule } from './admin/admin.module';
import { DevItWithGregWebSiteAccountModule } from './account/account.module';
import { DevItWithGregWebSiteEntityModule } from './entities/entity.module';

import { customHttpProvider } from './blocks/interceptor/http.provider';
import { PaginationConfig } from './blocks/config/uib-pagination.config';

// jhipster-needle-angular-add-module-import JHipster will add new module here

import {
    JhiMainComponent,
    LayoutRoutingModule,
    NavbarComponent,
    FooterComponent,
    ProfileService,
    PageRibbonComponent,
    ActiveMenuDirective,
    ErrorComponent
} from './layouts';

@NgModule({
    imports: [
        BrowserModule,
        LayoutRoutingModule,
        Ng2Webstorage.forRoot({ prefix: 'jhi', separator: '-'}),
        DevItWithGregWebSiteSharedModule,
        DevItWithGregWebSiteHomeModule,
        DevItWithGregWebSiteAdminModule,
        DevItWithGregWebSiteAccountModule,
        DevItWithGregWebSiteEntityModule,
        // jhipster-needle-angular-add-module JHipster will add new module here
    ],
    declarations: [
        JhiMainComponent,
        NavbarComponent,
        ErrorComponent,
        PageRibbonComponent,
        ActiveMenuDirective,
        FooterComponent
    ],
    providers: [
        ProfileService,
        customHttpProvider(),
        PaginationConfig,
        UserRouteAccessService
    ],
    bootstrap: [ JhiMainComponent ]
})
export class DevItWithGregWebSiteAppModule {}
