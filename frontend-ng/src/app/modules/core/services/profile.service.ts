import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
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

  getUserProfile(id: number): Observable<UserProfile> {
    this.log.debug(`getUserProfile(${id})`);
    return this.http.get<UserProfile>(`${this.config.api}/api/profile/${id}`);
  }
}
