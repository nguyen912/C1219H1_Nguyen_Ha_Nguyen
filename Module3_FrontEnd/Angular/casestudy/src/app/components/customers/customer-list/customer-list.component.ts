import { Component, OnInit } from '@angular/core';
import {Customer} from "../../../models/customer";
import {CustomerService} from "../../../shared/customer.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[];

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
    this.getCustomers();
  }

  getCustomers() {
    this.customerService.getCustomers().subscribe(data => {
      this.customers = data;
    })
  }

}
