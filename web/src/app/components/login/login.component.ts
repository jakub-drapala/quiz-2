import { Component, OnInit } from '@angular/core';
import {Auth} from '../../common/model/auth';
import {LoginService} from '../../services/login.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService,
              private router: Router) { }

  ngOnInit(): void {
  }

  logIn(e: Auth) {
    this.loginService.login(e).subscribe((data: { token: string }) => {
      this.router.navigate(['/admin/quizzes']);
      sessionStorage.setItem('token', data.token);
    }, error => console.log(error));
  }

}
