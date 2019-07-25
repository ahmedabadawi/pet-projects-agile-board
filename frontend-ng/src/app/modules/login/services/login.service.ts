import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { concatMap, catchError } from 'rxjs/operators';

import { Credentials } from '../models/credentials.model';
import { LoginUser } from '../models/login-user.model';

import { ConfigService } from '../../core';
import { LogService } from '../../core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private config: ConfigService,
              private http: HttpClient,
              private log: LogService) { }

  login(credentials: Credentials): Observable<LoginUser> {
    this.log.debug(`Login Attempt for user ${credentials.email}`);
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };

    return this.http.post<LoginUser>(
      this.config.api + '/api/auth',
      credentials, httpOptions);
    // TODO: Catch and Log HTTP Errors
  }
}

interface AuthResponse {
  status: string;
  token: string;
  userId: number;
}
