package id.ac.ui.cs.advprog.eshop.model;

import java.util.List;
import java.util.Arrays;

public class Order {
    private String id;
    private List<Product> products;
    private Long orderTime;
    private String author;
    private String status;

    // Constructor without status parameter
    public Order(String id, List<Product> products, Long orderTime, String author) {
        this.id = id;
        this.orderTime = orderTime;
        this.author = author;
        this.status = "WAITING_PAYMENT";

        if (products.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.products = products;
        }
    }

    // Constructor with status parameter
    public Order(String id, List<Product> products, Long orderTime, String author, String status) {
        this(id, products, orderTime, author);
        String[] statusList = {"WAITING_PAYMENT", "FAILED", "SUCCESS", "CANCELLED"};
        if (Arrays.stream(statusList).noneMatch(item -> item.equals(status))) {
            throw new IllegalArgumentException();
        } else {
            this.status = status;
        }
    }

    // Setter for status
    public void setStatus(String status) {
        String[] statusList = {"WAITING_PAYMENT", "FAILED", "SUCCESS", "CANCELLED"};
        if (Arrays.stream(statusList).noneMatch(item -> item.equals(status))) {
            throw new IllegalArgumentException();
        } else {
            this.status = status;
        }
    }

    // Getters
    public String getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Long getOrderTime() {
        return orderTime;
    }

    public String getAuthor() {
        return author;
    }

    public String getStatus() {
        return status;
    }
}
