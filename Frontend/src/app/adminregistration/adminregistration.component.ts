import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from '../adminlogin/adminlogin.component';
import { RegisterService } from '../register.service';

@Component({
  selector: 'app-adminregistration',
  templateUrl: './adminregistration.component.html',
  styleUrls: ['./adminregistration.component.css']
})
export class AdminregistrationComponent implements OnInit {
  customer:Admin={
    id: 0,
    firstName: '',
    lastName: '',
    phonenumber: '',
    address: '',
    emailId: '',
    password: ''
  };
  constructor(private service:RegisterService ,private router:Router,private route: ActivatedRoute) { }

  ngOnInit(): void {
  }
  register(){
    console.log(this.customer);
    this.service.addAdmin(this.customer).subscribe(data=>{
      console.log(data);
      this.goToLoginPage();
  },(error: any)=>console.log(error));
  }
  goToLoginPage(){
    this.router.navigate(['/adminlogin']);
  }

}
