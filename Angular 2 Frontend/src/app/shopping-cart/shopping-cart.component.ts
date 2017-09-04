import { Component, OnInit } from '@angular/core';
import * as _ from 'underscore';
import {SelectItem} from 'primeng/primeng';
import {Message} from 'primeng/primeng';
import { ShoppingCartService } from './shopping-cart.service';
import { Auth } from '../auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  products : any[] = [];
  hasProducts : boolean = false;
  sizes: SelectItem[];
  msgs: Message[] = [];

  orderSubtotal : any = 0;
  orderTotal : any = 0;
  orderDiscount : any = 0;

  private formOrderDetails: FormGroup;
  private displayOrderDetails: boolean = false;
  private orderDetails : any = {"address" : "", "email" : "", "phone" : ""};

  constructor(private shoppingCartService : ShoppingCartService, 
              private authService : Auth,
              private _fb: FormBuilder
            ) { }

  ngOnInit() {

    this.products = JSON.parse(sessionStorage.getItem("shoppingCart"));

    this.formOrderDetails = this._fb.group({
        address: ['', Validators.required],
        email: ['', Validators.required],
        phone: ['', [Validators.required, Validators.pattern('[0-9]*')]]
    });

    if(this.products != null)
    {
        if(this.products.length != 0)
            this.hasProducts = true;
    }

    this.sizes = [];
        this.sizes.push({label:'S', value:'S'});
        this.sizes.push({label:'M', value:'M'});
        this.sizes.push({label:'L', value:'L'});
        this.sizes.push({label:'XL', value:'XL'}); 

    this.orderTotalCount();
  }

  fuck()
  {
      alert("LUD   ");
  }

  changeOrderDetails(product)
  {
      console.log(product);
  }

  removeFromShoppingCart(shoppingCartId)
  {
      this.products = _.without(this.products, _.findWhere(this.products, {'shoppingCartId': shoppingCartId}));

      console.log(this.products);

      sessionStorage.setItem("shoppingCart", JSON.stringify(this.products));

      this.msgs = [];
      this.msgs.push({severity:'info', summary:'Removed item', detail:'Item removed from order'});

      this.orderTotalCount();
  }

  orderTotalCount()
  {
      var subtotal = 0;

      _.each(this.products, function(item)
      {
          subtotal += Number(item.price_id.price_value * item.quantity);
      });

      this.orderSubtotal = subtotal;

      this.orderTotal = this.orderSubtotal - this.orderDiscount;
  }

  makeOrder()
  {
      //Making order for USER_ID and LIST OF ORDER_DETAILS he's trying to order

       var customer = JSON.parse(localStorage.getItem('profile'));

       var order = {"user_id" : customer.user_id, "address" : this.orderDetails.address,  "email" : this.orderDetails.email,  "phone" : this.orderDetails.phone, "orders" : []};

      _.each(this.products, function(item)
      {
          var order_detail = {"product_id" : 0, "quantity" : 0, "size" : 'L'};

          order_detail.product_id = item.id;
          order_detail.quantity = item.quantity;
          order_detail.size = item.size;

          order.orders.push(order_detail);
      });

      console.log(order);

        this.shoppingCartService.makeOrder(order)
                        .subscribe(
                            res => {

                                this.msgs = [];
                                this.msgs.push({severity:'success', summary:'Order has been made.', detail: 'You ordered ' + this.products.length + ' kinds of products.'});
                                
                                this.displayOrderDetails = false;

                                this.products = [];
                                this.hasProducts = false;

                                sessionStorage.setItem("shoppingCart", JSON.stringify(this.products));
                            }
                        );
      
  }

}
