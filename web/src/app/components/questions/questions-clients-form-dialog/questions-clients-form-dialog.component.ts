import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {ClientsFormService} from '../../../services/clients-form.service';
import {ClientsForm} from '../../../common/model/clients-form';

@Component({
  selector: 'app-questions-clients-form-dialog',
  templateUrl: './questions-clients-form-dialog.component.html',
  styleUrls: ['./questions-clients-form-dialog.component.css']
})
export class QuestionsClientsFormDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<QuestionsClientsFormDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data,
              private clientsFormService: ClientsFormService
              ) { }

  ngOnInit(): void {
  }

  submitForm(name: string, amountQuestions: number): void {
    const clientsForm: ClientsForm = {clientsName: name, questionsAmount: amountQuestions, timeInSec: 0, quizId: this.data.quizId};
    this.clientsFormService.create(clientsForm).subscribe(data => {
      this.dialogRef.close(data);
    });
  }

  close() {
    this.dialogRef.close();
  }
}
