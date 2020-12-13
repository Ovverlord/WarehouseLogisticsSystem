package com.bsuir.WarehouseManagementSystem.service;

import com.bsuir.WarehouseManagementSystem.model.Position;
import com.bsuir.WarehouseManagementSystem.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {
    @Autowired
    PositionRepository positionRepository;

    public void reducePositionFullness(Long positionId,Integer amount){
        Position position = positionRepository.findById(positionId).orElseThrow();
        position.setFullness(position.getFullness() - amount);
        positionRepository.save(position);
    }
}
