package com.klu.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.klu.model.AddStudent;

public interface AddStudentService {
 List<AddStudent> getAllStudents();
 void saveStudent(AddStudent student);
 AddStudent getStudentById(long id);
 void deleteStudentById(long id);
 Page<AddStudent> findPaginated(int pageNo, int pageSize);
}
