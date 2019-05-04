import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

import { BoardService } from '../../services/board.service';
import { Item } from '../../models/item.model';

@Component({
  selector: 'app-board-item',
  templateUrl: './board-item.component.html',
  styleUrls: [ './board-item.component.scss' ]
})
export class BoardItemComponent implements OnInit {
  @Input() item: Item;

  constructor(private boardService: BoardService,
              private snackBar: MatSnackBar) {
  }

  ngOnInit() {
  }
}
