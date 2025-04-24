package com.project.baithi.controller;

import com.project.baithi.entity.Student;
import com.project.baithi.entity.StudentScore;
import com.project.baithi.entity.Subject;
import com.project.baithi.repository.StudentRepository;
import com.project.baithi.repository.StudentScoreRepository;
import com.project.baithi.repository.SubjectRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentScoreController {
    StudentRepository studentRepo;
    SubjectRepository subjectRepo;
    StudentScoreRepository scoreRepo;
    @PostMapping("/score/add")
    public String addScore(@RequestParam int studentId, @RequestParam int subjectId,
                           @RequestParam double score1, @RequestParam double score2) {
        Student student = studentRepo.findById(studentId).orElse(null);
        Subject subject = subjectRepo.findById(subjectId).orElse(null);
        StudentScore score = new StudentScore();
        score.setStudent(student);
        score.setSubject(subject);
        score.setScore1(score1);
        score.setScore2(score2);
        scoreRepo.save(score);
        return "redirect:/scores";
    }
}
