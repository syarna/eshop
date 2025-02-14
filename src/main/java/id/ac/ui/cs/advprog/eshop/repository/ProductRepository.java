package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private final List<Product> productList = new ArrayList<>();
    private Long currentId = 1L;

    public void save(Product product) {
        product.setProductId(currentId++);
        productList.add(product);
    }

    public List<Product> findAll() {
        return new ArrayList<>(productList);
    }

    public Product findById(Long id) {
        return productList.stream()
                .filter(p -> p.getProductId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void update(Product updatedProduct) {
        Product existingProduct = findById(updatedProduct.getProductId());
        if (existingProduct != null) {
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setProductQuantity(updatedProduct.getProductQuantity());
        }
    }
}
