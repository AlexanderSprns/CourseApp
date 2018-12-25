package sample.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.IsNumeric;
import sample.Warning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            IsNumeric isNumeric = new IsNumeric();

            if (!medicineName.getText().trim().isEmpty() && medicineName.getText() != null &&
                    !company.getText().trim().isEmpty() && company.getText() != null &&
                    !unitPrice.getText().trim().isEmpty() && unitPrice.getText() != null &&
                    !inPackage.getText().trim().isEmpty() && inPackage.getText() != null &&
                    !pharmacyNumber.getText().trim().isEmpty() && pharmacyNumber.getText() != null &&
                    !shelfLife.getText().trim().isEmpty() && shelfLife.getText() != null &&
                    !dateOfDelivery.getText().trim().isEmpty() && dateOfDelivery != null &&
                    isNumeric.isNumeric(unitPrice.getText()) && isNumeric.isNumericInt(inPackage.getText()) &&
                    isNumeric.isNumericInt(pharmacyNumber.getText()) && isNumeric.isNumericInt(shelfLife.getText()) &&
                    validateJavaDate(dateOfDelivery.getText().trim())) {

                database.addInBase(medicineName.getText().trim(), company.getText().trim(),
                        Double.parseDouble(unitPrice.getText().trim()), Integer.parseInt(inPackage.getText().trim()),
                        Integer.parseInt(pharmacyNumber.getText().trim()), Integer.parseInt(shelfLife.getText().trim()),
                        dateOfDelivery.getText().trim());
                closeWindow();
            } else {
                Warning warning = new Warning();
                warning.alert("Invalid input");
            }
        });

    }

    private boolean validateJavaDate(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.setLenient(false);
        try {
            Date javaDate = sdf.parse(strDate);
            System.out.println(strDate + " is valid date format");
        } catch (ParseException e) {
            System.out.println(strDate + " is Invalid Date format");
            return false;
        }
        return true;
    }

    @FXML
    private void closeWindow(){
        Stage stage = (Stage) addMedicineBtn.getScene().getWindow();
        stage.close();
    }
}
