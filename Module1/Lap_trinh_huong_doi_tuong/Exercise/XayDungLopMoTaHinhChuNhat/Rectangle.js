let Rectangle = function (length,width) {
    this.length = length;
    this.width = width;
    this.getLength = function () {
        return this.length;
    }
    this.getWidth = function () {
        return this.width;
    }
    this.setLength = function (length) {
        this.length = length;
    }
    this.setWidth = function (width) {
        this.width = width;
    }
    this.getPerimeter = function () {
        return 2 * (this.length + this.width);
    }
    this.getArea = function () {
        return this.length * this.width;
    }
}

function createRectangle () {
    let c = document.getElementById('canvas').getContext("2d");
    let rectangle = new Rectangle(400,200);
    c.fillStyle = "#FF0000";
    c.fillRect(0,0,rectangle.width,rectangle.length);
    rectangle.setLength(600);
    rectangle.setWidth(300);
    let perimeter1 = rectangle.getPerimeter();
    let area1 = rectangle.getArea();
    alert("Hinh chu nhat co: chieu dai = " + rectangle.getLength() + " - chieu rong = " + rectangle.getWidth() +
        " - chu vi = " + perimeter1 + " - dien tich = " + area1);
}
createRectangle();