package com.klu.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.klu.model.AddCourse;

public interface AddCourseService {
	List<AddCourse> getAllCourses();
	void saveCourse(AddCourse addcourse);
	AddCourse getCourseById(long id);
	void deleteCourseById(long id);
	Page<AddCourse> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
