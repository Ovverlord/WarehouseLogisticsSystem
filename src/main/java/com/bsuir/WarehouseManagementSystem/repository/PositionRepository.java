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



    @Query(nativeQuery = true,value = "SELECT id FROM Positions WHERE fullness!=capacity ORDER BY fullness DESC, id ASC")
    List<Long> getUncompletedPositionId();

//    @Query(value = "UPDATE Positions SET capacity = :capacity",nativeQuery = true)
//    void updatePositionCapacity(@Param("capacity") Integer capacity);
}
