import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomersComponent} from './customers/customers.component';
import {combineAll} from 'rxjs/operators';
import {EmployeesComponent} from './employees/employees.component';
import {ServicesComponent} from './services/services.component';
import {ContractComponent} from './contracts/contract.component';
import {HomeComponent} from './home/home.component';


const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'customers', component: CustomersComponent},
  {path: 'employees', component: EmployeesComponent},
  {path: 'services', component: ServicesComponent},
  {path: 'contracts', component: ContractComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
