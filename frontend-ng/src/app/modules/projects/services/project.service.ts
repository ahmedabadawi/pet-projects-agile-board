import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { concatMap, catchError } from 'rxjs/operators';

import { ProjectsList } from '../models/project.model';

import { ConfigService } from '../../core';
import { LogService } from '../../core';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private config: ConfigService,
              private http: HttpClient,
              private log: LogService) { }

  /* tslint:disable: object-literal-key-quotes */
  getProjects(): Observable<ProjectsList> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Accept': 'application/json'
      })
    };

    return this.http.get<ProjectsList>(
      this.config.api + '/api/projects',
      httpOptions);
    // TODO: Catch and Log HTTP Errors
  }
}

interface AuthResponse {
  status: string;
  token: string;
  userId: number;
}
