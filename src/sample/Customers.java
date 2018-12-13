package sample;

/**
 * Class that describe an arraylist of Customer
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Customers implements Serializable {

    public ArrayList<Customer> databaseCustomers = new ArrayList<>();

    public void addCustomer(String firstName, String lastName, String phoneNumber, String address) {
        Customer customer = new Customer(firstName, lastName, phoneNumber, address);
        databaseCustomers.add(customer);
    }

    public boolean deleteCustomer(String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName, null, null);
        boolean result = false;

        for (int i = 0; i < databaseCustomers.size(); i++){
            if (databaseCustomers.get(i).getFirstName().equals(customer.getFirstName()) &&
                    databaseCustomers.get(i).getLastName().equals(customer.getLastName())) {
                databaseCustomers.remove(i);
                result = true;
            }
        }
        return result;
    }

    public void displayAllCustomers () {
        for (Customer customer: databaseCustomers) {
            System.out.println(customer);
        }
    }

    public ArrayList<Customer> getDatabaseCustomers() {
        return databaseCustomers;
    }

}
