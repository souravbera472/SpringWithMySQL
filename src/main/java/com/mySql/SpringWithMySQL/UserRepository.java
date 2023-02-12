package com.mySql.SpringWithMySQL;

import com.mySql.SpringWithMySQL.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Student, String> {
}