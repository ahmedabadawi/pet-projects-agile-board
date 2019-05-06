import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { LoginService } from '../../services/login.service';

@Component({
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss']
})
export class LoginPage implements OnInit {
  userLoginForm: FormGroup
  formErrors = {
    'email': '',
    'password': ''
  };

  validationMessages = {
    'email': {
      'required': 'Please enter your email',
      'email': 'Please enter your valid email'
    },
    'password': {
      'required': 'Please enter your password',
      'pattern': 'The password must contain numbers and letters',
      'minlength': 'The password should be more than 8 characters',
      'maxlength': 'The password should be less than 25 characters'
    }
  };

  loginFailed = false;

  constructor(private router: Router,
              private formBuilder: FormBuilder,
              private loginService: LoginService) { }

  ngOnInit() {
    this.buildForm();
  }

  buildForm() {
    this.userLoginForm = this.formBuilder.group({
      'email': ['', [Validators.required, Validators.email]],
      'password': ['', [
        //Validators.pattern('^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9]{8})$'),
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
    if (this.loginService.login({
      username: this.userLoginForm.value.email,
      password: this.userLoginForm.value.password
    })) {
      this.loginFailed = false;
      this.router.navigate(['/']);
    } else {
      this.loginFailed = true;
    }
  }
}
