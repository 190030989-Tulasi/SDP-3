package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klu.model.AddCourse;

@Repository
public interface AddCourseRepository extends JpaRepository<AddCourse, Long>{

}