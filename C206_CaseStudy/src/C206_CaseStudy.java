import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		ArrayList<Category> categoryArrList = new ArrayList<Category>();
		ArrayList<CCA> ccaList = new ArrayList<CCA>();
		ArrayList<Student> studentArrList = new ArrayList<Student>();
		ArrayList<Account> accountArrList = new ArrayList<Account>();
		
		int mainOption = 0;
		while(mainOption != 3) {
			
			mainMenu();
			mainOption = Helper.readInt("Enter your choice > ");
			
			if(mainOption == 1) { //Login
				// Call login function
				
				// Check user input for valid/not valid, and check parent or admin
				int subOption = 0;
				while(subOption != -1) {
					if() { 
						//if admin
						adminMenu();
						subOption = Helper.readInt("Enter your choice > ");
						switch(subOption) {
						case 1:
							//add student
							break;
						case 2:
							//view student
							break;
						case 3:
							//delete student
							break;
						case 4:
							//add cca
							CCA newCCA = addCCA(categoryArrList, ccaList);
							doAddCCA(ccaList, newCCA);
							break;
						case 5:
							//view cca
							viewAllCCA(ccaList);
							break;
						case 6:
							//delete cca
							viewAllCCA(ccaList);
							
							break;
						case 7: 
							//add category
							break;
						case 8: 
							//view category
							break;
						case 9: 
							//delete category
							break;
						case 10: 
							//add parent acc
							break;
						case 11: 
							//view parent acc
							break;
						case 12: 
							//delete parent acc
							break;
						case 13: 
							//add student to cca
							break;
						case 14: 
							//view students in cca
							break;
						case -1:
							//exit
							break;
						default:
							//error check
						}
					} else if () {
						// if parent
						parentMenu();
						subOption = Helper.readInt("Enter your choice > ");
						switch(subOption) {
						case 1:
							//view category
							break;
						case 2:
							//view cca
							break;
						case 3:
							//register for cca
							break;
						case -1:
							//exit
							break;
						default:
							//error check
						}
					} else {
						// error
					}
					
				}
				
			} else if (mainOption == 2) { //Register
				//get user input
				
				//check user input
				
				//if valid, create acc
				
				//else, don't create acc and throw error message
				
			} else if (mainOption == 3) { //Exit
				System.out.println("Thank you for using our CCA Registration System! See you again soon!");
			} else { //Error
				System.out.println("Invalid option, please try again.");
			}
		}
		

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	public static void mainMenu() {
		setHeader("CCA Registration System");
		System.out.println("1. Login to account");
		System.out.println("2. Register for account");
		System.out.println("3. Exit System");
	}
	public static void adminMenu() {
		setHeader("Admin Logged In");
		System.out.println("ENTER -1 TO LOG OUT");
		System.out.println("===== STUDENT FUNCTIONS =====");
		System.out.println("1. Add Student");
		System.out.println("2. View Student");
		System.out.println("3. Delete Student");
		System.out.println("===== CCA FUNCTIONS =====");
		System.out.println("4. Add CCA");
		System.out.println("5. View All CCAs");
		System.out.println("6. Delete CCA");
		System.out.println("===== CATEGORY FUNCTIONS =====");
		System.out.println("7. Add CCA Category");
		System.out.println("8. View All CCA Categories");
		System.out.println("9. Delete CCA Category");
		System.out.println("===== PARENT ACCOUNT FUNCTIONS =====");
		System.out.println("10. Add Parent Account");
		System.out.println("11. View Registered Parent Accounts");
		System.out.println("12. Delete Parent Account");
		System.out.println("===== STUDENT CCA FUNCTIONS =====");
		System.out.println("13. Add Student to CCA");
		System.out.println("14. View Students under CCA");
		System.out.println("*** ENTER -1 TO LOG OUT ***");
	}
	
	public static void parentMenu() {
		C206_CaseStudy.setHeader("Parent Logged In");
		System.out.println("1. View All CCA Categories");
		System.out.println("2. View All CCAs");
		System.out.println("3. Register for CCAs");
		System.out.println("*** ENTER -1 TO LOG OUT ***");
	}
	
	////////member1////////
	//Input Student name
	public static Student InputStudent(ArrayList<Student> studentArrList, ArrayList<Student> studentList) {
		viewAllStudents(studentArrList);
		String name = Helper.readString("Enter student's name > ");
		int id = Helper.readInt("Enter student's ID > ");
		int age = Helper.readInt("Enter student's age > ");
		String studentClass = Helper.readString("Enter student's class > ");
		String grade = Helper.readString("Enter student's grade > ");
		double weight = Helper.readDouble("Enter student's weight > ");
		double height = Helper.readDouble("Enter student's height > ");
		Student student = new Student(id, weight, height, age, name, studentClass, grade);
		return student;
	}
	//Add student
	public static void addStudent(ArrayList<Student> studentArrList, Student student) {
		studentArrList.add(student);
		System.out.println("New Student added");
	}
	
	//View Student
	public static String viewAllStudent(ArrayList<Student> studentArrList) {
		String view = String.format("-3%s -15%s \n", "ID", "Name");
		for(int i = 0; i < studentArrList.size(); i++) {
			view += String.format("-3%d -15%s \n", studentArrList.get(i).getStudentId(), studentArrList.get(i).getStudentName());
		}
		return view;
	}
	
	//Delete Student
	public static boolean deleteStudent(ArrayList<Student> studentArrList, int id) {
		boolean delete = false;
		for(int i = 0; i < studentArrList.size(); i++) {
			if(studentArrList.get(i).getStudentId() == id) {
				studentArrList.remove(i);
				delete = true;
			}
		}
		return delete;
	}
	
	////////member2////////
	// CCA METHODS
	//addCCA to get user input for CCA
	public static CCA addCCA(ArrayList<Category> categoryArrList, ArrayList<CCA> ccaList) {
		setHeader("Add New CCA");
		viewAllCategories(categoryArrList);
		int catId = Helper.readInt("Enter CCA's category ID > ");
		boolean valid = false;
		for(int i = 0; i < categoryArrList.size(); i++) {
			if(catId == categoryArrList.get(i).getCatId()) {
				valid = true;
				break;
			}
		}
		if(valid) {
			String catName = categoryArrList.get(catId).getCatName();
			int id = (catId * 1000) + ccaList.size();
			String title = Helper.readString("Enter CCA's title > ");
			String desc = Helper.readString("Enter CCA's description > ");
			int size = Helper.readInt("Enter CCA's size > ");
			String day = Helper.readString("Enter CCA's day > ");
			String time = Helper.readString("Enter CCA's timing (start to end, in 24 hours) > ");
			String venue = Helper.readString("Enter CCA's venue > ");
			String instructor = Helper.readString("Enter CCA's instructor in-charge > ");
			CCA cca = new CCA(catId, catName, id, title, desc, size, day, time, venue, instructor);
			return cca;
		} else {
			CCA cca = new CCA(-1, "NIL", -1, "NIL", "NIL", 0, "NIL", "NIL", "NIL", "NIL");
			return cca;
		}
	}
	
	//Add CCA
	public static void doAddCCA(ArrayList<CCA> ccaList, CCA cca) {
		if(cca.getCatId() != -1) {
			ccaList.add(cca);
			System.out.println("New CCA added");
		} else {
			System.out.println("Invalid Category ID, CCA not added.");
		}
	}
	
	
	//Retrieve all CCA
	public static String retrieveAllCCA(ArrayList<CCA> ccaList) {
		
		String view = "";
		for(int i = 0; i < ccaList.size(); i++) {
			view += String.format("-3%d -15%s \n", ccaList.get(i).getCcaId(), ccaList.get(i).getCcaTitle());
		}
		return view;
	}
	
	//View all CCA
	public static void viewAllCCA(ArrayList<CCA> ccaList) {
		setHeader("View All CCA");
		String view = String.format("-3%s -15%s \n", "ID", "Title");
		view += retrieveAllCCA(ccaList);
		System.out.println(view);
	}
	
	//Delete CCA to get user input to delete CCA
	public static int deleteCCA(ArrayList<CCA> ccaList) {
		int id = Helper.readInt("Enter ID of CCA you want to delete > ");
		boolean found = false;
		for(int i = 0; i < ccaList.size(); i++) {
			if(id == ccaList.get(i).getCcaId()) {
				found = true;
				break;
			}
		}
		if(!found) {
			id = -1;
		}
		return id;
	}
	
	//Delete CCA
	public static void doDeleteCCA(ArrayList<CCA> ccaList, int id) {
		if(id != -1) {
			ccaList.remove(id);
			System.out.println("CCA deleted.");
		} else {
			System.out.println("Invalid CCA ID, CCA not deleted.");
		}
	}
	
	////////member3////////
	// CATEGORY METHODS
	//Add category
	private static ArrayList<Category> doAddCategory(Category newCategory, ArrayList<Category> categoryArrList) {
		categoryArrList.add(newCategory);
		
		return categoryArrList;
	}
	private static Category addCategory(ArrayList<Category> categoryArrList) {
		int catId = categoryArrList.size() + 1;
		String catName = Helper.readString("Enter category name > ");
		
		Category newCategory = new Category(catId, catName);
		return newCategory;
	}
	
	//View All Categories
	private static String viewAllCategories(ArrayList<Category> categoryArrList) {
		String allCategories = "";
		
		for (int i = 1; i <= categoryArrList.size(); i++) {
			allCategories += categoryArrList.get(i).getCatId() + ": " + categoryArrList.get(i).getCatName();
		}
		
		return allCategories;
	}
	
	//Remove Category
	private static ArrayList<Category> doDeleteCategory(int id, ArrayList<Category> categoryArrList) {
		
		categoryArrList.remove(id);
		
		return categoryArrList;
		
	}
	private static int deleteCategory(ArrayList<Category> categoryArrList) {
		viewAllCategories(categoryArrList);
		int id = -1;
		
		boolean found = false;
		
		while (!found || id != 0) {
			id = Helper.readInt("Enter Category ID to delete, or enter 0 to cancel > ");
			
			if (id != 0) {
				for (int i = 0; i < categoryArrList.size(); i++) {
					if (categoryArrList.get(i).getCatId() == id) {
						found = true;
					}
				}
			}
		}
		return id;
		
	}
	
	////////member4(weiHong)////////
	//input account
	public static Account inputAccount(ArrayList<Account> accountArrList) {
		int accId = Helper.readInt("Enter Account Id > ");
		int studentId = Helper.readInt("Enter Student Id > ");
		String studentName = Helper.readString("Enter your child's name > ");
		String studentGrade = Helper.readString("Enter your child's grade > ");
		String studentClass = Helper.readString("Enter the class your child is in > ");
		String studentTeacher = Helper.readString("Enter your child's class teacher > ");
		String accName = Helper.readString("Enter your name > ");
		String accEmail = Helper.readString("Enter your email > ");
		String accContactNo = Helper.readString("Enter your contact number > ");
		Account account = new Account(accId, studentId, studentName, studentGrade, studentClass, studentTeacher, accName, accEmail, accContactNo);
		return account;
		
	}
	
	//Add Account
	public static void addAccount(ArrayList<Account> accountArrList, Account account) {
		accountArrList.add(account);
		System.out.println("New Parent Account added");
	}
	
	//View Parent
	public static String viewAllAccounts(ArrayList<Account> accountArrList) {
		String viewAccounts = String.format("-3%s -15%s \n", "accId", "accName");
		for(int i = 0; i < accountArrList.size(); i++) {
			viewAccounts += String.format("-3%s -15%s \n", accountArrList.get(i).getAccId(), accountArrList.get(i).getAccName());
		}
		return viewAccounts;
	}
	//Delete Account
	public static boolean deleteAccount(ArrayList<Account> accountArrList, int accId) {
		boolean deleteAcc = false;
		for(int i = 0; i < accountArrList.size(); i++) {
			if(accountArrList.get(i).getAccId() == accId) {
				accountArrList.remove(i);
				deleteAcc = true;
			}
		}
		return deleteAcc;
	}
	
	////////member5////////
	//login to system student id and CCA registration ID//
	private void loginToSystem() {
		
		int studentId = Helper.readInt("Enter your student ID > ");
		int accId = Helper.readInt("Enter CCA registration ID > ");
		
	}
	
	//add student for CCA//
	public static void addStudentforCCA() {
		
		int studentId = Helper.readInt("Enter your student ID > ");
		int accId = Helper.readInt("Enter CCA registration ID > ");
		
	}
	
	//View students registered for a CCA//
	private static String viewAllStudents(ArrayList<Student> studentArrList) {
		String listofStudents = String.format("-20s -10%s -15%s \n", "CCA name", "ID", "Name");
		for(int i = 0; i < studentArrList.size(); i++) {
			listofStudents += String.format("-3%d -15%s \n", studentArrList.get(i).getStudentId(), studentArrList.get(i).getStudentName());
		}
		return listofStudents;
	}
}
