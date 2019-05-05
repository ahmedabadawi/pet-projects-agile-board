import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatToolbarModule } from '@angular/material/toolbar';

import { BoardHomePage } from './board-home.page';
import { BoardItemComponent } from '../../components/board-item/board-item.component';

describe('BoardHomePage', () => {
  let component: BoardHomePage;
  let fixture: ComponentFixture<BoardHomePage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        MatButtonModule,
        MatCardModule,
        MatIconModule,
        MatSnackBarModule,
        MatToolbarModule
      ],
      declarations: [ BoardHomePage, BoardItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BoardHomePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
