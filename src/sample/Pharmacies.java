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

    public boolean removeDrug(String drugName, int pharmacyNumber) {
        boolean result = false;
        for (int i = 0; i < dataBase.size();  i++) {
            if (dataBase.get(i).getDrugName().equals(drugName) && dataBase.get(i).getPharmacyNumber() == pharmacyNumber) {
                dataBase.remove(i);
                result = true;
            }
        }
        return result;
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

    public ArrayList<Pharmacy> getDataBase() {
        return dataBase;
    }
}
