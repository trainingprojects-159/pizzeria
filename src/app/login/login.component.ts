import { Component, OnInit } from '@angular/core';
import { Router } from '../../../node_modules/@angular/router';
import { PizzastoreService } from '../pizzastore.service';
import { PizzaStore } from '../pizza-store';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
pizzastores: PizzaStore=new PizzaStore;
error = 'invalid';
  constructor(private router: Router,
  private _pizzastoreService: PizzastoreService) { }

  ngOnInit() {
  }
  
  login(){
    this._pizzastoreService.login(this.pizzastores.storeid,this.pizzastores.password)
    .then(result => {
      if(result === true)
      {
        this.router.navigateByUrl('home');
      }
      else{
        this.error = 'invalid storeid and password';
        this.router.navigateByUrl('login');
      }
    },
  error =>{this.error =error;});
 
  return ;
  }

}
