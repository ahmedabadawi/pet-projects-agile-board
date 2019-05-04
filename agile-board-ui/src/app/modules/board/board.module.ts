import { NgModule, ModuleWithProviders } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';

import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatToolbarModule } from '@angular/material/toolbar';

import { SharedModule } from '../shared';

import { LayoutComponent } from './components/layout/layout.component';
import { BoardItemComponent } from './components/board-item/board-item.component';
import { ItemDetailsComponent } from './components/item-details/item-details.component';

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

    MatButtonModule,
    MatCardModule,
    MatIconModule,
    MatListModule,
    MatToolbarModule,

    SharedModule
  ],
  exports: [ RouterModule ],
  declarations: [
    LayoutComponent, BoardItemComponent, ItemDetailsComponent, BoardHomePage
  ],
  providers: []
})
export class BoardModule { }
