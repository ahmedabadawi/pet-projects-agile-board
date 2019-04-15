import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BoardHomePage } from './board-home.page';

describe('BoardHomePage', () => {
  let component: BoardHomePage;
  let fixture: ComponentFixture<BoardHomePage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BoardHomePage ]
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
