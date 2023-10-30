package com.viachaslausviatski.pet_project.entity.emums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER,ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
