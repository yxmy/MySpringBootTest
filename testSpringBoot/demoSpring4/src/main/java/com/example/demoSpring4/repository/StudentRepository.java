package com.example.demoSpring4.repository;

import com.example.demoSpring4.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 2018/6/11.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
