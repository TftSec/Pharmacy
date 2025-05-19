package com.pharmacy.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents a purchase made by a customer
 */
public class Purchase {
    private String id;
    private LocalDateTime purchaseDate;
    private Customer customer;
    private Prescription prescription;
    private double originalPrice;
    private double discountApplied;
    private double finalPrice;

    public Purchase(Customer customer, Prescription prescription) {
        this.id = UUID.randomUUID().toString();
        this.purchaseDate = LocalDateTime.now();
        this.customer = customer;
        this.prescription = prescription;
        this.originalPrice = prescription.calculateTotalCost();
        this.finalPrice = prescription.calculateFinalPrice();
        this.discountApplied = originalPrice - finalPrice;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public double getDiscountApplied() {
        return discountApplied;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(id, purchase.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id='" + id + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", customer=" + customer.getLastName() +
                ", originalPrice=" + originalPrice +
                ", discountApplied=" + discountApplied +
                ", finalPrice=" + finalPrice +
                '}';
    }
}