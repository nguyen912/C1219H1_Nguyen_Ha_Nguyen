package ClassAndObjectInJava.Exercise.QuadraticEquation;

public class QuadraticEquation {
    private double a,b,c;

    public QuadraticEquation() {

    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() {
        return Math.pow(this.b,2) - 4 * this.a * this.c;
    }

    public double setRoot1() {
        double r1 = (-this.b + Math.sqrt(Math.pow(this.b,2) - 4 * this.a * this.c)) / (2 * this.a);
        if (this.getDiscriminant() >= 0) {
            return r1;
        }
        else {
            return 0;
        }

    }

    public double setRoot2() {
        double r2 = (-this.b - Math.sqrt(Math.pow(this.b,2) - 4 * this.a * this.c)) / (2 * this.a);
        if (this.getDiscriminant() >= 0) {
            return r2;
        }
        else {
            return 0;
        }
    }

    @Override
    public String toString() {
        if (this.getDiscriminant() > 0) {
            return "The equation has 2 roots: r1 = " + this.setRoot1() + ", r2 = " + this.setRoot2();
        }
        else if (this.getDiscriminant()== 0) {
            return "The equation have only 1 root: r = " + this.setRoot1();
        }
        else {
            return "The equation has no roots";
        }
    }
}
