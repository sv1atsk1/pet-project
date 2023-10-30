package com.viachaslausviatski.pet_project.repositories;

import com.viachaslausviatski.pet_project.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Images,Long> {
}
