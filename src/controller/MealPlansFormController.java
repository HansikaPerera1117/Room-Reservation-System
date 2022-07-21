package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MealPlansFormController {
    public AnchorPane mealPlansContext;

    public void backToMainOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) mealPlansContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/mainForm.fxml"))));
        stage.centerOnScreen();
    }

    public void openLocalMealPlansOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("LocalMealPlansForm");
    }

    public void openChineseMealPlansOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("ChineseMealPlansForm");
    }

    public void openFrenchMealPlansOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("FrenchMealPlansForm");
    }
    private void setUi(String location) throws IOException {
        Stage stage = (Stage) mealPlansContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
