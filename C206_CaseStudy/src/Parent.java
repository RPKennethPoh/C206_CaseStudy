/*
 * I declare that this code was written by me. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Kenneth Poh
 * Student ID: 20040654
 * Class: W67L
 * Date/Time created: Tuesday 10-08-2021 00:02
 */

public class Parent extends Account{

	private String parentName, parentEmail, parentContact;
	private Student student;
	
	
	public Parent(String accountId, int accountType, String parentName, String parentEmail, String parentContact, Student student) {
		super(accountId, accountType);
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.parentContact = parentContact;
		this.student = student;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentEmail() {
		return parentEmail;
	}

	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}

	public String getParentContact() {
		return parentContact;
	}

	public void setParentContact(String parentContact) {
		this.parentContact = parentContact;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	
}
