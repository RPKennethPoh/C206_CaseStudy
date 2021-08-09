/*
 * I declare that this code was written by me. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Kenneth Poh
 * Student ID: 20040654
 * Class: W67L
 * Date/Time created: Tuesday 10-08-2021 00:08
 */

public class Coordinator extends Account{
	
	private String password;

	public Coordinator(String accountId, int accountType, String password) {
		super(accountId, accountType);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
