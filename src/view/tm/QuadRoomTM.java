package view.tm;

import javafx.scene.control.Button;

public class QuadRoomTM {
     private String roomNo;
     private String furniture;
     private String maintenance;
     private String availability;
     private Button btn;

    public QuadRoomTM() {
    }

    public QuadRoomTM(String roomNo, String furniture, String maintenance, String availability, Button btn) {
        this.roomNo = roomNo;
        this.furniture = furniture;
        this.maintenance = maintenance;
        this.availability = availability;
        this.btn = btn;
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "QuadRoomTM{" +
                "roomNo='" + roomNo + '\'' +
                ", furniture='" + furniture + '\'' +
                ", maintenance='" + maintenance + '\'' +
                ", availability='" + availability + '\'' +
                ", btn=" + btn +
                '}';
    }
}
