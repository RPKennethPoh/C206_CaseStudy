import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		ArrayList<Category> categoryArrList = new ArrayList<Category>();
		ArrayList<CCA> ccaList = new ArrayList<CCA>();
		ArrayList<Student> studentArrList = new ArrayList<Student>();

	}
	
	// CCA METHODS
	//Input CCA
	public static CCA InputCCA(ArrayList<Category> categoryArrList, ArrayList<CCA> ccaList) {
		viewAllCategories();
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
	
////////member2////////
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
	private boolean addCategory(int catId, String catName) {
		boolean added = false;
		
		Category category = new Category(catId, catName);
		
		int oldArrListSize = categoryArrList.size();
		categoryArrList.add(category);
		
		int newArrListSize = categoryArrList.size();
		
		if (newArrListSize == (oldArrListSize + 1)) {
			added = true;
		}
		
		return added;
	}
	
	//View All Categories
	private static String viewAllCategories() {
		String allCategories = "";
		
		for (int i = 1; i <= categoryArrList.size(); i++) {
			allCategories += categoryArrList.get(i).getCatId() + ": " + categoryArrList.get(i).getCatName();
		}
		
		return allCategories;
	}
	
	//Remove Category
	private boolean removeCategory() {
		boolean removed = false;
		
		String allCategories = viewAllCategories();
		System.out.println(allCategories);
		
		int id = Helper.readInt("Enter ID to delete > ");
		
		for (int i = 0; i < categoryArrList.size(); i++) {
			if (categoryArrList.get(i).getCatId() == id) {
				categoryArrList.remove(i);
				removed = true;
				
				break;
			}
		}
		return removed;
		
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
		String list = String.format("-20s -10%s -15%s \n", "CCA name", "ID", "Name");
		for(int i = 0; i < studentArrList.size(); i++) {
			list += String.format("-3%d -15%s \n", studentArrList.get(i).getStudentId(), studentArrList.get(i).getStudentName());
		}
		return list;
	}
}
