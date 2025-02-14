package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductService {
    void save(Product product);
    List<Product> getAllProducts();
    Product getById(Long id);
    void update(Product product);
}
