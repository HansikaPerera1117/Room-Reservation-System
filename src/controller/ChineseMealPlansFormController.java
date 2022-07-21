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
import model.ChineseMealPlan;
import view.tm.ChineseMealPlanTM;


import java.io.IOException;
import java.util.Optional;

public class ChineseMealPlansFormController {
    public AnchorPane chineseMealPlansContext;
    public JFXTextField txtMealNo;
    public JFXTextField txtMealName;
    public JFXTextField txtPrice;
    public JFXButton btnSave;
    public TableView<ChineseMealPlanTM> tblChineseMeal;
    public TableColumn colMealNo;
    public TableColumn colMealName;
    public TableColumn colPrice;
    public TableColumn colOption;

    public void initialize(){
        colMealNo.setCellValueFactory(new PropertyValueFactory("mealNo"));
        colMealName.setCellValueFactory(new PropertyValueFactory("mealName"));
        colPrice.setCellValueFactory(new PropertyValueFactory("priceOfOnePotion"));
        colOption.setCellValueFactory(new PropertyValueFactory("btn"));

        loadAllChineseMeal();

        tblChineseMeal.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setData(newValue);
            }
        });

    }

    private void setData(ChineseMealPlanTM tm) {
        btnSave.setText("Update Meal");
        txtMealNo.setText(tm.getMealNo());
        txtMealName.setText(tm.getMealName());
        txtPrice.setText(String.valueOf(tm.getPriceOfOnePotion()));
    }

    private void loadAllChineseMeal() {
        ObservableList<ChineseMealPlanTM> obList = FXCollections.observableArrayList();
        for (ChineseMealPlan cm: Database.chineseMealPlanTable
        ) {
            Button btn = new Button("Delete");
            ChineseMealPlanTM tm = new ChineseMealPlanTM(cm.getMealNo(),cm.getMealName(),cm.getPriceOfOnePotion(),btn);
            obList.add(tm);

            btn.setOnAction((e)->{

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure?", ButtonType.YES,ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();

                if (buttonType.get().equals(ButtonType.YES)){
                    Database.chineseMealPlanTable.remove(cm);
                    obList.remove(tm);
                }

            });
        }
        tblChineseMeal.setItems(obList);

    }

    public void backToMealPlansOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) chineseMealPlansContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MealPlansForm.fxml"))));
        stage.centerOnScreen();

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if (btnSave.getText().equals("Save Meal")){
            ChineseMealPlan c1=new ChineseMealPlan(txtMealNo.getText(), txtMealName.getText(),Double.parseDouble(txtPrice.getText()));
            Database.chineseMealPlanTable.add(c1);
            loadAllChineseMeal();

        }else{
            for (ChineseMealPlan tm:Database.chineseMealPlanTable
            ) {
                if (tm.getMealNo().equals(txtMealNo.getText())){
                    tm.setMealName(txtMealName.getText());
                    tm.setPriceOfOnePotion(Double.parseDouble(txtPrice.getText()));
                    loadAllChineseMeal();
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
