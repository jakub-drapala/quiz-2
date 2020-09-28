import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {QuestionService} from '../../services/question.service';
import {switchMap} from 'rxjs/operators';
import {Question} from '../../common/model/question';
import {Page} from '../../common/model/page';
import {QuizParamsService} from '../communication/quiz-params.service';
import {QuizService} from '../../services/quiz.service';
import {MatDialog} from '@angular/material/dialog';
import {QuestionChangeNameDialogComponent} from './question-change-name-dialog/question-change-name-dialog.component';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  questionPage: Page<Question>;
  quizId: number;
  quizTitle: string;

  constructor(private route: ActivatedRoute,
              private quizService: QuizService,
              private questionService: QuestionService,
              private quizParamsService: QuizParamsService,
              private dialog: MatDialog
              ) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(
      switchMap(params => {
        this.quizId = +params.get('quizId');
        this.quizTitle = this.quizParamsService.getQuizName(this.quizId);
        return this.questionService.getQuestions(this.quizId);
      })
    ).subscribe(data => this.questionPage = data);
  }

  fetchData() {
    this.questionService.getQuestions(this.quizId).subscribe(data => this.questionPage = data);
  }

  addQuestion(content: string) {
    this.questionService.saveQuestion(this.quizId, content).subscribe(() => this.fetchData());
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
        console.log(result);
        this.quizTitle = result.title;
      }
    });
  }
}
