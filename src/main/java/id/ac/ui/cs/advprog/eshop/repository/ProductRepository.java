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
        product.setId(nextId++);
        productData.add(product);
        return product;
    }

    public List<Product> findAll() {
        return new ArrayList<>(productData);
    }

    public Product findById(int id) {
        return productData.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void update(Product updatedProduct) {
        for (Product product : productData) {
            if (product.getId() == updatedProduct.getId()) {
                product.setName(updatedProduct.getName());
                product.setQuantity(updatedProduct.getQuantity());
                return;
            }
        }
    }

    public void delete(int id) {
        productData.removeIf(product -> product.getId() == id);
        reorderIds();
    }

    private void reorderIds() {
        for (int i = 0; i < productData.size(); i++) {
            productData.get(i).setId(i + 1);
        }
        nextId = productData.size() + 1;
    }
}
