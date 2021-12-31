package com.klu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addgrade")
public class AddGrade {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "stu_id")
    private String stuId;
	
	@Column(name = "acy")
    private String acy;
	
	@Column(name = "sem")
    private String sem;
	
	@Column(name = "offering_year")
    private String offeringYear;
	
	@Column(name = "course_code")
    private String courseCode;
	
	@Column(name = "course_name")
    private String courseName;
	
	//@Column(name = "pro_Status")
    //private String proStatus;
	
	@Column(name = "credits")
    private int credits;
	
	@Column(name = "internal_marks")
    private int internalMarks;
	
	@Column(name = "exLabMarks")
    private int exLabMarks;
	
	@Column(name = "ex_theory_marks")
    private int exTheoryMarks;
	
	/*@Column(name = "externalMarks")
    private int externalMarks;
	*/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getAcy() {
		return acy;
	}

	public void setAcy(String acy) {
		this.acy = acy;
	}

	public String getSem() {
		return sem;
	}

	public void setSem(String sem) {
		this.sem = sem;
	}

	public String getOfferingYear() {
		return offeringYear;
	}

	public void setOfferingYear(String offeringYear) {
		this.offeringYear = offeringYear;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getProStatus() {
		int tm=internalMarks+(exLabMarks+exTheoryMarks);
		String proStatus;
		if(tm>=60)
			proStatus= "P";
		else
			proStatus="NP";
		return proStatus;

	}

	/*public void setProStatus(String proStatus) {
		this.proStatus = proStatus;
	}*/

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getInternalMarks() {
		return internalMarks;
	}

	public void setInternalMarks(int internalMarks) {
		this.internalMarks = internalMarks;
	}

	public int getExternalMarks() {
		int externalMarks=exLabMarks+exTheoryMarks;
		return externalMarks;
	}

	/*public void setExternalMarks(int externalMarks) {
		this.externalMarks = externalMarks;
	}*/

	public int getTotalMarks() {
		int totalMarks=internalMarks+(exLabMarks+exTheoryMarks);
		return totalMarks;
	}

	/*public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}*/

	public String getGrade() {
		int tm=internalMarks+(exLabMarks+exTheoryMarks);
		String grade;
		if(tm>=90)
			grade= "O";
		else if((tm>=80) && (tm<90))
			grade= "A+";
		else if((tm>=70) && (tm<80))
			grade= "A";
		else if((tm>=60) && (tm<70))
			grade= "B";
		else
			grade="F";	
		return grade;
			
	}

	/*public void setGrade(String grade) {
		this.grade = grade;
	}*/

	public int getGradePoint() {
		int tm=internalMarks+(exLabMarks+exTheoryMarks);
		int gradePoint;
		if(tm>=90)
			gradePoint= 10;
		else if((tm>=80) && (tm<90))
			gradePoint= 9;
		else if((tm>=70) && (tm<80))
			gradePoint= 8;
		else if((tm>=60) && (tm<70))
			gradePoint= 7;
		else 
			gradePoint=-1;
		return gradePoint;
	}

	/*public void setGradePoint(int gradePoint) {
		this.gradePoint = gradePoint;
	}
*/
	public int getExLabMarks() {
		return exLabMarks;
	}

	public void setExLabMarks(int exLabMarks) {
		this.exLabMarks = exLabMarks;
	}

	public int getExTheoryMarks() {
		return exTheoryMarks;
	}

	public void setExTheoryMarks(int exTheoryMarks) {
		this.exTheoryMarks = exTheoryMarks;
	}

	/*@Column(name = "totalMarks")
    private int totalMarks;
	
	@Column(name = "grade")
    private String grade;
	
	@Column(name = "gradePoint")
    private int gradePoint;*/
	
}
