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
import model.Maintenance;
import view.tm.MaintenanceTM;

import java.io.IOException;
import java.util.Optional;

public class MaintenanceFormController {
    public AnchorPane MaintenanceContext;
    public JFXTextField txtRoomNo;
    public JFXTextField txtMaintenance;
    public JFXButton btnSave;
    public TableView<MaintenanceTM> tblMaintenance;
    public TableColumn colRoomNo;
    public TableColumn colMaintenance;
    public TableColumn colOption;

    public void initialize(){
        colRoomNo.setCellValueFactory(new PropertyValueFactory("roomNo"));
        colMaintenance.setCellValueFactory(new PropertyValueFactory("maintenance"));
        colOption.setCellValueFactory(new PropertyValueFactory("btn"));

        loadAllMaintenance();

        tblMaintenance.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setData(newValue);
            }
        });
    }

    private void setData(MaintenanceTM tm) {
        btnSave.setText("Update Maintenance");
        txtRoomNo.setText(tm.getRoomNo());
        txtMaintenance.setText(tm.getMaintenance());

    }

    private void loadAllMaintenance() {
        ObservableList<MaintenanceTM> obList = FXCollections.observableArrayList();
        for (Maintenance mn: Database.maintenanceTable
        ) {
            Button btn = new Button("Delete");
            MaintenanceTM tm = new MaintenanceTM(mn.getRoomNo(),mn.getMaintenance(),btn);
            obList.add(tm);

            btn.setOnAction((e)->{

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure?", ButtonType.YES,ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();

                if (buttonType.get().equals(ButtonType.YES)){
                    Database.maintenanceTable.remove(mn);
                    obList.remove(tm);
                }

            });
        }
        tblMaintenance.setItems(obList);
    }

    public void backToMainOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) MaintenanceContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/mainForm.fxml"))));
        stage.centerOnScreen();

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if (btnSave.getText().equals("+ Add room to Maintenance")){
            Maintenance m1=new Maintenance(txtRoomNo.getText(),txtMaintenance.getText());
            Database.maintenanceTable.add(m1);
            loadAllMaintenance();

        }else{
            for (Maintenance tm:Database.maintenanceTable
            ) {
                if (tm.getRoomNo().equals(txtRoomNo.getText())){
                    tm.setMaintenance(txtMaintenance.getText());
                    loadAllMaintenance();
                    return;
                }
            }
        }
    }

    public void btnNewRoomOnAction(ActionEvent actionEvent) {
        btnSave.setText("+ Add room to Maintenance");
        txtRoomNo.setText("");
        txtMaintenance.setText("");

    }
}
