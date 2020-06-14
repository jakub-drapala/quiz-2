import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Page} from '../common/page';
import {Quiz} from '../common/quiz';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  private baseUrl = 'http://localhost:8080/quizzes';

  constructor(private httpClient: HttpClient) {
  }

  getQuizzes(): Observable<Page<Quiz>>{
    return this.httpClient.get<Page<Quiz>>(this.baseUrl, {responseType: 'json'});
  }

  removeQuiz(id: number): Observable<any> {
    return this.httpClient.delete(this.baseUrl + `/${id}`, {responseType: 'json'});
  }

  updateQuizName(id: number, newName: string) {
    return this.httpClient.put(this.baseUrl + `/${id}/title`, { value: newName } );
  }
}
