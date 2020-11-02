import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {ClientsQuizService} from '../../services/clients-quiz.service';

@Component({
  selector: 'app-clients-quiz',
  templateUrl: './clients-quiz.component.html',
  styleUrls: ['./clients-quiz.component.css']
})
export class ClientsQuizComponent implements OnInit {

  welcomeMessage: string;

  constructor(private route: ActivatedRoute,
              private clientsQuizService: ClientsQuizService) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.clientsQuizService.getWelcomeMessage(params.uid).subscribe(data =>
        this.welcomeMessage = data.result
      );
    });
  }

}
