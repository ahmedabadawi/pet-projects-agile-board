import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { ConfigService } from '../../core';

import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  constructor(private config: ConfigService,
              private http: HttpClient) { }

  getAll(): Observable<User[]> {
    return this.http.get<User[]>(this.config.api + '/api/users');
  }

  findById(userId: number): Observable<User> {
    return this.http.get<User>(`${this.config.api}/api/users/${userId}`);
  }

  save(user: User): Observable<boolean> {
    return this.http.post<boolean>(this.config.api + '/api/users', JSON.stringify(user))
      .pipe(map(() =>  true));
  }
}

interface Message {
  message: string;
}
