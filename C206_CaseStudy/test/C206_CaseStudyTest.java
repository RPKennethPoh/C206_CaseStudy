import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	//test
	private CCA cca1, cca2, cca3;
	private ArrayList<CCA> ccaList;
	private Account account1, account2, account3;
	private ArrayList<Account> accountArrList;

	@Before
	public void setUp() throws Exception {
		// Preparing test data
		
		//Member 3
		//CCA Setup
		cca1 = new CCA(1, "Sports", 1001, "Football", "A team based game where two teams of 11 try to score into their opposing team's goal by kicking a ball in.", 50, "Tuesday", "1400 - 1500", "School Field", "Abdul Qadir Jailani");
		cca2 = new CCA(2, "Clubs & Societies", 2001, "Arts Society", "A club for aspiring, budding artists to learn and explore more the world of arts.", 40, "Wednesday", "1430 - 1530", "Art Room", "Naomi Tan Qian Hui");
		cca3 = new CCA(3, "Uniform Group", 3001, "Red Cross Youth", "A uniform group that aims to help build character and leadership, while also teaching helpful life skills.", 60, "Friday", "1400 - 1530", "CCA Rooms 1 - 3", "Kenneth Poh Ren Kang");
		ccaList = new ArrayList<CCA>();

		account1 = new Account(5, 20013000, "Chris Oliver", "Primary 6", "Class A", "Mrs Jasmine", "Simon Oliver", "simonoliver@gmail.com", "90019000");
		account2 = new Account(6, 20013001, "Timothy Tan", "Primary 6", "Class B", "Mr Kim", "Michael Tan", "michaeltan@gmail.com", "90019001");
		account3 = new Account(6, 20013001, "Simon Chris", "Primary 6", "Class C", "Mr Henz", "Lim Chris", "limchris@gmail.com", "90019002");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	//Member 3
	//CCA Tests
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
	
	public void viewAllCCATest() {
		// Test if empty CCA list will show nothing
		String actualView = "";
		String testView = C206_CaseStudy.retrieveAllCCA(ccaList);
		assertSame("Empty CCA list shows something different", actualView, testView);
		
		// Test if CCA list with 2 item will show correctly
		actualView = String.format("-3%d -15%s \n-3%d -15%s \n", cca1.getCcaId(), cca1.getCcaTitle(), cca2.getCcaId(), cca2.getCcaTitle());
		ccaList.add(cca1);
		ccaList.add(cca2);
		testView = C206_CaseStudy.retrieveAllCCA(ccaList);
		assertSame("CCA list showing different Strings after adding", actualView, testView);
		
		// Test if CCA list will show correctly after 1 item has been removed
		actualView = String.format("-3%d -15%s \n-3%d -15%s \n", cca1.getCcaId(), cca1.getCcaTitle());
		ccaList.remove(1);
		testView = C206_CaseStudy.retrieveAllCCA(ccaList);
		assertSame("CCA list showing different Strings after removing", actualView, testView);
		
		
		
	}
	
	public void deleteCCATest() {
		// Test if can delete invalid CCA ID
		ccaList.add(cca1);
		C206_CaseStudy.doDeleteCCA(ccaList, 0);
		assertEquals("Invalid CCA deleted", ccaList.size(), 1);
		
		// Test if CCA is deleted from a list with 1 item
		C206_CaseStudy.doDeleteCCA(ccaList, 1001);
		assertEquals("CCA not deleted", ccaList.size(), 0);
		
		// Test if correct item is deleted from CCA list with 3 items
		ccaList.add(cca1);
		ccaList.add(cca2);
		ccaList.add(cca3);
		C206_CaseStudy.doDeleteCCA(ccaList, 2001);
		assertEquals("CCA not deleted", ccaList.size(), 2);
		assertSame("Remaining CCA is not same (first item)", ccaList.get(0), cca1);
		assertSame("Remaining CCA is not same (second item)", ccaList.get(1), cca3);
	}
	
	//member4
	public void addAccountTest() {
		assertNotNull("Account List is not null", accountArrList);
		
		C206_CaseStudy.addAccount(accountArrList, account1);
		assertEquals("Size is not 1",  accountArrList.size(), 1);
		
		assertSame("Added account does not match original Account object", account1, accountArrList.get(0));
		
		C206_CaseStudy.addAccount(accountArrList, account2);
		assertEquals("Size is not 2", accountArrList.size(), 2);
		
	}
	
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
}
