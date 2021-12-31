package com.klu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.klu.model.AddGrade;
import com.klu.model.Employee;
import com.klu.repository.AddGradeRepository;

@Service
public class AddGradeServiceImpl implements AddGradeService {

    @Autowired
    private AddGradeRepository employeeRepository;

    @Override
    public List < AddGrade > getAllAddGrades() {
        return employeeRepository.findAll();
    }
    @Override
    public void saveAddGrade(AddGrade employee) {
        this.employeeRepository.save(employee);
    }
    
    @Override
    public AddGrade getAddGradeById(long id) {
        Optional < AddGrade > optional = employeeRepository.findById(id);
        AddGrade employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Student Grade not found for id :: " + id);
        }
        return employee;
    }
    
    @Override
    public void deleteGradeById(long id) {
     this.employeeRepository.deleteById(id);
    }
    
    
    @Override
    public Page < AddGrade > findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
            Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.employeeRepository.findAll(pageable);
    }
}

