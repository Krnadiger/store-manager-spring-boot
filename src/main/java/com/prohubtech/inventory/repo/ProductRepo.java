package com.prohubtech.inventory.repo;

import com.prohubtech.inventory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {

    void deleteProductById(Long id);

    Optional<Product> findProductById(Long id);
}
