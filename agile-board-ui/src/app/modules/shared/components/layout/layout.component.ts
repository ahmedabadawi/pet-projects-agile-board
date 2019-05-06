import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AuthService, UserProfile } from '../../../core';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.scss']
})
export class LayoutComponent implements OnInit {
  currentUser: UserProfile;

  constructor(private router: Router,
              private authService: AuthService) {
    this.currentUser = this.authService.getCurrentUser();
  }

  ngOnInit() {
    this.currentUser = this.authService.getCurrentUser();
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
