package id.ac.ui.cs.advprog.eshop.util; // Sesuaikan dengan struktur package-mu

import java.util.UUID;

public class CarIdGenerator {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
