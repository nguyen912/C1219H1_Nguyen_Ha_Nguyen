import { Component } from '@angular/core';
import {Car} from './car';
import {TransportationService} from './transportation.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  // prefix = 'I am a ';
  // name = 'star student';
  //
  // colors: string[] = ['red', 'blue', 'green', 'purple'];
  //
  // fruits: string[] = ['apple', 'orange', 'pear', 'peach'];
  //
  // speak() {
  //   const sentence = this.prefix + this.name;
  //   return sentence;
  // }

  // subaru: Car = {make: 'Subaru', model: 'Outback', miles: 58232};
  // honda: Car = {make: 'Honda', model: 'Accord', miles: 39393};
  // bmw: Car = {make: 'BMW', model: 'X3', miles: 4400};
  //
  // cars: Car[] = [this.subaru, this.honda, this.bmw];
  //
  // cars: Car[];
  //
  // constructor(private transportationService: TransportationService) {
  //   this.cars = this.transportationService.getCars();
  // }

  // constructor() {}
  //
  // counter = 0;
  //
  // increment() {
  //   this.counter++;
  // }

  // constructor() {}
  //
  // phrase = 'It\'s going';
  //
  // update() {
  //   this.phrase += ' ..and going';
  // }

  cars: Car[];
  make: string;
  model: string;
  miles: number;

  constructor(private transportationService: TransportationService) {
    this.cars = this.transportationService.getCars();
  }

  addCar(){
    const newCar: Car = {make: this.make, model: this.model, miles: this.miles };
    this.transportationService.addCar(newCar);
  }
}

