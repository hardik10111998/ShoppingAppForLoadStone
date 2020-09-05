package com.hardik.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hardik.model.Product;
import com.hardik.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	public ProductService productService;
	
	
	// RESTful API methods for Retrieval operations
    @GetMapping("/products")
    public List<Product> list() {
        return productService.listAll();
    }
     
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id) {
        try {
            Product product = productService.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }      
    }
    
    // RESTful API method for Create operation
    @PostMapping("/products")
    public void add(@RequestBody Product product) {
        productService.save(product);
    }
     
    // RESTful API method for Update operation
    @PutMapping("/products/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
        try {
            Product existProduct = productService.get(id);
            productService.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
     
    // RESTful API method for Delete operation
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }

}
