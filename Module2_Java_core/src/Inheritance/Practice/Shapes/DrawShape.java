package Inheritance.Practice.Shapes;

public class DrawShape {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.toString());

        Square square = new Square();
        square.setSide(3);
        System.out.println(square.toString());
        System.out.println("Square area: " + square.getArea(3,3));

    }
}
