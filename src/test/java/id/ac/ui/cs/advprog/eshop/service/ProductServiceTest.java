package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product existingProduct;
    private Product updatedProduct;

    @BeforeEach
    void setUp() {
        existingProduct = new Product("1", "Laptop", 10);
        updatedProduct = new Product("1", "Gaming Laptop", 5);
    }

    @Test
    void testUpdateProduct_Success() {
        when(productRepository.findById("1")).thenReturn(existingProduct);

        productService.update(updatedProduct);

        verify(productRepository, times(1)).update(updatedProduct);
    }

    @Test
    void testUpdateProduct_Fail_ProductNotFound() {
        when(productRepository.findById("2")).thenReturn(null);

        assertDoesNotThrow(() -> productService.update(new Product("2", "Tablet", 3)));

        verify(productRepository, times(1)).findById("2");
        verify(productRepository, never()).update(any(Product.class));
    }

    @Test
    void testDeleteProduct_Success() {
        when(productRepository.findById("1")).thenReturn(existingProduct);

        productService.delete("1");

        verify(productRepository, times(1)).delete("1");
    }

    @Test
    void testDeleteProduct_Fail_ProductNotFound() {
        when(productRepository.findById("2")).thenReturn(null);

        assertDoesNotThrow(() -> productService.delete("2"));

        verify(productRepository, times(1)).findById("2");
        verify(productRepository, never()).delete(anyString());
    }
}
