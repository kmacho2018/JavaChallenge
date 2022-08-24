package com.exercise.javaChallenge.controller;

import com.exercise.javaChallenge.model.Roster;
import com.exercise.javaChallenge.model.Student;
import com.exercise.javaChallenge.service.SchoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {
    private final static Logger LOG = LoggerFactory.getLogger(SchoolController.class);
    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/school/addStudent")
    public String addStudent(@RequestBody Student student) {
        LOG.info("Student :: Student Name {}", student.getName());
        schoolService.addStudent(student);
        return "Student with Name:" + student.getName() + " has been Added.";
    }
    @GetMapping("/school/getSortedRoster")
    public List<Roster> getSortedRoster() {
        return schoolService.getSortedRoster();
    }
}
