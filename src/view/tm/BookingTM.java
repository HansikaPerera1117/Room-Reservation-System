package view.tm;

import javafx.scene.control.Button;

public class BookingTM {
     private String customerName;
     private String NIC;
     private String address;
     private String telNo;
     private String email;
     private String roomNo;
     private String mealPlan;
     private String duration;
     private Button btn;

    public BookingTM() {
    }

    public BookingTM(String customerName, String NIC, String address, String telNo, String email, String roomNo, String mealPlan, String duration, Button btn) {
        this.customerName = customerName;
        this.NIC = NIC;
        this.address = address;
        this.telNo = telNo;
        this.email = email;
        this.roomNo = roomNo;
        this.mealPlan = mealPlan;
        this.duration = duration;
        this.btn = btn;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(String mealPlan) {
        this.mealPlan = mealPlan;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "BookingTM{" +
                "customerName='" + customerName + '\'' +
                ", NIC='" + NIC + '\'' +
                ", address='" + address + '\'' +
                ", telNo='" + telNo + '\'' +
                ", email='" + email + '\'' +
                ", roomNo='" + roomNo + '\'' +
                ", mealPlan='" + mealPlan + '\'' +
                ", duration='" + duration + '\'' +
                ", btn=" + btn +
                '}';
    }
}
