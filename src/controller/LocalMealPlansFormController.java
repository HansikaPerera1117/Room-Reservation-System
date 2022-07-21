package controller;

import com.jfoenix.controls.JFXButton;
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
import model.LocalMealPlan;
import view.tm.LocalMealPlanTM;

import java.io.IOException;
import java.util.Optional;

public class LocalMealPlansFormController {
    public AnchorPane localMealPlansContext;
    public TableView<LocalMealPlanTM> tblLocalMealPlan;
    public TableColumn colMealNo;
    public TableColumn colMealName;
    public TableColumn colPrice;
    public TableColumn colOption;
    public JFXTextField txtMealNo;
    public JFXTextField txtMealName;
    public JFXTextField txtPrice;
    public JFXButton btnSave;

    public void initialize(){
        colMealNo.setCellValueFactory(new PropertyValueFactory("mealNo"));
        colMealName.setCellValueFactory(new PropertyValueFactory("mealName"));
        colPrice.setCellValueFactory(new PropertyValueFactory("priceOfOnePotion"));
        colOption.setCellValueFactory(new PropertyValueFactory("btn"));

        loadAllLocalMeal();

        tblLocalMealPlan.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setData(newValue);
            }
        });
    }

    private void setData(LocalMealPlanTM tm) {
        btnSave.setText("Update Meal");
        txtMealNo.setText(tm.getMealNo());
        txtMealName.setText(tm.getMealName());
        txtPrice.setText(String.valueOf(tm.getPriceOfOnePotion()));
    }

    private void loadAllLocalMeal() {
        ObservableList<LocalMealPlanTM> obList = FXCollections.observableArrayList();
        for (LocalMealPlan lm: Database.localMealPlanTable
        ) {
            Button btn = new Button("Delete");
            LocalMealPlanTM tm = new LocalMealPlanTM(lm.getMealNo(),lm.getMealName(),lm.getPriceOfOnePotion(),btn);
            obList.add(tm);

            btn.setOnAction((e)->{

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure?", ButtonType.YES,ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();

                if (buttonType.get().equals(ButtonType.YES)){
                    Database.localMealPlanTable.remove(lm);
                    obList.remove(tm);
                }

            });
        }
        tblLocalMealPlan.setItems(obList);

    }

    public void backToMealPlansOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) localMealPlansContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MealPlansForm.fxml"))));
        stage.centerOnScreen();

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if (btnSave.getText().equals("Save Meal")){

            LocalMealPlan l1=new LocalMealPlan(txtMealNo.getText(),txtMealName.getText(),Double.parseDouble(txtPrice.getText()));
            Database.localMealPlanTable.add(l1);
            loadAllLocalMeal();

        }else{
            for (LocalMealPlan tm:Database.localMealPlanTable
            ) {
                if (tm.getMealNo().equals(txtMealNo.getText())){
                    tm.setMealName(txtMealName.getText());
                    tm.setPriceOfOnePotion(Double.parseDouble(txtPrice.getText()));
                    loadAllLocalMeal();
                    return;
                }
            }
        }
    }

    public void btnNewMealOnAction(ActionEvent actionEvent) {
        btnSave.setText("Save Meal");
        txtMealNo.setText("");
        txtMealName.setText("");
        txtPrice.setText("");

    }
}
