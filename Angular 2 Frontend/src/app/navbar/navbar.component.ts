import { Component, OnInit } from '@angular/core';
import { Auth } from '../auth.service';
import { ProductsService } from '../products/products.service';
import {Http,Headers,RequestOptions,RequestMethod,Request,Response} from '@angular/http';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  searchText : any = "";

  constructor(private auth : Auth,
              private productsService : ProductsService) { }

  ngOnInit() {
  }

  searchProducts()
  {
      // var wrapper : any = {"text" : this.secondSearch.text, "name" : this.selectedSearchWildcard.includes("Name") , "description" : this.selectedSearchWildcard.includes("Description"), "category" : this.selectedSearchWildcard.includes("Category")};
             
      //        console.log(wrapper);

      //        this.productsService.getSecondSearch(wrapper)
      //                         .subscribe(
      //                             res => {
      //                                 this.products = res;

      //                                 this.msgs = [];
      //                                 this.msgs.push({severity:'success', summary:'Successful search!'});

      //                                 this.displaySearchFilter = false;
      //                             }
      //                         );
  }

}
