import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';

import { ConfigService } from './config.service';
import { LogService } from './log.service';

import { AuthenticatedUser } from '../models/authenticated-user.model';
import { UserProfile } from '../models/user-profile.model';

const CURRENT_USER_KEY = 'currentUser';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  public currentUser: Observable<AuthenticatedUser>;
  private currentUserEmitter: BehaviorSubject<AuthenticatedUser>;

  constructor(private config: ConfigService,
              private log: LogService) {
    this.currentUserEmitter =
      new BehaviorSubject<AuthenticatedUser>(
        this.loadCurrentUser());
    this.currentUser = this.currentUserEmitter.asObservable();
  }

  loadCurrentUser(): AuthenticatedUser {
    const sessionUser = localStorage.getItem(CURRENT_USER_KEY);
    return (sessionUser) ? JSON.parse(sessionUser) : null;
  }

  public getCurrentUserProfile(): UserProfile {
    return (this.isAuthenticated) ? this.currentUserEmitter.value.profile : null;
  }

  public isAuthenticated(): boolean {
    return this.currentUserEmitter.value != null;
  }

  public getToken(): string {
    return this.currentUserEmitter.value.token;
  }

  login(token: string, userProfile: UserProfile) {
    this.log.debug(`User ${userProfile.id} Logged In`);

    const user: AuthenticatedUser = {
      token,
      profile: userProfile
    };

    localStorage.setItem(CURRENT_USER_KEY, JSON.stringify(user));
    this.currentUserEmitter.next(user);
  }

  logout() {
    localStorage.removeItem(CURRENT_USER_KEY);
    this.currentUserEmitter.next(null);
  }
}
