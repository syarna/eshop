package id.ac.ui.cs.advprog.eshop.model;

import java.util.Map;
import java.util.UUID;

public class Payment {
    private String id;
    private String method;
    private String status;
    private Map<String, String> paymentData;

    public Payment(String method, Map<String, String> paymentData) {
        this.id = UUID.randomUUID().toString();
        this.method = method;
        this.paymentData = paymentData;
        this.status = "PENDING";  // Default status
    }

    public String getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public String getStatus() {
        return status;
    }

    public Map<String, String> getPaymentData() {
        return paymentData;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
