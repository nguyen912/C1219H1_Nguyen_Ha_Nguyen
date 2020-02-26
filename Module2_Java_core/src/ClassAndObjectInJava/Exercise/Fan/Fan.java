package ClassAndObjectInJava.Exercise.Fan;

public class Fan {
    final private int slow = 1;
    final private int medium = 2;
    final private int fast = 3;
    private int speed = slow;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public int getSlow() {
        return slow;
    }

    public int getMedium() {
        return medium;
    }

    public int getFast() {
        return fast;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = true;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Fan() {

    }

    public String toString() {
        if (this.on) {
            return "Fan is on{" +
                    "speed=" + speed +
                    ", radius=" + radius +
                    ", color='" + color +
                    "}";
        }
        else {
            return "Fan is off{" +
                    "radius=" + radius +
                    ", color='" + color +
                    '}';
        }

    }
}
