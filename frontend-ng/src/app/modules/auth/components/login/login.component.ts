import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import {
  AuthService,
  ProfileService
} from '../../../core';

import { LoginService } from '../../services/login.service';

import { LoginUser } from '../../models/login-user.model';

import { ConfigService } from '../../../core';
import { LogService } from '../../../core';

@Component({
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  userLoginForm: FormGroup;
  formErrors = {
    email: '',
    password: ''
  };

  validationMessages = {
    email: {
      required: 'Please enter your email',
      email: 'Please enter your valid email'
    },
    password: {
      required: 'Please enter your password',
      pattern: 'The password must contain numbers and letters',
      minlength: 'The password should be more than 8 characters',
      maxlength: 'The password should be less than 25 characters'
    }
  };

  loginFailed = false;

  constructor(private router: Router,
              private formBuilder: FormBuilder,
              private loginService: LoginService,
              private profileService: ProfileService,
              private authService: AuthService,
              private config: ConfigService,
              private log: LogService) { }

  ngOnInit() {
    this.buildForm();
  }

  buildForm() {
    this.userLoginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [
        // Validators.pattern('^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9]{8})$'),
        Validators.minLength(8),
        Validators.maxLength(25)
      ]],
    });

    this.userLoginForm.valueChanges.subscribe(data => this.onValueChanged(data));
    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    this.formErrors.email = '';
    this.formErrors.password = '';

  }

  login() {
    this.loginService.login({
      email: this.userLoginForm.value.email,
      password: this.userLoginForm.value.password
      }).subscribe(
        (loginUser: LoginUser) => {
          this.profileService.getUserProfile(loginUser.userId)
            .subscribe(
              (profile) => {
                this.authService.login(loginUser.token, profile);
                this.loginFailed = false;
                this.router.navigate(['/']);
              },
              (error) => {
                this.log.error(`Failed to retrieve User Profile ${loginUser.userId} - ${error}`);
                this.loginFailed = true;
              });
        },
        (error) => {
          this.log.error(`Failed to Login - ${this.userLoginForm.value.email} - ${error}`);
          this.loginFailed = true;
        });
  }
}
