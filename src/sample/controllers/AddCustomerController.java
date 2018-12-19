package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.IsNumeric;
import sample.Warning;

import static sample.Main.customersDatabase;

public class AddCustomerController {
    @FXML
    private TextField customerFirstName;

    @FXML
    private TextField customerLastName;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField address;

    @FXML
    private Button addCustomerBtn;

    @FXML
    void initialize(){
        IsNumeric isNumeric = new IsNumeric();
        addCustomerBtn.setOnAction(event -> {
            if (!customerFirstName.getText().trim().isEmpty() && customerFirstName.getText() != null &&
                    !customerLastName.getText().trim().isEmpty() && customerLastName.getText() != null &&
                    !phoneNumber.getText().trim().isEmpty() && phoneNumber.getText() != null &&
                    !address.getText().trim().isEmpty() && address.getText() != null &&
                    isNumeric.isNumeric(phoneNumber.getText())) {
                System.out.println(isNumeric.isNumeric(phoneNumber.getText()));
                customersDatabase.addCustomer(customerFirstName.getText(), customerLastName.getText(),
                        phoneNumber.getText(), address.getText());
                closeWindow();
            } else {
                Warning warning = new Warning();
                warning.alert("Invalid input");
            }
        });
    }

    @FXML
    private void closeWindow(){
        Stage stage = (Stage) addCustomerBtn.getScene().getWindow();
        stage.close();
    }


}
