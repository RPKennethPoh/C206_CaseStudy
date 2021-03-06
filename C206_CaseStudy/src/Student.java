/*
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Crystal Koh
 * Student ID: 20019791
 * Class: C208-2B4B-E37A-FF
 * Date/Time created: Sunday 01-08-2021 23:42
 */

/**
 *
 */
public class Student {
	private int studentId, studentAge;
	private String studentName, studentClass, studentGrade;
	
	public Student(int studentId, int studentAge, String studentName, String studentClass, String studentGrade) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentClass = studentClass;
		this.studentGrade = studentGrade;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}
	
}