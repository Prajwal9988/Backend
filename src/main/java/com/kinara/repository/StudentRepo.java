package com.kinara.repository;

import com.kinara.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s JOIN s.classRoom c WHERE s.name LIKE %:name% AND (:roll IS NULL OR CAST(s.studentId AS string) LIKE %:roll%) AND c.name LIKE %:classRoomName%")
    public Page<Student> findByClassAndNameAndRollNumber(@Param("name") String name, @Param("roll") Long roll, @Param("classRoomName") String classRoomName,  Pageable pageable);
}
