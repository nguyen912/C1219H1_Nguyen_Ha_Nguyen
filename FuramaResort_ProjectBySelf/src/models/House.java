package models;

public class House extends Services {
    private String standard;
    private String otherComfortDescription;
    private int numberOfFloors;

    public House() {

    }

    public House(String standard, String otherComfortDescription, int numberOfFloors) {
        this.standard = standard;
        this.otherComfortDescription = otherComfortDescription;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String serviceId, String serviceName, double usableArea, int rentalCost, int maxPeople, String typeOfRent, String standard, String otherComfortDescription, int numberOfFloors) {
        super(serviceId, serviceName, usableArea, rentalCost, maxPeople, typeOfRent);
        this.standard = standard;
        this.otherComfortDescription = otherComfortDescription;
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
                "numberOfFloors=" + numberOfFloors + "\n";
    }
}
