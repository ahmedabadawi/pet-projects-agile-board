import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AuthGuard } from '../core';

import { BoardComponent } from './components/board/board.component';

const ROUTES: Routes = [
  { path: '', component: BoardComponent, canActivate: [ AuthGuard ] }
];

@NgModule({
  imports: [
    RouterModule.forChild(ROUTES)
  ],
  exports: [
    RouterModule
  ]
})
export class BoardRoutingModule {}
