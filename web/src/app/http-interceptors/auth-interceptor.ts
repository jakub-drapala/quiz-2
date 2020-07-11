import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor() {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const authToken = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5NTMzMzIwNywicm9sZXMiOlsiQURNSU4iXX0.ENGUGLINO12gMLzYEl7WPq_46BYvUPWZCT_28arDQ-N0O6WbuB_0x9o5lJj_5WvwSkEb3l0VPYdW3mHB8c_Flg';
    const authReq = req.clone({ setHeaders: { Authorization: authToken }, responseType: 'json' });
    return next.handle(authReq);
  }
}
