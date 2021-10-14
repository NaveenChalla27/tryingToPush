import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../customer';
import { RegisterService } from '../register.service';

@Component({
  selector: 'app-customer-register',
  templateUrl: './customer-register.component.html',
  styleUrls: ['./customer-register.component.css']
})
export class CustomerRegisterComponent implements OnInit {

  constructor(private service:RegisterService ,private router:Router,private route: ActivatedRoute) { }

  ngOnInit(): void {
  }
  customer:Customer={
    password: '',
    firstName: '',
    lastName: '',
    emailid: '',
    address: '',
    phonenumber: '',
    id: 0
  };
register(){
  console.log(this.customer);
  this.service.addCustomer(this.customer).subscribe(data=>{
    console.log(data);
    this.goToLoginPage();
},(error: any)=>console.log(error));
}
goToLoginPage(){
  this.router.navigate(['/login']);
}
}
