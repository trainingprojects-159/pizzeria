import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes} from '@angular/router';
import { PizzastoreService } from './pizzastore.service';
import { AddpizzaitemComponent } from './PizzaItems/addpizzaitem/addpizzaitem.component';
import { EditpizzaitemComponent } from './PizzaItems/editpizzaitem/editpizzaitem.component';
import { DeletepizzaitemComponent } from './PizzaItems/deletepizzaitem/deletepizzaitem.component';
import { GetbyidpizzaitemComponent } from './PizzaItems/getbyidpizzaitem/getbyidpizzaitem.component';
import { EidtorderComponent } from './PizzaItems/eidtorder/eidtorder.component';
import { HeaderComponent } from './PizzaItems/header/header.component';
import { FooterComponent } from './PizzaItems/footer/footer.component';
import { HomecomponentComponent } from './PizzaItems/homecomponent/homecomponent.component';
import { PagenotfoundComponent } from './PizzaItems/pagenotfound/pagenotfound.component';
import { PizzaitemsDetailsComponent } from './PizzaItems/pizzaitems-details/pizzaitems-details.component';
import { LoginComponent } from './login/login.component';




const appRoutes: Routes = [
{path: 'login', component: LoginComponent},
  {path: 'home', component: HomecomponentComponent,
  children: [
   
{path: 'addpizzaitem', component:AddpizzaitemComponent},
{path: 'editpizza/:sid', component:AddpizzaitemComponent},
{path: 'editpizza', component:EditpizzaitemComponent},
  { path: 'pizzaitems-details', component: PizzaitemsDetailsComponent},

  {path: 'eidtorder', component: EidtorderComponent}
]},
{ path: '', redirectTo: '/login' , pathMatch: 'full'},
{path: '**', component: PagenotfoundComponent}
];


@NgModule({
  declarations: [
    AppComponent,
  
    AddpizzaitemComponent,
    EditpizzaitemComponent,
    DeletepizzaitemComponent,
    GetbyidpizzaitemComponent,
    
   
    EidtorderComponent,
    HeaderComponent,
    FooterComponent,
    HomecomponentComponent,
    PagenotfoundComponent,
    PizzaitemsDetailsComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
    
  ],
  providers: [PizzastoreService],
  bootstrap: [AppComponent]
})
export class AppModule { }
