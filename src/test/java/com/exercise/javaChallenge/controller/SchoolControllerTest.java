package com.exercise.javaChallenge.controller;

import com.exercise.javaChallenge.model.Student;
import com.exercise.javaChallenge.service.SchoolService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchoolControllerTest {
    private final static Logger LOG = LoggerFactory.getLogger(SchoolControllerTest.class);
    @Mock
    private SchoolService schoolServiceMock;

    @InjectMocks
    private SchoolController schoolController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddStudent() {
        Student student = new Student();
        student.setName("Student 1");
        schoolController.addStudent(student);
    }

    @Test
    public void testGetSortedRoster() {
        schoolController.getSortedRoster();
    }
}
