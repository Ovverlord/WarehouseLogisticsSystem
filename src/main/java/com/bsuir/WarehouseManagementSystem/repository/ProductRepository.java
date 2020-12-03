package com.bsuir.WarehouseManagementSystem.repository;

import com.bsuir.WarehouseManagementSystem.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
