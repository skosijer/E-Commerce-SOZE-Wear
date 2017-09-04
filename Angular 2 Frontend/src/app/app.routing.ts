import {Router, RouterModule} from '@angular/router';

//Services imports
import { AuthGuard } from './authguard.service';

//Components imports
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ProductsComponent } from './products/products.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';

export const routing = RouterModule.forRoot([
    { path: '', component: LoginComponent},
    { path: 'login', component: LoginComponent},
    { path: 'home', component: HomeComponent},
    { path: 'products', component: ProductsComponent},
    { path: 'shoppingcart', component: ShoppingCartComponent},
    { path: '**', component: HomeComponent}
]);