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
import view.tm.SingleRoomTM;

import java.io.IOException;
import java.util.Optional;

public class SingleRoomFormController {
    public AnchorPane singleRoomContext;
    public TableView<SingleRoomTM> tblSingleRoom;
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

        loadAllSingleRooms();

        tblSingleRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setData(newValue);
            }
        });
    }

    private void setData(SingleRoomTM tm) {
        btnSave.setText("Update Room");
        txtRoomNo.setText(tm.getRoomNo());
        txtFurniture.setText(tm.getFurniture());
        txtMaintenance.setText(tm.getMaintenance());
        txtAvailability.setText(tm.getAvailability());

    }

    private void loadAllSingleRooms() {
        ObservableList<SingleRoomTM> obList = FXCollections.observableArrayList();
        for (SingleRoom sr: Database.singleRoomTable
             ) {

            for (Maintenance m:Database.maintenanceTable
            ) {
                for (SingleRoom s:Database.singleRoomTable
                ) {
                    if (m.getRoomNo().equals(s.getRoomNo())){
                        s.setMaintenance("In Maintenance");
                        s.setAvailability("Not Available");
                    }
                }
            }

            Button btn = new Button("Delete");
            SingleRoomTM tm = new SingleRoomTM(sr.getRoomNo(),sr.getFurniture(),sr.getMaintenance(),sr.getAvailability(),btn);
            obList.add(tm);

            btn.setOnAction((e)->{

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure?",ButtonType.YES,ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();

                if (buttonType.get().equals(ButtonType.YES)){
                    Database.singleRoomTable.remove(sr);
                    obList.remove(tm);
                }

            });
        }
        tblSingleRoom.setItems(obList);
    }

    public void backToRoomsOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) singleRoomContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/RoomsForm.fxml"))));
        stage.centerOnScreen();

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if (btnSave.getText().equals("Save Room")){
            SingleRoom s1=new SingleRoom(txtRoomNo.getText(), txtFurniture.getText(), txtMaintenance.getText(), txtAvailability.getText());
            Database.singleRoomTable.add(s1);
            loadAllSingleRooms();

        }else{
            for (SingleRoom tm:Database.singleRoomTable
                 ) {
                if (tm.getRoomNo().equals(txtRoomNo.getText())){
                    tm.setFurniture(txtFurniture.getText());
                    tm.setMaintenance(txtMaintenance.getText());
                    tm.setAvailability(txtAvailability.getText());
                    loadAllSingleRooms();
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
