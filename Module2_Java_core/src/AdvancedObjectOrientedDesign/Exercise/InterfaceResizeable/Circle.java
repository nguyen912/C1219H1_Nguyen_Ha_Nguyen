package AdvancedObjectOrientedDesign.Exercise.InterfaceResizeable;

public class Circle extends Shape {
    private double radius = 1;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(double radius) {
        return (Math.PI * Math.pow(radius,2));
    }

    public double getPerimeter(double radius) {
        return (2 * Math.PI * radius);
    }

    @Override
    public String toString() {
        return "A Circle with radius=" + radius + ", area = " + getArea(getRadius());
    }

    @Override
    public void resize(double percent) {
        setRadius(getRadius() + getRadius() * percent / 100);
    }
}
