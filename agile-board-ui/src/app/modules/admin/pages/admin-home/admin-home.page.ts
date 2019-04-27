import { Component, OnInit } from '@angular/core';
import { SelectionModel } from '@angular/cdk/collections';
import { User } from '../../models/user.model';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.page.html',
  styleUrls: ['./admin-home.page.scss']
})
export class AdminHomePage implements OnInit {

  selectedUsers: SelectionModel<User>;

  constructor() { }

  ngOnInit() {
  }

  selectionChanged(selection) {
    this.selectedUsers = selection;
  }
}
