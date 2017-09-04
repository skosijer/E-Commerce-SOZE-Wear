import { Injectable } from '@angular/core';
import { AbstractService } from '../abstract.service';
import { Auth } from '../auth.service';
import {Http,Headers,RequestOptions,RequestMethod,Request,Response} from '@angular/http';
import 'rxjs/Rx';

@Injectable()
export class LoginService extends AbstractService{

  constructor(private _http : Http, private _auth : Auth) {
      super();
   }

  //  getFreeManagers_AndUserManagers(manager_id,restaurant_id){
  //   return this._http.get(this._baseURL + "/userRepo/getManagers/" + manager_id + "/forRestaurant/"+restaurant_id)
  //         .map(res=>res.json());
  // }

  //  return this._http.post(this._baseURL + "/filterRestaurants",JSON.stringify(filterData),options)
  //           .map(res =><RestaurantClass[]> res.json());

  //provide services

  userLoggedIn(user)
  {
       return this._http.post(this._baseURL + "/userLoggedIn",JSON.stringify(user),this.options)
                        .map(res => res.json());
  }
}
