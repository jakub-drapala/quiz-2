import { Component, OnInit } from '@angular/core';
import {QuizService} from '../../services/quiz.service';
import {Page} from '../../common/page';
import {Quiz} from '../../common/quiz';

@Component({
  selector: 'app-quizzes',
  templateUrl: './quizzes.component.html',
  styleUrls: ['./quizzes.component.css']
})
export class QuizzesComponent implements OnInit {

  page: Page<Quiz>;

  constructor(private quizService: QuizService) {
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

}
