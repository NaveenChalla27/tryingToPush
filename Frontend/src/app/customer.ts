export class Customer {
    id:number;
    emailid:string;
    firstName:string;
    lastName:string;
    address:string;
    phonenumber:string;
    password:string;
  constructor (id:number, emailid:string,firstName:string ,lastName:string,address:string,phonenumber:string,password:string){
      this.id=id;
      this.emailid=emailid;
       this.firstName=firstName;
       this.lastName=lastName;
       this.password=password;
     this.address=address;
       this.phonenumber=phonenumber
   }

}
