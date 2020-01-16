let Temperature = function (valuePerC) {
    this.valuePerC = valuePerC;
    this.getValuePerC = function () {
        return this.valuePerC;
    }
    this.setValuePerC = function (valuePerC) {
        this.valuePerC = valuePerC;
    }
    this.changeCToF = function () {
        return this.valuePerC * 1.8 + 32;
    }
    this.changeCToKevin = function () {
        return this.valuePerC + 273.15;
    }
}

let temperature = new Temperature();
temperature.setValuePerC(25);
alert("C to F: " + temperature.changeCToF() + " - C to K: " + temperature.changeCToKevin());