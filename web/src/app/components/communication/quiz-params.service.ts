import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QuizParamsService {

  private map = new Map<number, string>();

  constructor() { }

  public pushEntry(id: number, quizName: string) {
    this.map.set(id, quizName);
    console.log(this.map);
  }

  public getQuizName(id: number): string {
    return this.map.get(id);
  }

}
