import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AuthGuard } from '../core';

import { HomeComponent } from './components/home/home.component';

const ROUTES: Routes = [
  { path: '', component: HomeComponent, canActivate: [ AuthGuard ] }
];

@NgModule({
  imports: [
    RouterModule.forChild(ROUTES)
  ],
  exports: [
    RouterModule
  ]
})
export class HomeRoutingModule {}
