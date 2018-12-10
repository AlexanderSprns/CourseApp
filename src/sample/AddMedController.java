package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static sample.Main.database;

public class AddMedController {


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

    @FXML
    private Button addMedicineBtn;

    @FXML
    void initialize() {

        addMedicineBtn.setOnAction(event ->  {
            database.addInBase(medicineName.getText(),
                    company.getText(),Double.parseDouble(unitPrice.getText()),
                    Integer.parseInt(inPackage.getText()), Integer.parseInt(pharmacyNumber.getText()),
                    Integer.parseInt(shelfLife.getText()), dateOfDelivery.getText());
            closeWindow();
        });

    }

    @FXML
     void closeWindow(){
        Stage stage = (Stage) addMedicineBtn.getScene().getWindow();
        stage.close();
    }
}
