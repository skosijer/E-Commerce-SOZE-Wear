import { Component, OnInit } from '@angular/core';
import { Auth } from "../auth.service";
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ProductsService } from '../products/products.service';
import {Message} from 'primeng/primeng';
import {ConfirmationService} from 'primeng/primeng';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  msgs: Message[] = [];

  uploadedFiles: any[] = [];

  private formAddCategory: FormGroup;
  private displayAddCategory: boolean = false;
  private category : any = {"name" : "", "description" : ""};
  private optionCategories : any[] = [];

  private formAddProduct: FormGroup;
  private displayAddProduct: boolean = false;
  private product : any = {"name" : "", "description" : "", "category" : "", "price" : ""};
  private optionPrices : any[] = [];

  private allProducts = [];
  private allProductsCols = [];
  
  private allCategories = [];
  private allCategoriesCols = [];

  constructor(private auth : Auth,
              private _fb: FormBuilder,
              private productsService: ProductsService,
              private confirmationService: ConfirmationService
          ) { }

  ngOnInit() {

      this.formAddCategory = this._fb.group({
        name: ['', Validators.required],
        description: ['', Validators.required]
    });

      this.formAddProduct = this._fb.group({
        name: ['', Validators.required],
        description: ['', Validators.required],
        category: ['', Validators.required],
        price: ['', Validators.required]
    });

      this.allProductsCols = [
            {field: 'name', header: 'Name'},
            {field: 'description', header: 'Description'},
            {field: 'createDate', header: 'Create date'},
            {field: 'category.name', header: 'Category'},
            {field: 'price_id.price_value', header: 'Price'}
        ];

        this.allCategoriesCols = [
            {field: 'name', header: 'Name'},
            {field: 'description', header: 'Description'}
        ];

      this.getProducts();
      this.getCategories();
  }

   onUpload(event) {
        for(let file of event.files) {
            this.uploadedFiles.push(file);
        }
    
        this.msgs = [];
        this.msgs.push({severity: 'info', summary: 'File Uploaded', detail: ''});
    }

  getProducts()
  {
      this.productsService.getProducts()
                          .subscribe(
                            res => {this.allProducts = res; console.log(res);}
                          );
                      
  }

  getCategories()
  {
       this.productsService.getCategories()
                          .subscribe(
                            res => {this.allCategories = res; console.log(res);}
                          );
  }

  getCategoriesAndPrices()
  {
       this.productsService.getCategories()
                          .subscribe(
                            res => {
                                for(let i in res)
                                  { 
                                      this.optionCategories.push({label: res[i].name, value: res[i].id});
                                  }
                            }
                          );
        
        this.productsService.getPrices()
                          .subscribe(
                            res => {
                                for(let i in res)
                                  { 
                                      this.optionPrices.push({label: res[i].price_value, value: res[i].id});
                                  }
                            }
                          );
  }

  addCategory()
  {
    this.displayAddCategory = false;

    this.productsService.addCategory(this.category)
                        .subscribe(
                          res => {
                                 this.msgs = [];
                                 this.msgs.push({severity:'success', summary:'New category added.', detail:'Find category under products.'});

                                 this.getCategories();
                                 this.getProducts();
                          }
                        );
  }

  addProduct()
  {
    this.displayAddProduct = false;

    this.productsService.addProduct(this.product)
                        .subscribe(
                          res => {
                                 this.msgs = [];
                                 this.msgs.push({severity:'success', summary:'New product added.', detail:'Find product under products.'});

                                 this.getProducts();
                          }
                        );
  }

  updateCategory(category)
  {
      this.category.name = category.name;
      this.category.description = category.description;
      this.category.id = category.id;
      this.showCategoryDialog();

  }

  updateProduct(product)
  {
      this.product.id = product.id;
      this.product.name = product.name;
      this.product.description = product.description;
      this.showProductDialog();
  }

  deleteProduct(product)
  {

      this.confirmationService.confirm({
            message: 'Do you want to delete this product?',
            header: 'Delete Confirmation',
            icon: 'fa fa-trash',
            accept: () => {
               this.productsService.deleteProduct(product.id)
                          .subscribe(
                            res => {
                                      this.msgs = [];
                                      this.msgs.push({severity:'success', summary:'Product deleted.'});

                                      this.getProducts();
                            }
                          );
            }
        });

      
  }

  deleteCategory(category)
  {
    this.confirmationService.confirm({
            message: 'Do you want to delete this category?',
            header: 'Delete Confirmation',
            icon: 'fa fa-trash',
            accept: () => {
                 this.productsService.deleteCategory(category.id)
                          .subscribe(
                            res =>{
                                     this.msgs = [];
                                     this.msgs.push({severity:'success', summary:'Category is deleted with all it\'s products.'});

                                    this.getCategories();
                                    this.getProducts();
                            }
                          );
            }
        });
  }

  addNewProduct()
  {
      this.product.id = "";
      this.showProductDialog();
  }

  addNewCategory()
  {
      this.category.id = "";
      this.showCategoryDialog();
  }

  showCategoryDialog()
  {
      this.displayAddCategory = true;
      this.optionCategories = [];
      this.optionPrices = [];
      this.getCategoriesAndPrices();
  }

  showProductDialog()
  {
      this.displayAddProduct = true;
      this.optionCategories = [];
      this.optionPrices = [];
      this.getCategoriesAndPrices();
  }

}
