package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
            customersDatabase.deleteCustomer(customerFirstName.getText(), customerLastName.getText());
            closeWindow();
        });
    }

    @FXML
    void closeWindow(){
        Stage stage = (Stage) deleteCustomerBtn.getScene().getWindow();
        stage.close();
    }
}
