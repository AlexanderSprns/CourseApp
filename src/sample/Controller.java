package sample;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static sample.Main.customersDatabase;
import static sample.Main.database;

public class Controller {

    // Main menu

    @FXML
    private Button addDrugsMainMenu;

    @FXML
    private Button deleteDrug;

    @FXML
    private Button displayAll;

    @FXML
    private Button delExpired;

    @FXML
    private Button displayInPackageMoreThan100;

    @FXML
    private Button displayByPharmacyNumber;

    @FXML
    private Button addCustomer;

    @FXML
    private Button deleteCustomer;

    @FXML
    private Button displayCustomers;

    @FXML
    private Button saveChanges;


    @FXML
    void initialize() {

        delExpired.setOnAction(event -> database.deleteAllExpiredDrugs());

        addDrugsMainMenu.setOnAction(new EventHandler<>() {
             public void handle(ActionEvent event) {
                 try {
                     Parent root = FXMLLoader.load(getClass().getResource("addMedicine.fxml"));
                     Stage stage = new Stage();
                     stage.setTitle("Add medicine");
                     stage.setScene(new Scene(root, 700, 500));
                     stage.show();
                 }
                 catch (IOException e) {
                     e.printStackTrace();
                 }
             }
        });

        displayAll.setOnAction(event -> {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("displayAllMed.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("All medicine");
                stage.setScene(new Scene(root1));
                stage.show();
            }catch (Exception e) {
                e.printStackTrace();
            }
        });

        deleteDrug.setOnAction(event -> {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("deleteMedicine.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Delete medicine");
                stage.setScene(new Scene(root1));
                stage.show();
            }catch (Exception e) {
                e.printStackTrace();
            }
        });

        displayInPackageMoreThan100.setOnAction(event -> {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("displayPackageMoreThan100.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Medicine in a package of more than 100");
                stage.setScene(new Scene(root1));
                stage.show();
            }catch (Exception e) {
                e.printStackTrace();
            }
        });

        displayByPharmacyNumber.setOnAction(event -> {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("displayByPharmNumber.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Finding a pharmacy by number");
                stage.setScene(new Scene(root1));
                stage.show();
            }catch (Exception e) {
                e.printStackTrace();
            }
        });

        addCustomer.setOnAction(event -> {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addCustomer.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Adding customer");
                stage.setScene(new Scene(root1));
                stage.show();
            }catch (Exception e) {
                e.printStackTrace();
            }
        });

        deleteCustomer.setOnAction(event -> {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("deleteCustomer.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Deleting customer");
                stage.setScene(new Scene(root1));
                stage.show();
            }catch (Exception e) {
                e.printStackTrace();
            }
        });

        displayCustomers.setOnAction(event -> {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("displayAllCustomers.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("All customers");
                stage.setScene(new Scene(root1));
                stage.show();
            }catch (Exception e) {
                e.printStackTrace();
            }
        });

        saveChanges.setOnAction(event -> {
            IOClass write = new IOClass();
            write.saveFile(database, "database.data");

            IOClass writeCustomers = new IOClass();
            writeCustomers.saveFile(customersDatabase, "customersDatabase.data");
        });
    }
}
