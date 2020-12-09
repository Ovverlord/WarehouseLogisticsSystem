package com.bsuir.WarehouseManagementSystem.controller;

import com.bsuir.WarehouseManagementSystem.model.Product;
import com.bsuir.WarehouseManagementSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PreAuthorize("hasAuthority('CHECKMAN')")
    @GetMapping("/getProducts")
    public String getProducts(Map<String,Object> model){

        Iterable<Product> products = productRepository.findAll();
        model.put("products",products);

        return "productsList";
    }

    @PreAuthorize("hasAuthority('CHECKMAN')")
    @PostMapping("/addProduct")
    public String addProducts(Product product, Map<String,Object> model){

        productRepository.save(product);

        return "productsList";
    }
}
