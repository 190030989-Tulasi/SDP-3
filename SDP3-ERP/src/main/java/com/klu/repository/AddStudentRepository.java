package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.model.AddStudent;

@Repository
public interface AddStudentRepository extends JpaRepository<AddStudent, Long>{

}
