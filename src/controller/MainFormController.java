package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {
    public AnchorPane mainFormContext;


    public void backToStartOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) mainFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/StartForm.fxml"))));
        stage.centerOnScreen();
    }

    public void openRoomsOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("RoomsForm");
    }
    private void setUi(String location) throws IOException {
        Stage stage = (Stage) mainFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }

    public void openMealPlansOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("MealPlansForm");
    }

    public void openBookingOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("BookingForm");
    }

    public void openMaintenanceOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("MaintenanceForm");
    }

    public void openReportsOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("ReportsForm");
    }

    public void openContactUsOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("ContactUsForm");
    }

    public void openEmailOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("EmailForm");
    }

    public void openAddressOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("AddressForm");
    }
}
