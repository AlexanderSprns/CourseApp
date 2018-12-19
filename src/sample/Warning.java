package sample;

import javafx.scene.control.Alert;

public class Warning {

    public void alert(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);

        alert.showAndWait();
    }
}