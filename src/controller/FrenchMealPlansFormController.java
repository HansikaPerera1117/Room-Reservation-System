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
import model.FrenchMealPlan;
import view.tm.FrenchMealPlanTM;

import java.io.IOException;
import java.util.Optional;

public class FrenchMealPlansFormController {
    public AnchorPane frenchMealPlansContext;
    public JFXTextField txtMealNo;
    public JFXTextField txtMealName;
    public JFXTextField txtPrice;
    public JFXButton btnSave;
    public TableView<FrenchMealPlanTM> tblFrenchMeal;
    public TableColumn colMealNo;
    public TableColumn colMealName;
    public TableColumn colPrice;
    public TableColumn colOption;

    public void initialize(){

        colMealNo.setCellValueFactory(new PropertyValueFactory("mealNo"));
        colMealName.setCellValueFactory(new PropertyValueFactory("mealName"));
        colPrice.setCellValueFactory(new PropertyValueFactory("priceOfOnePotion"));
        colOption.setCellValueFactory(new PropertyValueFactory("btn"));

        loadAllFrenchMeal();

        tblFrenchMeal.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setData(newValue);
            }
        });


    }

    private void setData(FrenchMealPlanTM tm) {
        btnSave.setText("Update Meal");
        txtMealNo.setText(tm.getMealNo());
        txtMealName.setText(tm.getMealName());
        txtPrice.setText(String.valueOf(tm.getPriceOfOnePotion()));

    }

    private void loadAllFrenchMeal() {

        ObservableList<FrenchMealPlanTM> obList = FXCollections.observableArrayList();
        for (FrenchMealPlan fm: Database.frenchMealPlanTable
        ) {
            Button btn = new Button("Delete");
            FrenchMealPlanTM tm = new FrenchMealPlanTM(fm.getMealNo(),fm.getMealName(),fm.getPriceOfOnePotion(),btn);
            obList.add(tm);

            btn.setOnAction((e)->{

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure?", ButtonType.YES,ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();

                if (buttonType.get().equals(ButtonType.YES)){
                    Database.frenchMealPlanTable.remove(fm);
                    obList.remove(tm);
                }

            });
        }
        tblFrenchMeal.setItems(obList);
    }

    public void backToMealPlansOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) frenchMealPlansContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/MealPlansForm.fxml"))));
        stage.centerOnScreen();

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if (btnSave.getText().equals("Save Meal")){
            FrenchMealPlan f1=new FrenchMealPlan(txtMealNo.getText(), txtMealName.getText(),Double.parseDouble(txtPrice.getText()));
            Database.frenchMealPlanTable.add(f1);
            loadAllFrenchMeal();

        }else{
            for (FrenchMealPlan tm:Database.frenchMealPlanTable
            ) {
                if (tm.getMealNo().equals(txtMealNo.getText())){
                    tm.setMealName(txtMealName.getText());
                    tm.setPriceOfOnePotion(Double.parseDouble(txtPrice.getText()));
                    loadAllFrenchMeal();
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
