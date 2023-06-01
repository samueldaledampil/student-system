package com.samueldaledampil.student.system.service;

import com.samueldaledampil.student.system.model.Student;
import com.samueldaledampil.student.system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> listAllStudents(){
        return repo.findAll();
    }

    public Student getStudent(long id){
        return repo.findById(id).get();
    }

    public void saveStudent(Student student) {
        repo.save(student);
    }

    public Student updateStudent(Student student, long id){

        Student std = repo.findById(id).get();

        if(Objects.nonNull(student.getFirstName()) &&
                !"".equalsIgnoreCase(student.getFirstName())){
            std.setFirstName(student.getFirstName());
        }

        if(Objects.nonNull(student.getLastName()) &&
                !"".equalsIgnoreCase(student.getLastName())){
            std.setLastName(student.getLastName());
        }

        if(Objects.nonNull(student.getAddress()) &&
                !"".equalsIgnoreCase(student.getAddress())){
            std.setAddress(student.getAddress());
        }

        return repo.save(std);
    }

    public void delete(long id){
        repo.deleteById(id);
    }
}
