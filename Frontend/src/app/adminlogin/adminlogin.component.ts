import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RegisterService } from '../register.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  constructor( private register:RegisterService,private route: ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
  }
  username: string='';
  password : string='';
errorMessage='InavlidCredentials';
successMessage:string='';
invalidLogin=false;
loginSuccess=false;
admin:  Admin=new Admin(0,'','','','','','');
  handleLogin() {
     console.log(this.admin)
    this.register.admincredentials(this.admin).subscribe((result: any)=> {
      this.loginSuccess=result;
      if(this.loginSuccess){
       this.router.navigate(['/adminMenu']);}
       else{
       this. invalidLogin=true;
       }
    } )}; 
  
}
export class Admin{
  id:number;
		 firstName:string;
		 lastName:string;	 
		 phonenumber:string;
		 address:string;
   emailId:string;
   password:string;
   constructor(id:number,emailId:string,password:string,firstName:string, lastName:string,phonenumber:string,address:string){
     this.emailId=emailId;
     this.password=password;
     this.lastName=lastName;
     this.firstName=firstName;
     this.address=address;
     this.phonenumber=phonenumber
     this.id=id;
   }
}
