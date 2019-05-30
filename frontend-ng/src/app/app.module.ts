import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { MAT_SNACK_BAR_DEFAULT_OPTIONS } from '@angular/material/snack-bar';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { CoreModule } from './modules/core/core.module';
import { SharedModule } from './modules/shared/shared.module';
import { HomeModule } from './modules/home/home.module';
import { LoginModule } from './modules/login/login.module';
import { ProjectsModule } from './modules/projects/projects.module';
import { BoardModule } from './modules/board/board.module';
import { AdminModule } from './modules/admin/admin.module';

import { LayoutComponent } from './modules/shared';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

// import { ServicesStubInterceptor } from './modules/core/interceptors';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,

    CoreModule,
    SharedModule,
    HomeModule,
    LoginModule,
    ProjectsModule,
    BoardModule,
    AdminModule,
  ],
  providers: [
    { provide: MAT_SNACK_BAR_DEFAULT_OPTIONS, useValue: { duration: 2500 } },
    // { provide: HTTP_INTERCEPTORS, useClass: ServicesStubInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
