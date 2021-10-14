import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminItemAddComponent } from './admin-item-add/admin-item-add.component';
import { AdminItemUpdateComponent } from './admin-item-update/admin-item-update.component';
import { AdminMenuComponent } from './admin-menu/admin-menu.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdminregistrationComponent } from './adminregistration/adminregistration.component';
import { CartItemsComponent } from './cart-items/cart-items.component';
import { CustomerRegisterComponent } from './customer-register/customer-register.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', redirectTo:'/login',pathMatch:'full'},
  {path: 'home', component: HomeComponent},
  {path: 'logout', component: LoginComponent},
  {path:'register',component:CustomerRegisterComponent},
  {path:'menu',component:MenuComponent},
  {path:'cart',component:CartItemsComponent},
  {path:'adminMenu',component:AdminMenuComponent},
  {path:"adminlogin",component:AdminloginComponent},
  {path:'adminregistration',component:AdminregistrationComponent},
  {path:'admin',redirectTo:'/adminlogin',pathMatch:'full'},
  {path:'adminItemAdd',component:AdminItemAddComponent},
  {path:'adminItemUpdate',component:AdminItemUpdateComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
