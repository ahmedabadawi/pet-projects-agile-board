import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  constructor(private http: HttpClient) { }

  getAll(): Observable<User[]> {
    return this.http.get<User[]>('http://localhost:8080/api/users');
  }

  findById(userId: number): Observable<User> {
    return this.http.get<User>(`http://localhost:8080/api/users/${userId}`);
  }

  save(user: User): Observable<boolean> {
    return this.http.post<boolean>('http://localhost:8080/api/users', JSON.stringify(user))
      .pipe(map(() =>  true));
  }
}

interface Message {
  message: string
}
