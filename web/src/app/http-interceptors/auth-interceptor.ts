import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable()
export class AuthInterceptor implements HttpInterceptor{

  constructor() {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const authToken = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5MTA5MTUwOSwicm9sZXMiOlsiQURNSU4iXX0.kBxqCb2s8BHcFssJ7ABkqsG3XeJ-JI6ayHrm56TbjRpc4MavqLBzWWjhShIm4EeTd_kmS-i_2KktiAP2yjRgBg';
    const authReq = req.clone({setHeaders: { Authorization: authToken }, responseType: 'json' });
    return next.handle(authReq);
  }
}
