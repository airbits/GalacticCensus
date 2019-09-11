package enlighta.galantic.census.utility;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import enlighta.galantic.census.model.Person;

public class CensusUtil {
	
	/**
	 * getPersonsGroupedByPlanetAndGender take as an argument of list of person object and Persons map with grouped by Planet and Gender 
	 * @param personsList
	 * @return Person map with grouped by Planet and Gender  
	 */
	
	public static Map<String, Map<String, List<Person>>> getPersonsGroupedByPlanetAndGender(List<Person> personsList)
	{
		
		Map<String, Map<String, List<Person>>> map  = personsList.stream().collect(Collectors.groupingBy(Person::getPlanetOfResidence,Collectors.groupingBy(Person::getGender)));

		return map;
		
	}
	
	/**
	 * getPersonsListByPlanet - this method person filter for given planet 
	 * @param personsList
	 * @param planet
	 * @return List of persons filtered by planet;
	 */
	public static List<Person> getPersonsListByPlanet(List<Person> personsList , String planet)
	{
		List<Person> filteredList  = personsList.stream().filter(x ->x.getPlanetOfResidence().equalsIgnoreCase(planet)).collect(Collectors.toList());
		return filteredList;
	}
	
	/**
	 * getTotalNumberOfPerson - this method gives you the total count of person in the provided list 
	 * @param personsList
	 * @return List of persons
	 */
	public static long getTotalNumberOfPerson(List<Person> personsList)
	{
		return personsList.size();	
	}
	
	/**
	 * getTotalNumberOfPerson - this method gives you the total count of person for given planet 
	 * @param personsList
	 * @param planet
	 * @return count
	 */
	public static long getTotalNumberOfPerson(List<Person> personsList , String planet)
	{
			return personsList.stream().filter(x ->x.getPlanetOfResidence().equalsIgnoreCase(planet)).count();
	}
	
	/**
	 * calculatePerCapita - calculates per capita for whole universe
	 * @param personsList
	 * @return
	 */
	
	public static Double calculatePerCapita(List<Person> personsList)
	{
		Double perCapitaIncome  = personsList.stream().collect(Collectors.averagingDouble(Person::getAnualIncome));
		return perCapitaIncome;	
	}
	
	/**
	 * calculatePerCapita - calculates per capita for given planet 
	 * @param personsList , planet
	 * @param planet
	 * @return PerCapita
	 */
	public static Double calculatePerCapita(List<Person> personsList , String planet)
	{
		
		
		Double perCapitaIncome  = personsList.stream().filter(x ->x.getPlanetOfResidence().equalsIgnoreCase(planet)).collect(Collectors.averagingDouble(Person::getAnualIncome));
		return perCapitaIncome;
			
	}
	
	
	
	/**
	 * calculateStanderedDeviation - calculate SD for whole universe 
	 * @param personsList
	 * @return
	 */
	public static Double calculateStanderedDeviation(List<Person> personsList)
	{
		
		double standardDeviation = 0.0;
		Double meanValue  = personsList.stream().collect(Collectors.averagingDouble(Person::getAnualIncome));
		//System.out.println(perCapitaIncome);
			
		for (Person person : personsList) {
			standardDeviation += Math.pow(person.getAnualIncome()- meanValue, 2) ;
			
		}
		
		return Math.sqrt(standardDeviation/personsList.size());	
	}
	
	/**
	 * calculateStanderedDeviation - calculate SD for given planet 
	 * @param personsList
	 * @param planet
	 * @return
	 */
	public static Double calculateStanderedDeviation(List<Person> personsList , String planet)
	{
		Stream<Person> stream = personsList.stream().filter(x ->x.getPlanetOfResidence().equalsIgnoreCase(planet));
		double standardDeviation = 0.0;
		Map<String, Double> map  = stream.collect(Collectors.groupingBy(Person::getPlanetOfResidence,Collectors.averagingDouble(Person::getAnualIncome)));
		Double meanValue  = map.get(planet);
		//System.out.println(perCapitaIncome);
			
		for (Person person : personsList) {
			standardDeviation += Math.pow(person.getAnualIncome()- meanValue, 2) ;
			
		}
		
		return Math.sqrt(standardDeviation/personsList.size());	
	}
	
	
	
	

}
