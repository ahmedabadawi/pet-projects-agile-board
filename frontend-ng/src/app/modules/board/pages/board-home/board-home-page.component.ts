import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';

import { BoardService } from '../../services/board.service';
import { Item } from '../../models/item.model';

@Component({
  templateUrl: './board-home-page.component.html',
  styleUrls: ['./board-home-page.component.scss']
})
export class BoardHomePageComponent implements OnInit {
  backlogItems: Array<Item> = [];
  blockedItems: Array<Item> = [];
  inProgressItems: Array<Item> = [];
  doneItems: Array<Item> = [];

  constructor(private boardService: BoardService) { }

  ngOnInit() {
    this.boardService.getBoard()
      .pipe(first())
      .subscribe(
        items => {
          items.forEach(item => {
            switch (item.state) {
              case 'NOT_STARTED': {
                this.backlogItems.push(item);
                break;
              }
              case 'BLOCKED': {
                this.blockedItems.push(item);
                break;
              }
              case 'IN_PROGRESS': {
                this.inProgressItems.push(item);
                break;
              }
              case 'DONE': {
                this.doneItems.push(item);
                break;
              }
            }
          });
        },
        error => {
          console.log(error);
        }
      );
  }
}
