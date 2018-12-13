package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static Pharmacies database = readPharmacy();
    public static Customers customersDatabase = readCustomers();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        primaryStage.setTitle("Pharmacy");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }

    public static Pharmacies readPharmacy() {
        IOClass read = new IOClass();
        Pharmacies data;
        data = (Pharmacies) read.readFile("database.data");
        return data;
    }

    public static Customers readCustomers() {
        IOClass read = new IOClass();
        Customers customersData;
        customersData = (Customers) read.readFile("customersDatabase.data");
        return customersData;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
