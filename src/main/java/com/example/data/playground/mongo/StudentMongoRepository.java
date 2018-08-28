package com.example.data.playground.mongo;

import com.example.data.playground.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMongoRepository extends CrudRepository<Student, Long> {
}
