import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  id:number=0;
  setItemId(id:number) {
    this.id=id;
  }
  cartItemsList?:any[];
  setCartItems(cartItems: any){
     this.cartItemsList=cartItems;
     console.log("challa"+this.cartItemsList);
  }
  getCartItemsList(){
    return this.cartItemsList;
  }

  getItemId(){
    return this.id;
  }
  constructor() { }
}
