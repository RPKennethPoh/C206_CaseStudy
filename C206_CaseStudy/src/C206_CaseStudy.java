import java.util.ArrayList;
import java.util.Random;

public class C206_CaseStudy {
	
	private static int accountType;
	private static Student student;

	public static void main(String[] args) {
		ArrayList<Category> categoryArrList = new ArrayList<Category>();
		ArrayList<CCA> ccaList = new ArrayList<CCA>();
		ArrayList<Student> studentArrList = new ArrayList<Student>();
		ArrayList<Coordinator> coordinatorList = new ArrayList<Coordinator>();
		ArrayList<Parent> parentList = new ArrayList<Parent>();
		
		// Setup Category
		Category category1 = new Category(1, "Sports");
		Category category2 = new Category(2, "Clubs & Societies");
		Category category3 = new Category(3, "Uniform Group");
		categoryArrList.add(category1);
		categoryArrList.add(category2);
		categoryArrList.add(category3);
		
		// Setup CCA
		CCA cca1 = new CCA(1, "Sports", 1001, "Football", "A team based game where two teams of 11 try to score into their opposing team's goal by kicking a ball in.", 50, "Tuesday", "1400 - 1500", "School Field", "Abdul Qadir Jailani");
		CCA cca2 = new CCA(2, "Clubs & Societies", 2001, "Arts Society", "A club for aspiring, budding artists to learn and explore more the world of arts.", 40, "Wednesday", "1430 - 1530", "Art Room", "Naomi Tan Qian Hui");
		CCA cca3 = new CCA(3, "Uniform Group", 3001, "Red Cross Youth", "A uniform group that aims to help build character and leadership, while also teaching helpful life skills.", 60, "Friday", "1400 - 1530", "CCA Rooms 1 - 3", "Declan Tham Wai Leng");
		ccaList.add(cca1);
		ccaList.add(cca2);
		ccaList.add(cca3);
		
		// Setup student
		Student student1 = new Student(80000001, 8, "Rachel Tan Xi Ping", "2C", "2");
		Student student2 = new Student(80000002, 7, "George Lee Kian Heng", "1F", "1");
		Student student3 = new Student(80000003, 9, "Amos Ng Kho Shan Zhi", "3B", "3");
		Student student4 = new Student(80000004, 8, "Jodie Lee Jia Xin", "2E", "2");
		Student student5 = new Student(80000005, 7, "Crystal Koh Qiao Wei", "1B", "1");
		Student student6 = new Student(80000006, 7, "Foo Wei Hong", "1C", "1");
		Student student7 = new Student(80000007, 9, "Kenneth Poh Ren Kang", "3D", "3");
		Student student8 = new Student(80000008, 8, "Desmond Lee Xian Long", "2A", "2");
		studentArrList.add(student1);
		studentArrList.add(student2);
		studentArrList.add(student3);
		studentArrList.add(student4);
		studentArrList.add(student5);
		studentArrList.add(student6);
		studentArrList.add(student7);
		studentArrList.add(student8);
		
		// Setup coordinator
		Coordinator coordinator1 = new Coordinator("12345678", 2, "admin");
		coordinatorList.add(coordinator1);
		
		// Setup parent
		// String accountId, int accountType, String parentName, String parentEmail, String parentContact, Student student
		Parent parent1 = new Parent("10000001", 1, "Bob Tan Hock Leong", "bobthl@gmail.com", "91234567", student1);
		parentList.add(parent1);
		
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
						Student placeholderStudent = new Student(81234567, 9, "Leonard Lin Lao Peh", "3B", "3");
						student = placeholderStudent;
						while(subOption != -1) {
							coordinatorMenu();
							subOption = Helper.readInt("Enter your choice > ");
							switch(subOption) {
							case 1:
								//add student
								Student newStudent = addStudent(studentArrList);
								studentArrList = doAddStudent(newStudent, studentArrList); 
								break;
							case 2:
								//view student
								System.out.println(viewAllStudent(studentArrList));
								break;
							case 3:
								//delete student
								Student deleteStudent = deleteStudent(studentArrList);
								studentArrList = doDeleteStudent(studentArrList, deleteStudent);
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
								String allCategories = viewAllCategories(categoryArrList);
								System.out.println(allCategories);
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
								System.out.println(viewAllAccounts(parentList));
								break;
							case 12: 
								//delete parent acc
								Parent delParent = deleteAccount(parentList);
								doDeleteAccount(parentList, delParent);
								break;
							case 13: 
								//add student to cca
								viewAllCCA(ccaList);
								int addStudentCcaId = Helper.readInt("Enter CCA ID > ");
								addStudentForCCA(ccaList, addStudentCcaId, student);
								break;
							case 14: 
								//view students in cca
								viewAllCCA(ccaList);
								int viewStudentCcaId = Helper.readInt("Enter CCA ID > ");
								System.out.println(viewStudentsRegistered(ccaList, viewStudentCcaId));
								break;
							case -1:
								//exit
								System.out.println("Logged out of system, returning to main menu...");
								break;
							default:
								//error check
								System.out.println("Invalid option, please try again.");
							}
						}
						
					} else {

						while(subOption != -1) {
							parentMenu();
							subOption = Helper.readInt("Enter your choice > ");
							switch(subOption) {
							case 1:
								//view category
								String allCategories = viewAllCategories(categoryArrList);
								System.out.println(allCategories);
								break;
							case 2:
								//view cca
								viewAllCCA(ccaList);
								break;
							case 3:
								//register for cca
								viewAllCCA(ccaList);
								int addStudentCcaId = Helper.readInt("Enter CCA ID > ");
								addStudentForCCA(ccaList, addStudentCcaId, student);
								break;
							case -1:
								//exit
								System.out.println("Logged out of system, returning to main menu...");
								break;
							default:
								//error check
								System.out.println("Invalid option, please try again.");
							}
						}
					}
					
				}
				
			} else if (mainOption == 2) { //Register
				//get user input
				Parent newParent = inputAccount(parentList, studentArrList);
				addAccount(parentList, newParent);
				
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
	
	public static void coordinatorMenu() {
		setHeader("Coordinator Logged In");
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
		setHeader("Add New Student");
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
		setHeader("View All Students");
		String view = String.format("%-10s %-30s \n", "ID", "Name");
		for(int i = 0; i < studentArrList.size(); i++) {
			view += String.format("%-10d %-30s \n", studentArrList.get(i).getStudentId(), studentArrList.get(i).getStudentName());
		}
		return view;
	}
	
	//Delete Student
	public static ArrayList<Student> doDeleteStudent(ArrayList<Student> studentList, Student student) {
		if(student != null) {
			studentList.remove(student);
			System.out.println("Student successfully removed");
		} else {
			System.out.println("Student not found");
		}
		return studentList;
	}
	

	private static Student deleteStudent(ArrayList<Student> studentArrList) {
		System.out.println(viewAllStudent(studentArrList));
		setHeader("Delete Student");
		Student student = null;
		int studentId = Helper.readInt("Enter Student ID to delete > ");
		for(int i = 0; i < studentArrList.size(); i++) {
			if(studentArrList.get(i).getStudentId() == studentId) {
				student = studentArrList.get(i);
				break;
			}
		}
		return student;
	}
	
	public static CCA addCCA(ArrayList<Category> categoryArrList, ArrayList<CCA> ccaList) {
		setHeader("Add New CCA");
		System.out.println(viewAllCategories(categoryArrList));
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
			view += String.format("%-5d %-30s \n", ccaList.get(i).getCcaId(), ccaList.get(i).getCcaTitle());
		}
		return view;
	}
	
	//View all CCA
	public static void viewAllCCA(ArrayList<CCA> ccaList) {
		setHeader("View All CCA");
		String view = String.format("%-5s %-30s \n", "ID", "Title");
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
	
	//Add category
	public static ArrayList<Category> doAddCategory(Category newCategory, ArrayList<Category> categoryArrList) {
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
	public static String viewAllCategories(ArrayList<Category> categoryArrList) {
		String allCategories = "";
		
		if (categoryArrList.size() == 0) {
			allCategories = "There are no available categories";
		}
		else {
			for (int i = 0; i < categoryArrList.size(); i++) {
				Category category = categoryArrList.get(i);
				allCategories += (category.getCatId()) + ": " + category.getCatName() + "\n";
			}
		}
		return allCategories;
	}
	
	//Remove Category
	public static ArrayList<Category> doDeleteCategory(int id, ArrayList<Category> categoryArrList) {
		
		categoryArrList.remove(id);
		System.out.println("Category Deleted!");
		return categoryArrList;
		
	}
	public static int deleteCategory(ArrayList<Category> categoryArrList) {
		viewAllCategories(categoryArrList);
		int id = -1;
		
		boolean found = false;
		
		while (!found || id != 0) {
			id = Helper.readInt("Enter Category ID to delete, or enter 0 to cancel > ");
			
			if (id != 0) {
				for (int i = 0; i < categoryArrList.size(); i++) {
					if (categoryArrList.get(i).getCatId() == id) {
						found = true;
						id = 0;
						break;
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
		Student student;
		for(int i = 0; i < studentList.size(); i++) {
			if(studentId == studentList.get(i).getStudentId() 
					&& studentName.equals(studentList.get(i).getStudentName()) 
					&& studentClass.equals(studentList.get(i).getStudentClass()) 
					&& studentGrade.equals(studentList.get(i).getStudentGrade())) {
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
				System.out.println("Your Account ID: " + accId);
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
		setHeader("Viewing Registered Parent Accounts");
		String view = String.format("%-15s %-50s\n", "Account ID", "Parent Name");
		for(int i = 0; i < parentList.size(); i++) {
			view += String.format("%-15s %-50s\n", parentList.get(i).getAccountId(), parentList.get(i).getParentName());
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
		
		for(int i = 0; i < parentList.size(); i++) {
			
			if(parentList.get(i).getAccountId().equals(accId) 
					&& parentList.get(i).getStudent().getStudentId() == studentId) {
				
				found = true;
				accountType = parentList.get(i).getAccountType();
				student = parentList.get(i).getStudent();
				break;
			}
		}
		return found;
	}
	
	public static void addStudentForCCA(ArrayList<CCA> ccaList, int ccaId, Student addStudent) { //
		boolean found = false;
		boolean add = false;
		for(int i = 0; i < ccaList.size(); i++) {
			if(ccaList.get(i).getCcaId() == ccaId) {
				found = true;
				for(int x = 0; x < ccaList.get(i).getCcaArray().length; x++) {
					if(ccaList.get(i).getCcaArray()[x] == null) {
						ccaList.get(i).getCcaArray()[x] = addStudent;
						add = true;
						break;
					}
				}
				break;
			}
		}
		
		if(found) {
			if(add) {
				System.out.println("Student registered for CCA");
			} else {
				System.out.println("CCA is full, student not registered");
			}
		} else {
			System.out.println("CCA not found");
		}
	}
	
	public static String viewStudentsRegistered(ArrayList<CCA> ccaList, int ccaId) {
		setHeader("Viewing Registered Students");
		String view = String.format("%-5s %-12s %-40s \n", "NO.", "STUDENT ID", "STUDENT NAME");
		boolean found = false;
		for(int i = 0; i < ccaList.size(); i++) {
			if(ccaList.get(i).getCcaId() == ccaId) {
				found = true;
				for(int x = 0; x < ccaList.get(i).getCcaArray().length; x++) {
					Student current = ccaList.get(i).getCcaArray()[x];
					if(current != null) {
						view += String.format("%-5d %-12s %-40s \n", x+1, current.getStudentId(), current.getStudentName());
					}
				}
				break;
			}
		}
		
		if(!found) {
			view = "CCA not found";
		}
		return view;
	}
}
