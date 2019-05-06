import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthService, ProfileService } from './';

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers: [
    AuthService,
    ProfileService
  ]
})
export class CoreModule { }
