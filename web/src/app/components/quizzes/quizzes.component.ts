import { Component, OnInit } from '@angular/core';
import {QuizService} from '../../services/quiz.service';
import {Page} from '../../common/page';
import {Quiz} from '../../common/quiz';
import {QuizParamsService} from '../communication/quiz-params.service';

@Component({
  selector: 'app-quizzes',
  templateUrl: './quizzes.component.html',
  styleUrls: ['./quizzes.component.css']
})
export class QuizzesComponent implements OnInit {

  page: Page<Quiz>;

  constructor(private quizService: QuizService,
              private quizParamsService: QuizParamsService) {
  }

  ngOnInit(): void {
    this.fetchData();
  }

  remove(quizId: number) {
    this.quizService.removeQuiz(quizId).subscribe(() => this.fetchData());
  }

  fetchData() {
    this.quizService.getQuizzes().subscribe(data => this.page = data);
  }

  updateQuizParamsService(quizId: number, quizTitle: string) {
    this.quizParamsService.pushEntry(quizId, quizTitle);
  }

}
