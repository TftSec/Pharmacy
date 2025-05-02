package com.pharmacie.model;

import java.time.LocalDate;

//represent tablet medication (pills or capsules)
public class TabletMedication extends Medication {
    private int unitsPerBox;

    public TabletMedication(String name, String reference, int stockQuantity,
                            LocalDate expirationDate, boolean isGeneric,
                            double price, int unitsPerBox) {
        super(name, reference, stockQuantity, expirationDate, isGeneric, price);
        this.unitsPerBox = unitsPerBox;
    }
// getters and setters :
    public int getUnitsPerBox() {
        return unitsPerBox;
    }

    public void setUnitsPerBox(int unitsPerBox) {
        this.unitsPerBox = unitsPerBox;
    }
// we need to redefine the toString method to suit our need in this class
    @Override
    public String toString() {
        return super.toString() + " TabletMedication{" +
                "unitsPerBox=" + unitsPerBox +
                '}';
    }
}
