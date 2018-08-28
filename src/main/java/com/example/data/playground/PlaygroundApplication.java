package com.example.data.playground;

import com.example.data.playground.elastic.StudentElasticRepository;
import com.example.data.playground.jpa.StudentJPARepository;
import com.example.data.playground.model.Student;
import com.example.data.playground.mongo.StudentMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.repository.CrudRepository;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
@EntityScan
public class PlaygroundApplication {


	public static void main(String[] args) throws SQLException {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(PlaygroundApplication.class, args);
        System.out.println("Testing Elastic -----");
        test(applicationContext.getBean(StudentElasticRepository.class));
        applicationContext.getBean(DataSource.class).getConnection().createStatement().execute("create table STUDENT(id Number, address varchar(50), name varchar (50), rank number)");
        System.out.println("Testing Database -----");
        test(applicationContext.getBean(StudentJPARepository.class));
        System.out.println("Testing Mongo -----");
        test(applicationContext.getBean(StudentMongoRepository.class));
    }


    private static void test(CrudRepository repository) {
        repository.save(Student.newStudent().address("Kharadi").id(1L).rank(1).name("Sumit").build());
        repository.save(Student.newStudent().address("Wagholi").id(2L).rank(6).name("Rashmi").build());
        repository.save(Student.newStudent().address("Pune").id(3L).rank(3).name("Viraj").build());
        Iterable<Student> students = repository.findAll();
        students.forEach(std -> System.out.println(std));
    }
}
