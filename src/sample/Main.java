package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Pharmacies database = readPharmacy();
    public static Customers customersDatabase = readCustomers();
//    public static Pharmacies database = new Pharmacies();
//    public static Customers customersDatabase = new Customers();

    private static Pharmacies readPharmacy() {
        IOClass read = new IOClass();
        Pharmacies data;
        data = (Pharmacies) read.readFile("database.data");
        return data;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxmlFiles/mainMenu.fxml"));
        primaryStage.setTitle("Pharmacy");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        IOClass write = new IOClass();
        write.saveFile(database, "database.data");

        IOClass writeCustomers = new IOClass();
        writeCustomers.saveFile(customersDatabase, "customersDatabase.data");

        super.stop();
    }

    private static Customers readCustomers() {
        IOClass read = new IOClass();
        Customers customersData;
        customersData = (Customers) read.readFile("customersDatabase.data");
        return customersData;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
