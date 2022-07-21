package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RoomsFormController {
    public AnchorPane roomsContext;

    public void backToMainOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) roomsContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/mainForm.fxml"))));
        stage.centerOnScreen();
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) roomsContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }

    public void openSingleRoomOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("SingleRoomForm");
    }

    public void openDoubleRoomOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("DoubleRoomForm");
    }

    public void openTripleRoomOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("TripleRoomForm");
    }

    public void openQuadRoomOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("QuadRoomForm");
    }
}
