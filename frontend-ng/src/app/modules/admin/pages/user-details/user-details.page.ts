import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { take } from 'rxjs/operators';

import { User } from '../../models/user.model';

@Component({
  templateUrl: './user-details.page.html',
  styleUrls: ['./user-details.page.scss']
})
export class UserDetailsPage implements OnInit {
  userId?: any;
  user: User;

  constructor(private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.params
      .pipe(take(1))
      .subscribe(params => this.userId = params.userId);
  }

  isNew() {
    return (this.userId == null);
  }
}
