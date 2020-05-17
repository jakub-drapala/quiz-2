import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { QuizzesComponent } from './components/quizzes/quizzes.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AuthInterceptor} from './http-interceptors/auth-interceptor';
import {RouterModule} from '@angular/router';
import {QuestionsComponent} from './components/questions/questions.component';

const appRoute = [
  { path: '', redirectTo: 'quizzes', pathMatch: 'full' },
  { path: 'quizzes', component: QuizzesComponent },
  { path: 'quizzes/:quizId', component: QuestionsComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    QuizzesComponent,
    QuestionsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoute)
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
