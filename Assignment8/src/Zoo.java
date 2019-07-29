import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zoo {
	
	// number of zones in zoo = 3;
	private final int zooCapacity = 3;
	// list of zones in zoo
	private List<Zone> zone = new ArrayList<Zone>();
	// id should be allocated automatically to new animal so it is made static
	private static int id = 0;

	/**
	 * @param type: type of animal that can be put in that cage 
	 * @return capacity of animal in that cage
	 */
	public int getCapacityOfCage(String type) {
		//storing capacity using Hashmaps
		Map<String, Integer> capacity = new HashMap<String, Integer>();
		capacity.put("Lion", 4);
		capacity.put("Deer", 6);
		capacity.put("Snake", 10);
		capacity.put("Turtle", 10);
		capacity.put("Eagle", 3);
		capacity.put("Parrot", 12);
		return capacity.get(type);
	}
	
	/**
	 * @param category: type of category 
	 * @return number of cages allocated to specific category
	 */
	public int getCapacityOfZone(String category) {
		Map<String, Integer> capacity = new HashMap<String, Integer>();
		capacity.put("Mammal", 1);
		capacity.put("Reptile", 1);
		capacity.put("Bird", 1);
		return capacity.get(category);
	}

	/**
	 * @param typeOfAnimal e.g lion,deer,snake etc..
	 * @return superclass's name of that type of animal
	 */
	public String getCategory(String typeOfAnimal) {
		String category = "";
		switch (typeOfAnimal) {
			case "Lion" :
				//returns superclass name as string
				category = Lion.class.getSuperclass().getSimpleName();
				break;
			case "Deer" :
				category = Deer.class.getSuperclass().getSimpleName();
				break;
			case "Snake" :
				category = Snake.class.getSuperclass().getSimpleName();
				break;
			case "Turtle" :
				category = Turtle.class.getSuperclass().getSimpleName();
				break;
			case "Eagle" :
				category = Eagle.class.getSuperclass().getSimpleName();
				break;
			case "Parrot" :
				category = Parrot.class.getSuperclass().getSimpleName();
				break;
			default :
				break;
		}
		return category;
	}
	
	/**
	 * @param category : category of zone
	 * @param limitOfCages : number of cages allowed in that zone
	 * @return function add zone in the zone list and returns the index of last zone added
	 */
	public int addZone(String category) {
		zone.add(new Zone(category, getCapacityOfZone(category) ));
		return zone.size() - 1;
	}
	
	/**
	 * @param typeOfAnimal
	 * @return function add cages to the cage list and returns true if cage is added else throws assertion error
	 */
// 	public boolean addCage(String typeOfAnimal) {
// 		//check in zone list
// 		for (int i = 0; i < zone.size(); i++) {
// 			//check if zone exist for the particular type of animal
// 			if (getCategory(typeOfAnimal).equals(zone.get(i).getCategory())) {
// 				//if number of cages in that zone is less than limit of cages in that zone
// 				if (zone.get(i).cageList.size() < zone.get(i).getLimitOfCages()){
// 					//add cage
// 					zone.get(i).cageList.add(new Cage(typeOfAnimal, getCapacityOfCage(typeOfAnimal)));
// 					return true;
// 				}
// 				// zone has cages equal to it's limit so throw assertion error
// 				else
// 					throw new AssertionError("Zone is full");
// 			}
// 		}
// 		//zone does not exist for that animal category
// 		return false;
// 	}

	/**
	 * @param name : name of animal
	 * @param type : category of animal
	 * @param weight
	 * @param age
	 * @return function add animal to list of animals and returns true;
	 */
	public boolean addAnimal( String name, String type, double weight, int age) {
		//get indexes of the zone and cage available
		int[] indexes = indexForAnimal(type);
		//add animal on the basis of it's type
		switch (type) {
			case "Lion" :
				zone.get(indexes[0]).cageList.get(indexes[1]).animal.add(new Lion(name, type, weight, age, ++id));
				break;
			case "Deer" :
				zone.get(indexes[0]).cageList.get(indexes[1]).animal.add(new Deer(name, type, weight, age, ++id));
				break;
			case "Snake" :
				zone.get(indexes[0]).cageList.get(indexes[1]).animal.add(new Snake(name, type, weight, age, ++id));
				break;
			case "Turtle" :
				zone.get(indexes[0]).cageList.get(indexes[1]).animal.add(new Turtle(name, type, weight, age, ++id));
				break;
			case "Eagle" :
				zone.get(indexes[0]).cageList.get(indexes[1]).animal.add(new Eagle(name, type, weight, age, ++id));
				break;
			case "Parrot" :
				zone.get(indexes[0]).cageList.get(indexes[1]).animal.add(new Parrot(name, type, weight, age, ++id));
				break;
			default :
				break;
		}
		return true;
	}
	
	/**
	 * @param type
	 * @return index of zone
	 */
	public int indexOfZone(String type) {
		//get category of animal
		String category = getCategory(type);
		//traverse through zone list
		for (int i = 0; i < zone.size(); i++) {
			//if zone of that category exist
			if (zone.get(i).getCategory().equals(category)) {
				//if zone has cage for that type of animal
				if (zone.get(i).cageList.contains(type)) {
					//get index of that cage
					int cageIndex = zone.get(i).cageList.indexOf(type);
					//if number of animals in that cage are less than the limit
					if (zone.get(i).cageList.get(cageIndex).animal.size() < zone.get(i).cageList.get(cageIndex).getCapacity()){
						//return index of zone
						return i;
					}
					
				}
				// zone has cages less than limit of cages in that zone
				else if (zone.get(i).cageList.size() < zone.get(i).getLimitOfCages())
					return i;
			}
		}
		//if zone does not exist and number of zones are less than zoo capacity then add zone
		if (zone.size() < zooCapacity)
			return addZone(category);
		//zone cant be added
		else
			throw new AssertionError("Zoo is full");
	}
	
	/**
	 * @param type
	 * @return index of zone and cage
	 */
	public int[] indexForAnimal(String type) {
		//store zone index having that type
		int zoneIndex = indexOfZone(type);
		//array of two elements storing index of zone and cage
		int[] indexes = new int[2];
		//if cage exist
		if (zone.get(zoneIndex).cageList.contains(type)) {
			indexes[0] = zoneIndex;
			indexes[1] = zone.get(zoneIndex).cageList.indexOf(type);
			return indexes;
		} 
		//if cage does not exist then add cage
		else {
			zone.get(zoneIndex).cageList.add(new Cage(type, getCapacityOfCage(type)));
			indexes[0] = zoneIndex;
			indexes[1] = zone.get(zoneIndex).cageList.size() - 1;
			return indexes;
		}
	}
	
	/**
	 * @param name
	 * @param type
	 * @return true if animal is removed
	 */
	public boolean removeAnimal(String name, String type) {
		int i;
		//traverse in the zone list
		for (i = 0; i < zone.size(); i++) {
			//check the category of the animal in zone
			if (zone.get(i).getCategory().equals(getCategory(type))) {
				//traverse in the cage list
				for (int j = 0; j < zone.get(i).cageList.size(); j++) {
					//check the type of the animal in cage
					if (zone.get(i).cageList.get(j).getTypeOfAnimal().equals(type)) {
						//traverse through the animal list in the cage
						for (int k = 0; k < zone.get(i).cageList.get(j).animal.size(); k++) {
							//if animal of that name is found
							if (zone.get(i).cageList.get(j).animal.get(k).getName().equals(name)){
								//animal removed
								zone.get(i).cageList.get(j).animal.remove(name);
								return true;
							}
						}
						//if type not found in cage return false
						return false;
					}
				}
			}
		}
		//if category not found in zone
		return false;
	}

}


