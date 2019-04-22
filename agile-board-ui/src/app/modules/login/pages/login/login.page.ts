import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
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

  constructor(private router: Router,
              private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.buildForm();
  }

  buildForm() {
    this.userLoginForm = this.formBuilder.group({
      'email': ['', [ Validators.required, Validators.email ]],
      'password': ['', [
        Validators.pattern('^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9]{8})$'),
        Validators.minLength(8),
        Validators.maxLength(25)
      ]],
    });

    this.userLoginForm.valueChanges.subscribe(data => this.onValueChanged(data));
    this.onValueChanged();
  }

  onValueChanged(data?: any) {
    // TODO: remove the error messages when changing the values
  }

  login() {
    this.router.navigate(['/']);
  }
}
