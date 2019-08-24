import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { ConfigService } from './config.service';
import { LogService } from './log.service';

import { UserProfile } from '../models/user-profile.model';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private config: ConfigService,
              private http: HttpClient,
              private log: LogService) { }

  /* tslint:disable: object-literal-key-quotes */
  getUserProfile(id: number, token: string): Observable<UserProfile> {
    this.log.debug(`getUserProfile(${id})`);
    const httpOptions = {
      headers: new HttpHeaders({
        'Authorization': `Bearer ${token}`, // TODO: Refactor the login to be separate from retrieving the user profile
        'Accept': 'application/json'
      })
    };
    return this.http.get<UserProfile>(`${this.config.api}/api/profile/${id}`,
      httpOptions);
  }
}
