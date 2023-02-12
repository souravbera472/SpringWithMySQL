package com.mySql.SpringWithMySQL.StudentRepo;

import com.mySql.SpringWithMySQL.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.Document;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping
public class MainControl {
    @Autowired
    private StudentRepository studentRepository;


    @PostMapping("/add")
    ResponseEntity<String> addData(@RequestParam String name, @RequestParam String address) {
        Student student = new Student();

        try {
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            student.setId(uuidAsString);
            student.setName(name);
            student.setAddress(address);
            studentRepository.save(student);
            return ResponseEntity.status(HttpStatus.CREATED).body("Data added successfully");
        } catch (Exception e) {
            System.err.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data not added successfully");

        }
    }

    @GetMapping("/get")
    ResponseEntity<List<Student>> getData(){
        List<Student> allStudent = studentRepository.findAllStudent();
        return ResponseEntity.status(HttpStatus.OK).body(allStudent);
    }
}
