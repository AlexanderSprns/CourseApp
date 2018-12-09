package sample;

/**
 * Class that describe an arraylist of Customer
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Customers implements Serializable {

    private ArrayList<Customer> dataBaseCustomers = new ArrayList<>();

    public void addCustomer(String firstName, String lastName, String phoneNumber, String address) {
        Customer customer = new Customer(firstName, lastName, phoneNumber, address);
        dataBaseCustomers.add(customer);
    }

    public boolean deleteCustomer(String firstName, String lastName, String phoneNumber, String address) {
        Customer customer = new Customer(firstName, lastName, phoneNumber, address);
        boolean result = false;

        for (int i = 0; i < dataBaseCustomers.size(); i++){
            if (dataBaseCustomers.get(i).equals(customer)) {
                dataBaseCustomers.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    public void displayAllCustomers () {
        for (Customer customer: dataBaseCustomers) {
            System.out.println(customer);
        }
    }

    public ArrayList<Customer> getDataBaseCustomers() {
        return dataBaseCustomers;
    }

}
