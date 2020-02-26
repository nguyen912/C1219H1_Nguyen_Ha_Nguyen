package AdvancedObjectOrientedDesign.Exercise.InterfaceResizeable;

public class Rectangle extends Shape {
    private double width = 1;
    private double length = 1;

    public Rectangle() {

    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea(double width, double length) {
        return width * length;
    }

    public  double getPerimeter(double width, double length) {
        return (2 * (width + length));
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + width + " and length="
                + length + ", area = "
                + getArea(getWidth(),getLength());
    }

    @Override
    public void resize(double percent) {
        setLength(getLength() + getLength() * percent / 100);
        setWidth(getWidth() + getWidth() * percent / 100);
    }
}
