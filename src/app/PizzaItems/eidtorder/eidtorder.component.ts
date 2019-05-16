import { Component, OnInit } from '@angular/core';
import { Orders } from '../../orders';
import { PizzastoreService } from '../../pizzastore.service';

@Component({
  selector: 'app-eidtorder',
  templateUrl: './eidtorder.component.html',
  styleUrls: ['./eidtorder.component.css']
})
export class EidtorderComponent implements OnInit {
  orders:Orders=new Orders();
  error ='invalid';
  constructor(private _pizzastoreService: PizzastoreService) { }
  ngOnInit() {
  }
  saveOrder()
  {
    console.log(this.orders.orderid);
  }
}
