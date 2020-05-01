import { Component, OnInit } from '@angular/core';
import {QuizService} from '../../services/quiz.service';

@Component({
  selector: 'app-quizzes',
  templateUrl: './quizzes.component.html',
  styleUrls: ['./quizzes.component.css']
})
export class QuizzesComponent implements OnInit {

  constructor(private quizService: QuizService) { }

  ngOnInit(): void {
    this.quizzes();
  }

  quizzes() {
    this.quizService.getQuizzes().subscribe(data => console.log(data));
  }

}
