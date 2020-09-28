import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Auth} from '../common/model/auth';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private baseUrl = 'http://localhost:8080/login';

  constructor(private httpClient: HttpClient) { }

  login(auth: Auth): Observable<{}> {
    return this.httpClient.post<any>(this.baseUrl, auth);
  }
}
