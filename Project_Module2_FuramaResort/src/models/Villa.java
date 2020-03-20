package models;


public class Villa extends Services {
    private String standard;
    private String otherFacility;
    private int floor;
    private double poolArea;

    public Villa() {
    }

    public Villa(String id, String name, double usedArea, int cost, int maxPeople, String type, String standard, String otherFacility, int floor, double poolArea) {
        super(id, name, usedArea, cost, maxPeople, type);
        this.standard = standard;
        this.otherFacility = otherFacility;
        this.floor = floor;
        this.poolArea = poolArea;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getOtherFacility() {
        return otherFacility;
    }

    public void setOtherFacility(String otherFacility) {
        this.otherFacility = otherFacility;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    @Override
    public String showInfo() {
        return getId() + "\t" + getName() + "\t" + getUsedArea() + "\t" +
                getCost() + "\t" + getMaxPeople() + "\t" + getType() + "\t" +
                getStandard() + "\t" + getOtherFacility() + "\t" + getFloor() +
                "\t" + getPoolArea();
    }
}