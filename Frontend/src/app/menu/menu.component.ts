import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ItemsList } from '../food-item';
import { RegisterService } from '../register.service';
import { SharedService } from '../shared.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  total=0;
  constructor(private service:RegisterService,private route: ActivatedRoute,private router: Router,private shared:SharedService,private cartService:RegisterService) { }
  itemsList!: any[];
  cartItems: Array<any> = [];
  item:ItemsList=new ItemsList(0,1,0,'','');
  ngOnInit(): void {
    this.getMenuItems();
}
  getMenuItems(){
    this.service.getItemsList().subscribe(data=>{
      this.itemsList=data;
    });
  }
  addingToCart(itemId:number){
    this.item=this.itemsList.find(i=>i.id==itemId)
    this.cartItems.push(this.item);
  }

    cart(){
      this.cartofcustomer.cartItem=this.cartItems;  
      this.cartofcustomer.date=new Date();
      this.cartofcustomer.id=1000;
      this.shared.setCartItems( this.cartofcustomer.cartItem);
      this.cartService.postCartItems(this.cartofcustomer).subscribe((data)=>console.log(data));
      this.router.navigate(['/cart']);
    }
  cartofcustomer: CartOfCustomer = new CartOfCustomer();
  items!:ItemsList[];
  
 
}
 export class CartOfCustomer{
   id!:number;
  date!: Date;
  cartItem!: ItemsList[];
}
