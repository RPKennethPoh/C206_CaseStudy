import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	//test
	private CCA cca1, cca2, cca3;
	private ArrayList<CCA> ccaList;
	private Student student1, student2, student3;
	private ArrayList<Student> studentList;
	private Parent parent1, parent2, parent3;
	private ArrayList<Parent> parentList;
	private ArrayList<Category> categoryArrList;

	@Before
	public void setUp() throws Exception {
		// Preparing test data.
		
		//Member 3
		//CCA Setup
		cca1 = new CCA(1, "Sports", 1001, "Football", "A team based game where two teams of 11 try to score into their opposing team's goal by kicking a ball in.", 50, "Tuesday", "1400 - 1500", "School Field", "Abdul Qadir Jailani");
		cca2 = new CCA(2, "Clubs & Societies", 2001, "Arts Society", "A club for aspiring, budding artists to learn and explore more the world of arts.", 40, "Wednesday", "1430 - 1530", "Art Room", "Naomi Tan Qian Hui");
		cca3 = new CCA(3, "Uniform Group", 3001, "Red Cross Youth", "A uniform group that aims to help build character and leadership, while also teaching helpful life skills.", 60, "Friday", "1400 - 1530", "CCA Rooms 1 - 3", "Kenneth Poh Ren Kang");
		ccaList = new ArrayList<CCA>();
		
		//int studentId, int studentAge, String studentName, String studentClass, String studentGrade
		student1 = new Student(80000001, 8, "Rachel Tan Xi Ping", "2C", "2");
		student2 = new Student(80000002, 7, "George Lee Kian Heng", "1F", "1");
		student3 = new Student(80000003, 9, "Leonard Lin Lao Peh", "3B", "3");

		//String accountId, int accountType, String parentName, String parentEmail, String parentContact, Student student
		parent1 = new Parent("10000001", 1, "Bob Tan Hock Leong", "bobthl@gmail.com", "91234567", student1);
		parent2 = new Parent("10000002", 1, "Simon Lee Meng Han", "simonleemh@gmail.com", "97654321", student2);
		parent3 = new Parent("10000003", 1, "Karen Ong Kah Kiao", "kongkahkiao@gmail.com", "86969696", student3);
	}

	

//	@Test
//	public void c206_test() {
//		//fail("Not yet implemented"); 
//		assertTrue("C206_CaseStudy_SampleTest ",true);
//	}
	//Member 1
		//Student Tests
		@Test
		public void addStudentTest() {
			// Test if student List is not null so that new students can be added
			assertNotNull("Student list is null", studentList);
			
			// Test if student list size is 1 when 1 item is added into empty list
			C206_CaseStudy.doAddStudent(student1, studentList);
			assertEquals("Size is not 1", studentList.size(), 1);
			
			// Test if student added into the list matches the original student object
			assertSame("Added Student not the same as original student object", student1, studentList.get(0));
			
			// Test if student list size increases to 2 when 1 more item is added
			C206_CaseStudy.doAddStudent(student1, studentList);
			assertEquals("Size is not 2", studentList.size(), 2);

		}
		
		@Test
		public void viewAllStudentTest() {
			// Test if empty student list will show nothing
			String actualView = "";
			String testView = C206_CaseStudy.viewAllStudent(studentList);
			assertEquals("Empty student list shows something different", actualView, testView);
			
			// Test if CCA list with 2 item will show correctly
			actualView = String.format("%-3d %-15s \n", student1.getStudentId(), student1.getStudentName());
			actualView += String.format("%-3d %-15s \n", student2.getStudentId(), student2.getStudentName());
			studentList.add(student1);
			studentList.add(student2);
			testView = C206_CaseStudy.viewAllStudent(studentList);
			assertEquals("Student list showing different Strings after adding", actualView, testView);
			
			// Test if CCA list will show correctly after 1 item has been removed
			actualView = String.format("%-3d %-15s \n", student1.getStudentId(), student1.getStudentName());
			studentList.remove(1);
			testView = C206_CaseStudy.viewAllStudent(studentList);
			assertEquals("Student list showing different Strings after removing", actualView, testView);
			
		}
		
		@Test
		public void deleteStudentTest() {
			// Test if can delete invalid student
			studentList.add(student1);
			Student invalidStudent = null;
			C206_CaseStudy.doDeleteStudent(studentList, invalidStudent);
			assertEquals("Invalid student deleted", studentList.size(), 1);
			
			// Test if student is deleted from a list with 1 item
			C206_CaseStudy.doDeleteStudent(studentList, student1);
			assertEquals("Student not deleted", studentList.size(), 0);
			
			// Test if correct item is deleted from student list with 3 items
			studentList.add(student1);
			studentList.add(student2);
			studentList.add(student3);
			C206_CaseStudy.doDeleteStudent(studentList, student2);
			assertEquals("Student not deleted", studentList.size(), 2);
			assertSame("Remaining student is not same (first item)", studentList.get(0), student1);
			assertSame("Remaining student is not same (second item)", studentList.get(1), student3);
		}
	//Member 3
	//CCA Tests
	@Test
	public void addCCATest() {
		// Test if CCA List is not null so that new CCAs can be added
		assertNotNull("CCA list is null", ccaList);
		
		// Test if CCA list size is 1 when 1 item is added into empty list
		C206_CaseStudy.doAddCCA(ccaList, cca1);
		assertEquals("Size is not 1", ccaList.size(), 1);
		
		// Test if CCA added into the list matches the original CCA object
		assertSame("Added CCA not the same as original CCA object", cca1, ccaList.get(0));
		
		// Test if CCA list size increases to 2 when 1 more item is added
		C206_CaseStudy.doAddCCA(ccaList, cca2);
		assertEquals("Size is not 2", ccaList.size(), 2);

	}
	
	@Test
	public void viewAllCCATest() {
		// Test if empty CCA list will show nothing
		String actualView = "";
		String testView = C206_CaseStudy.retrieveAllCCA(ccaList);
		assertEquals("Empty CCA list shows something different", actualView, testView);
		
		// Test if CCA list with 2 item will show correctly
		actualView = String.format("%-3d %-15s \n", cca1.getCcaId(), cca1.getCcaTitle());
		actualView += String.format("%-3d %-15s \n", cca2.getCcaId(), cca2.getCcaTitle());
		ccaList.add(cca1);
		ccaList.add(cca2);
		testView = C206_CaseStudy.retrieveAllCCA(ccaList);
		assertEquals("CCA list showing different Strings after adding", actualView, testView);
		
		// Test if CCA list will show correctly after 1 item has been removed
		actualView = String.format("%-3d %-15s \n", cca1.getCcaId(), cca1.getCcaTitle());
		ccaList.remove(1);
		testView = C206_CaseStudy.retrieveAllCCA(ccaList);
		assertEquals("CCA list showing different Strings after removing", actualView, testView);
		
	}
	
	@Test
	public void deleteCCATest() {
		// Test if can delete invalid CCA
		ccaList.add(cca1);
		CCA fakeCca = null;
		C206_CaseStudy.doDeleteCCA(ccaList, fakeCca);
		assertEquals("Invalid CCA deleted", ccaList.size(), 1);
		
		// Test if CCA is deleted from a list with 1 item
		C206_CaseStudy.doDeleteCCA(ccaList, cca1);
		assertEquals("CCA not deleted", ccaList.size(), 0);
		
		// Test if correct item is deleted from CCA list with 3 items
		ccaList.add(cca1);
		ccaList.add(cca2);
		ccaList.add(cca3);
		C206_CaseStudy.doDeleteCCA(ccaList, cca2);
		assertEquals("CCA not deleted", ccaList.size(), 2);
		assertSame("Remaining CCA is not same (first item)", ccaList.get(0), cca1);
		assertSame("Remaining CCA is not same (second item)", ccaList.get(1), cca3);
	}
	
	//member4
	@Test
	public void addAccountTest() {
		assertNotNull("Account List is not null", accountArrList);
		
		C206_CaseStudy.addAccount(accountArrList, account1);
		assertEquals("Size is not 1",  accountArrList.size(), 1);
		
		assertSame("Added account does not match original Account object", account1, accountArrList.get(0));
		
		C206_CaseStudy.addAccount(accountArrList, account2);
		assertEquals("Size is not 2", accountArrList.size(), 2);
		
	}
	
	@Test
	public void viewAllAccountsTest() {
		
		String viewAccounts = String.format("-3%s -15%s \n", "accId", "accName");
		String testviewAccounts = C206_CaseStudy.viewAllAccounts(accountArrList);
		assertSame("Empty CCA list show more than headers", viewAccounts, testviewAccounts);
		

		viewAccounts = String.format("-3%s -15%s \n", "accId", "accName");
		testviewAccounts += String.format("-3%d -15%s \n-3%d -15%s \n", account1.getAccId(), account1.getAccName(), account2.getAccId(), account2.getAccName());
		accountArrList.add(account1);
		accountArrList.add(account2);
		testviewAccounts = C206_CaseStudy.viewAllAccounts(accountArrList);
		assertSame("Account list showing different Strings after adding", viewAccounts, testviewAccounts);
		

		viewAccounts = String.format("-3%s -15%s \n", "accId", "accName");
		viewAccounts += String.format("-3%d -15%s \n-3%d -15%s \n",account1.getAccId(), account1.getAccName	());
		accountArrList.remove(1);
		testviewAccounts = C206_CaseStudy.viewAllAccounts(accountArrList);
		assertSame("Account list showing different Strings after removing", viewAccounts, testviewAccounts);
		
	}
	
	@Test
	public void deleteAccountTest() {
		boolean deleteAcc = C206_CaseStudy.deleteAccount(accountArrList, 0);
		assertFalse("Account deleted from empty list", deleteAcc);

		accountArrList.add(account1);
		deleteAcc = C206_CaseStudy.deleteAccount(accountArrList, 0);
		assertFalse("Invalid Account deleted", deleteAcc);
		
		deleteAcc = C206_CaseStudy.deleteAccount(accountArrList, 5);
		assertTrue("Account not deleted", deleteAcc);
		
		accountArrList.add(account1);
		accountArrList.add(account2);
		accountArrList.add(account3);
		deleteAcc = C206_CaseStudy.deleteAccount(accountArrList, 6);
		assertTrue("Account not deleted", deleteAcc);
	}
	
	@Test
	public void addCategoryTest() {
		categoryArrList = new ArrayList<Category>();
		Category test = new Category(1, "Test");
		
		categoryArrList = C206_CaseStudy.doAddCategory(test, categoryArrList);
		assertEquals(categoryArrList.size(), 1);
	}
	
	@Test
	public void viewCategoryTest() {
		categoryArrList = new ArrayList<Category>();
		categoryArrList.add(new Category(1, "Test"));
		
		String test = null;
		test = C206_CaseStudy.viewAllCategories(categoryArrList);
		
		assertFalse(test == null);
	}
	
	@Test
	public void deleteCategoryTest() {
		categoryArrList = new ArrayList<Category>();
		categoryArrList.add(new Category(1, "Test"));
		
		C206_CaseStudy.doDeleteCategory(0, categoryArrList);
		assertEquals(categoryArrList.size(), 0);

	}
	
	
	@Test
	public void viewRegisteredStudentsTest() {
		cca1.getCcaArray()[0] = student1;
		cca1.getCcaArray()[1] = student2;
		cca1.getCcaArray()[2] = student3;
		
		ccaList.add(cca1);
		
		System.out.println(C206_CaseStudy.viewStudentsRegistered(ccaList, cca1.getCcaId()));
	}
	
	
	
	@After
	public void tearDown() throws Exception {
		cca1 = null;
		cca2 = null;
		cca3 = null;
		ccaList = null;
	}
}
