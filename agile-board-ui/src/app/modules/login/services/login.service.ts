import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { concatMap } from 'rxjs/operators';

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

  login(credentials: Credentials): Observable<boolean> {
    if (credentials
      && credentials.username === 'admin@corp.com'
      && credentials.password === 'Pa$$w0rd') {

      console.log('Succeeded Login - ' + credentials.username);
      const token = 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJhZ2lsZS1ib2FyZCIsImlhdCI6MTU1NzE3NzUzOCwiZXhwIjoxNTg4NzEzNTM4LCJhdWQiOiJhZ2lsZS5ib2FyZC5pbyIsInN1YiI6IjEiLCJSb2xlIjoiQURNSU4ifQ.igt5Ip7Ej8VOec0JZSbhJj28yn4CIkxQ1MwaPQp-iZc';
      const userId = 1;

      return this.profileService.getUserProfile(userId)
        .pipe(concatMap(profile => {
          console.log('Got Profile: ' + profile.firstName);
          this.authService.login(token, profile);
          console.log('Logged In - ' + profile.firstName);
          return of(true);
        }));
    } else {
      console.log('Failed Login - ' + credentials.username);
      return of(false);
    }
  }
}
