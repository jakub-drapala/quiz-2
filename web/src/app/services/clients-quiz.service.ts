import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientsQuizService {

  private baseUrl = 'http://localhost:8080/quiz';

  constructor(private httpClient: HttpClient) { }

  getWelcomeMessage(uid: string): Observable<any> {
    return this.httpClient.get(this.baseUrl, {params: {quizUid: uid}});
  }
}
