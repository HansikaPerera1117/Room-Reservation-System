package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField pwdPassword;
    public AnchorPane loginContext;

    int attempts = 0;

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        attempts++;
        if (attempts<=3){
            if (txtUserName.getText().equals("Hansika") && pwdPassword.getText().equals("123")){
                new Alert(Alert.AlertType.CONFIRMATION, "Success!").show();
                setUi("mainForm");
            }else{
                new Alert(Alert.AlertType.WARNING,"Try Again!").show();
            }

        }else{
            txtUserName.setEditable(false);
            pwdPassword.setEditable(false);

        }

    }
    private void setUi(String location) throws IOException {
        Stage stage = (Stage) loginContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
