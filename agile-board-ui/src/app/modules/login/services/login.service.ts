import { Injectable } from '@angular/core';

import { Credentials } from '../models/credentials.model';
import {
  AuthService,
  ProfileService
} from '../../core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private authService: AuthService,
              private profileService: ProfileService) { }

  login(credentials: Credentials) {
    if (credentials
      && credentials.username === 'admin@corp.com'
      && credentials.password === 'Pa$$w0rd') {

      const token = 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJhZ2lsZS1ib2FyZCIsImlhdCI6MTU1NzE3NzUzOCwiZXhwIjoxNTg4NzEzNTM4LCJhdWQiOiJhZ2lsZS5ib2FyZC5pbyIsInN1YiI6IjEiLCJSb2xlIjoiQURNSU4ifQ.igt5Ip7Ej8VOec0JZSbhJj28yn4CIkxQ1MwaPQp-iZc';
      const userId = 1;

      const profile = this.profileService.getUserProfile(userId);

      this.authService.login(token, profile);

      return true;
    }
    return false;
  }
}
