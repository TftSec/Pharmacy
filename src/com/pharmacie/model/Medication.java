package com.pharmacie.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public abstract class Medication {
    private String name;
    private String reference;
    private int stockQuantity;
    private LocalDate expirationDate;
    private boolean isGeneric;
    private double price;

    public Medication(String name, String reference, int stockQuantity,
                      LocalDate expirationDate, boolean isGeneric, double price) {
        this.name = name;
        this.reference = reference;
        this.stockQuantity = stockQuantity;
        this.expirationDate = expirationDate;
        this.isGeneric = isGeneric;
        this.price = price;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isGeneric() {
        return isGeneric;
    }

    public void setGeneric(boolean generic) {
        isGeneric = generic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Decrease stock quantity when medication is sold
     * @param quantity Amount to decrease
     * @return true if sufficient stock, false otherwise
     */
    public boolean decreaseStock(int quantity) {
        if (stockQuantity >= quantity) {
            stockQuantity -= quantity;
            return true;
        }
        return false;
    }

    /**
     * Increase stock quantity when medication is restocked
     * @param quantity Amount to add
     */
    public void increaseStock(int quantity) {
        stockQuantity += quantity;
    }

    /**
     * Check if medication is about to expire
     * @param daysThreshold Days threshold for warning
     * @return true if expiration is within threshold
     */
    public boolean isNearExpiration(int daysThreshold) {
        LocalDate warningDate = LocalDate.now().plusDays(daysThreshold);
        return expirationDate.isBefore(warningDate);
    }

    /**
     * Check if medication is expired
     * @return true if expired
     */
    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medication that = (Medication) o;
        return Objects.equals(reference, that.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference);
    }

    @Override
    public String toString() {
        return "Medication{" +
                "name='" + name + '\'' +
                ", reference='" + reference + '\'' +
                ", stockQuantity=" + stockQuantity +
                ", expirationDate=" + expirationDate +
                ", isGeneric=" + isGeneric +
                ", price=" + price +
                '}';
    }
}

