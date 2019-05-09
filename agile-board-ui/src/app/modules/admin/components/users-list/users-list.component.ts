import { Component, OnInit, ElementRef, ViewChild, Output, EventEmitter } from '@angular/core';
import { first } from 'rxjs/operators';

import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { SelectionModel } from '@angular/cdk/collections';

import { User } from '../../models/user.model';
import { UsersService } from '../../services/users.service';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: [ './users-list.component.scss' ]
})
export class UsersListComponent implements OnInit {
  @Output() selectionChanged: EventEmitter<SelectionModel<User>> = new EventEmitter<SelectionModel<User>>();

  displayedColumns = [ 'select', 'userId', 'email', 'firstName', 'lastName', 'lastLogin' ];
  dataSource: MatTableDataSource<User>;
  selection = new SelectionModel<User>(true, []);

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private usersService: UsersService) { }

  ngOnInit() {
    this.usersService.getAll()
      .pipe(first())
      .subscribe(
        users => {
          this.dataSource = new MatTableDataSource<User>(users);
        },
        error => {
          console.log(error);
        }
      );
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  selectUser(row: User) {
    this.selection.toggle(row);
    this.selectionChanged.next(this.selection);
  }

  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  masterToggle() {
    this.isAllSelected()
      ? this.selection.clear()
      : this.dataSource.data.forEach(row => this.selection.select(row));
    this.selectionChanged.next(this.selection);
  }

  checkboxLabel(row?: User): string {
    if (!row) {
      return `${this.isAllSelected() ? 'select' : 'deselect' } all`;
    }
    return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.id}`;
  }
}
