package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static sample.Main.database;

public class DeleteMedController {
    @FXML
    private TextField medName;

    @FXML
    private TextField pharmNumber;

    @FXML
    private Button deleteMedBtn;

    @FXML
    void initialize () {
        deleteMedBtn.setOnAction(event -> {
            database.removeDrug(medName.getText(), Integer.parseInt(pharmNumber.getText()));
        closeWindow();
        });
    }

    @FXML
    void closeWindow(){
        Stage stage = (Stage) deleteMedBtn.getScene().getWindow();
        stage.close();
    }

}
