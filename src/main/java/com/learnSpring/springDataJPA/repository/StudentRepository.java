package com.learnSpring.springDataJPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learnSpring.springDataJPA.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  public List<Student> findByFirstName(String firstName);

  public List<Student> findByFirstNameContaining(String name);

  public List<Student> findByLastNameNotNull();

  public List<Student> findByGuardianName(String firstName);

  Student findByFirstNameAndLastName(String firstName, String lastName);

  // JQQL
  @Query("select s from Student s where s.emailId = ?1")
  Student getStudentByEmailAddress(String EmailId);

  // JPQL
  @Query("select s.firstName from Student s where s.emailId = ?1")
  String getStudentFirstNameByEmailAddress(String emailId);

  // NATIVE QUERY
  @Query(value = "select * from tbl_student s where s.email_address = ?1", nativeQuery = true)
  Student getStudentByEmailAddressNative(String emailId);

  // NATIVE QUERY WITH NAMED PARAMERTER
  @Query(value = "select * from tbl_student s where s.email_address = :emailId", nativeQuery = true)
  Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

  @Modifying
  @Transactional
  @Query(value = "update tbl_student set first_name = ?1 where email_address = ?2", nativeQuery = true)
  int updateStudentNameByEmailId(String firstName, String emailId);

}
