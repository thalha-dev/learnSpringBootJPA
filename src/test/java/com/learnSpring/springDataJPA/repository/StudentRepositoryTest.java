package com.learnSpring.springDataJPA.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.learnSpring.springDataJPA.entity.Guardian;
import com.learnSpring.springDataJPA.entity.Student;
import java.util.List;

@SpringBootTest
// @DataJpaTest
public class StudentRepositoryTest {
  @Autowired
  private StudentRepository studentRepository;

  @Test
  public void saveStudent() {
    Student student = Student.builder()
        .emailId("william@gmail.com")
        .firstName("William")
        .lastName("Jones")
        .build();

    studentRepository.save(student);
  }

  @Test
  public void saveStudentWithGuardian() {
    Guardian guardian = Guardian.builder()
        .email("park@gmail.com")
        .name("park")
        .mobile("8734124919")
        .build();

    Student student = Student.builder()
        .firstName("sam")
        .emailId("sam@gmail.com")
        .guardian(guardian)
        .build();

    studentRepository.save(student);
  }

  @Test
  public void printAllStudent() {
    List<Student> studentList = studentRepository.findAll();
    System.out.println("Student List = " + studentList);
  }

  @Test
  public void printStudentByFirstName() {
    List<Student> students = studentRepository.findByFirstName("sam");
    System.out.println("students ==> " + students);
  }

  @Test
  public void printStudentByFirstNameContaining() {
    List<Student> students = studentRepository.findByFirstNameContaining("Will");
    System.out.println("student firstname contains ==> " + students);
  }

  @Test
  public void printGetStudentByEmailAddress() {
    Student student = studentRepository.getStudentByEmailAddress("sam@gmail.com");
    System.out.println("student by email ==> " + student);
  }

  @Test
  public void printgetStudentFirstNameByEmailAddress() {
    String firstName = studentRepository.getStudentFirstNameByEmailAddress("sam@gmail.com");
    System.out.println("firstName = " + firstName);
  }

  @Test
  public void printGetStudentByEmailAddressNative() {
    Student student = studentRepository.getStudentByEmailAddressNative("sam@gmail.com");
    System.out.println("student by email with native query ==> " + student);
  }

  @Test
  public void updateStudentNameByEmailIdTest() {
    studentRepository.updateStudentNameByEmailId("Will", "william@gmail.com");
  }

}
