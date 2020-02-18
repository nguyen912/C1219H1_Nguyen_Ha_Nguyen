package ProjectModule2_NguyenHaNguyen.models;

public class Services {
    private String id;
    private String serviceName;
    private double usedArea;
    private int cost;
    private int maxPerson;
    private String rentedType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsedArea() {
        return usedArea;
    }

    public void setUsedArea(double usedArea) {
        this.usedArea = usedArea;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public String getRentedType() {
        return rentedType;
    }

    public void setRentedType(String rentedType) {
        this.rentedType = rentedType;
    }
}
