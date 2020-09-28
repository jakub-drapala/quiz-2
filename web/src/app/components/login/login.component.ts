import { Component, OnInit } from '@angular/core';
import {Auth} from '../../common/model/auth';
import {LoginService} from '../../services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
  }

  logIn(e: Auth) {
    this.loginService.login(e).subscribe(data => {
      console.log(data);
    }, error => console.log(error));
  }

}
