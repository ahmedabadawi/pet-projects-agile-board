import { NgModule, ModuleWithProviders } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { MatButtonModule } from '@angular/material/button';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatSortModule } from '@angular/material/sort';
import { MatTabsModule } from '@angular/material/tabs';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTooltipModule } from '@angular/material/tooltip';

import { CommonModule } from '@angular/common';

import { SharedModule } from '../shared';


import { LayoutComponent } from './components/layout/layout.component';
import { UserNewComponent } from './components/user-new/user-new.component';
import { UsersListComponent } from './components/users-list/users-list.component';
import { AdminHomePage } from './pages/admin-home/admin-home.page';
import { UserDetailsPage } from './pages/user-details/user-details.page';

import { UsersService } from './services/users.service';

const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: '', component: AdminHomePage },
      { path: 'user', component: UserDetailsPage },
      { path: 'user/:userId', component: UserDetailsPage },
      { path: '**', redirectTo: '' }
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(routes),
    CommonModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,

    MatButtonModule,
    MatCheckboxModule,
    MatIconModule,
    MatInputModule,
    MatFormFieldModule,
    MatPaginatorModule,
    MatSnackBarModule,
    MatSortModule,
    MatTabsModule,
    MatTableModule,
    MatToolbarModule,
    MatTooltipModule
  ],
  exports: [ RouterModule ],
  declarations: [
    LayoutComponent,
    UserNewComponent, UsersListComponent,
    AdminHomePage, UserDetailsPage
  ],
  providers: [ UsersService ]
})
export class AdminModule { }
