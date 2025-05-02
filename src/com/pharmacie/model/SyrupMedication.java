package com.pharmacie.model;

import java.time.LocalDate;

public class SyrupMedication extends Medication {
    private int volumeInMl;

    public SyrupMedication(String name, String reference, int stockQuantity,
                           LocalDate expirationDate, boolean isGeneric,
                           double price, int volumeInMl) {
        super(name, reference, stockQuantity, expirationDate, isGeneric, price);
        this.volumeInMl = volumeInMl;
    }
    //setter and getters:
    public int getVolumeInMl() {
        return volumeInMl;
    }

    public void setVolumeInMl(int volumeInMl) {
        this.volumeInMl = volumeInMl;
    }

    @Override
    public String toString() {
        return super.toString() + " SyrupMedication{" +
                "volumeInMl=" + volumeInMl +
                '}';
    }
}
