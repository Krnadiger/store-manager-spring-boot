package com.prohubtech.inventory.services;

import com.prohubtech.inventory.exceptions.ProductNotFoundException;
import com.prohubtech.inventory.model.Product;
import com.prohubtech.inventory.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    public Product addProduct(Product product) {
        product.setProductCode(UUID.randomUUID().toString());
        return productRepo.save(product);
    }

    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteProductById(id);
    }

    public Product findProductById(Long id) {
        return productRepo.findProductById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product by id " + id + " was not found"));
    }
}
