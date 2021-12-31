package com.klu.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.klu.model.AddGrade;
import com.klu.model.Employee;

public interface AddGradeService {
 List<AddGrade> getAllAddGrades();
 void saveAddGrade(AddGrade employee);
 AddGrade getAddGradeById(long id);
 void deleteGradeById(long id);
 Page<AddGrade> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}

