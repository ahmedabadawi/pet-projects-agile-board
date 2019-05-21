import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { concatMap, catchError } from 'rxjs/operators';

import { Credentials } from '../models/credentials.model';
import {
  AuthService,
  ProfileService
} from '../../core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient,
              private authService: AuthService,
              private profileService: ProfileService) { }

  login(credentials: Credentials): Observable<boolean> {
    return this.http.post<any>('http://localhost:8080/api/auth/login', JSON.stringify(credentials))
      .pipe(concatMap((loginResponse) => {
        console.log('Succeeded Login - ' + credentials.username);
        const token = loginResponse.token;
        const userId = loginResponse.userId;

        return this.profileService.getUserProfile(userId)
          .pipe(concatMap(profile => {
            console.log('Got Profile: ' + profile.firstName);
            this.authService.login(token, profile);
            console.log('Logged In - ' + profile.firstName);

            return of(true);
          }));
      }),
      catchError((error) => {
        console.log(error);
        console.log(error.status);
        console.log(error.message);
        return of(false);
      }));
  }
}

interface AuthResponse {
  status: string;
  token: string;
  userId: number;
}
