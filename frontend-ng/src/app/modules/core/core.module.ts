import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ConfigService, AuthService, ProfileService } from './';

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers: [
    ConfigService,
    AuthService,
    ProfileService
  ]
})
export class CoreModule { }
