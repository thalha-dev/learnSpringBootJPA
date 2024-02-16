package com.learnSpring.springDataJPA.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learnSpring.springDataJPA.entity.Course;

@SpringBootTest
public class CourseRepositoryTest {
  @Autowired
  private CourseRepository courseRepository;

  @Test
  public void printCourses() {
    List<Course> courses = courseRepository.findAll();
    System.out.println("\n\ncorses ==> " + courses + "\n\n");
  }

}
