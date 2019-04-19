import { NgModule, ModuleWithProviders } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../shared';

import { LayoutComponent } from './components/layout/layout.component';
import { AdminHomePage } from './pages/admin-home/admin-home.page';

const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: '', component: AdminHomePage },
      { path: '**', redirectTo: '' }
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(routes),
    CommonModule,
    SharedModule
  ],
  exports: [ RouterModule ],
  declarations: [
    LayoutComponent, AdminHomePage
  ],
  providers: []
})
export class AdminModule { }