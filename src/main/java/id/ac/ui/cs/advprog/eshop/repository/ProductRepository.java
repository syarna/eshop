package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    private int nextId = 1;

    public Product create(Product product) {
        product.setId(String.valueOf(nextId++)); // Konversi ID ke String
        productData.add(product);
        return product;
    }

    public List<Product> findAll() {
        return new ArrayList<>(productData);
    }

    public Product findById(String id) { // Ubah parameter ke String
        return productData.stream()
                .filter(product -> product.getId().equals(id)) // Gunakan equals() untuk String
                .findFirst()
                .orElse(null);
    }

    public void update(Product updatedProduct) {
        for (Product product : productData) {
            if (product.getId().equals(updatedProduct.getId())) { // Gunakan equals() untuk String
                product.setName(updatedProduct.getName());
                product.setQuantity(updatedProduct.getQuantity());
                return;
            }
        }
    }

    public void delete(String id) { // Ubah parameter ke String
        productData.removeIf(product -> product.getId().equals(id)); // Gunakan equals() untuk String
        reorderIds(); // Panggil fungsi untuk merapikan ID
    }

    private void reorderIds() {
        for (int i = 0; i < productData.size(); i++) {
            productData.get(i).setId(String.valueOf(i + 1)); // Konversi ID ke String
        }
        nextId = productData.size() + 1;
    }
}
