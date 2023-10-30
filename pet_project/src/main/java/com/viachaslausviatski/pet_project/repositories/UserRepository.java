package com.viachaslausviatski.pet_project.repositories;

import com.viachaslausviatski.pet_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
