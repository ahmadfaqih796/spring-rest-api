package com.latihan.demoapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.latihan.demoapi.models.entities.Product;
import com.latihan.demoapi.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

   @Autowired
   private ProductService productService;

   @PostMapping
   public Product create(@RequestBody Product product) {
      return productService.create(product);
   }

   @GetMapping
   public Iterable<Product> findAll() {
      return productService.findAll();
   }

}
