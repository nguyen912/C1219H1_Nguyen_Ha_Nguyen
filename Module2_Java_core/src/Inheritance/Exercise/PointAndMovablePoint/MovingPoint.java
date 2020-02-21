package Inheritance.Exercise.PointAndMovablePoint;

public class MovingPoint {
    public static void main(String[] args) {
        Point point = new MovablePoint();
        ((Point)point).setXY(50,50);
        ((MovablePoint)point).setSpeed(30,10);
        System.out.println(point.toString());

        System.out.print("speed = ");
        for (float i : ((MovablePoint) point).move()) {
            System.out.print(i + " ");
        }
    }
}
