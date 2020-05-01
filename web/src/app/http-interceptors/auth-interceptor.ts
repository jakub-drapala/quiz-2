import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable()
export class AuthInterceptor implements HttpInterceptor{

  constructor() {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const authToken = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU4OTE4NTc0Nywicm9sZXMiOlsiQURNSU4iXX0.6ArRVuD9pmODSkRpkNIcHxKHlzolhxGKm50aZ9o8l4x5xQdZtYPRw5lTqwIUJ9j_DWnbji4iFuFhXsMZm5nWZA';
    const authReq = req.clone({setHeaders: { Authorization: authToken } });
    return next.handle(authReq);
  }



}
