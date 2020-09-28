import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor() {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authReq: HttpRequest<any>;
    if (sessionStorage.getItem('token')) {
      const authToken = sessionStorage.getItem('token');
      authReq = req.clone({ setHeaders: { Authorization: authToken }, responseType: 'json' });
    } else {
      authReq = req.clone({ responseType: 'json', setHeaders: {} });
    }
    return next.handle(authReq);
  }
}
