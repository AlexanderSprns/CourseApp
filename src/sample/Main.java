package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static Pharmacies database = readPharmacy();
    public static Customers customersDatabase = new Customers();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
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
    //TODO file read
//    public static Customers readCustomers() {
//        IOClass read = new IOClass();
//        Customers custData;
//        custData = (Customers) read.readFile("customersDatabase.data");
//        return custData;
//    }

    public static void main(String[] args) {
        launch(args);
    }
}
