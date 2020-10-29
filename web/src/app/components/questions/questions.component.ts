import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {QuestionService} from '../../services/question.service';
import {switchMap} from 'rxjs/operators';
import {Question} from '../../common/model/question';
import {Page} from '../../common/model/page';
import {QuizParamsService} from '../communication/quiz-params.service';
import {QuizService} from '../../services/quiz.service';
import {MatDialog} from '@angular/material/dialog';
import {QuestionChangeNameDialogComponent} from './question-change-name-dialog/question-change-name-dialog.component';
import {AbstractAdminComponent} from '../../abstract/abstract-admin.component';
import {AnswerService} from '../../services/answer.service';
import {Answer} from '../../common/model/answer';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent extends AbstractAdminComponent {

  questionPage: Page<Question>;
  quizId: number;
  quizTitle: string;
  answers: Answer[];

  constructor(private route: ActivatedRoute,
              private quizService: QuizService,
              private questionService: QuestionService,
              private quizParamsService: QuizParamsService,
              private answerService: AnswerService,
              private dialog: MatDialog,
              protected router: Router
              ) {
    super(router);
  }

  // tslint:disable-next-line:use-lifecycle-interface
  ngOnInit(): void {
    super.ngOnInit();
    this.route.paramMap.pipe(
      switchMap(params => {
        this.quizId = +params.get('quizId');
        this.quizTitle = this.quizParamsService.getQuizName(this.quizId);
        return this.questionService.getQuestions(this.quizId);
      })
    ).subscribe(data => this.questionPage = data);
  }

  fetchQuestions() {
    this.questionService.getQuestions(this.quizId).subscribe(data => this.questionPage = data);
  }

  fetchAnswers(questionId: number) {
    this.answerService.getAnswer(this.quizId, questionId).subscribe(data => {
      console.log(data);
      this.answers = data;
    });
  }

  addQuestion(content: string) {
    this.questionService.saveQuestion(this.quizId, content).subscribe(() => this.fetchQuestions());
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(QuestionChangeNameDialogComponent, {
      width: '250px',
      data: {
        id: this.quizId,
        title: this.quizTitle
      }
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.quizTitle = result.title;
      }
    });
  }
}
