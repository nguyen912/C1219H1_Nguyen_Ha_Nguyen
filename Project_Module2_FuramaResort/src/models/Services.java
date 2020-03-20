package models;

public abstract class Services {
    private String id;
    private String name;
    private double usedArea;
    private int cost;
    private int maxPeople;
    private String type;

    public Services() {
    }

    public Services(String id, String name, double usedArea, int cost, int maxPerson, String rentedType) {
        this.id = id;
        this.name = name;
        this.usedArea = usedArea;
        this.cost = cost;
        this.maxPeople = maxPerson;
        this.type = rentedType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract String showInfo();
}