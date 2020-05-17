import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable()
export class AuthInterceptor implements HttpInterceptor{

  constructor() {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const authToken = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5MDA4NjgxOSwicm9sZXMiOlsiQURNSU4iXX0.bzclHzyCna3-RwM2VnQ56n4cC1CNSWxrbTiHZvVm5bDdAXlBLd6YMsFmdk42qqyrqL5tlNA9cPnetvynEriCYA';
    const authReq = req.clone({setHeaders: { Authorization: authToken }, responseType: 'json' });
    return next.handle(authReq);
  }
}
