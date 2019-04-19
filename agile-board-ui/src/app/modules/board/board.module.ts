import { NgModule, ModuleWithProviders } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../shared';

import { LayoutComponent } from './components/layout/layout.component';
import { BoardHomePage } from './pages/board-home/board-home.page';

const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: '', component: BoardHomePage },
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
    LayoutComponent, BoardHomePage
  ],
  providers: []
})
export class BoardModule { }