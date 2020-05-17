import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Question} from "../common/question";

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private baseUrl = 'http://localhost:8080/quizzes/';

  constructor(private httpClient: HttpClient) { }

  getQuestions(quizId: any): Observable<Question[]> {
    return this.httpClient.get<Question[]>(this.baseUrl + quizId + '/questions');
  }
}
