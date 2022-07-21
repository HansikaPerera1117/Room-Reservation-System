package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EmailFormController {
    public AnchorPane emailContext;

    public void backToMainOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) emailContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/mainForm.fxml"))));
        stage.centerOnScreen();
    }
}
