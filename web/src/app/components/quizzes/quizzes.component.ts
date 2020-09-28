import { Component, OnInit } from '@angular/core';
import {QuizService} from '../../services/quiz.service';
import {Page} from '../../common/model/page';
import {Quiz} from '../../common/model/quiz';
import {QuizParamsService} from '../communication/quiz-params.service';
import {AbstractAdminComponent} from '../../abstract/abstract-admin.component';
import {Router} from '@angular/router';

@Component({
  selector: 'app-quizzes',
  templateUrl: './quizzes.component.html',
  styleUrls: ['./quizzes.component.css']
})
export class QuizzesComponent extends AbstractAdminComponent {

  page: Page<Quiz>;

  constructor(private quizService: QuizService,
              private quizParamsService: QuizParamsService,
              protected router: Router) {
    super(router);
  }

  // tslint:disable-next-line:use-lifecycle-interface
  ngOnInit(): void {
    super.ngOnInit();
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
