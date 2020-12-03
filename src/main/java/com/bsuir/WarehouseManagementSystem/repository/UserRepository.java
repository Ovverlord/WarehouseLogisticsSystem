package com.bsuir.WarehouseManagementSystem.repository;

import com.bsuir.WarehouseManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
