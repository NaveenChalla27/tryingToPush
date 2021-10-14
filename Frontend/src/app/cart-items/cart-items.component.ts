import { Component, OnInit } from '@angular/core';
import { ItemsList } from '../food-item';
import { RegisterService } from '../register.service';
import { SharedService } from '../shared.service';

@Component({
  selector: 'app-cart-items',
  templateUrl: './cart-items.component.html',
  styleUrls: ['./cart-items.component.css']
})
export class CartItemsComponent implements OnInit {
  myCartItems?: ItemsList[];
 
  constructor(private shared:SharedService, private cartservice:RegisterService) { }
  totalvalue=0;
  ngOnInit(): void {
  let total=0;
   this.cartservice.getCartItemsList().subscribe(data=>{
    this.myCartItems=data ;
    this.myCartItems.forEach((value)=>
    {
      total=total+value.itemprice;
      this.totalsum(total)
    })
},(error: any)=>console.log(error));
} 

delete(id:number,itemname:string){
 this.cartservice.deleteItem(id,itemname).subscribe(data=>{
 console.log("deleted")
});
};
 totalsum(sum:number){
   this.totalvalue=sum;
 }

}
