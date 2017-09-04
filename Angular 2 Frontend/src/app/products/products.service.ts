import { Injectable } from '@angular/core';
import { AbstractService } from '../abstract.service';
import {Http,Headers,RequestOptions,RequestMethod,Request,Response} from '@angular/http';
import 'rxjs/Rx';

@Injectable()
export class ProductsService extends AbstractService{

  constructor(private _http : Http) {
    super();
   }

   //searching

   getFirstSearch(wrapper)
   {
       return this._http.post(this._baseURL + "/rest/manual/search/firstSearch",JSON.stringify(wrapper),this.options)
               .map(res => res.json());
   }

    getSecondSearch(wrapper)
   {
       return this._http.post(this._baseURL + "/rest/manual/search/secondSearch",JSON.stringify(wrapper),this.options)
               .map(res => res.json());
   }

   getThirdSearch(wrapper)
   {
       return this._http.post(this._baseURL + "/rest/manual/search/thirdSearch",JSON.stringify(wrapper),this.options)
               .map(res => res.json());  
   }

   //

  getCategories()
  {
        return this._http.get(this._baseURL + "/getCategories")
              .map(res => res.json());
  }

   getProductsByCategory(id)
  {
        return this._http.get(this._baseURL + "/getProductsByCategory/" + id)
              .map(res => res.json());
  }

   getProducts()
  {
        return this._http.get(this._baseURL + "/getProducts")
              .map(res => res.json());
  }

  getPrices()
  {
        return this._http.get(this._baseURL + "/getPrices")
              .map(res => res.json());
  }

  addProduct(product)
  {
        return this._http.post(this._baseURL + "/addProduct",JSON.stringify(product),this.options)
               .map(res => res.json());
  }

  addCategory(category)
  {
        return this._http.post(this._baseURL + "/addCategory",JSON.stringify(category),this.options)
               .map(res => res.json());
  }

  deleteProduct(product_id)
  {
      return this._http.post(this._baseURL + "/deleteProduct",JSON.stringify(product_id),this.options)
               .map(res => res.json());
  }

  deleteCategory(category_id)
  {
      return this._http.post(this._baseURL + "/deleteCategory",JSON.stringify(category_id),this.options)
               .map(res => res.json());
  }
}
