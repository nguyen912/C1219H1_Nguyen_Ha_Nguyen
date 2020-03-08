package FuramaResort.models;

public class House extends Services {
    private String roomStandard;
    private String otherFacility;
    private int floor;

    public House() {
    }

    public House(String id, String serviceName, double usedArea, int cost, int maxPerson, String rentedType, String roomStandard, String otherFacility, int floor) {
        super(id, serviceName, usedArea, cost, maxPerson, rentedType);
        this.roomStandard = roomStandard;
        this.otherFacility = otherFacility;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
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

    @Override
    public String showInfo() {
        return
            "House information: " +
                "\n1. ID: " +
                "\n2. Service name: " +
                "\n3. Used area: " +
                "\n4. Cost: " +
                "\n5. Max person: " +
                "\n6. Rented type: " +
                "\n7. Standard: " +
                "\n8. Other Facility: " +
                "\n9. The number of floors: "
        ;

    }
}
