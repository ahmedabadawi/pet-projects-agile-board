import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { first } from 'rxjs/operators';

import { MatSnackBar } from '@angular/material/snack-bar';

import { UsersService } from '../../services/users.service';
import { User } from '../../models/user.model';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: [ './user-details.component.scss' ]
})
export class UserDetailsComponent implements OnInit {
  @Input() userId: number;

  userForm: FormGroup;

  constructor(private usersService: UsersService,
              private router: Router,
              private formBuilder: FormBuilder,
              private snackBar: MatSnackBar) {
    this.userForm = formBuilder.group({
      id: new FormControl(''),
      email: new FormControl(''),
      firstName: new FormControl(''),
      lastName: new FormControl('')
    });
  }

  ngOnInit() {
    console.log('Finding user for id:' + this.userId);
    this.usersService.findById(this.userId)
      .pipe(first())
      .subscribe(
        user => {
          if (user) {
            this.fillForm(user);
          } else {
            // TODO: Show error that the user id is incorrect
          }
        },
        error => {
          console.log(error);
        }
      );
  }

  onSubmit() {
    const updatedUser: User = this.packUser();
    console.log(updatedUser);
    this.usersService.save(updatedUser)
      .pipe(first())
      .subscribe(
        result => {
          if (result) {
            this.router.navigate(['/admin']);
            this.snackBar.open(`User ${updatedUser.email} has been saved.`, 'dismiss');
          }
        },
        error => {
          console.log(error);
        }
      );
  }

  fillForm(user: User) {
    this.userForm.setValue({
      id: user.id,
      email: user.email,
      firstName: user.firstName,
      lastName: user.lastName
    });
  }

  packUser(): User {
    return {
      id: this.userForm.value.id,
      email: this.userForm.value.email,
      firstName: this.userForm.value.firstName,
      lastName: this.userForm.value.lastName,
      lastLogin: null
    };
  }

  cancel() {
    this.router.navigate(['/admin']);
  }
}
