import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

//Router import
import { routing } from './app.routing';

//PrimeNG imports
import {CalendarModule} from 'primeng/primeng';
import {MenuModule,MenuItem} from 'primeng/primeng';
import {DataGridModule} from 'primeng/primeng';
import {PanelModule} from 'primeng/primeng';
import {TooltipModule} from 'primeng/primeng';
import {DataListModule} from 'primeng/primeng';
import {DataScrollerModule} from 'primeng/primeng';
import {ButtonModule} from 'primeng/primeng';
import {SpinnerModule} from 'primeng/primeng';
import {DropdownModule} from 'primeng/primeng';
import {GrowlModule} from 'primeng/primeng';
import {DialogModule} from 'primeng/primeng';
import {DataTableModule} from 'primeng/primeng';
import {ConfirmDialogModule,ConfirmationService} from 'primeng/primeng';
import {TabViewModule} from 'primeng/primeng';
import {ToolbarModule} from 'primeng/primeng';
import {CheckboxModule} from 'primeng/primeng';
import {RadioButtonModule} from 'primeng/primeng';
import {SliderModule} from 'primeng/primeng';
import {FileUploadModule} from 'primeng/primeng';

//Service imports
import { LoginService } from './login/login.service';
import { AuthGuard } from './authguard.service';
import { ProductsService } from './products/products.service';
import { ShoppingCartService } from './shopping-cart/shopping-cart.service';

//Auth0 imports
import { Auth } from './auth.service';

//Components imports
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { WishlistComponent } from './wishlist/wishlist.component';
import { ProductsComponent } from './products/products.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    NavbarComponent,
    WishlistComponent,
    ProductsComponent,
    ShoppingCartComponent
  ],
  
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    CalendarModule,
    MenuModule,
    DataGridModule,
    PanelModule,
    TooltipModule,
    DataListModule,
    DataScrollerModule,
    ButtonModule,
    SpinnerModule,
    DropdownModule,
    GrowlModule,
    DialogModule,
    DataTableModule,
    ConfirmDialogModule,
    TabViewModule,
    ToolbarModule,
    CheckboxModule,
    RadioButtonModule,
    SliderModule,
    FileUploadModule,
    routing
  ],

  providers: [
    Auth,
    AuthGuard,
    LoginService,
    ProductsService,
    ShoppingCartService,
    ConfirmationService
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
