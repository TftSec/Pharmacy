package com.pharmacie.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Objects;

public class Prescription {
    private final String id;
    private LocalDate prescriptionDate;
    private Customer customer;
    private final List<PrescriptionItem> items;

    public Prescription(LocalDate prescriptionDate, Customer customer) {
        this.id = UUID.randomUUID().toString();
        this.prescriptionDate = prescriptionDate;
        this.customer = customer;
        this.items = new ArrayList<>();
        if (prescriptionDate == null || customer == null) {
            throw new IllegalArgumentException("Prescription date and customer cannot be null");
        }
        if (prescriptionDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Prescription date cannot be in the future");
        }
    }

    public String getId() {
        return id;
    }

    public LocalDate getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(LocalDate prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<PrescriptionItem> getItems() {
        return items;
    }

    public void addItem(Medication medication, String dosage, String frequency, int durationInDays) {
        items.add(new PrescriptionItem(medication, dosage, frequency, durationInDays));
    }

    public void removeItem(PrescriptionItem item) {
        items.remove(item);
    }

    /**
     * Calculate the total cost of all items in the prescription
     * @return Total cost
     */
    public double calculateTotalCost() {
        return items.stream()
                .mapToDouble(PrescriptionItem::calculateCost)
                .sum();
    }

    /**
     * Apply insurance discount if available
     * @return Final price after discount
     */
    public double calculateFinalPrice() {
        double totalCost = calculateTotalCost();
        if (customer.getInsuranceCard() != null && customer.getInsuranceCard().isActive()) {
            double discount = customer.getInsuranceCard().calculateDiscount(totalCost);
            return totalCost - discount;
        }
        return totalCost;
    }

    /**
     * Check if all medications in the prescription are available in sufficient quantity
     * @return true if all medications are available
     */
    public boolean checkAvailability() {
        for (PrescriptionItem item : items) {
            if (item.getMedication().getStockQuantity() < item.getQuantity()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription that = (Prescription) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id='" + id + '\'' +
                ", prescriptionDate=" + prescriptionDate +
                ", customer=" + customer.getLastName() +
                ", items=" + items.size() +
                '}';
    }
}