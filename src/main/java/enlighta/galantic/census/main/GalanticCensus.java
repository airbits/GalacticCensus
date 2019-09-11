package enlighta.galantic.census.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import enlighta.galantic.census.model.Person;
import enlighta.galantic.census.utility.CensusUtil;

public class GalanticCensus {
	
public static void main(String[] args) 
{
	Person p1 = new Person("Rohan Sahu", new Date(), "Earth", "M", "Navi Mumbai", 1);
	Person p2 = new Person("Nilay Sahu", new Date(), "Pluto", "M", "Banglore", 2);
	
	Person p3 = new Person("Sipra Sahu", new Date(), "Earth", "F", "Navi Mumbai", 3);
	Person p4 = new Person("Kajal Sahu", new Date(), "Pluto", "F", "Banglore", 4);
	Person p5 = new Person("Suryansh Sahu",new Date(), "Earth", "M", "Navi Mumbai", 9);
	
	List<Person> personsList = new ArrayList<Person>();
	personsList.add(p1);
	personsList.add(p2);
	personsList.add(p3);
	personsList.add(p4);
	personsList.add(p5);
	
	
			
	System.out.println( "personsListGroupedByPlanetAndGender for whole universe --> "+CensusUtil.getPersonsGroupedByPlanetAndGender(personsList));
	System.out.println( "getPersonsListByPlanet for given planet --> "+CensusUtil.getPersonsListByPlanet(personsList,"Earth"));
	System.out.println( "\n");
	System.out.println( "getTotalNumberOfPerson for  whole universe --> "+CensusUtil.getTotalNumberOfPerson(personsList));
	System.out.println( "getTotalNumberOfPerson for given planet Earth--> "+CensusUtil.getTotalNumberOfPerson(personsList,"Earth"));
	System.out.println( "getTotalNumberOfPerson for given planet Pluto--> "+CensusUtil.getTotalNumberOfPerson(personsList,"Pluto"));
	System.out.println( "\n");
	System.out.println( "calculatePerCapita for whole universe--> "+CensusUtil.calculatePerCapita(personsList));
	System.out.println( "calculatePerCapita for given planet Earth --> "+CensusUtil.calculatePerCapita(personsList,"Earth"));
	System.out.println( "calculatePerCapita for given planet Pluto --> "+CensusUtil.calculatePerCapita(personsList,"Pluto"));
	
	System.out.println( "\n");
	System.out.println( "calculateStanderedDeviation for whole universe--> "+CensusUtil.calculateStanderedDeviation(personsList));
	System.out.println( "calculateStanderedDeviation for given planet Earth --> "+CensusUtil.calculateStanderedDeviation(personsList,"Earth"));
	System.out.println( "calculateStanderedDeviation for given planet Pluto --> "+CensusUtil.calculateStanderedDeviation(personsList,"Pluto"));
	
	
	
}


}
