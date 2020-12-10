package com.bsuir.WarehouseManagementSystem.service;


import com.bsuir.WarehouseManagementSystem.model.Box;
import com.bsuir.WarehouseManagementSystem.model.Position;
import com.bsuir.WarehouseManagementSystem.model.Product;
import com.bsuir.WarehouseManagementSystem.repository.BoxGetters;
import com.bsuir.WarehouseManagementSystem.repository.BoxRepository;
import com.bsuir.WarehouseManagementSystem.repository.PositionRepository;
import com.bsuir.WarehouseManagementSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BoxRepository boxRepository;

    @Autowired
    private PositionRepository positionRepository;

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

        List<BoxGetters> list = boxRepository.getBoxesAndPositionId(id);

        Map<Long,Integer> map = new HashMap<>();
        for(BoxGetters obj : list){
            map.put(obj.getPositionId(),obj.getBoxesAmount());
        }

        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            reducePositionFullness(entry.getKey(),entry.getValue());
            System.out.println("ID позиции =  " + entry.getKey() + " КОличество коробок = " + entry.getValue());
        }

        productRepository.deleteById(id);
    }

    void reducePositionFullness(Long id,Integer amount){
        Position position = positionRepository.findById(id).orElseThrow();
        position.setFullness(position.getFullness() - amount);

        positionRepository.save(position);
    }
}
