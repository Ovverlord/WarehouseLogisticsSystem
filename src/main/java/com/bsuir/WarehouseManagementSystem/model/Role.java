package com.bsuir.WarehouseManagementSystem.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,CHECKMAN, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
