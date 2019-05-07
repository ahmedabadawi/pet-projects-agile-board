import { Injectable } from '@angular/core';
import { Item } from '../models/item.model';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BoardService {
  constructor() { }

  getBoard(): Observable<Item[]> {
    return of(ITEMS_DATA);
  }
}

const ITEMS_DATA: Item[] = [
  {
    id: 1,
    title: 'Task 1',
    description: 'Lorem ipsum dolor sit amet',
    state: 'DONE'
  },
  {
    id: 2,
    title: 'Task 2',
    description: 'sunt in culpa qui officia deserunt mollit anim id est laborum',
    state: 'DONE'
  },
  {
    id: 3,
    title: 'Task 3',
    description: 'Excepteur sint occaecat cupidatat non proident',
    state: 'IN_PROGRESS'
  },
  {
    id: 4,
    title: 'Task 4',
    description: 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur',
    state: 'IN_PROGRESS'
  },
  {
    id: 5,
    title: 'Task 5',
    description: 'Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat',
    state: 'IN_PROGRESS'
  },
  {
    id: 6,
    title: 'Task 6',
    description: 'sed do eiusmod tempor incididunt ut labore et dolore magna aliqua',
    state: 'BLOCKED'
  },
  {
    id: 7,
    title: 'Task 7',
    description: 'consectetur adipisicing elit',
    state: 'NOT_STARTED'
  }
];
