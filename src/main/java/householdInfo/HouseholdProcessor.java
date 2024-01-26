package householdInfo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HouseholdProcessor {

	// Method to sort the occupants with lastName followed by firstName using
	// comparator
	// Input : List of Occupants in household
	// Output : List of Occupants in household (sorted)
	public static List<Occupant> getSortedOccupantList(List<Occupant> occupantList) {
		return occupantList.stream()
				.sorted(Comparator.comparing(Occupant::getLastName).thenComparing(Occupant::getFirstName))
				.collect(Collectors.toList());
	}

	// Method to group occupants based on formatted address, city, and state
	// (address is formatted by removing special characters and spaces around, and
	// converting address, state, and city to uppercase).
	// Input : List of Occupants
	// Output : Map of household details(key contains Household info i.e., address,
	// city, state and values contains list of occupants in household)

	public static Map<String, List<Occupant>> groupOccupantsByHousehold(List<Occupant> OccupantList) {
		Map<String, List<Occupant>> groupedOccupant = new HashMap<>();

		for (Occupant occupant : OccupantList) {
			String address = occupant.getAddress().replaceAll("[^a-zA-Z0-9\\s+]", ""); // Regular expression to remove
																						// all special characters
			groupedOccupant
					.computeIfAbsent(address.trim().toUpperCase() + ", " + occupant.getCity().trim().toUpperCase()
							+ ", " + occupant.getState().trim().toUpperCase(), k -> new ArrayList<>())
					.add(occupant);
		}

		return groupedOccupant;
	}

	// Method to filter occupants based on age (above 18)
	// Input : List of Occupants in household
	// Output : List of Occupants in household (filtered based on age)
	public static List<Occupant> filterHouseholdOccupantsByAge(List<Occupant> occupantList) {
		List<Occupant> filteredOccupants = occupantList.stream().filter(each -> each.getAge() > 18)
				.collect(Collectors.toList());
		return filteredOccupants;
	}

	// Method to display output to console (Initially, group the occupants based on
	// households, then filter the occupants based on age, and finally, sort the
	// occupants based on last name, followed by first name)
	// Input : List of Occupants
	// Output : Dispalay output to console
	public static void displayHouseholdDetails(List<Occupant> occupantList) {
		Map<String, List<Occupant>> groupedOccupants = groupOccupantsByHousehold(occupantList);

		groupedOccupants.forEach((household, occupants) -> {
			System.out.println("Household: " + household + ", Number of Occupants: " + occupants.size());
			List<Occupant> filteredOccupantList = filterHouseholdOccupantsByAge(occupants);
			if (filteredOccupantList.size() > 0) {
				List<Occupant> sortedOccupantList = getSortedOccupantList(filteredOccupantList);
				System.out.println("Details of occupants aged above 18 : ");
				sortedOccupantList.forEach(System.out::println);
			} else {
				System.out.println("No occupants aged above 18");

			}

			System.out.println("------------------------------------------------------------------");
		});
	}

}
