import { NgModule, ModuleWithProviders } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../shared';

import { HomeComponent } from './components/home/home.component';

import { HomeRoutingModule } from './home-routing.module';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,

    HomeRoutingModule,
  ],
  exports: [  ],
  declarations: [
    HomeComponent
  ],
  providers: []
})
export class HomeModule { }
