import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

import { UserProfile } from '../models/user-profile.model';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor() { }

  getUserProfile(id: number): Observable<UserProfile> {
    console.log('Fetching profile of id: ' + id);
    return of({
      id: 1,
      email: 'admin@corp.com',
      firstName: 'Admin',
      lastName: 'Admin',
      avatar: 'https://placeimg.com/200/200/people',
      role: 'ADMIN'
    });
  }
}
