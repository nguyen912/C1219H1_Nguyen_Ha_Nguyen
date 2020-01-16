let Circle = function (radius) {
    this.radius = radius;
    this.getRadius = function () {
        return this.radius;
    }
    this.getArea = function (radius) {
        return Math.PI * Math.pow(this.radius,2);
    }
}
let circle = new Circle(2);
let radius = circle.getRadius();
let area = circle.getArea(radius);
alert('radius: ' + radius + ', area: ' + area);