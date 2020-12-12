package com.bsuir.WarehouseManagementSystem.repository;

import com.bsuir.WarehouseManagementSystem.model.Position;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long> {
    Long getPositionById(Long id);

    @Query(value = "SELECT SUM(capacity) FROM Boxes",nativeQuery = true)
    Integer getTotalCapacity();

    @Query(value = "SELECT SUM(fullness) FROM Boxes",nativeQuery = true)
    Integer getTotalFullness();

    @Query(nativeQuery = true,value = "SELECT id FROM positions WHERE fullness!=capacity ORDER BY fullness DESC, id ASC")
    List<Long> getUncompletedPositionId();
}
