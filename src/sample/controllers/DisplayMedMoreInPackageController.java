package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Pharmacy;

import java.util.ArrayList;
import java.util.Date;

import static sample.Main.database;

public class DisplayMedMoreInPackageController {

        @FXML
        private TableColumn<Pharmacy, String> tableName;

        @FXML
        private TableColumn<Pharmacy, String> tableCompany;

        @FXML
        private TableColumn<Pharmacy, Double> tableUnitPrice;

        @FXML
        private TableColumn<Pharmacy, Integer> tableInPackage;

        @FXML
        private TableColumn<Pharmacy, Integer> tablePharmacyNumber;

        @FXML
        private TableColumn<Pharmacy, Integer> tableShelfLife;

        @FXML
        private TableColumn<Pharmacy, Date> tableDate;

        @FXML
        public TableView<Pharmacy> allMedInPackage;

    private ObservableList<Pharmacy> list = FXCollections.observableArrayList();

        @FXML
        public void initialize ()
        {
            ArrayList <Pharmacy> pharmacyArrayList = database.getDataBase();

            for (Pharmacy pharmacy: pharmacyArrayList) {
                if (pharmacy.getInPackage() >= 100) {
                    list.add(pharmacy);
                }
            }
            tableName.setCellValueFactory(new PropertyValueFactory<>("drugName"));
            tableCompany.setCellValueFactory(new PropertyValueFactory<>("company"));
            tableUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
            tableInPackage.setCellValueFactory(new PropertyValueFactory<>("inPackage"));
            tablePharmacyNumber.setCellValueFactory(new PropertyValueFactory<>("pharmacyNumber"));
            tableShelfLife.setCellValueFactory(new PropertyValueFactory<>("shelfLife"));
            tableDate.setCellValueFactory(new PropertyValueFactory<>("dateOfDelivery"));

            allMedInPackage.setItems(list);
        }
}
