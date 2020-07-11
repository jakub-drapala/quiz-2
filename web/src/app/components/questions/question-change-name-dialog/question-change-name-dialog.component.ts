import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {QuestionService} from '../../../services/question.service';
import {QuizService} from '../../../services/quiz.service';

@Component({
  selector: 'app-question-change-name-dialog',
  templateUrl: './question-change-name-dialog.component.html',
  styleUrls: ['./question-change-name-dialog.component.css']
})
export class QuestionChangeNameDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<QuestionChangeNameDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data,
              private quizService: QuizService) { }

  ngOnInit(): void {
  }

  submitForm(title: string, confirm: boolean): void {
    if (confirm) {
      this.quizService.updateQuizName(this.data.id, title).subscribe(data => {
        this.dialogRef.close(data);
      });
    } else {
      this.dialogRef.close();
    }
  }

}
