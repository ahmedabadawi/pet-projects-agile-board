import { Component } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBarModule } from '@angular/material/snack-bar';

import { BoardItemComponent } from './board-item.component';
import { BoardService } from '../../services/board.service';

import { Item } from '../../models/item.model';

describe('BoardItemComponent', () => {
  let component: BoardItemComponent;
  let fixture: ComponentFixture<BoardItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        MatCardModule,
        MatIconModule,
        MatSnackBarModule,
      ],
      declarations: [ BoardItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BoardItemComponent);
    component = fixture.componentInstance;
    component.item = {
      id: 1,
      title: 'Task 1',
      description: 'Lorem ipsum dolor sit amet',
      state: 'DONE'
    };
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
