package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.klu.model.AddCourse;
import com.klu.repository.AddCourseRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
@Service
public class AddCourseServiceImpl implements AddCourseService{
	@Autowired
    private AddCourseRepository addcourseRepository;

    @Override
    public List < AddCourse > getAllCourses() {
        return addcourseRepository.findAll();
    }
    @Override
    public void saveCourse(AddCourse course) {
        this.addcourseRepository.save(course);
    }
    @Override
    public AddCourse getCourseById(long id) {
        java.util.Optional<AddCourse> optional = addcourseRepository.findById(id);
        AddCourse course = null;
        if (optional.isPresent()) {
            course = optional.get();
        } else {
            throw new RuntimeException(" Course not found for id :: " + id);
        }
        return course;
    }
    @Override
    public void deleteCourseById(long id) {
        this.addcourseRepository.deleteById(id);
    }
    
    @Override
    public Page<AddCourse> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
     Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
      Sort.by(sortField).descending();
     
     Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
     return this.addcourseRepository.findAll(pageable);
    }
}
