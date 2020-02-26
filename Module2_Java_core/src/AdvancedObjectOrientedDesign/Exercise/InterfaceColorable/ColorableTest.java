package AdvancedObjectOrientedDesign.Exercise.InterfaceColorable;

public class ColorableTest {
    public static void main(String[] args) {
        Square[] squares = new Square[3];
        squares[0] = new Square(50);
        squares[1] = new Square(40);
        squares[2] = new Square(100);

        for (Square square : squares) {
            System.out.println(square.getArea());
            square.howToColor();
        }
    }
}