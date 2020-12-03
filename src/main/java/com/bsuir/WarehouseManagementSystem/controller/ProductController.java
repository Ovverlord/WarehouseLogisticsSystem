package com.bsuir.WarehouseManagementSystem.controller;

import com.bsuir.WarehouseManagementSystem.model.Product;
import com.bsuir.WarehouseManagementSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String main(Map<String,Object> model){

        Iterable<Product> products = productRepository.findAll();
        model.put("products",products);

        return "main";
    }

    @PostMapping("/")
    public String add(@RequestParam String description, Map<String,Object> model){

        Product product = new Product(description);
        productRepository.save(product);

        Iterable<Product> products = productRepository.findAll();
        model.put("products",products);

        return "main";
    }
}
