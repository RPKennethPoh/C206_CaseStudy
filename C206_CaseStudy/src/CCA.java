/*
 * I declare that this code was written by me. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Kenneth Poh
 * Student ID: 20040654
 * Class: W67L
 * Date/Time created: Sunday 01-08-2021 23:17
 */

public class CCA extends Category {
	private int ccaId;
	private String ccaTitle, ccaDesc, ccaDay, ccaTime, ccaVenue, ccaInstructor;
	private Student[] ccaStudentsArray;
	
	public CCA(int catId, String catName, int ccaId, String ccaTitle,
			String ccaDesc, int ccaSize, String ccaDay, String ccaTime,
			String ccaVenue, String ccaInstructor) {
		
		super(catId, catName);
		this.ccaId = ccaId;
		this.ccaTitle = ccaTitle;
		this.ccaDesc = ccaDesc;
		this.ccaDay = ccaDay;
		this.ccaTime = ccaTime;
		this.ccaVenue = ccaVenue;
		this.ccaInstructor = ccaInstructor;
		this.ccaStudentsArray = new Student[ccaSize];
	}

	public int getCcaId() {
		return ccaId;
	}

	public void setCcaId(int ccaId) {
		this.ccaId = ccaId;
	}

	public int getCcaSize() {
		return ccaStudentsArray.length;
	}

	public void setCcaSize(int ccaSize) {
		ccaStudentsArray = new Student[ccaSize];
	}

	public String getCcaTitle() {
		return ccaTitle;
	}
	
	public void setCcaTitle(String ccaTitle) {
		this.ccaTitle = ccaTitle;
	}

	public String getCcaDesc() {
		return ccaDesc;
	}

	public void setCcaDesc(String ccaDesc) {
		this.ccaDesc = ccaDesc;
	}

	public String getCcaDay() {
		return ccaDay;
	}

	public void setCcaDay(String ccaDay) {
		this.ccaDay = ccaDay;
	}

	public String getCcaTime() {
		return ccaTime;
	}

	public void setCcaTime(String ccaTime) {
		this.ccaTime = ccaTime;
	}

	public String getCcaVenue() {
		return ccaVenue;
	}

	public void setCcaVenue(String ccaVenue) {
		this.ccaVenue = ccaVenue;
	}

	public String getCcaInstructor() {
		return ccaInstructor;
	}

	public void setCcaInstructor(String ccaInstructor) {
		this.ccaInstructor = ccaInstructor;
	}

	public Student[] getCcaArray() {
		return ccaStudentsArray;
	}

	public void setCcaArray(Student[] ccaArray) {
		this.ccaStudentsArray = ccaArray;
	}
	
}
