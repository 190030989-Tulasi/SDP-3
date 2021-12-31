package com.klu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addcourse")
public class AddCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "student_id")
    private String stuId;
    
    @Column(name = "year")
    private String year;
    
    public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	@Column(name = "course_code")
    private String courseCode;
    
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "course_name")
    private String courseName;

    @Column(name = "section")
    private String section;

    @Column(name = "semester")
    private String semester;
   
    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String firstName) {
        this.courseName = firstName;
    }
    public String getSection() {
        return section;
    }
    public void setSection(String lastName) {
        this.section = lastName;
    }
    public String getSemester() {
        return semester;
    }
    public void setSemester(String email) {
        this.semester = email;
    }
}