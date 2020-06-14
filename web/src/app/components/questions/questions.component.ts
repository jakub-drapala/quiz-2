import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {QuestionService} from '../../services/question.service';
import {switchMap} from 'rxjs/operators';
import {Question} from '../../common/question';
import {Page} from '../../common/page';
import {QuizParamsService} from '../communication/quiz-params.service';
import {QuizService} from '../../services/quiz.service';

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
              private quizParamsService: QuizParamsService
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

  updateQuizName(quizId: number, newName: string) {
    this.quizService.updateQuizName(quizId, newName).subscribe();
  }
}
