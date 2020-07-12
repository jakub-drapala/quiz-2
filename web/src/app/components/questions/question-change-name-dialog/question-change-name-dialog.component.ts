import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {QuizService} from '../../../services/quiz.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-question-change-name-dialog',
  templateUrl: './question-change-name-dialog.component.html',
  styleUrls: ['./question-change-name-dialog.component.css']
})
export class QuestionChangeNameDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<QuestionChangeNameDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data,
              private quizService: QuizService,
              private toastrService: ToastrService) { }

  ngOnInit(): void {
  }

  submitForm(title: string, confirm: boolean): void {
    if (confirm) {
      this.quizService.updateQuizName(this.data.id, title).subscribe(data => {
        this.dialogRef.close(data);
        this.toastrService.success('Zmiana nazwy powiodła się!');
      });
    } else {
      this.dialogRef.close();
      this.toastrService.error('Nie udało się zmienić nazwy!');
    }
  }

}
