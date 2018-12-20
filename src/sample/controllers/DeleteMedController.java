package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.IsNumeric;
import sample.Warning;

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
            IsNumeric isNumeric = new IsNumeric();

            if (!medName.getText().trim().isEmpty() && medName.getText() != null && !pharmNumber.getText().trim().isEmpty()
                    && pharmNumber.getText() != null && isNumeric.isNumericInt(pharmNumber.getText().trim()) &&
                    database.removeDrug(medName.getText().trim(), Integer.parseInt(pharmNumber.getText().trim()))) {
                closeWindow();
            } else {
                Warning warning = new Warning();
                warning.alert("This medicine does not exist in database");
            }
        });
    }

    @FXML
    private void closeWindow() {
        Stage stage = (Stage) deleteMedBtn.getScene().getWindow();
        stage.close();
    }

}
