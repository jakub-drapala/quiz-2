import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { QuizzesComponent } from './components/quizzes/quizzes.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AuthInterceptor} from './http-interceptors/auth-interceptor';
import {RouterModule} from '@angular/router';
import {QuestionsComponent} from './components/questions/questions.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatTableModule} from '@angular/material/table';
import {MatListModule} from '@angular/material/list';
import {QuizParamsService} from './components/communication/quiz-params.service';
import {MatButtonModule} from '@angular/material/button';
// tslint:disable-next-line:max-line-length
import { QuestionChangeNameDialogComponent } from './components/questions/question-change-name-dialog/question-change-name-dialog.component';
import {MatDialogModule} from '@angular/material/dialog';
import { ToastrModule } from 'ngx-toastr';
import {CommonModule} from '@angular/common';
import { LoginFormComponent } from './common/form/login-form/login-form.component';
import {MatCardModule} from '@angular/material/card';
import {MatInputModule} from '@angular/material/input';
import { LoginComponent } from './components/login/login.component';

const appRoute = [
  { path: '', redirectTo: 'admin/quizzes', pathMatch: 'full' },
  { path: 'admin/quizzes', component: QuizzesComponent },
  { path: 'admin/quizzes/:quizId', component: QuestionsComponent },
  { path: 'login', component: LoginComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    QuizzesComponent,
    QuestionsComponent,
    QuestionChangeNameDialogComponent,
    LoginFormComponent,
    LoginComponent
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
    MatDialogModule,
    CommonModule,
    ReactiveFormsModule,
    MatCardModule,
    MatInputModule,
    ToastrModule.forRoot()
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true},
    QuizParamsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
