import { Component, OnInit } from '@angular/core';
import { ItemsList } from '../food-item';
import { RegisterService } from '../register.service';
import { SharedService } from '../shared.service';

@Component({
  selector: 'app-admin-item-update',
  templateUrl: './admin-item-update.component.html',
  styleUrls: ['./admin-item-update.component.css']
})
export class AdminItemUpdateComponent implements OnInit {
   id:number=0;
  constructor(private shared :SharedService,private service :RegisterService) { }
  item!:ItemsList;
  ngOnInit(): void {
  }
  updatingItem(){
     this.id=this.shared.getItemId();
     this.service.updateItem(this.id,this.item);

  }
}
