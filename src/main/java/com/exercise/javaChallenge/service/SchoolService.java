package com.exercise.javaChallenge.service;

import com.exercise.javaChallenge.dao.repository.StudentRepository;
import com.exercise.javaChallenge.model.Roster;
import com.exercise.javaChallenge.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
public class SchoolService {
    private final static Logger LOG = LoggerFactory.getLogger(SchoolService.class);
    private StudentRepository studentRepository;

    @Autowired
    public SchoolService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Long addStudent(Student student) {
        student = studentRepository.saveAndFlush(student);
        LOG.info("Student {} Successfully added", student.getId());
        return student.getId();
    }

    public List<Roster> getSortedRoster() {
        List<Student> studentList = studentRepository.findAll();
        Map<Integer, List<Student>> postsPerType = studentList.stream()
                .collect(groupingBy(Student::getGrade));

        List<Roster> rosterResult = new ArrayList<Roster>();

        for (Map.Entry<Integer, List<Student>> entry : postsPerType.entrySet()) {
            Roster roster = new Roster();
            roster.setGrade(entry.getKey());
            List<String> students = new ArrayList<>();
            for (Student name : entry.getValue()) {
                students.add(name.getName());
            }
            roster.setStudents(students);
            rosterResult.add(roster);
        }
        return rosterResult;
    }
}

