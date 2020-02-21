package Inheritance.Exercise.CircleAndCylinder;

import Inheritance.Practice.Shapes.Circle;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {

    }

    public Cylinder(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(double height) {
        return height * super.getArea(super.getRadius());
    }

    @Override
    public String toString() {
        return "The Cylinder with volume = " + getVolume(height) +
                ", which is a subclass of " + super.toString();
    }
}
