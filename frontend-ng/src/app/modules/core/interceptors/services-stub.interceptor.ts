import { Injectable } from '@angular/core';
import {
  HttpRequest, HttpResponse,
  HttpHandler, HttpEvent ,
  HttpInterceptor, HTTP_INTERCEPTORS
} from '@angular/common/http';
import { Observable } from 'rxjs';

import { AdminStubs } from '../../admin/stubs/admin-stubs';
import { BoardStubs } from '../../board/stubs/board-stubs';
import { ProjectsStubs } from '../../projects/stubs/projects-stubs';
import { LoginStubs } from '../../login/stubs/login-stubs';

const LOGIN_API = '/api/login';
const BOARD_API = '/api/board';
const PROJECTS_API = '/api/projects';
const ADMIN_API = '/api/users';

@Injectable()
export class ServicesStubInterceptor implements HttpInterceptor {
  private adminStubs: AdminStubs = new AdminStubs();
  private boardStubs: BoardStubs = new BoardStubs();
  private projectsStubs: ProjectsStubs;
  private loginStubs: LoginStubs;

  constructor() {
    this.boardStubs = new BoardStubs();
    this.adminStubs = new AdminStubs();
    this.projectsStubs = new ProjectsStubs();
    this.loginStubs = new LoginStubs();

  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (request.url.includes(LOGIN_API)) {
      return this.loginStubs.handle(this.extractEndpoint(LOGIN_API, request.url), request);
    } else if (request.url.includes(BOARD_API)) {
      return this.boardStubs.handle(this.extractEndpoint(BOARD_API, request.url), request);
    } else if (request.url.includes(PROJECTS_API)) {
      return this.projectsStubs.handle(this.extractEndpoint(PROJECTS_API, request.url), request);
    } else if (request.url.includes(ADMIN_API)) {
      return this.adminStubs.handle(this.extractEndpoint(ADMIN_API, request.url), request);
    }
    console.log(request.url);
    return next.handle(request);
  }

  extractEndpoint(apiString, url) {
    return url.substring(url.indexOf(apiString) + apiString.length);
  }
}
