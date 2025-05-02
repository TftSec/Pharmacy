package com.pharmacie.model;

public class HealthInsuranceCard {
    private String socialSecurityNumber;
    private boolean isActive;
    private double discountRate; // Percentage (0-100)
//constructor :
    public HealthInsuranceCard(String socialSecurityNumber, boolean isActive, double discountRate) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.isActive = isActive;
        this.discountRate = discountRate;
    }
//setter and getters :
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    /**
     * Calculate discount amount based on total price
     * @param totalPrice Original price
     * @return Discount amount
     */
    public double calculateDiscount(double totalPrice) {
        if (isActive) {
            return totalPrice * (discountRate / 100.0);
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "HealthInsuranceCard{" +
                "socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", isActive=" + isActive +
                ", discountRate=" + discountRate +
                '}';
    }
}

