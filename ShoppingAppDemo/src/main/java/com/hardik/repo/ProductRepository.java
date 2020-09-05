package com.hardik.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hardik.model.Product;
 
public interface ProductRepository extends JpaRepository<Product, Integer> {
 
}