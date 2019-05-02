import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

import { UsersService } from '../../services/users.service';
import { User } from '../../models/user.model';

@Component({
  selector: 'app-user-new',
  templateUrl: './user-new.component.html',
  styleUrls: [ './user-new.component.scss' ]
})
export class UserNewComponent implements OnInit {
  newUserForm: FormGroup;

  constructor(private usersService: UsersService,
              private router: Router,
              private formBuilder: FormBuilder,
              private snackBar: MatSnackBar) {
    this.newUserForm = formBuilder.group({
      hideRequired: false,
      floatLabel: 'auto',
      id: new FormControl(''),
      email: new FormControl(''),
      firstName: new FormControl(''),
      lastName: new FormControl('')
    });
  }

  ngOnInit() {
  }

  onSubmit() {
    const newUser: User = this.packUser();
    console.log(newUser);
    this.usersService.save(newUser);
    this.router.navigate(['/admin']);
    this.snackBar.open(`User ${newUser.email} has been saved.`, 'dismiss');
  }

  packUser(): User {
    return {
      id: this.newUserForm.value.id,
      email: this.newUserForm.value.email,
      firstName: this.newUserForm.value.firstName,
      lastName: this.newUserForm.value.lastName,
      lastLogin: null
    };
  }

  cancel() {
    this.router.navigate(['/admin']);
  }
}
