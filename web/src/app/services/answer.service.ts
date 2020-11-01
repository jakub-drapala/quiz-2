import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Answer} from '../common/model/answer';

@Injectable({
  providedIn: 'root'
})
export class AnswerService {

  private baseUrl = 'http://localhost:8080/quizzes/';

  constructor(private httpClient: HttpClient) { }

  getAnswer(quizId: number, questionId: number): Observable<any> {
    return this.httpClient.get<Answer[]>(this.baseUrl + quizId + '/questions/' + questionId + '/answers');
  }

  addAnswer(quizId: number, questionId: number, answer: Answer): Observable<any> {
    return this.httpClient.post<any>(this.baseUrl + quizId + '/questions/' + questionId + '/answers', answer);
  }

  updateAnswer(quizId: number, questionId: number, answer: Answer): Observable<any> {
    return this.httpClient.put(this.baseUrl + quizId + '/questions/' + questionId + '/answers/' + answer.id, answer);
  }
}
