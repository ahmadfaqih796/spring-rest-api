package com.latihan.demoapi.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.latihan.demoapi.models.entities.Product;
import com.latihan.demoapi.models.repository.ProductRepo;

@RestController
@RequestMapping("/api/products")
public class ProductController {

   @Autowired
   private ProductRepo productRepo;

   @SuppressWarnings("null")
   @PostMapping
   public Product create(@RequestBody Product product) {
      return productRepo.save(product);
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
