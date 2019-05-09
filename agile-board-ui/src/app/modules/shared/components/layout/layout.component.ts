import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';

import { AuthService, UserProfile } from '../../../core';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.scss']
})
export class LayoutComponent implements OnInit, OnDestroy {
  currentUserSubscription: Subscription;

  currentUser: UserProfile;

  constructor(private router: Router,
              private authService: AuthService) {
  }

  ngOnInit() {
    this.currentUserSubscription =
      this.authService.currentUser.subscribe((authUser) => {
        this.currentUser = (authUser) ? authUser.profile : null;
      });
  }

  ngOnDestroy() {
    this.currentUserSubscription.unsubscribe();
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }

  getAvatar() {
    return (this.currentUser) ? this.currentUser.avatar : '';
  }

  getFullName() {
    return (this.currentUser) ? `${this.currentUser.firstName} ${this.currentUser.lastName}`: '';
  }
}
