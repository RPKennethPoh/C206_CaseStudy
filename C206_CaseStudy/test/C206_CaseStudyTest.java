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
	private ArrayList<Account> accountArrList;

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
			assertNotNull("Account List is not null", parentList);
			
			C206_CaseStudy.addAccount(parentList, parent1);
			assertEquals("Size is not 1",  parentList.size(), 1);
			
			assertSame("Added account does not match original Account object", parent1, parentList.get(0));
			
			C206_CaseStudy.addAccount(parentList, parent2);
			assertEquals("Size is not 2", parentList.size(), 2);
			
		}
		
		@Test
		public void viewAllAccountsTest() {
			
			String viewAccounts = String.format("-3%s -15%s \n", "accId", "accName");
			String testviewAccounts = C206_CaseStudy.viewAllAccounts(parentList);
			assertSame("Empty CCA list show more than headers", viewAccounts, testviewAccounts);
			

			viewAccounts = String.format("-3%s -15%s \n", "accId", "accName");
			testviewAccounts += String.format("-3%d -15%s \n-3%d -15%s \n", parent1.getAccountId(), parent1.getParentName(), parent2.getAccountId(), parent2.getParentName());
			parentList.add(parent1);
			parentList.add(parent2);
			testviewAccounts = C206_CaseStudy.viewAllAccounts(parentList);
			assertSame("Account list showing different Strings after adding", viewAccounts, testviewAccounts);
			

			viewAccounts = String.format("-3%s -15%s \n", "accId", "accName");
			viewAccounts += String.format("-3%d -15%s \n-3%d -15%s \n",parent1.getAccountId(), parent1.getParentName());
			parentList.remove(1);
			testviewAccounts = C206_CaseStudy.viewAllAccounts(parentList);
			assertSame("Account list showing different Strings after removing", viewAccounts, testviewAccounts);
			
		}
		
		@Test
		public void deleteAccountTest() {
			parentList.add(parent1);
			Parent invalidParent = null;
			C206_CaseStudy.doDeleteAccount(parentList, invalidParent);
			assertEquals("Invalid Account deleted", parentList.size(), 1);
			
			C206_CaseStudy.doDeleteAccount(parentList, parent1);
			assertEquals("Account not deleted", parentList.size(), 0);
			
			parentList.add(parent1);
			parentList.add(parent2);
			parentList.add(parent3);
			C206_CaseStudy.doDeleteAccount(parentList, parent2);
			assertEquals("Account not deleted", ccaList.size(), 2);
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
		String actualView = "";
		String testView = C206_CaseStudy.viewAllCategories(categoryArrList);
		assertSame("Empty Category list shows something different", actualView, testView);
		
		// Test if CCA list with 2 item will show correctly
		actualView = "1: Test1\n2: Test 2";
		categoryArrList.add(new Category(1, "Test 1"));
		categoryArrList.add(new Category(2, "Test 2"));
		testView = C206_CaseStudy.viewAllCategories(categoryArrList);
		assertSame("CCA list showing different Strings after adding", actualView, testView);
		
		// Test if CCA list will show correctly after 1 item has been removed
		actualView = "1: Test 1";
		ccaList.remove(1);
		testView = C206_CaseStudy.viewAllCategories(categoryArrList);
		assertSame("CCA list showing different Strings after removing", actualView, testView);
		
		
		
	}
	
	@Test
	public void deleteCategoryTest() {
		categoryArrList = new ArrayList<Category>();
		categoryArrList.add(new Category(1, "Test"));
		
		C206_CaseStudy.doDeleteCategory(0, categoryArrList);
		assertEquals(categoryArrList.size(), 0);

	}
	
	@After
	public void tearDown() throws Exception {
		cca1 = null;
		cca2 = null;
		cca3 = null;
		ccaList = null;
	}
}
