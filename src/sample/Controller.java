package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    // Main menu
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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

    // Add medicine
    @FXML
    private Button addMedicineBtn;

    @FXML
    private TextField medicineName;

    @FXML
    private TextField company;

    @FXML
    private TextField unitPrice;

    @FXML
    private TextField inPackage;

    @FXML
    private TextField pharmacyNumber;

    @FXML
    private TextField shelfLife;

    @FXML
    private TextField dateOfDelivery;

    //Delete medicine

    @FXML
    private Button deleteMedicine;

    @FXML
    private TextField medicineNameDel;

    @FXML
    private TextField pharmacyNumberDel;


    private Pharmacies database = new Pharmacies();

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

//        displayAll.setOnAction(event -> {
//            try{
//                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("displayAllMed.fxml"));
//                Parent root1 = (Parent) fxmlLoader.load();
//                Stage stage = new Stage();
//                stage.setTitle("All medicine");
//                stage.setScene(new Scene(root1));
//                stage.show();
//            }catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        });

//        addMedicine.setOnAction(event -> {
//            database.addInBase(medicineName.getText(), company.getText(), Double.parseDouble(unitPrice.getText()),
//                    Integer.parseInt(inPackage.getText()),
//                    Integer.parseInt(pharmacyNumber.getText()), Integer.parseInt(shelfLife.getText()), dateOfDelivery.getText());
//        });

    }
}
