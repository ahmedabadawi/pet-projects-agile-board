import { Injectable } from '@angular/core';
import {
  HttpInterceptor,
  HttpHandler,
  HttpRequest } from '@angular/common/http';

import { AuthService } from '../services/auth.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private auth: AuthService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler) {
    if (this.auth.isAuthenticated()) {
      const token = this.auth.getToken();
      const authRequest = request.clone({
        headers: request.headers.set('Authorization', `Bearer ${token}`)
      });
      return next.handle(authRequest);
    }

    return next.handle(request);
  }
}
