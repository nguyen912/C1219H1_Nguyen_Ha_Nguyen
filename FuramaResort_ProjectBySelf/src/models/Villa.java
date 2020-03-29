package models;

public class Villa extends Services {
    private String standard;
    private String otherComfortDescription;
    private double poolArea;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String standard, String otherComfortDescription, double poolArea, int numberOfFloors) {
        this.standard = standard;
        this.otherComfortDescription = otherComfortDescription;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(String serviceId, String serviceName, double usableArea, int rentalCost, int maxPeople, String typeOfRent, String standard, String otherComfortDescription, double poolArea, int numberOfFloors) {
        super(serviceId, serviceName, usableArea, rentalCost, maxPeople, typeOfRent);
        this.standard = standard;
        this.otherComfortDescription = otherComfortDescription;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getOtherComfortDescription() {
        return otherComfortDescription;
    }

    public void setOtherComfortDescription(String otherComfortDescription) {
        this.otherComfortDescription = otherComfortDescription;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String showInfo() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString() +
                "standard=" + standard + "\n" +
                "otherComfortDescription='" + otherComfortDescription + "\n" +
                "poolArea=" + poolArea + "\n" +
                "numberOfFloors=" + numberOfFloors + "\n";
    }
}
