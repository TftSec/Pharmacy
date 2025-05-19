package com.pharmacy.model;

import java.time.LocalDate;

public class InjectableMedication extends Medication {
//there is no new attributes to add to this class so we only need the constructor
    public InjectableMedication(String name, String reference, int stockQuantity,
                                LocalDate expirationDate, boolean isGeneric, double price) {
        super(name, reference, stockQuantity, expirationDate, isGeneric, price);
    }

    @Override
    public String toString() {
        return super.toString() + " InjectableMedication{}";
    }
}