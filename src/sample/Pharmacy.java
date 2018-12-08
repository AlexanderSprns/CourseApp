package sample;

/**
 * Class that describes the drug
 */

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pharmacy implements Serializable {
    private String drugName;
    private String company;
    private double unitPrice;
    private int inPackage;
    private int pharmacyNumber;
    private int shelfLife;
    private Date dateOfDelivery;

    public Pharmacy(String drugName, String company, double unitPrice, int inPackage, int pharmacyNumber, int shelfLife, String date) {
        this.drugName = drugName;
        this.company = company;
        setUnitPrice(unitPrice);
        setInPackage(inPackage);
        setPharmacyNumber(pharmacyNumber);
        setShelfLife(shelfLife);
        setDate(date);
    }

    @Override
    public String toString() {
        int currency = 0x20B4;
        return "Pharmacy{" +
                "drugName: '" + drugName + '\'' +
                ", company: '" + company + '\'' +
                ", unitPrice: " + (char) currency + unitPrice +
                ", inPackage: " + inPackage + "pcs." +
                ", pharmacyNumber: " + pharmacyNumber +
                ", shelfLife: " + shelfLife + "years" +
                ", date: " + getDate() +
                '}';
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getUnitPrice() { return unitPrice; }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice <= 0. ? -1. : unitPrice;
    }

    public int getInPackage() {
        return inPackage;
    }

    public void setInPackage(int inPackage) {
        this.inPackage = inPackage <= 0 ? -1 : inPackage;
    }

    public int getPharmacyNumber() {
        return pharmacyNumber;
    }

    public void setPharmacyNumber(int pharmacyNumber) {
        this.pharmacyNumber = pharmacyNumber <= 0 ? -1 : pharmacyNumber;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife <= 0 ? -1 : shelfLife;
    }

    public String getDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        return df.format(dateOfDelivery);
    }

    public void setDate(String date) {
        this.dateOfDelivery = new Date(date);
    }
}
