import { NgModule } from '@angular/core';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

import { SharedModule } from '../shared';

import { LoginComponent } from './components/login/login.component';
import { LoginService } from './services/login.service';

import { AuthRoutingModule } from './auth-routing.module';

@NgModule({
  imports: [
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    SharedModule,

    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,

    AuthRoutingModule
  ],
  exports: [ ],
  declarations: [
    LoginComponent
  ],
  providers: [ LoginService ]
})
export class AuthModule { }
