package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.AddCourse;
import com.klu.repository.StudentCourseRepository;
@Service
public class StudentCourseService {
	@Autowired
	 private StudentCourseRepository repository;
	 public List<AddCourse> getByKeyword(String keyword){
	  return repository.findByKeyword(keyword);
	 }
	 
}
