package Inheritance.Exercise.Triagle;

import Inheritance.Practice.Shapes.Shape;

public class Triangle extends Shape {
    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle() {

    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getPerimeter() {
        double P = side1 + side2 + side3;
        return P;
    }
    public double getArea() {
        double p = getPerimeter()/2;
        double A = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
        return A;
    }

    @Override
    public String toString() {
        return "The triangle side 1 = " + side1 + ", side 2 = " + side2 + ", side 3 = " + side3
                + ", Perimeter = " + getPerimeter() + ", Area = " + getArea()
                + ", color: " + super.getColor();
    }
}
