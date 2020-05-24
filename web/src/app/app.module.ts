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
import { TablesComponent } from './components/tables/tables.component';
import {MatListModule} from "@angular/material/list";

const appRoute = [
  { path: '', redirectTo: 'quizzes', pathMatch: 'full' },
  { path: 'quizzes', component: QuizzesComponent },
  { path: 'quizzes/:quizId', component: QuestionsComponent },
  { path: 'table', component: TablesComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    QuizzesComponent,
    QuestionsComponent,
    TablesComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoute),
    FormsModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatListModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
