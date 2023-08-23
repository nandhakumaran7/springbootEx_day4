package com.classwork4.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.classwork4.demo.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{

}
