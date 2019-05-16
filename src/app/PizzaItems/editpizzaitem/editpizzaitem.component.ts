import { Component, OnInit } from '@angular/core';
import { Router } from '../../../../node_modules/@angular/router';
import { PizzastoreService } from '../../pizzastore.service';
import { PizzaItems } from '../../pizza-items';


@Component({
  selector: 'app-editpizzaitem',
  templateUrl: './editpizzaitem.component.html',
  styleUrls: ['./editpizzaitem.component.css']
})
export class EditpizzaitemComponent implements OnInit {
  pizzaitem: PizzaItems=new PizzaItems();
  error ='invalid';

  

  constructor(private router: Router,private _pizzastoreService: PizzastoreService) { }

  ngOnInit() {
  }
  savePizzaItems(): void{
    console.log(this.pizzaitem.pizzaid);
  }

}


