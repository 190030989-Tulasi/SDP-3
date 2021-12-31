package com.klu.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.klu.model.AddCourse;
import com.klu.model.AddGrade;
@Repository
public interface StuGradeRepository extends JpaRepository<AddGrade, Long>{
	 @Query(value = "select * from addgrade s where s.stu_id like %:keyword%" , nativeQuery = true)
	 List<AddGrade> findByKeyword(@Param("keyword") String keyword);
}
 