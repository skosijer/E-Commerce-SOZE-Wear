import { Injectable } from '@angular/core';
import { AbstractService } from '../abstract.service';
import {Http,Headers,RequestOptions,RequestMethod,Request,Response} from '@angular/http';
import * as _ from 'underscore';
import 'rxjs/Rx';

@Injectable()
export class ShoppingCartService extends AbstractService{

  constructor(private _http : Http) {
    super();
   }

  getCategories()
  {
        return this._http.get(this._baseURL + "/getCategories")
              .map(res => res.json());
  }

  makeOrder(order_details)
  {
        return this._http.post(this._baseURL + "/makeOrder",JSON.stringify(order_details),this.options)
               .map(res => res.json());
  }

  //                      POST REQUEST
  //  return this._http.post(this._baseURL + "/filterRestaurants",JSON.stringify(filterData),options)
  //           .map(res => res.json());


}
