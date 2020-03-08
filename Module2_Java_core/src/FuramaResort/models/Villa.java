package FuramaResort.models;

public class Villa extends House {
    private double poolArea;

    public Villa() {
    }

    public Villa(String id, String serviceName, double usedArea, int cost, int maxPerson, String rentedType, String roomStandard, String otherFacility, int floor, double poolArea) {
        super(id, serviceName, usedArea, cost, maxPerson, rentedType, roomStandard, otherFacility, floor);
        this.poolArea = poolArea;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    @Override
    public String showInfo() {
        return super.showInfo() + "\n10. The area of swimming pool: " + getPoolArea();
    }
}
