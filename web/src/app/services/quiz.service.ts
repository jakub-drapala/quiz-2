import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Page} from '../common/page';
import {Quiz} from '../common/quiz';
import {map, tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  private baseUrl = 'http://localhost:8080/quizzes';

  constructor(private httpClient: HttpClient) {
  }

  getQuizzes(): Observable<Page<Quiz>>{
    return this.httpClient.get<Page<Quiz>>(this.baseUrl);
  }
}
