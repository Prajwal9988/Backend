package com.kinara.repository;

import com.kinara.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepo extends JpaRepository<ClassRoom, Long> {
    public ClassRoom findByName(String name);
}
