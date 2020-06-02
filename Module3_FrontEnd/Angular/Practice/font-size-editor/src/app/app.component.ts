import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  fontSize = 14;

  onChange(value) {
    this.fontSize = value;
  }

  constructor() {
  }

}
