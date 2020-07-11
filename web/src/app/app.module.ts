import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { QuizzesComponent } from './components/quizzes/quizzes.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AuthInterceptor} from './http-interceptors/auth-interceptor';
import {RouterModule} from '@angular/router';
import {QuestionsComponent} from './components/questions/questions.component';
import {FormsModule} from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatTableModule} from '@angular/material/table';
import {MatListModule} from '@angular/material/list';
import {QuizParamsService} from './components/communication/quiz-params.service';
import {MatButtonModule} from '@angular/material/button';
import { QuestionChangeNameDialogComponent } from './components/questions/question-change-name-dialog/question-change-name-dialog.component';
import {MatDialogModule} from '@angular/material/dialog';

const appRoute = [
  { path: '', redirectTo: 'quizzes', pathMatch: 'full' },
  { path: 'quizzes', component: QuizzesComponent },
  { path: 'quizzes/:quizId', component: QuestionsComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    QuizzesComponent,
    QuestionsComponent,
    QuestionChangeNameDialogComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoute),
    FormsModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatListModule,
    MatButtonModule,
    MatDialogModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true},
    QuizParamsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
