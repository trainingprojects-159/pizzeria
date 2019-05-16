import { Injectable } from '@angular/core';
import { Headers ,Http } from '@angular/http';
import { PizzaItems } from './pizza-items';


@Injectable()
export class PizzastoreService {
 private url='http://localhost:8076/pizza/pizzastore/login'

 private  headers = new Headers({'Content-Type': 'application/json'});
  constructor(private _http: Http) { }
  private handleError(error: any): Promise<any>{
   // console.error('error', error);
    return Promise.reject(error.message || error)
  }
  
  login(storeid: string,pass: string): Promise<boolean>{

    const lurl =`${this.url}/${storeid}/${pass}`;
    return this._http.get(lurl,JSON.stringify({storeid: storeid,pass: pass}))
    .toPromise()
    .then(response => {
     // let pizzastores = response.json() && response.json().pizzastores;
      console.log(response.text());
      if(response.text() === 'true')
      {
        return false;
      }
      else
      {
        return true;
      }
    })
    .catch(this.handleError);
  }
  


  
  //add method
  addPizzaItems(pizzaItems: PizzaItems): Promise<PizzaItems>{
    return this._http.post('http://localhost:8076/pizza/pizzastore/pizzaitems/add',
    JSON.stringify(pizzaItems),
    {headers : this.headers})
    .toPromise()
    .then(res => res.json() as PizzaItems)
    .catch(this.handleError);
  }


//edit method
  editPizzaItems(pizzaItems: PizzaItems): Promise<PizzaItems>{
    return this._http.put('http://localhost:8076/pizza/pizzastore/pizzaitems/${pizzaid}',JSON.stringify(pizzaItems))
    .toPromise()
    .then(res => res.json() as PizzaItems)
    .catch(this.handleError);
  }


  //for get all method
  getAllPizzaItems(): Promise<PizzaItems[]> {
    const lurl= `http://localhost:8076/pizza/pizzastore/pizzaitems`;
    return this._http.get(lurl)
   .toPromise()
    .then(res => res.json() as PizzaItems[])
    .catch(this.handleError);
  }
  
  //get by id
  getById(pizzaid: string): Promise<PizzaItems>{
    const lurl=`http://localhost:8076/pizza/pizzastore/pizzaItems/${pizzaid}`;
    return this._http
    .get(lurl)
    .toPromise()
    .then(res => res.json() as PizzaItems)
    .catch(this.handleError);
  }

  //delete method
  deletePizzaItems(pizzaid: string): Promise<void>{
    const lurl=`http://localhost:8076/pizza/pizzastore/pizzaItems/${pizzaid}`;
    return this._http
    .delete(lurl)
    .toPromise()
    .then(res => res.json() as PizzaItems)
    .catch(this.handleError);
  }
  
}
