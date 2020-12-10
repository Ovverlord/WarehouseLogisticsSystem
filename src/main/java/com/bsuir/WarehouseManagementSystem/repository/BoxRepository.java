package com.bsuir.WarehouseManagementSystem.repository;

import com.bsuir.WarehouseManagementSystem.model.Box;
import com.bsuir.WarehouseManagementSystem.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BoxRepository extends CrudRepository<Box, Long> {
    List<Box> findAll();
    List<Box> getBoxesByProduct(Product product);

    @Query(value = "SELECT position_id AS positionId, COUNT(position_id) AS boxesAmount FROM Boxes WHERE product_id = :product_id GROUP BY position_id", nativeQuery = true)
    List<BoxGetters> getBoxesAndPositionId(@Param("product_id") Long productId);
}
