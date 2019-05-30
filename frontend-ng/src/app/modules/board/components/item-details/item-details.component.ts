import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

import { BoardService } from '../../services/board.service';
import { Item } from '../../models/item.model';

@Component({
  selector: 'app-item-details',
  templateUrl: './item-details.component.html',
  styleUrls: [ './item-details.component.scss' ]
})
export class ItemDetailsComponent implements OnInit {
  @Input() itemId: number;

  constructor(private boardService: BoardService,
              private router: Router,
              private snackBar: MatSnackBar) {
  }

  ngOnInit() {

  }

  cancel() {
    this.router.navigate(['/board']);
  }
}
