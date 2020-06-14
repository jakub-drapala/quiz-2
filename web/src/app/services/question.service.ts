import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Question} from '../common/question';
import {Page} from '../common/page';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private baseUrl = 'http://localhost:8080/quizzes/';

  constructor(private httpClient: HttpClient) { }

  getQuestions(quizId: any): Observable<Page<Question>> {
    return this.httpClient.get<Page<Question>>(this.baseUrl + quizId + '/questions');
  }

  saveQuestion(quizId: number, content: string): Observable<any> {
    return this.httpClient.post<any>(this.baseUrl +  quizId + '/questions', { content });
  }

}
