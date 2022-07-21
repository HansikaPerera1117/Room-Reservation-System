package controller;

import com.jfoenix.controls.JFXTextField;
import db.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Booking;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Date;
import java.util.Optional;

public class TokenFormController {
    public AnchorPane tokenContext;
    public JFXTextField txtRoomNo;
    public JFXTextField txtMealPlan;
    public JFXTextField txtDuration;
    public JFXTextField txtCustomerName;
    public JFXTextField txtNIC;
    public JFXTextField txtTelNo;
    public JFXTextField txtReceptionist;
    public JFXTextField txtDate;
    public JFXTextField txtTime;
    private Object Date;

    public void initialize(){
        for (Booking b:Database.bookingTable
             ) {
            txtCustomerName.setText(b.getCustomerName());
            txtNIC.setText(b.getNIC());
            txtTelNo.setText(b.getTelNo());
            txtRoomNo.setText(b.getRoomNo());
            txtMealPlan.setText(b.getMealPlan());
            txtDuration.setText(b.getDuration());
        }
    }



    public void btnPrintOnAction(ActionEvent actionEvent) throws IOException {

        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Token is printing.\n" +
                "Please wait a few Seconds for printout.....", ButtonType.OK);

        Optional<ButtonType> buttonType = alert.showAndWait();

        if (buttonType.get().equals(ButtonType.OK)){

            Stage stage = (Stage) tokenContext.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/BookingForm.fxml."))));
            stage.centerOnScreen();

            }

    }

    public void btnEmailOnAction(ActionEvent actionEvent) throws IOException {
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION,"Mailed Successfully\n" +
                "Token Mailed to the Customer", ButtonType.OK);

        Optional<ButtonType> buttonType = alert2.showAndWait();

        if (buttonType.get().equals(ButtonType.OK)){

            Stage stage = (Stage) tokenContext.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/BookingForm.fxml."))));
            stage.centerOnScreen();

        }

    }
}
