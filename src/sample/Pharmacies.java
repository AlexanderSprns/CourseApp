package sample;

/**
 * Class that describes an array list of medicines
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Pharmacies implements Serializable {
    public ArrayList<Pharmacy> dataBase = new ArrayList<>();


    public Pharmacies() {
    }

    public void addInBase(String drugName, String company, double unitPrice, int inPackage,
                          int pharmacyNumber, int shelfLife, String date) {
        Pharmacy pharmacy = new Pharmacy(drugName, company, unitPrice, inPackage, pharmacyNumber, shelfLife, date);
        dataBase.add(pharmacy);
    }

    public void removeDrug(String drugName, int pharmacyNumber) {
        for (int i = 0; i < dataBase.size();  i++) {
            if (dataBase.get(i).getDrugName().equals(drugName) && dataBase.get(i).getPharmacyNumber() == pharmacyNumber) {
                dataBase.remove(i);
                break;
            }
        }
    }

    public void deleteAllExpiredDrugs () {
        Date todayDate = new Date();
        Date expired;
        int diff;

        for (int i = 0; i < dataBase.size();  i++) {
            expired = new Date(dataBase.get(i).getDateOfDelivery());
            diff = todayDate.getYear() - expired.getYear();

            if (diff >= dataBase.get(i).getShelfLife()) {
                dataBase.remove(i);
            }
        }
    }

    public void displayInPackageMoreThan100 () {
        for (Pharmacy pharmacy: dataBase) {
            if (pharmacy.getInPackage() >= 100) {
                System.out.println(pharmacy.getDrugName());
            }
        }
    }

    public void displayPharmacyByNumber (int storeNumber) {
        for (Pharmacy pharmacy: dataBase) {
            if (storeNumber == pharmacy.getPharmacyNumber()) {
                System.out.println(pharmacy);
            }
        }
    }

    public void displayAllDrugs () {
        for (Pharmacy pharmacy: dataBase) {
            System.out.println(pharmacy);
        }
    }

    public ArrayList<Pharmacy> getDataBase() {
        return dataBase;
    }
}
