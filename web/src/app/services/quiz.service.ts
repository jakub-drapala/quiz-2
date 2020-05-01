import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Page} from '../common/page';
import {Quiz} from '../common/quiz';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  private baseUrl = 'http://localhost:8080/quizzes';
  private httpOptions = {
    headers: new HttpHeaders({
      Authorization: 'aa'
    })
  };
  // private headers = new HttpHeaders({Authorization: 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU4OTE4NTc0Nywicm9sZXMiOlsiQURNSU4iXX0.6ArRVuD9pmODSkRpkNIcHxKHlzolhxGKm50aZ9o8l4x5xQdZtYPRw5lTqwIUJ9j_DWnbji4iFuFhXsMZm5nWZA'});

  constructor(private httpClient: HttpClient) {
  }

  getQuizzes(): Observable<Page<Quiz>> {
    const headersObj = new HttpHeaders().set('Authorization', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU4OTE4NTc0Nywicm9sZXMiOlsiQURNSU4iXX0.6ArRVuD9pmODSkRpkNIcHxKHlzolhxGKm50aZ9o8l4x5xQdZtYPRw5lTqwIUJ9j_DWnbji4iFuFhXsMZm5nWZA');
    // headers.set('Authorization', 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU4OTE4NTc0Nywicm9sZXMiOlsiQURNSU4iXX0.6ArRVuD9pmODSkRpkNIcHxKHlzolhxGKm50aZ9o8l4x5xQdZtYPRw5lTqwIUJ9j_DWnbji4iFuFhXsMZm5nWZA')
    return this.httpClient.get<GetResponse>(this.baseUrl, this.httpOptions).pipe(
      map(response => response._embedded.quizzes)
    );
  }
}

interface GetResponse {
  _embedded: {
    quizzes: Page<Quiz>;
  };
}
