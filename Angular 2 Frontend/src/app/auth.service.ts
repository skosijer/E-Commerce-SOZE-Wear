import { Injectable }      from '@angular/core';
import { tokenNotExpired, JwtHelper } from 'angular2-jwt';
import { myConfig }        from './auth.config';
import { Router } from '@angular/router';
import { AbstractService } from './abstract.service';
import {Http,Headers,RequestOptions,RequestMethod,Request,Response} from '@angular/http';

// Avoid name not found warnings
declare var Auth0Lock: any;

@Injectable()
export class Auth extends AbstractService {

  // Configure Auth0
  lock = new Auth0Lock(myConfig.clientID, myConfig.domain, {
       theme: {
          logo: "http://myteeshop.com/graphics/cafepressshirts/cafepressshirts/T-shirt%20Logo%20Tee%20Blk.png"
       },
      languageDictionary: {
          title: "SOZE Wear TShirts"
      },
      additionalSignUpFields: [{
      name: "name",                              // required
      placeholder: "enter your name",            // required
      // icon: "https://example.com/address_icon.png", // optional
      // validator: function(value) {                  // optional
        // only accept addresses with more than 10 characters
        // return value.length > 10;
      // }
    },{
      name: "lastname",
      placeholder: "enter your last name"
    }]
  });

  public userProfile : any;

  role : String = new String();

  jwtHelper : JwtHelper = new JwtHelper();
  //alert("TOKEN " + this.jwtHelper.decodeToken(localStorage.getItem('id_token')));
  //console.log(this.jwtHelper.decodeToken(localStorage.getItem('id_token')));

  constructor(public router: Router, private _http : Http) {

    super();

    this.userProfile = localStorage.getItem(JSON.stringify('profile'));

    var http = this._http;
    var options = this.options;
    var baseURL = this._baseURL;

    // Add callback for lock `authenticated` event
    this.lock.on('authenticated', (authResult) => {
      localStorage.setItem('id_token', authResult.idToken);
            
            this.lock.getProfile(authResult.idToken, function (err, profile) {
              if(err) {
                return;
              }

              localStorage.setItem('profile', JSON.stringify(profile));

              var user : any = {};
              user.firstname = profile.user_metadata.name;
              user.lastname = profile.user_metadata.lastname;
              user.username = profile.nickname;
              user.email = profile.email;
              user.auth_id = profile.user_id;

              http.post( baseURL + "/userLoggedIn",JSON.stringify(user),options)
                        .map(res => res.json())
                        .subscribe(
                            res => res
                        );
              // window.location.reload();
            });
        });
  }
  

  public login() {
    // Call the show method to display the widget.
    this.lock.show();
  };

  public authenticated() {
    // Check if there's an unexpired JWT
    // It searches for an item in localStorage with key == 'id_token'
    return tokenNotExpired();
  };

  public logout() {
    // Remove token from localStorage
    localStorage.removeItem('id_token');
    localStorage.removeItem('profile');
    this.router.navigateByUrl("/");
  };
}