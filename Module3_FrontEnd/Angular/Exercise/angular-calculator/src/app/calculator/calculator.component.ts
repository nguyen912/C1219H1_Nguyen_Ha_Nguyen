import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  first: number;
  second: number;
  output:number;
  operator = '+';

  constructor() { }

  ngOnInit(): void {
  }

  onFirstChange(value) {
    this.first = Number(value);
  }

  onSecondChange(value) {
    this.second = Number(value);
  }

  onOperatorChange(value) {
    this.operator = value;
  }

  calculator() {
    switch (this.operator) {
      case '+':
        this.output = Number(this.first) + Number(this.second);
        break;
      case '-':
        this.output = this.first - this.second;
        break;
      case '*':
        this.output = this.first * this.second;
        break;
      case '/':
        this.output = this.first / this.second;
        break;
    }
  }
}
