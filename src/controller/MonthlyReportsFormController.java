package controller;

import db.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.MonthlyReport;
import view.tm.MonthlyReportTM;

import javax.xml.crypto.Data;
import java.io.IOException;

public class MonthlyReportsFormController {
    public AnchorPane monthlyReportContext;
    public TableView<MonthlyReportTM> tblMonthlyReport;
    public TableColumn colMonth;
    public TableColumn colHead;
    public TableColumn colIncome;
    
    public void initialize(){

        colMonth.setCellValueFactory(new PropertyValueFactory("month"));
        colHead.setCellValueFactory(new PropertyValueFactory("head"));
        colIncome.setCellValueFactory(new PropertyValueFactory("income"));

        loadAllMonthlyReport();

    }

    private void loadAllMonthlyReport() {
        ObservableList<MonthlyReportTM> obList = FXCollections.observableArrayList();
        for (MonthlyReport mr: Database.monthlyReportsTable
             ) {
            MonthlyReportTM tm = new MonthlyReportTM(mr.getMonth(),mr.getHead(),mr.getIncome());
            obList.add(tm);
        }
        tblMonthlyReport.setItems(obList);
    }

    public void backToReportsOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) monthlyReportContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReportsForm.fxml"))));
        stage.centerOnScreen();

    }
}
