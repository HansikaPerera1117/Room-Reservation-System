package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Booking;
import model.Maintenance;
import view.tm.BookingTM;

import java.io.IOException;
import java.util.Optional;



public class BookingFormController {
    public AnchorPane bookingContext;
    public JFXComboBox<String> cmbRoomNo;
    public JFXComboBox<String> cmbMealPlan;
    public JFXTextField txtEmail;
    public JFXTextField txtDuration;
    public JFXTextField txtCustomerName;
    public JFXTextField txtNIC;
    public JFXTextField txtAddress;
    public JFXTextField txtTelNo;
    public TableView<BookingTM> tblBooking;
    public TableColumn colCustomerName;
    public TableColumn colNIC;
    public TableColumn colAddress;
    public TableColumn colTelNo;
    public TableColumn colEmail;
    public TableColumn colRooNo;
    public TableColumn colMealPlan;
    public TableColumn colDuration;
    public TableColumn colOption;
    public JFXButton btnSave;
    public JFXTextField txtSelectedRoomNo;
    public JFXTextField txtSelectedMealPlan;

    public void initialize(){
        ObservableList<String> obList = FXCollections.observableArrayList();
            obList.add("Room No 01");
            obList.add("Room No 02");
            obList.add("Room No 03");
            obList.add("Room No 04");
            obList.add("Room No 05");
            obList.add("Room No 06");
            obList.add("Room No 07");
            obList.add("Room No 08");
            obList.add("Room No 09");
            obList.add("Room No 10");
            obList.add("Room No 11");
            obList.add("Room No 12");
            obList.add("Room No 13");
            obList.add("Room No 14");
            obList.add("Room No 15");
            obList.add("Room No 16");
            obList.add("Room No 17");
            obList.add("Room No 18");
            obList.add("Room No 19");
            obList.add("Room No 20");
            obList.add("Room No 21");

       //==============================not work============================

        for (Maintenance m:Database.maintenanceTable
        ) {
            String temp1="";
            for (String ob:obList
            ) {
                if (m.getRoomNo().equals(ob)){
                    temp1=ob;
                }
            }
            obList.remove(temp1);
        }


        //==============================================================

        for (Booking b:Database.bookingTable
             ) {
            String temp="";
            for (String ob:obList
                 ) {
                if (b.getRoomNo().equals(ob)){
                     temp=ob;
                }
            }
            obList.remove(temp);
        }



        cmbRoomNo.setItems(obList);

        cmbRoomNo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtSelectedRoomNo.setText(newValue);
        });

        ObservableList<String> obList1 = FXCollections.observableArrayList();
        obList1.add("Local Meals");
        obList1.add("Chinese Meals");
        obList1.add("French Meals");
        cmbMealPlan.setItems(obList1);

        cmbMealPlan.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtSelectedMealPlan.setText(newValue);
        });

        colCustomerName.setCellValueFactory(new PropertyValueFactory("customerName"));
        colNIC.setCellValueFactory(new PropertyValueFactory("NIC"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colTelNo.setCellValueFactory(new PropertyValueFactory("telNo"));
        colEmail.setCellValueFactory(new PropertyValueFactory("email"));
        colRooNo.setCellValueFactory(new PropertyValueFactory("roomNo"));
        colMealPlan.setCellValueFactory(new PropertyValueFactory("mealPlan"));
        colDuration.setCellValueFactory(new PropertyValueFactory("duration"));
        colOption.setCellValueFactory(new PropertyValueFactory("btn"));

        loadAllBookings();

        tblBooking.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setData(newValue);
            }
        });
        
    }

    private void setData(BookingTM tm) {
        btnSave.setText("Update Reservation");
        txtCustomerName.setText(tm.getCustomerName());
        txtNIC.setText(tm.getNIC());
        txtAddress.setText(tm.getAddress());
        txtTelNo.setText(tm.getTelNo());
        txtEmail.setText(tm.getEmail());
        txtSelectedRoomNo.setText(tm.getRoomNo());
        txtSelectedMealPlan.setText(tm.getMealPlan());
        txtDuration.setText(tm.getDuration());
    }

    private void loadAllBookings() {
        ObservableList<BookingTM> obList = FXCollections.observableArrayList();
        for (Booking bo: Database.bookingTable
        ) {
            Button btn = new Button("Delete");
            BookingTM tm = new BookingTM(bo.getCustomerName(),bo.getNIC(),bo.getAddress(),bo.getTelNo(),bo.getEmail(),bo.getRoomNo(),bo.getMealPlan(),bo.getDuration(),btn);
            obList.add(tm);

            btn.setOnAction((e)->{

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure?", ButtonType.YES,ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();

                if (buttonType.get().equals(ButtonType.YES)){
                    Database.bookingTable.remove(bo);
                    obList.remove(tm);
                }

            });
        }
        tblBooking.setItems(obList);
    }

    public void backToMainOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) bookingContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/mainForm.fxml"))));
        stage.centerOnScreen();

    }

    public void openTokenOnAction(ActionEvent actionEvent) throws IOException {

        if (btnSave.getText().equals("Save Reservation")){
            Booking b1=new Booking(txtCustomerName.getText(),txtNIC.getText(),txtAddress.getText(),txtTelNo.getText(),txtEmail.getText(),txtSelectedRoomNo.getText(),txtSelectedMealPlan.getText(),txtDuration.getText());
            Database.bookingTable.add(b1);
            loadAllBookings();

        }else{
            for (Booking tm:Database.bookingTable
            ) {
                if (tm.getCustomerName().equals(txtCustomerName.getText())){
                    tm.setNIC(txtNIC.getText());
                    tm.setAddress(txtAddress.getText());
                    tm.setTelNo(txtTelNo.getText());
                    tm.setEmail(txtEmail.getText());
                    tm.setRoomNo(txtSelectedRoomNo.getText());
                    tm.setMealPlan(txtSelectedMealPlan.getText());
                    tm.setDuration(txtDuration.getText());
                    loadAllBookings();
                    return;
                }
            }
        }

        setUi("TokenForm");
        for (Booking b:Database.bookingTable
             ) {


        }
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) bookingContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }

    public void btnNewReservation(ActionEvent actionEvent) {
        btnSave.setText("Save Reservation");
        txtCustomerName.setText("");
        txtNIC.setText("");
        txtAddress.setText("");
        txtTelNo.setText("");
        txtEmail.setText("");
        txtSelectedRoomNo.setText("");
        txtSelectedMealPlan.setText("");
        txtDuration.setText("");
    }
}
