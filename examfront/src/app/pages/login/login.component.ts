import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginData = {
    username: '',
    password: ''
  };

  constructor(private loginService:LoginService,private router:Router) { }

  ngOnInit(): void {
  }
  formSubmit() {
    console.log("Login Form Submited");
    if (this.loginData.username.trim() == '' || this.loginData.username == null) {
      alert("Username is Required!!!");
      return;
    }
    if (this.loginData.password == '' || this.loginData.password == null) {
      alert("Password is Required!!!");
      return;
    }

    //request to server to generate token
    this.loginService.generateToken(this.loginData).subscribe((data:any)=>{
      console.log("success");
      console.log(data);

      //login..
      this.loginService.loginUser(data.token);
      this.loginService.getCurrentUser().subscribe((user:any)=>{
        this.loginService.setUser(user);
        //redirect ...ADMIN: admin-dashboard
        //redirect ...NORMAL:normal-dashboard
        if(this.loginService.getUserRole()=='ADMIN'){
          //admin-dashboard
         // window.location.href='/admin';
         this.router.navigate(['admin']);
         this.loginService.loginStatusSubject.next(true);
        }else if(this.loginService.getUserRole()=='NORMAL'){
          //normal user-dashboard
        //  window.location.href='/user-dashboard';
        this.router.navigate(['user-dashboard']);
        this.loginService.loginStatusSubject.next(true);
        }else{
        this.loginService.logout();  
        }
      })
    },(error)=>{
      console.log("Error !");
      console.log(error);
      alert("Invalid Details !! Try Again.");
    })
  }
}
