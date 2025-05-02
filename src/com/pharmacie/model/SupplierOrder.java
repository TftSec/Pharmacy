package com.pharmacie.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Objects;

/**
 * The SupplierOrder class represents an order placed with a supplier in a pharmacy system.
 * It includes details such as the order's unique ID, the date it was created, the supplier
 * associated with the order, the list of items in the order, and the current status of the order.
 * The class provides methods to manage the order, such as adding or removing items, calculating
 * the total cost, and updating the order's status. It also overrides equals, hashCode, and
 * toString methods for object comparison and string representation.
 */
public class SupplierOrder {
    private String id;
    private LocalDateTime orderDate;
    private Supplier supplier;
    private List<OrderItem> items;
    private OrderStatus status;

    public enum OrderStatus {
        PENDING,
        CONFIRMED,
        SHIPPED,
        DELIVERED,
        CANCELLED
    }

    public SupplierOrder(Supplier supplier) {
        this.id = UUID.randomUUID().toString();
        this.orderDate = LocalDateTime.now();
        this.supplier = supplier;
        this.items = new ArrayList<>();
        this.status = OrderStatus.PENDING;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(Medication medication, int quantity) {
        items.add(new OrderItem(medication, quantity));
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    /**
     * Calculate the total cost of the entire order
     * @return Total cost
     */
    public double calculateTotalCost() {
        return items.stream()
                .mapToDouble(OrderItem::calculateCost)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierOrder that = (SupplierOrder) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SupplierOrder{" +
                "id='" + id + '\'' +
                ", orderDate=" + orderDate +
                ", supplier=" + supplier.getName() +
                ", items=" + items.size() +
                ", status=" + status +
                '}';
    }
}