package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ReportsFormController {
    public AnchorPane reportsContext;

    public void backToMainOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) reportsContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/mainForm.fxml"))));
        stage.centerOnScreen();

    }

    public void openMonthlyReportOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("MonthlyReportsForm");
    }

    public void openAnnuallyReportOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("AnnuallyReportsForm");
    }
    private void setUi(String location) throws IOException {
        Stage stage = (Stage) reportsContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
