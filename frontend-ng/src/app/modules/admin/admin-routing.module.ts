import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AuthGuard } from '../core';

import { AdminComponent } from './components/admin/admin.component';
import { UserNewComponent } from './components/user-new/user-new.component';
import { UserDetailsComponent } from './components/user-details/user-details.component';
import { UsersListComponent } from './components/users-list/users-list.component';

const ROUTES: Routes = [
  {
    path: '',
    component: AdminComponent,
    canActivate: [ AuthGuard ],
    children: [
      { path: 'user-list', component: UsersListComponent },
      { path: 'user', component: UserNewComponent },
      { path: 'user/:userId', component: UserDetailsComponent },
      { path: '', redirectTo: 'user-list' }
    ],
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(ROUTES)
  ],
  exports: [
    RouterModule
  ]
})
export class AdminRoutingModule {}
