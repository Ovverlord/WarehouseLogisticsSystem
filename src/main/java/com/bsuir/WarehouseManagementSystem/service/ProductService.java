package com.bsuir.WarehouseManagementSystem.service;


import com.bsuir.WarehouseManagementSystem.model.Product;
import com.bsuir.WarehouseManagementSystem.model.User;
import com.bsuir.WarehouseManagementSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void save(Product product){
        product.setQuantity(0);
        productRepository.save(product);
    }

    public void editProduct(Product product){
        Product updatedProduct = productRepository.findById(product.getId()).orElseThrow();
        updatedProduct.setDescription(product.getDescription());
        productRepository.save(updatedProduct);
    }

    public void removeProduct(Long id){
        productRepository.deleteById(id);
    }
}
