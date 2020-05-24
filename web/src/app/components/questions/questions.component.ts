import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {QuestionService} from '../../services/question.service';
import {switchMap} from 'rxjs/operators';
import {Question} from '../../common/question';
import {Page} from '../../common/page';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  questionPage: Page<Question>;
  quizId: number;
  listColumns: string[] = ['content'];

  constructor(private route: ActivatedRoute,
              private questionService: QuestionService,
              ) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(
      switchMap(params => {
        this.quizId = +params.get('quizId');
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

}
