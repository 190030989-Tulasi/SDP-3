package com.klu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.klu.model.AddStudent;
import com.klu.repository.AddStudentRepository;

@Service
public class AddStudentServiceImpl implements AddStudentService {

    @Autowired
    private AddStudentRepository addstudentRepository;

    @Override
    public List < AddStudent > getAllStudents() {
        return addstudentRepository.findAll();
    }
    @Override
    public void saveStudent(AddStudent student) {
        this.addstudentRepository.save(student);
    }
    
    @Override
    public AddStudent getStudentById(long id) {
        Optional < AddStudent > optional = addstudentRepository.findById(id);
        AddStudent student = null;
        if (optional.isPresent()) {
            student = optional.get();
        } else {
            throw new RuntimeException(" Student not found for id :: " + id);
        }
        return student;
    }
    
    @Override
    public void deleteStudentById(long id) {
     this.addstudentRepository.deleteById(id);
    }
    
    @Override
    public Page<AddStudent> findPaginated(int pageNo, int pageSize) {
     Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
     return this.addstudentRepository.findAll(pageable);
    }
}

