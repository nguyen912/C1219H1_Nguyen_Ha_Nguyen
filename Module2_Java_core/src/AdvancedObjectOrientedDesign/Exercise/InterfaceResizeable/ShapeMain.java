package AdvancedObjectOrientedDesign.Exercise.InterfaceResizeable;

public class ShapeMain {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(50);
        shapes[1] = new Rectangle(50,100);
        shapes[2] = new Square(60);

        for (Shape shape : shapes) {
            System.out.println(shape);
        }
        for (Shape shape : shapes) {
            shape.resize(50);
        }

        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}
