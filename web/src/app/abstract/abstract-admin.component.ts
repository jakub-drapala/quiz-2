import {OnInit} from '@angular/core';
import {Router} from '@angular/router';

export abstract class AbstractAdminComponent implements OnInit {

  protected constructor(protected router: Router) {
  }

  ngOnInit(): void {
    if (!sessionStorage.getItem('token')) {
      this.router.navigate(['login']);
    }
  }
}
