package model;

public class Maintenance {
    private String roomNo;
    private String maintenance;

    public Maintenance() {
    }

    public Maintenance(String roomNo, String maintenance) {
        this.roomNo = roomNo;
        this.maintenance = maintenance;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "roomNo='" + roomNo + '\'' +
                ", maintenance='" + maintenance + '\'' +
                '}';
    }
}
