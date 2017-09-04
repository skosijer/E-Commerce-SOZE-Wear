import { Injectable } from '@angular/core';
import { CanActivate, Router }    from '@angular/router';
import {Http,Headers,RequestOptions,RequestMethod,Request,Response} from '@angular/http';
import 'rxjs/Rx';
import { Auth } from './auth.service';

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(private auth : Auth, private router : Router) { }

  canActivate()
  {
        let canActivate = this.auth.authenticated();

        if(!canActivate)
        {
            this.router.navigateByUrl("login");
            return true;
        }
        
        return canActivate;
  }
}
