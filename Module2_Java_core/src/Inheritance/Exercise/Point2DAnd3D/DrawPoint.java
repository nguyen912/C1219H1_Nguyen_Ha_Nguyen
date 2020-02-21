package Inheritance.Exercise.Point2DAnd3D;

public class DrawPoint {
    public static void main(String[] args) {
        Point2D _3d = new Point3D();
        ((Point3D) _3d).setXYZ(3,4,5);
        System.out.println(_3d.toString());

        Point2D _2d = new Point2D();
        _2d.setX(5);
        System.out.println(_2d.toString());
    }
}
