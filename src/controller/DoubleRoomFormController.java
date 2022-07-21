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
import model.DoubleRoom;
import model.Maintenance;
import model.SingleRoom;
import view.tm.DoubleRoomTM;

import java.io.IOException;
import java.util.Optional;

public class DoubleRoomFormController {
    public AnchorPane doubleRoomContext;
    public TableView<DoubleRoomTM> tblDoubleRoom;
    public TableColumn colRoomNo;
    public TableColumn colFurniture;
    public TableColumn colMaintenance;
    public TableColumn colAvailability;
    public TableColumn colOption;
    public JFXTextField txtRoomNo;
    public JFXTextField txtFurniture;
    public JFXTextField txtMaintenance;
    public JFXTextField txtAvailability;
    public JFXButton btnSave;

    public void initialize(){
        colRoomNo.setCellValueFactory(new PropertyValueFactory("roomNo"));
        colFurniture.setCellValueFactory(new PropertyValueFactory("furniture"));
        colMaintenance.setCellValueFactory(new PropertyValueFactory("maintenance"));
        colAvailability.setCellValueFactory(new PropertyValueFactory("availability"));
        colOption.setCellValueFactory(new PropertyValueFactory("btn"));

        loadAllDoubleRoom();

        tblDoubleRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
           if (newValue != null){
               setData(newValue);
           }
        });
    }

    private void setData(DoubleRoomTM tm) {
        btnSave.setText("Update Room");
        txtRoomNo.setText(tm.getRoomNo());
        txtFurniture.setText(tm.getFurniture());
        txtMaintenance.setText(tm.getMaintenance());
        txtAvailability.setText(tm.getAvailability());
    }

    private void loadAllDoubleRoom() {
        ObservableList<DoubleRoomTM> obList = FXCollections.observableArrayList();

        for (DoubleRoom dr: Database.doubleRoomTable
             ) {

            for (Maintenance m:Database.maintenanceTable
            ) {
                for (DoubleRoom d:Database.doubleRoomTable
                ) {
                    if (m.getRoomNo().equals(d.getRoomNo())){
                        d.setMaintenance("In Maintenance");
                        d.setAvailability("Not Available");
                    }
                }
            }



            Button btn = new Button("Delete");
            DoubleRoomTM tm = new DoubleRoomTM(dr.getRoomNo(),dr.getFurniture(),dr.getMaintenance(),dr.getAvailability(),btn);
            obList.add(tm);


            btn.setOnAction((e)->{

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are You sure?", ButtonType.YES,ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();

                if (buttonType.get().equals(ButtonType.YES)){
                    Database.doubleRoomTable.remove(dr);
                    obList.remove(tm);
                }

            });

        }
        tblDoubleRoom.setItems(obList);
    }

    public void backToRoomsOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) doubleRoomContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/RoomsForm.fxml"))));
        stage.centerOnScreen();

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if (btnSave.getText().equals("Save Room")){
            DoubleRoom d1 = new DoubleRoom(txtRoomNo.getText(),txtFurniture.getText(),txtMaintenance.getText(),txtAvailability.getText());
            Database.doubleRoomTable.add(d1);
            loadAllDoubleRoom();
        }else{
            for (DoubleRoom tm:Database.doubleRoomTable
                 ) {
                if (tm.getRoomNo().equals(txtRoomNo.getText())){
                    tm.setFurniture(txtFurniture.getText());
                    tm.setMaintenance(txtMaintenance.getText());
                    tm.setAvailability(txtAvailability.getText());
                    loadAllDoubleRoom();
                    return;
                }
            }
        }

    }

    public void btnNewRoomOnAction(ActionEvent actionEvent) {
        btnSave.setText("Save Room");
        txtRoomNo.setText("");
        txtFurniture.setText("");
        txtMaintenance.setText("");
        txtAvailability.setText("");
    }
}
