import { Injectable } from '@angular/core';

import { AuthenticatedUser } from '../models/authenticated-user.model';
import { UserProfile } from '../models/user-profile.model';

const CURRENT_USER_KEY = 'currentUser';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  public currentUser: AuthenticatedUser;

  constructor() {
    this.loadCurrentUser();
  }
  
  getCurrentUser() {
    const sessionUser = localStorage.getItem(CURRENT_USER_KEY);
    return (sessionUser) ? JSON.parse(sessionUser).profile : null;
  }

  loadCurrentUser() {
    const sessionUser = localStorage.getItem(CURRENT_USER_KEY);
    this.currentUser = (sessionUser) ? JSON.parse(sessionUser) : null;
  }

  login(token: string, userProfile: UserProfile) {
    const user: AuthenticatedUser = {
      token: token,
      profile: userProfile
    };

    localStorage.setItem(CURRENT_USER_KEY, JSON.stringify(user));
    this.loadCurrentUser();
  }

  logout() {
    localStorage.removeItem(CURRENT_USER_KEY);
    this.loadCurrentUser();
  }
}
