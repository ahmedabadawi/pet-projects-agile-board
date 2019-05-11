import { HttpRequest, HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

export class ProjectsStubs {
  handle(endpoint: string, request: HttpRequest<any>): Observable<HttpResponse<any>> {
    return of(new HttpResponse({ status: 501, body: { message: 'Not Implemented'} }));
  }
}
