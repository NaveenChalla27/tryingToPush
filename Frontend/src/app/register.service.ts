import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from './adminlogin/adminlogin.component';
import { Customer } from './customer';
import { ItemsList } from './food-item';
import { CartOfCustomer } from './menu/menu.component';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
 
  user=sessionStorage.getItem('authenticatedUser')
  private baseUrl="http://localhost:8080/register";
  private baseUrl1="http://localhost:8080/menuList";
  private baseUrl2="http://localhost:8080/cart/12/items";
  private baseUrl3="http://localhost:8080/1/cart";
  //private baseUrl3="http://localhost:8080/{user}/cart";
  private baseUrl4="http://localhost:8080/cart";
  private baseUrl5="http://localhost:8080/admin/logindetails";
  private baseUrl6="http://localhost:8080/admin/register";
  private baseUrl7="http://localhost:8080/admin/deleteItem";
  private baseUrl8="http://localhost:8080/admin/addItem";
  private baseUrl9="http://localhost:8080//admin/updateItem";

  
  constructor(private httpClient: HttpClient) { }
  addCustomer(customer:Customer):Observable<object>{
    return this.httpClient.post(`${this.baseUrl}`,customer);}

  getItemsList():Observable<ItemsList[]>{
    return this.httpClient.get<ItemsList[]>(`${this.baseUrl1}`);
  }
  getCartItemsList():Observable<ItemsList[]>{
    return this.httpClient.get<ItemsList[]>(`${this.baseUrl2}`);
  }
  postCartItems(itemsofCart:CartOfCustomer):Observable<any>{
    return this.httpClient.post(`${this.baseUrl3}`,itemsofCart);}

  deleteItem(id: number, itemname: string) {
      return this.httpClient.delete(`${this.baseUrl4}/${id}/${itemname}`);
    }



    // admin

    addAdmin(admin: Admin):Observable<any> {
     return this.httpClient.post<any>(`${this.baseUrl6}`,admin);
    }
    admincredentials(admin:Admin):Observable<any> {
      return this.httpClient.post<any>(`${this.baseUrl5}`,admin)}

    deleteItemByAdmin(id:number):Observable<any> {
      return this.httpClient.delete(`${this.baseUrl7}/${id}`);
    } 
    addingitemByAdmin(item: ItemsList):Observable<any> {
      return this.httpClient.post<any>(`${this.baseUrl8}`,item);
    }
   updateItem(id: any, item: any):Observable<any> {
    return this.httpClient.put<any>(`${this.baseUrl9}/${id}`,item)
  }
      
}
