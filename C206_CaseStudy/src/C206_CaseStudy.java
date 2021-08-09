import java.util.ArrayList;
import java.util.Random;

public class C206_CaseStudy {
	
	private static int accountType;
	private static Student student;

	public static void main(String[] args) {
		ArrayList<Category> categoryArrList = new ArrayList<Category>();
		ArrayList<CCA> ccaList = new ArrayList<CCA>();
		ArrayList<Student> studentArrList = new ArrayList<Student>();
		ArrayList<Account> accountArrList = new ArrayList<Account>();
		ArrayList<Coordinator> coordinatorList = new ArrayList<Coordinator>();
		ArrayList<Parent> parentList = new ArrayList<Parent>();
		
		int mainOption = 0;
		while(mainOption != 3) {
			
			mainMenu();
			mainOption = Helper.readInt("Enter your choice > ");
			
			if(mainOption == 1) { //Login
				int loginOption = 0;
				loginMenu();
				loginOption = Helper.readInt("Enter your choice > ");
				boolean login = false;
				if(loginOption == 1) {
					login = doParentLogin(parentList);
				} else if (loginOption == 2) {
					login = doCoordinatorLogin(coordinatorList);
				} else {
					System.out.println("Invalid option");
				}
				
				if(!login) {
					System.out.println("Invalid login credentials");
				} else {
					int subOption = 0;
					if(accountType == 2) {
						adminMenu();
						subOption = Helper.readInt("Enter your choice > ");
						switch(subOption) {
						case 1:
							//add student
							Student newStudent = addStudent(studentArrList);
							studentArrList = doAddStudent(newStudent, studentArrList); 
							break;
						case 2:
							//view student
							viewAllStudent(studentArrList);
							break;
						case 3:
							//delete student
							int deleteStudentId = deleteStudent(studentArrList);
							studentArrList = doDeleteStudent(deleteStudentId, studentArrList);
							break;
							
						case 4:
							//add cca
							CCA newCca = addCCA(categoryArrList, ccaList);
							doAddCCA(ccaList, newCca);
							break;
						case 5:
							//view cca
							viewAllCCA(ccaList);
							break;
						case 6:
							//delete cca
							CCA delCca = deleteCCA(ccaList);
							doDeleteCCA(ccaList, delCca);
							break;
						case 7: 
							//add category
							Category newCategory = addCategory(categoryArrList);
							categoryArrList = doAddCategory(newCategory, categoryArrList);
							break;
						case 8: 
							//view category
							viewAllCategories(categoryArrList);
							break;
						case 9: 
							//delete category
							int editCatId = deleteCategory(categoryArrList);
							categoryArrList = doDeleteCategory(editCatId, categoryArrList);
							break;
						case 10: 
							//add parent acc
							Parent addParent = inputAccount(parentList, studentArrList);
							addAccount(parentList, addParent);
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
							System.out.println("Invalid option, please try again.");
						}
					} else {
						parentMenu();
						subOption = Helper.readInt("Enter your choice > ");
						switch(subOption) {
						case 1:
							//view category
							break;
						case 2:
							//view cca
							viewAllCCA(ccaList);
							break;
						case 3:
							//register for cca
							break;
						case -1:
							//exit
							break;
						default:
							//error check
							System.out.println("Invalid option, please try again.");
						}
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
	
	public static void loginMenu() {
		System.out.println("1. Login as parent");
		System.out.println("2. Login as coordinator");
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
	public static ArrayList<Student> doAddStudent(Student student, ArrayList<Student> studentArrList) {
		studentArrList.add(student);
		System.out.println("New Student added");
		return studentArrList;
	}
	//Add student
	public static Student addStudent(ArrayList<Student> studentArrList) {
		String name = Helper.readString("Enter student's name > ");
		int id = Helper.readInt("Enter student's ID > ");
		int age = Helper.readInt("Enter student's age > ");
		String studentClass = Helper.readString("Enter student's class > ");
		String grade = Helper.readString("Enter student's grade > ");
		Student student = new Student(id, age, name, studentClass, grade);
		return student;
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
	private static ArrayList<Student> doDeleteStudent(int id, ArrayList<Student> studentArrList) {
		
		studentArrList.remove(id);
		System.out.println("Student removed!");
		return studentArrList;
		
	}

	private static int deleteStudent(ArrayList<Student> studentArrList) {
		viewAllStudent(studentArrList);
		int id = -1;
		
		boolean found = false;
		
		while (!found || id != 0) {
			id = Helper.readInt("Enter Student ID to delete, or enter 0 to cancel > ");
			
			if (id != 0) {
				for (int i = 0; i < studentArrList.size(); i++) {
					if (studentArrList.get(i).getStudentId() == id) {
						found = true;
					}
				}
			}
		}
		return id;
		
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
	public static CCA deleteCCA(ArrayList<CCA> ccaList) {
		setHeader("Delete CCA");
		viewAllCCA(ccaList);
		int id = Helper.readInt("Enter ID of CCA you want to delete > ");
		CCA cca = null;
		for(int i = 0; i < ccaList.size(); i++) {
			if(id == ccaList.get(i).getCcaId()) {
				cca = ccaList.get(i);
				break;
			}
		}
		return cca;
	}
	
	//Delete CCA
	public static void doDeleteCCA(ArrayList<CCA> ccaList, CCA cca) {
		if(cca != null) {
			ccaList.remove(cca);
			System.out.println("CCA successfully deleted");
		} else {
			System.out.println("Failed to delete CCA.");
		}
	}
	
	////////member3////////
	// CATEGORY METHODS
	//Add category
	private static ArrayList<Category> doAddCategory(Category newCategory, ArrayList<Category> categoryArrList) {
		categoryArrList.add(newCategory);
		System.out.println("New Category added");
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
		System.out.println("Category Deleted!");
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
	
	////////member4(wei Hong)////////
	//input account	
	public static Parent inputAccount(ArrayList<Parent> parentList, ArrayList<Student> studentList) {
		Parent parent = null;
		int studentId = Helper.readInt("Enter Student Id > ");
		String studentName = Helper.readString("Enter your child's name > ");
		String studentGrade = Helper.readString("Enter your child's grade > ");
		String studentClass = Helper.readString("Enter the class your child is in > ");
		String studentTeacher = Helper.readString("Enter your child's class teacher > ");
		Student student;
		for(int i = 0; i < studentList.size(); i++) {
			if(studentId == studentList.get(i).getStudentId() && studentName.equals(studentList.get(i).getStudentName()) && studentClass.equals(studentList.get(i).getStudentClass()) && studentGrade.equals(studentList.get(i).getStudentGrade())) {
				student = studentList.get(i);
				String accName = Helper.readString("Enter your name > ");
				String accEmail = Helper.readString("Enter your email > ");
				String accContactNo = Helper.readString("Enter your contact number > ");
				String accId = "";
				Random rnd = new Random();
				while (accId.length() < 8) {
					int randNum = rnd.nextInt(10);
					accId += randNum;
		        }
				// String accountId, int accountType, String parentName, String parentEmail, String parentContact, Student student
				parent = new Parent(accId, 1, accName, accEmail, accContactNo, student);
				break;
			}
		}
		return parent;
	}
	
	//Add Account
	public static void addAccount(ArrayList<Parent> parentList, Parent parent) {
		if(parent != null) {
			parentList.add(parent);
			System.out.println("New Parent Account added");
		} else {
			System.out.println("Parent account not added, student not found.");
		}
		
	}
	
	//View Parent
	public static String viewAllAccounts(ArrayList<Parent> parentList) {
		String view = String.format("%-10s %-50s", "Account ID", "Parent Name");
		for(int i = 0; i < parentList.size(); i++) {
			view += String.format("%-10s %-50s", parentList.get(i).getAccountId(), parentList.get(i).getParentName());
		}
		return view;
	}
	
	//Delete Account
	public static Parent deleteAccount(ArrayList<Parent> parentList) {
		String accountId = Helper.readString("Enter account ID > ");
		Parent parent = null;
		for(int i = 0; i < parentList.size(); i++) {
			if(parentList.get(i).getAccountId().equals(accountId)) {
				parent = parentList.get(i);
				break;
			}
		}
		return parent;
	}
	
	public static void doDeleteAccount(ArrayList<Parent> parentList, Parent parent) {
		if(parent != null) {
			parentList.remove(parent);
			System.out.println("Account successfully deleted");
		} else {
			System.out.println("Account not deleted");
		}
	}
	
	
	//member5//
	
	//login to system student id and CCA registration ID//
//	public static int loginToSystem(ArrayList<Account> accountArrList) {
//		setHeader("Login");
//		boolean isTrue = false;
//		int studentId = Helper.readInt("Enter your student ID > ");
//		int accId = Helper.readInt("Enter CCA registration ID > ");
//		for(int i = 0; i < accountArrList.size(); i++) {
//			if (accountArrList.get(i).getStudentId() == studentId && accountArrList.get(i).getAccId() == accId) {
//				isTrue = true;
//				break;
//			}
//		}
//		int type = 0;
//		if (isTrue) {
//			if (studentId == 87654321 && accId == 87654321) {
//				type = 1; //admin
//			}
//			else {
//				type = 2; //parent
//			}
//		}
//		return type;
//	}
	
	public static boolean doCoordinatorLogin(ArrayList<Coordinator> coordinatorList) {
		String accId = Helper.readString("Enter Account ID > ");
		String password = Helper.readString("Enter password > ");
		boolean found = false;
		for(int i = 0; i< coordinatorList.size(); i++) {
			if(coordinatorList.get(i).getAccountId().equals(accId) && coordinatorList.get(i).getPassword().equals(password)) {
				found = true;
				accountType = coordinatorList.get(i).getAccountType();
				break;
			}
		}
		return found;
	}
	
	public static boolean doParentLogin(ArrayList<Parent> parentList) {
		String accId = Helper.readString("Enter Account ID > ");
		int studentId = Helper.readInt("Enter student ID > ");
		boolean found = false;
		for(int i = 0; i< parentList.size(); i++) {
			if(parentList.get(i).getAccountId().equals(accId) && parentList.get(i).getStudent().getStudentId() == studentId) {
				found = true;
				accountType = parentList.get(i).getAccountType();
				student = parentList.get(i).getStudent();
				break;
			}
		}
		return found;
	}

			
	
	//add student for CCA//
	public static void addStudentForCCA(ArrayList<Student> studentArrList, ArrayList<CCA> ccaList) {
		setHeader("Register for CCA");
		int studentId = Helper.readInt("Enter your student ID > ");
		String studentName = Helper.readString("Enter your full name > ");
		int ccaId = Helper.readInt("Enter a CCA > ");
		for (int i = 0; i < ccaList.size(); i ++) {
			if (ccaList.get(i).getCcaId() != ccaId) {
				if (studentArrList.get(i).getStudentId() != studentId) {
					if (studentArrList.get(i).getStudentName() != studentName) {
						System.out.println("Student does not exist!");
					}
				}
			}
			else {
				System.out.println("Student already exist!");
			}
		}

	}
	
	//View students registered for a CCA//
	private static String viewStudentsRegistered(ArrayList<Student> studentArrList, ArrayList<CCA> ccaList) {
		setHeader("Viewing Registered Students");
		String listofStudents = String.format("-10s -20%s -30%s \n", "Student ID", "Student Name", "CCA name");
		for(int i = 0; i < studentArrList.size(); i++) {
			listofStudents += String.format("-10%s -15%s %-20%s", studentArrList.get(i).getStudentId(), studentArrList.get(i).getStudentName(), ccaList.get(i).getCcaTitle());
		}
		return listofStudents;
	}
}
