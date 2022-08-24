package com.exercise.javaChallenge.service;

import com.exercise.javaChallenge.dao.repository.StudentRepository;
import com.exercise.javaChallenge.model.Roster;
import com.exercise.javaChallenge.model.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

public class SchoolServiceTest {
    @Mock
    private StudentRepository studentRepositoryMock;

    @InjectMocks
    private SchoolService schoolService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddStudent() {
        Student student = new Student();
        student.setName("Student 1");
        student.setGrade(1);
        Mockito.when(studentRepositoryMock.save(Mockito.any(Student.class))).thenReturn(student);
        Long studentId = schoolService.addStudent(student);
        Assert.assertEquals(1, studentId.longValue());
    }

    @Test
    public void testGetSortedRoster() {
        List<Roster> roster = null;
        roster = schoolService.getSortedRoster();
        Assert.assertNotNull(roster);
    }
}
