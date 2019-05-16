import { Component, OnInit } from '@angular/core';

import { PizzastoreService } from '../../pizzastore.service';
import { Router, ActivatedRoute } from '../../../../node_modules/@angular/router';
import { PizzaItems } from '../../pizza-items';
import { PizzaStore } from '../../pizza-store';


@Component({
  selector: 'app-addpizzaitem',
  templateUrl: './addpizzaitem.component.html',
  styleUrls: ['./addpizzaitem.component.css']
})
export class AddpizzaitemComponent implements OnInit {
pizzaitem: PizzaItems=new PizzaItems;
pizzastores: PizzaStore[];

  

constructor(private _router: Router,private _pizzastoreService: PizzastoreService,
  private route:ActivatedRoute){}

  ngOnInit() {
    this._pizzastoreService.getAllPizzaItems()
    .then(pizzastores => this.pizzastores = this.pizzastores);
    this.route.paramMap.subscribe(parameterMap =>{

     const sid = parameterMap.get('sid');

     if(sid){

       console.log("id "|| sid);

     this._pizzastoreService.getById(sid).then(pizzaitem =>this.pizzaitem =pizzaitem);

     }else{

      console.log("invalid id");

     }

   });
  }
 


   pizzaItemsForm(): void{

    this.pizzaitem = {

      'pizzaid': null,

      'pizzaname':  null,

      'pizzaprice':  null,

      'pizzatype': null,

     

      'pizzastores' :{

        'storeid': null,

        'password':'no',
        'storename': null,
        'city': null,
        'state': null,
        'manager_name': null

      }
   };

  }


  
  savePizzaItems(): void{

    this.pizzaitem = {
      'pizzaid': this.pizzaitem.pizzaid,
      'pizzaname': this.pizzaitem.pizzaname,
      'pizzaprice': this.pizzaitem.pizzaprice,
      'pizzatype': this.pizzaitem.pizzatype,
      'pizzastores': {
       'storeid': localStorage.getItem('storeid'),
        'storename': 'no',
        'city': 'no',
        'state': 'no',
        'password': 'no',
        'manager_name':'no'
      }
    };
  
if(this.pizzaitem.pizzaid==null){
  console.log(this.pizzaitem.pizzaname|| 'add method');
  this._pizzastoreService.addPizzaItems(this.pizzaitem);

  console.log(this.pizzaitem);

  this.pizzaItemsForm();}

  else{
console.log('update called');

this._pizzastoreService.editPizzaItems(this.pizzaitem);

console.log(this.pizzaitem);

this.pizzaItemsForm();

}

}


}

