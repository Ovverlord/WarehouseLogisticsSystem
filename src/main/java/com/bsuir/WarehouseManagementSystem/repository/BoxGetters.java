package com.bsuir.WarehouseManagementSystem.repository;


public interface BoxGetters {
    //getters for getBoxesAndPositionId method in BoxRepository
    Long getPositionId();
    Integer getBoxesAmount();

    //getters for getIncompleteBoxesByProductId method in BoxRepository
    Long getBoxId();
}
