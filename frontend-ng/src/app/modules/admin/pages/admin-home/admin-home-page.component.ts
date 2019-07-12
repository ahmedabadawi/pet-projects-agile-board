import { Component, OnInit } from '@angular/core';
import { SelectionModel } from '@angular/cdk/collections';
import { User } from '../../models/user.model';

@Component({
  templateUrl: './admin-home-page.component.html',
  styleUrls: ['./admin-home-page.component.scss']
})
export class AdminHomePageComponent implements OnInit {

  selectedUsers: SelectionModel<User>;

  constructor() { }

  ngOnInit() {
  }

  selectionChanged(selection) {
    this.selectedUsers = selection;
  }
}
