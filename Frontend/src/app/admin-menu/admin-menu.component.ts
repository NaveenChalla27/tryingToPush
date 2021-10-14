import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RegisterService } from '../register.service';
import { SharedService } from '../shared.service';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  constructor(private service:RegisterService,private router:Router,private route: ActivatedRoute,private shared:SharedService) { }
  itemsList!: any[];
  ngOnInit(): void {
    this.getMenuItems();
  }
  getMenuItems(){
    this.service.getItemsList().subscribe(data=>{
      this.itemsList=data;
    });
  }
  update(id:number){
        this.shared.setItemId(id);
        this.router.navigate(['/adminItemUpdate']);
  }
  delete(id:number){
    this.service.deleteItemByAdmin(id).subscribe(data=>{
      console.log("deleted")
     });
  }
  addItem(){
    this.router.navigate(['/adminItemAdd']);
  }
}
