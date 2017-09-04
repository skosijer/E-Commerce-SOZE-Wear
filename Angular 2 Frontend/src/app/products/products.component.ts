import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/primeng';
import { ProductsService } from './products.service';
import {Http,Headers,RequestOptions,RequestMethod,Request,Response} from '@angular/http';
import {Header} from 'primeng/primeng';
import 'rxjs/Rx';
import * as _ from 'underscore';
import {Message} from 'primeng/primeng';
import { Observable } from 'rxjs/Rx';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  categories : MenuItem[];
  showCategories = false;
  productsTitle = "All";
  showCategoriesTitle = "Show categories";
  products : any[] = [];
  allProducts : any[] = [];
  msgs: Message[] = [];

  displaySearchFilter : boolean = false;

  selectedSearchPhrases : string[] = [];
  firstSearchForm: FormGroup;
  firstSearch : any = { "text" : "" };

  selectedSearchWildcard : string = "";
  secondSearchForm: FormGroup;
  secondSearch : any = { "text" : "" };

  thirdSearchForm : FormGroup;
  thirdSearch : any = { "text" : "" };

//   priceSearchForm : FormGroup;
//   rangeValues: number[] = [0,5000];

  constructor(
      private productsService : ProductsService,
      private _fb: FormBuilder
           ) { }

  ngOnInit() {

      this.firstSearchForm = this._fb.group({
        text: ['', [Validators.required, Validators.pattern('[a-z A-Z]*')]],
    });

      this.secondSearchForm = this._fb.group({
        text: ['', [Validators.required, Validators.pattern('[a-z A-Z]*')]],
    });

     this.thirdSearchForm = this._fb.group({
        text: ['', [Validators.required]],
    });



      Observable.forkJoin([ this.productsService.getProducts(), this.productsService.getCategories()])
                .subscribe(
                    data => {
                        //first call logic
                            this.products = data[0]; this.allProducts = data[0];
                        //second call logic
                             this.categories = [{
                                    label: 'Categories',
                                    items: [{label: 'All', command: (event) => {
                                        this.productsTitle = "All";
                                             this.productsService.getProducts()
                                                                .subscribe(
                                                                    res => {this.products = res;}
                                                                );
                                    }}]
                                }];
                              
                                  for(let i in data[1])
                                  {
                                      this.categories[0].items.push(
                                        {label: data[1][i].name, command: (event) => {
                
                                            this.productsTitle = data[1][i].name;
                                            this.products = [];
                                         
                                            this.allProducts.forEach(element => {
                                                if(element.category.id == data[1][i].id)
                                                    this.products.push(element);
                                            });
                                        }}    
                                      );
                                  }
                    }
                );

      
  }

  makeFirstSearch()
  {
      if(this.selectedSearchPhrases.length == 0)
      {
          this.msgs = [];
          this.msgs.push({severity:'warn', summary:'No fields selected!', detail:'Please select at least one field to search for'});
      }
      else
      {
          var wrapper : any = {"text" : this.firstSearch.text, "name" : this.selectedSearchPhrases.includes("Name") , "description" : this.selectedSearchPhrases.includes("Description"), "category" : this.selectedSearchPhrases.includes("Category")};

          this.productsService.getFirstSearch(wrapper)
                              .subscribe(
                                  res => {
                                      this.products = res;

                                      this.msgs = [];
                                      this.msgs.push({severity:'success', summary:'Successful phrase search!'});

                                      this.displaySearchFilter = false;
                                  }
                              );

      }
  }

  makeSecondSearch()
  {
      console.log(this.selectedSearchWildcard);
        // if(this.selectedSearchWildcard.length == 0)
        // {
        //      this.msgs = [];
        //      this.msgs.push({severity:'warn', summary:'No fields selected!', detail:'Please select at least one field to search for'});
        // }
        // else
        // {
             var wrapper : any = {"text" : this.secondSearch.text, "name" : this.selectedSearchWildcard.includes("Name") , "description" : this.selectedSearchWildcard.includes("Description"), "category" : this.selectedSearchWildcard.includes("Category")};
             
             console.log(wrapper);

             this.productsService.getSecondSearch(wrapper)
                              .subscribe(
                                  res => {
                                      this.products = res;

                                      this.msgs = [];
                                      this.msgs.push({severity:'success', summary:'Successful fuzzy search!'});

                                      this.displaySearchFilter = false;
                                  }
                              );
        // }
  }

  makeThirdSearch()
  {
        var wrapper : any = {"text" : this.thirdSearch.text, "name" : this.selectedSearchWildcard.includes("Name") , "description" : this.selectedSearchWildcard.includes("Description"), "category" : this.selectedSearchWildcard.includes("Category")};
             
             console.log(wrapper);

             this.productsService.getThirdSearch(wrapper)
                              .subscribe(
                                  res => {
                                      this.products = res;

                                      this.msgs = [];
                                      this.msgs.push({severity:'success', summary:'Successful simple query search!'});

                                      this.displaySearchFilter = false;
                                  }
                              );
  }

  showHideCategories()
  {
      if(this.showCategoriesTitle == "Show categories")
          this.showCategoriesTitle = "Hide categories";
      else
          this.showCategoriesTitle = "Show categories";
      
      this.showCategories = !this.showCategories;
  }

  addToShoppingCart(product)
  {
      console.log(product);
      
      //var shoppingCart = localStorage.getItem("shoppingCart");
      //put shit in sessionStorage and enjoy 
      var shoppingCart : any[] = JSON.parse(sessionStorage.getItem("shoppingCart"));

      if(shoppingCart == null)
      {
          var newShoppingCart : any[] = [];
          product.shoppingCartId = 1;
          product.size = "L";
          product.quantity = 1;
          newShoppingCart.push(product);
          sessionStorage.setItem("shoppingCart", JSON.stringify(newShoppingCart));
      }
      else
      {
        // Product already added to shoppingCart
        //   if(_.findWhere(shoppingCart,product.id))
        //     alert("already added");
          product.shoppingCartId = 1;
          product.size = "L";
          product.quantity = 1;

          var i = 1;

          _.each(shoppingCart, function(item) {
                item.shoppingCartId = ++i;
          });
        

          shoppingCart.push(product);
          console.log(shoppingCart);
          
          sessionStorage.setItem("shoppingCart", JSON.stringify(shoppingCart));
      }

      this.msgs = [];
      this.msgs.push({severity:'success', summary:'Item added', detail:'Find item in shopping cart'});
  }

}
