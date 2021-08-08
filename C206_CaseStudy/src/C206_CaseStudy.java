import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		ArrayList<Category> categoryArrList = new ArrayList<Category>();
		ArrayList<CCA> ccaList = new ArrayList<CCA>();
		ArrayList<Student> studentArrList = new ArrayList<Student>();
		ArrayList<Account> accountArrList = new ArrayList<Account>();

	}
	
	////////member2////////
	// CCA METHODS
	//Input CCA
	public static CCA InputCCA(ArrayList<Category> categoryArrList, ArrayList<CCA> ccaList) {
		viewAllCategories(categoryArrList);
		int catId = Helper.readInt("Enter CCA's category ID > ");
		String catName = categoryArrList.get(catId).getCatName();
		int id = ccaList.size();
		String title = Helper.readString("Enter CCA's title > ");
		String desc = Helper.readString("Enter CCA's description > ");
		int size = Helper.readInt("Enter CCA's cohort size > ");
		String day = Helper.readString("Enter CCA's day > ");
		String time = Helper.readString("Enter CCA's timing (start to end, in 24 hours) > ");
		String venue = Helper.readString("Enter CCA's venue > ");
		String instructor = Helper.readString("Enter CCA's instructor in-charge > ");
		CCA cca = new CCA(catId, catName, id, title, desc, size, day, time, venue, instructor);
		return cca;
	}
	
	//Add CCA
	public static void addCCA(ArrayList<CCA> ccaList, CCA cca) {
		ccaList.add(cca);
		System.out.println("New CCA added");
	}
	
	//View CCA
	public static String viewAllCCA(ArrayList<CCA> ccaList) {
		String view = String.format("-3%s -15%s \n", "ID", "Title");
		for(int i = 0; i < ccaList.size(); i++) {
			view += String.format("-3%d -15%s \n", ccaList.get(i).getCcaId(), ccaList.get(i).getCcaTitle());
		}
		return view;
	}
	
	//Delete CCA
	public static boolean deleteCCA(ArrayList<CCA> ccaList, int id) {
		boolean delete = false;
		for(int i = 0; i < ccaList.size(); i++) {
			if(ccaList.get(i).getCcaId() == id) {
				ccaList.remove(i);
				delete = true;
			}
		}
		return delete;
	}
	
	////////member3////////
	// CATEGORY METHODS
	//Add category
	private static ArrayList<Category> addCategory(int catId, String catName, ArrayList<Category> categoryArrList) {
		Category category = new Category(catId, catName);
		categoryArrList.add(category);
		
		return categoryArrList;
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
	private static ArrayList<Category> removeCategory(ArrayList<Category> categoryArrList) {
		boolean removed = false;
		
		int id = Helper.readInt("Enter ID to delete > ");
		
		for (int i = 0; i < categoryArrList.size(); i++) {
			if (categoryArrList.get(i).getCatId() == id) {
				categoryArrList.remove(i);
				removed = true;
				
				break;
			}
		}
		
		if (!removed) {
			System.out.println("Category ID not found, please try again.");
		}
		
		return categoryArrList;
		
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
	
	////////member1////////
	//Add Student
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
