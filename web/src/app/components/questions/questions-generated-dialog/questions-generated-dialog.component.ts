import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-questions-generated-dialog',
  templateUrl: './questions-generated-dialog.component.html',
  styleUrls: ['./questions-generated-dialog.component.css']
})
export class QuestionsGeneratedDialogComponent implements OnInit {

  url: string;

  constructor(public dialogRef: MatDialogRef<QuestionsGeneratedDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data,
  ) { this.url = 'localhost:8080/quiz?uid=' + data.uid; }

  ngOnInit(): void {
  }

}
