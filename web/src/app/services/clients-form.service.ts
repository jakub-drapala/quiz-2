import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ClientsForm} from '../common/model/clients-form';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientsFormService {

  private baseUrl = 'http://localhost:8080/';

  constructor(private httpClient: HttpClient) { }

  create(clientsForm: ClientsForm): Observable<any> {
    return this.httpClient.post(this.baseUrl + 'admin/quiz', clientsForm);
  }
}
