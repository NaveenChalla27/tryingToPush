import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {AuthenticationService} from './auth.service'


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string='';
  password : string='';
errorMessage='InavlidCredentials';
successMessage:string='';
invalidLogin=false;
loginSuccess=false;
 constructor(private authenticationService:AuthenticationService, private route: ActivatedRoute,
  private router: Router) { }

  ngOnInit(): void {
  }
  handleLogin() {
    this.authenticationService.authenticationService(this.username, this.password).subscribe((result: any)=> {
      console.log(result);
      this.invalidLogin = false;
      this.loginSuccess = true;
      this.successMessage = 'Login Successful.';
      this.router.navigate(['/home']);
    }, () => {
      this.invalidLogin = true;
      this.loginSuccess = false;
    });      
  }

}
