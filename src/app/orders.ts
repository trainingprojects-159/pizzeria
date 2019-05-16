import { Shoppingcart } from "./shoppingcart";
import { PizzaStore } from "./pizza-store";
import { PizzaItems } from "./pizza-items";
import { Customer } from "./customer";

export class Orders {

orderid: string;
order_cost: number;
status: string;

shoppingcart: Shoppingcart;
pizzastore: PizzaStore;
pizzaitems: PizzaItems;
customer: Customer;
}
