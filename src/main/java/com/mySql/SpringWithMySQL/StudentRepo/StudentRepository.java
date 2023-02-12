package com.mySql.SpringWithMySQL.StudentRepo;

import com.mySql.SpringWithMySQL.Entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,String> {
    @Query(value = "SELECT * FROM student", nativeQuery = true)
    List<Student> findAllStudent();
}
