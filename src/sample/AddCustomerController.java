package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        addCustomerBtn.setOnAction(event -> {
            customersDatabase.addCustomer(customerFirstName.getText(), customerLastName.getText(),
                    phoneNumber.getText(), address.getText());
            closeWindow();
        });
    }

    @FXML
    void closeWindow(){
        Stage stage = (Stage) addCustomerBtn.getScene().getWindow();
        stage.close();
    }


}
