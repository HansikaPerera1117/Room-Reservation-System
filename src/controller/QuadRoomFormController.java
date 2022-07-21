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
import model.QuadRoom;
import model.SingleRoom;
import view.tm.QuadRoomTM;

import java.io.IOException;
import java.util.Optional;

public class QuadRoomFormController {
    public AnchorPane quadRoomContext;
    public TableView<QuadRoomTM> tblQuadRoom;
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

        loadAllQuadRooms();

        tblQuadRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null){
                setData(newValue);
            }
        });
    }

    private void setData(QuadRoomTM tm) {
        btnSave.setText("Update Room");
        txtRoomNo.setText(tm.getRoomNo());
        txtFurniture.setText(tm.getFurniture());
        txtMaintenance.setText(tm.getMaintenance());
        txtAvailability.setText(tm.getAvailability());
    }

    private void loadAllQuadRooms() {
        ObservableList<QuadRoomTM>  obList = FXCollections.observableArrayList();
        for (QuadRoom qr: Database.quadRoomTable
             ) {

            for (Maintenance m:Database.maintenanceTable
            ) {
                for (QuadRoom q:Database.quadRoomTable
                ) {
                    if (m.getRoomNo().equals(q.getRoomNo())){
                        q.setMaintenance("In Maintenance");
                        q.setAvailability("Not Available");
                    }
                }
            }

            Button btn = new Button("Delete");
            QuadRoomTM tm = new QuadRoomTM(qr.getRoomNo(),qr.getFurniture(),qr.getMaintenance(),qr.getAvailability(),btn);
            obList.add(tm);

            btn.setOnAction((e)->{

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are You sure?", ButtonType.YES,ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();

                if (buttonType.get().equals(ButtonType.YES)){
                    Database.quadRoomTable.remove(qr);
                    obList.remove(tm);
                }

            });
        }
        tblQuadRoom.setItems(obList);
    }

    public void backToRoomsOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) quadRoomContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/RoomsForm.fxml"))));
        stage.centerOnScreen();

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if (btnSave.getText().equals("Save Room")){
            QuadRoom q1=new QuadRoom(txtRoomNo.getText(), txtFurniture.getText(), txtMaintenance.getText(), txtAvailability.getText());
            Database.quadRoomTable.add(q1);
            loadAllQuadRooms();

        }else{
            for (QuadRoom tm:Database.quadRoomTable
            ) {
                if (tm.getRoomNo().equals(txtRoomNo.getText())){
                    tm.setFurniture(txtFurniture.getText());
                    tm.setMaintenance(txtMaintenance.getText());
                    tm.setAvailability(txtAvailability.getText());
                    loadAllQuadRooms();
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
