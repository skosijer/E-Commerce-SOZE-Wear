import { Injectable } from '@angular/core';
import {Http,Headers,RequestOptions,RequestMethod,Request,Response} from '@angular/http';
import 'rxjs/Rx';

@Injectable()
export class AbstractService {

  public _baseURL = "http://localhost:4400";
  public headers = new Headers({'Content-Type':'application/json'});
  public options = new RequestOptions({headers:this.headers});

  constructor() { }

}

  //                      GET REQUEST
  // get(){
  //       return this._http.get(this._baseURL + "/nesto")
  //             .map(res => res.json());
  // }


  //                      POST REQUEST
  //  return this._http.post(this._baseURL + "/filterRestaurants",JSON.stringify(filterData),options)
  //           .map(res => res.json());


  //                      GET FOR SPRING
  // @RequestMapping(
	// 		value = "/getAllProducts",
	// 		method = RequestMethod.GET,
	// 		produces = MediaType.APPLICATION_JSON_VALUE
	// 		)
	// public ResponseEntity<Collection<Product>> getAllProducts(){
		
	// 	Collection<Product> products = productService.findAll();
		
	// 	if(products == null){
	// 		return new ResponseEntity<Collection<Product>>(HttpStatus.NOT_FOUND);
	// 	}
	// 	return new ResponseEntity<Collection<Product>>(products,HttpStatus.OK);
	// }


  //                       POST FOR SPRING
  // @RequestMapping(
	// 		value = "userLoggedIn",
	// 		method = RequestMethod.POST,
	// 		produces = MediaType.APPLICATION_JSON_VALUE)
	// @ResponseBody
	// public void userLoggedIn(@RequestBody HashMap<String,String> user)
	// {
    
	// 	}	
	// }

