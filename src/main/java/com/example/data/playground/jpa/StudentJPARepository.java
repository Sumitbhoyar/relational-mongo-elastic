package com.example.data.playground.jpa;

import com.example.data.playground.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentJPARepository extends CrudRepository<Student, Long> {
}
