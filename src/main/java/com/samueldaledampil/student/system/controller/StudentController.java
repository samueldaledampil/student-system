package com.samueldaledampil.student.system.controller;

import com.samueldaledampil.student.system.model.Student;
import com.samueldaledampil.student.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/")
    public List<Student> showAllStudents(){
        return service.listAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable(name = "id") long id){
        return service.getStudent(id);
    }

    @PostMapping("/add")
    public String add(@RequestBody Student student){
        service.saveStudent(student);
        return "New Student has been added";
    }

    @PutMapping("/edit/{id}")
    public Student updateStudent(@RequestBody Student newStudent, @PathVariable(name = "id") long id){
        return service.updateStudent(newStudent,id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(name = "id") int id){
        service.delete(id);
        return "Student Deleted";
    }

}
