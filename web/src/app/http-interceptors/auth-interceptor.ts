import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor() {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const authToken = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5MjkwNDM1OSwicm9sZXMiOlsiQURNSU4iXX0.jZkGodMxV7mbbYzKpH9gLb_bhire5a2GOaH8YYoIgHh1d-xKDLe_LjqcPDYIViQl0cZS44OYtUEPMmMMy6EU8Q';
    const authReq = req.clone({ setHeaders: { Authorization: authToken }, responseType: 'json' });
    return next.handle(authReq);
  }
}
