import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpInterceptorService } from './http-interceptor.service';
import { LogoutComponent } from './logout/logout.component';
import { MenuComponent } from './menu/menu.component';
import { NavigationbarComponent } from './navigationbar/navigationbar.component';
import { CartItemsComponent } from './cart-items/cart-items.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatIconModule} from '@angular/material/icon';
import { AdminMenuComponent } from './admin-menu/admin-menu.component';
import { AdminregistrationComponent } from './adminregistration/adminregistration.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { CustomerRegisterComponent } from './customer-register/customer-register.component';
import { AdminItemUpdateComponent } from './admin-item-update/admin-item-update.component';
import { AdminItemAddComponent } from './admin-item-add/admin-item-add.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    LogoutComponent,
    MenuComponent,
    NavigationbarComponent,
    CartItemsComponent,
    AdminMenuComponent,
    AdminregistrationComponent,
    AdminloginComponent,
    CustomerRegisterComponent,
    AdminItemUpdateComponent,
    AdminItemAddComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatIconModule
  ],
  providers: [  
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }
