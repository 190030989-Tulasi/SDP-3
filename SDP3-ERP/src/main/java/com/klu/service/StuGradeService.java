package com.klu.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klu.model.AddGrade;
import com.klu.repository.StuGradeRepository;

@Service
public class StuGradeService {
	@Autowired
	 private StuGradeRepository repository;
	 public List<AddGrade> getByKeyword(String keyword){
	  return repository.findByKeyword(keyword);
	 }
}
