package com.latihan.demoapi.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.latihan.demoapi.models.entities.Product;
import com.latihan.demoapi.models.repository.ProductRepo;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

   @Autowired
   private ProductRepo productRepo;

   @SuppressWarnings("null")
   @PostMapping
   public ResponseEntity<Object> create(@RequestBody Product product) throws JsonProcessingException {
      Product savedProduct = productRepo.save(product);

      Map<String, Object> response = new HashMap<>();
      response.put("status", HttpStatus.CREATED.value());
      response.put("message", "Product created successfully");
      response.put("data", savedProduct);

      return ResponseEntity.status(HttpStatus.CREATED).body(response);
   }

   @GetMapping
   public Iterable<Product> findAll() {
      return productRepo.findAll();
   }

   @GetMapping("/{id}")
   public Product findOne(@PathVariable("id") Long id) {
      @SuppressWarnings("null")
      Optional<Product> product = productRepo.findById(id);
      if (!product.isPresent()) {
         return null;
      }
      return product.get();
   }

   @SuppressWarnings("null")
   @PutMapping
   public Product update(@RequestBody Product product) {
      return productRepo.save(product);
   }

   @SuppressWarnings("null")
   @DeleteMapping("/{id}")
   public void removeOne(@PathVariable("id") Long id) {
      productRepo.deleteById(id);
   }
}
