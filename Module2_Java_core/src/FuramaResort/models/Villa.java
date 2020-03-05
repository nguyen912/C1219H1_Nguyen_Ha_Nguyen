package FuramaResort.models;

public class Villa extends Services {
    private String standard;
    private String otherFacility;
    private double poolArea;
    private int floor;

    public Villa() {
    }

    public Villa(String id, String serviceName, double usedArea, int cost, int maxPerson,
                 String rentedType, String standard, String otherFacility, double poolArea,
                 int floor) {
        super(id, serviceName, usedArea, cost, maxPerson, rentedType);
        this.standard = standard;
        this.otherFacility = otherFacility;
        this.poolArea = poolArea;
        this.floor = floor;
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

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public void showInfo() {
        System.out.println(
                "Villa information: " +
                        "\n1. ID: " + getId() +
                        "\n2. Service name: " + getServiceName() +
                        "\n3. Used area: " + getUsedArea() +
                        "\n4. Cost: " + getCost() +
                        "\n5. Max person: " + getMaxPerson() +
                        "\n6. Rented type: " + getRentedType() +
                        "\n7. Standard: " + getStandard() +
                        "\n8. Other Facility: " + getOtherFacility() +
                        "\n9. Pool area: " + getPoolArea() +
                        "\n10. The number of floors: " + getFloor()
        );
    }
}
