package com.learnSpring.springDataJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnSpring.springDataJPA.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
