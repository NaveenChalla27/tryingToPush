import { Component, OnInit } from '@angular/core';
import { ItemsList } from '../food-item';
import { RegisterService } from '../register.service';

@Component({
  selector: 'app-admin-item-add',
  templateUrl: './admin-item-add.component.html',
  styleUrls: ['./admin-item-add.component.css']
})
export class AdminItemAddComponent implements OnInit {
  item!:ItemsList;
 //item:ItemsList= new ItemsList(0,0,0,'','');
  constructor(private service:RegisterService) { }

  ngOnInit(): void {
  }
  addingItem(){
     this.service.addingitemByAdmin(this.item).subscribe(data=>{
      console.log(data);
    });
  }
}
