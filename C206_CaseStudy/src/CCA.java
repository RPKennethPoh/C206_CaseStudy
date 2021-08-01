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
	private int ccaId, ccaSize;
	private String ccaTitle, ccaDesc, ccaDay, ccaTime, ccaVenue, ccaInstructor;
	
	public CCA(int catId, String catName, int ccaId, String ccaTitle,
			String ccaDesc, int ccaSize, String ccaDay, String ccaTime,
			String ccaVenue, String ccaInstructor) {
		
		super(catId, catName);
		this.ccaId = ccaId;
		this.ccaTitle = ccaTitle;
		this.ccaDesc = ccaDesc;
		this.ccaSize = ccaSize;
		this.ccaDay = ccaDay;
		this.ccaTime = ccaTime;
		this.ccaVenue = ccaVenue;
		this.ccaInstructor = ccaInstructor;
	}

	public int getCcaId() {
		return ccaId;
	}

	public void setCcaId(int ccaId) {
		this.ccaId = ccaId;
	}

	public int getCcaSize() {
		return ccaSize;
	}

	public void setCcaSize(int ccaSize) {
		this.ccaSize = ccaSize;
	}

	public String getCcaTitle() {
		return ccaTitle;
	}

	public void setCcaName(String ccaTitle) {
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
	
	
}
