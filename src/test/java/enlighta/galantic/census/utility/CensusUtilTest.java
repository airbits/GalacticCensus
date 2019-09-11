package enlighta.galantic.census.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enlighta.galantic.census.model.Person;

class CensusUtilTest {
	
	
	static List<Person> personsList;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		Person p1 = new Person("Rohan Sahu", new Date(), "Earth","M", "Navi Mumbai", 1);
		Person p2 = new Person("Nilay Sahu", new Date(), "Pluto","M", "Banglore", 2);
		
		Person p3 = new Person("Sipra Sahu", new Date(), "Earth","F", "Navi Mumbai", 3);
		Person p4 = new Person("Kajal Sahu", new Date(), "Pluto","F", "Banglore", 4);
		Person p5 = new Person("Suryansh Sahu",new Date(),"Earth","M", "Navi Mumbai", 9);
		
		personsList = new ArrayList<Person>();
		personsList.add(p1);
		personsList.add(p2);
		personsList.add(p3);
		personsList.add(p4);
		personsList.add(p5);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetPersonsGroupedByPlanetAndGender() {
		Map<String, Map<String, List<Person>>> groupedMap = CensusUtil.getPersonsGroupedByPlanetAndGender(personsList);
		Map<String, List<Person>> personInEarth = groupedMap.get("Earth"); // Filtering based on Earth
		List<Person> personInEarthAndFemale = personInEarth.get("M"); // Filtering male ( Rohan Sahu and Suryansh Sahu)
		assertEquals(2,personInEarthAndFemale.size()); 
	}

	@Test
	void testGetPersonsListByPlanet() {
		List<Person> personInPlanet = CensusUtil.getPersonsListByPlanet(personsList,"Earth");
		assertEquals(3,personInPlanet.size());
	}

	@Test
	void testGetTotalNumberOfPerson() {
		assertEquals(5,CensusUtil.getTotalNumberOfPerson(personsList));
	}

	@Test
	void testGetTotalNumberOfPersonByPlanet() {
		assertEquals(2,CensusUtil.getTotalNumberOfPerson(personsList,"Pluto"));
		assertEquals(3,CensusUtil.getTotalNumberOfPerson(personsList,"Earth"));
	}

	@Test
	void testCalculatePerCapita() {
		assertEquals(3.8,CensusUtil.calculatePerCapita(personsList));
		assertEquals(3.0,CensusUtil.calculatePerCapita(personsList,"Pluto"));
	}

	
	@Test
	void testCalculateStanderedDeviation() {
		assertEquals(2.785677655436824,CensusUtil.calculateStanderedDeviation(personsList));
		assertEquals(2.898275349237888,CensusUtil.calculateStanderedDeviation(personsList,"Pluto"));
	}

	

}
