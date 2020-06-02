import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  background = '#00e067';
  constructor() { }

  onChange(value) {
    this.background = value;
  }
}
