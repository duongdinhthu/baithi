package com.project.baithi.controller;

import com.project.baithi.entity.Student;
import com.project.baithi.repository.StudentRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    StudentRepository studentRepository;

    @PostMapping("/student/add")
    public String addStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/students";
    }

}
