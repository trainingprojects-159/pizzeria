import { Component, OnInit, Input } from '@angular/core';

import { PizzastoreService } from '../../pizzastore.service';
import { Router } from '../../../../node_modules/@angular/router';
import { PizzaItems } from '../../pizza-items';

@Component({
  selector: 'app-pizzaitems-details',
  templateUrl: './pizzaitems-details.component.html',
  styleUrls: ['./pizzaitems-details.component.css']
})
export class PizzaitemsDetailsComponent implements OnInit {
pizzaitems: PizzaItems[];

  constructor(private _pizzaStoreService: PizzastoreService,private router: Router) { }
  ngOnInit(){

    this._pizzaStoreService.getAllPizzaItems().then(pizzaitems => this.pizzaitems=pizzaitems);

  }

  // editPizzaItems(pizzaid: string): void{
  //   this._pizzaStoreService.editPizzaItems(pizzaid);
  // }

  deletePizzaItems(pizzaid: string): void{
   this._pizzaStoreService.deletePizzaItems(pizzaid);
 }

}
