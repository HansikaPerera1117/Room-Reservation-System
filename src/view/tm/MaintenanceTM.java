package view.tm;

import javafx.scene.control.Button;

public class MaintenanceTM {
     private String roomNo;
     private String maintenance;
     private Button btn;

    public MaintenanceTM() {
    }

    public MaintenanceTM(String roomNo, String maintenance, Button btn) {
        this.roomNo = roomNo;
        this.maintenance = maintenance;
        this.btn = btn;
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "MaintenanceTM{" +
                "roomNo='" + roomNo + '\'' +
                ", maintenance='" + maintenance + '\'' +
                ", btn=" + btn +
                '}';
    }
}
