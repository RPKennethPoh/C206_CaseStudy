import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private CCA cca1, cca2, cca3;
	private ArrayList<CCA> ccaList;

	@Before
	public void setUp() throws Exception {
		// Preparing test data
		
		//Member 3
		//CCA Setup
		cca1 = new CCA(1, "Sports", 1001, "Football", "A team based game where two teams of 11 try to score into their opposing team's goal by kicking a ball in.", 50, "Tuesday", "1400 - 1500", "School Field", "Mr Abdul Qadir");
		cca2 = new CCA(2, "Clubs & Societies", 2001, "Arts Society", "A club for aspiring, budding artists to learn and explore more the world of arts.", 40, "Wednesday", "1430 - 1530", "Art Room", "Ms Naomi Tan");
		cca3 = new CCA(3, "Uniform Group", 3001, "Red Cross Youth", "A uniform group that aims to help build character and leadership, while also teaching helpful life skills.", 60, "Friday", "1400 - 1530", "CCA Rooms 1 - 3", "Mr Kenneth Poh");
		ccaList = new ArrayList<CCA>();

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
		C206_CaseStudy.addCCA(ccaList, cca1);
		assertEquals("Size is not 1", ccaList.size(), 1);
		
		// Test if CCA added into the list matches the original CCA object
		assertSame("Added CCA not the same as original CCA object", cca1, ccaList.get(0));
		
		// Test if CCA list size increases to 2 when 1 more item is added
		C206_CaseStudy.addCCA(ccaList, cca2);
		assertEquals("Size is not 2", ccaList.size(), 2);

	}
	
	public void viewAllCCATest() {
		// Test
		
	}
	
	public void deleteCCATest() {
		// Test
	}
	
}
