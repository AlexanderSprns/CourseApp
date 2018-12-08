package sample;

/**
 * Class that describes an arraylist of drugs
 */

import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Pharmacies implements Serializable {
    private ArrayList<Pharmacy> dataBase = new ArrayList<>();

//    Pharmacy first = new Pharmacy("Nimesil", "Laboratorios Menarini S.A.",
//            10.99,30, 1, 3, "2017/10/10");

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        ParsePosition parsePosition = new ParsePosition(0);

        for (int i = 0; i < dataBase.size();  i++) {
            Date expired = dateFormat.parse(dataBase.get(i).getDate(), parsePosition);
            if (todayDate.compareTo(expired) >= dataBase.get(i).getShelfLife()) {
                dataBase.remove(i);
                break;
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
