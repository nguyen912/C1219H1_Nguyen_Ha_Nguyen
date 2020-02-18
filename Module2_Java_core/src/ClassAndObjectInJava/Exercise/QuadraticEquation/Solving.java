package ClassAndObjectInJava.Exercise.QuadraticEquation;

public class Solving {
    public static void main(String[] args) {
        QuadraticEquation equation1 = new QuadraticEquation(1,2,3);
        System.out.println(equation1.toString());

        QuadraticEquation equation2 = new QuadraticEquation();
        equation2.setA(1);
        equation2.setB(2);
        equation2.setC(1);
        System.out.println(equation2.toString());
    }
}
