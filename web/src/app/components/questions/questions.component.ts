import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {QuestionService} from "../../services/question.service";
import {switchMap} from "rxjs/operators";
import {Question} from "../../common/question";


@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  data: Question[];

  constructor(private route: ActivatedRoute,
              private questionService: QuestionService) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(
      switchMap(params => {
        const id = +params.get('quizId');
        return this.questionService.getQuestions(id);
      })
    ).subscribe(data => this.data = data);
  }

}
