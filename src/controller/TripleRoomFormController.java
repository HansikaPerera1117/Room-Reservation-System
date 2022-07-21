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
import model.SingleRoom;
import model.TripleRoom;
import view.tm.TripleRoomTM;

import java.io.IOException;
import java.util.Optional;

public class TripleRoomFormController {
    public AnchorPane tripleRoomContext;
    public TableView<TripleRoomTM> tblTripleRoom;
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

         loadAllTripleRooms();

         tblTripleRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

             if (newValue != null){
                 setData(newValue);
             }

         });
    }

    private void setData(TripleRoomTM tm) {
        btnSave.setText("Update Room");
        txtRoomNo.setText(tm.getRoomNo());
        txtFurniture.setText(tm.getFurniture());
        txtMaintenance.setText(tm.getMaintenance());
        txtAvailability.setText(tm.getAvailability());
    }

    private void loadAllTripleRooms() {
        ObservableList<TripleRoomTM> obList = FXCollections.observableArrayList();
        for (TripleRoom tr: Database.tripleRoomTable
             ) {

            for (Maintenance m:Database.maintenanceTable
            ) {
                for (TripleRoom t:Database.tripleRoomTable
                ) {
                    if (m.getRoomNo().equals(t.getRoomNo())){
                        t.setMaintenance("In Maintenance");
                        t.setAvailability("Not Available");
                    }
                }
            }

            Button btn = new Button("Delete");
            TripleRoomTM tm = new TripleRoomTM(tr.getRoomNo(),tr.getFurniture(),tr.getMaintenance(),tr.getAvailability(),btn);
            obList.add(tm);

           btn.setOnAction((e)->{

               Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure?", ButtonType.YES,ButtonType.NO);
               Optional<ButtonType> buttonType = alert.showAndWait();

               if (buttonType.get().equals(ButtonType.YES)){
                   Database.tripleRoomTable.remove(tr);
                   obList.remove(tm);
               }

           });

        }
        tblTripleRoom.setItems(obList);
    }

    public void backToRoomsOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) tripleRoomContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/RoomsForm.fxml"))));
        stage.centerOnScreen();

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if (btnSave.getText().equals("Save Room")){
            TripleRoom r1=new TripleRoom(txtRoomNo.getText(),txtFurniture.getText(),txtMaintenance.getText(),txtAvailability.getText());
            Database.tripleRoomTable.add(r1);
            loadAllTripleRooms();
        }else {
            for (TripleRoom tm:Database.tripleRoomTable
                 ) {
                if (tm.getRoomNo().equals(txtRoomNo.getText())){
                    tm.setFurniture(txtFurniture.getText());
                    tm.setMaintenance(txtMaintenance.getText());
                    tm.setAvailability(txtAvailability.getText());
                    loadAllTripleRooms();
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
