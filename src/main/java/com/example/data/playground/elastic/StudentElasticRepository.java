package com.example.data.playground.elastic;

import com.example.data.playground.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentElasticRepository extends CrudRepository<Student, Long> {
}
