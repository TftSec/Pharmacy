package com.pharmacie.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private HealthInsuranceCard insuranceCard;
    private List<Purchase> purchaseHistory;

    public Customer(String firstName, String lastName, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.purchaseHistory = new ArrayList<>();
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public HealthInsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public void setInsuranceCard(HealthInsuranceCard insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    public List<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void addPurchase(Purchase purchase) {
        purchaseHistory.add(purchase);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}