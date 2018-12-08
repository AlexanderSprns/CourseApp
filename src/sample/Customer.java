package sample;

import java.io.Serializable;

/**
 * Class that describe customer in drug store
 */

public class Customer implements Serializable {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private Pharmacies pharmacies;

    public Customer(String firstName, String lastName, String phoneNumber, String address) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        this.address = address;
        pharmacies = new Pharmacies();
    }

    public void addDrug(String drugName, String company, double unitPrice, int inPackage,
                        int pharmacyNumber, int shelfLife, String date) {
        pharmacies.addInBase(drugName, company, unitPrice, inPackage, pharmacyNumber, shelfLife, date);
    }

    public void deleteDrug(String drugName, int pharmacyNumber) {
        pharmacies.removeDrug(drugName, pharmacyNumber);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = (firstName.isEmpty() || isNumeric(firstName)) ? "InvalidFirstName" : firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = (lastName.isEmpty() || isNumeric(lastName)) ? "InvalidLastName" : lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = (isNumeric(phoneNumber) && !phoneNumber.isEmpty()) ? phoneNumber : "InvalidPhoneNumber";
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Pharmacies getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(Pharmacies pharmacies) {
        this.pharmacies = pharmacies;
    }

    private boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

}
