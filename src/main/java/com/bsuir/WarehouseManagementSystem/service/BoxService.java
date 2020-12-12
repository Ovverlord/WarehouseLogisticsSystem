package com.bsuir.WarehouseManagementSystem.service;

import com.bsuir.WarehouseManagementSystem.model.Box;
import com.bsuir.WarehouseManagementSystem.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoxService {
    @Autowired
    private BoxRepository boxRepository;

    public List<Box> findAll() {
        return boxRepository.findAll();
    }
}