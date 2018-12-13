package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import static sample.Main.customersDatabase;

public class DisplayAllCustomersController {
    @FXML
    private TableView<Customer> allCustomersTable;

    @FXML
    private TableColumn<Customer, String> tableFirstName;

    @FXML
    private TableColumn<Customer, String> tableLastName;

    @FXML
    private TableColumn<Customer, String> tablePhoneNumber;

    @FXML
    private TableColumn<Customer, String> tableAddress;

    private ObservableList<Customer> list = FXCollections.observableArrayList();

    public void initialize(){
        list.addAll(customersDatabase.databaseCustomers);

        tableFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tableLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tablePhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        tableAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        allCustomersTable.setItems(list);
    }
}
