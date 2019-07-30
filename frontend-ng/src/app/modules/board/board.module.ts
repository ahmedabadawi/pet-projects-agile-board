import { NgModule, ModuleWithProviders } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';

import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatToolbarModule } from '@angular/material/toolbar';

import { SharedModule } from '../shared';

import { BoardItemComponent } from './components/board-item/board-item.component';
import { ItemDetailsComponent } from './components/item-details/item-details.component';

import { BoardComponent } from './components/board/board.component';

import { BoardRoutingModule } from './board-routing.module';

@NgModule({
  imports: [
    CommonModule,

    MatButtonModule,
    MatCardModule,
    MatIconModule,
    MatListModule,
    MatSnackBarModule,
    MatToolbarModule,

    SharedModule,

    BoardRoutingModule,
  ],
  exports: [ RouterModule ],
  declarations: [
    BoardItemComponent, ItemDetailsComponent,
    BoardComponent
  ],
  providers: []
})
export class BoardModule { }
