import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { concatMap, catchError } from 'rxjs/operators';

import { Credentials } from '../models/credentials.model';
import { LoginUser } from '../models/login-user.model';

import { ConfigService } from '../../core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private config: ConfigService,
              private http: HttpClient) { }

  login(credentials: Credentials): Observable<LoginUser> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };

    return this.http.post<LoginUser>(
      this.config.api + '/api/auth',
      credentials, httpOptions);
  }
}

interface AuthResponse {
  status: string;
  token: string;
  userId: number;
}
