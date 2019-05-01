import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { User } from '../../models/user.model';

@Component({
  templateUrl: './user-details.page.html',
  styleUrls: ['./user-details.page.scss']
})
export class UserDetailsPage implements OnInit {
  userId?: any;
  user: User;

  constructor(private route: ActivatedRoute) {
    this.route.params.subscribe(params => this.userId = params.userId);
  }

  ngOnInit() {
  }

  isNew() {
    console.log(this.userId);
    return (this.userId == null);
  }
}
