package com.bsuir.WarehouseManagementSystem.repository;

import com.bsuir.WarehouseManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
    List<User> findAll();

    User findByActivationCode(String code);
}
