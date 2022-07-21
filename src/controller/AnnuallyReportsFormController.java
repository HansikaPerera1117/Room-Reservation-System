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
import model.AnnuallyReport;
import view.tm.AnnuallyReportTM;

import java.io.IOException;

public class AnnuallyReportsFormController {
    public AnchorPane annuallyReportsContext;
    public TableView <AnnuallyReportTM> tblAnnuallyReport;
    public TableColumn colYear;
    public TableColumn colHead;
    public TableColumn colIncome;

    public void initialize(){

        colYear.setCellValueFactory(new PropertyValueFactory("year"));
        colHead.setCellValueFactory(new PropertyValueFactory("head"));
        colIncome.setCellValueFactory(new PropertyValueFactory("income"));

        loadAllAnnuallyReports();

    }

    private void loadAllAnnuallyReports() {
        ObservableList<AnnuallyReportTM> obList = FXCollections.observableArrayList();
        for (AnnuallyReport ar: Database.annuallyReportsTable
        ) {

            AnnuallyReportTM tm = new AnnuallyReportTM(ar.getYear(),ar.getHead(),ar.getIncome());
            obList.add(tm);
        }
        tblAnnuallyReport.setItems(obList);
    }


    public void backToReportsOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) annuallyReportsContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ReportsForm.fxml"))));
        stage.centerOnScreen();

    }
}
