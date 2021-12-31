package com.klu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.klu.model.AddCourse;
@Repository
public interface StudentCourseRepository extends JpaRepository<AddCourse, Long>{
		//Custom query
		 @Query(value = "select * from addcourse s where s.student_id like %:keyword%" , nativeQuery = true)
		 List<AddCourse> findByKeyword(@Param("keyword") String keyword);

}
