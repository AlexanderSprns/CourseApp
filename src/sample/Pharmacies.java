package sample;

/**
 * Class that describes an arraylist of drugs
 */

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

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

    //TODO fix date compare
    public void deleteAllExpiredDrugs () {
        Date todayDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        ParsePosition parsePosition = new ParsePosition(0);
        Date expired;
        int diff = 0;

        for (int i = 0; i < dataBase.size();  i++) {
            expired = dateFormat.parse(dataBase.get(i).getDateOfDelivery(), parsePosition);
            diff = getDiffYear(todayDate, expired);
            if (diff >= dataBase.get(i).getShelfLife()) {
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

    private int getDiffYear(Date todayDate, Date expired) {

        Calendar a = getCalendar(expired);
        Calendar b = getCalendar(todayDate);
        int diff = b.get(YEAR) - a.get(YEAR);

        if (a.get(MONTH) > b.get(MONTH)
                || (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
            diff--;
        }

        return diff;
    }

    private Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }


    public ArrayList<Pharmacy> getDataBase() {
        return dataBase;
    }
}
