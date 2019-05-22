import { Component, OnInit } from '@angular/core';
import { environment } from '../../../../../environments/environment';

@Component({
  templateUrl: './home.page.html',
  styleUrls: ['./home.page.scss']
})
export class HomePage implements OnInit {
  title = 'agile-board-ui';
  env = environment;

  constructor() { }

  ngOnInit() {
  }

}
