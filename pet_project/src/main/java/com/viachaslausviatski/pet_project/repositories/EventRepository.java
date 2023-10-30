package com.viachaslausviatski.pet_project.repositories;

import com.viachaslausviatski.pet_project.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByDescription(String description);
}
