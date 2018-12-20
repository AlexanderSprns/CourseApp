package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Warning;

import static sample.Main.customersDatabase;

public class DeleteCustomerController {
    @FXML
    private TextField customerFirstName;

    @FXML
    private TextField customerLastName;

    @FXML
    private Button deleteCustomerBtn;

    @FXML
    void initialize(){
        deleteCustomerBtn.setOnAction(event -> {
            if (!customerFirstName.getText().trim().isEmpty() && customerFirstName.getText() != null &&
                    !customerLastName.getText().trim().isEmpty() && customerLastName.getText() != null &&
                    customersDatabase.deleteCustomer(customerFirstName.getText().trim(), customerLastName.getText().trim())) {
                closeWindow();
            } else {
                Warning warning = new Warning();
                warning.alert("This client does not exist in the database");
            }
        });
    }

    @FXML
    private void closeWindow() {
        Stage stage = (Stage) deleteCustomerBtn.getScene().getWindow();
        stage.close();
    }
}
