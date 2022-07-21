package model;

public class SingleRoom {
    private String roomNo;
    private String furniture;
    private String maintenance;
    private String availability;

    public SingleRoom() {
    }

    public SingleRoom(String roomNo, String furniture, String maintenance, String availability) {
        this.roomNo = roomNo;
        this.furniture = furniture;
        this.maintenance = maintenance;
        this.availability = availability;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getFurniture() {
        return furniture;
    }

    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "SingleRoom{" +
                "roomNo='" + roomNo + '\'' +
                ", furniture='" + furniture + '\'' +
                ", maintenance='" + maintenance + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }
}
