import static org.junit.Assert.*;

import org.junit.Test;

public class zooTest {

	@Test
	public void addAnimalWhenZooIsNotFull() {
		Zoo zoo=new Zoo();
		zoo.addZone("Bird");
		assertTrue(zoo.addAnimal("SherKhan", "Lion", 120, 10));
		assertTrue(zoo.addAnimal("mithu", "Parrot", 0.250, 10));
		assertTrue(zoo.addAnimal("Sheru", "Lion", 120, 10));
//		Animal animal=(Lion)zoo.zone.get(1).cageList.get(0).animal.get(0);
//		System.out.println(animal.getSound());
	}
	
	@Test(expected = AssertionError.class)
	public void addAnimalWhenZooIsFull() {
		Zoo zoo=new Zoo();
		zoo.addZone("Bird");
		zoo.addZone("Bird");
		zoo.addZone("Bird");
		zoo.addAnimal("SherKhan", "Lion", 120, 10);
	}

	@Test
	public void addCageWhenZoneIsNotFull() {
		Zoo zoo=new Zoo();
		zoo.addZone("Bird");
		assertTrue(zoo.addCage("Parrot"));
	}
	
	@Test(expected = AssertionError.class)
	public void addCageWhenZoneIsFull() {
		Zoo zoo=new Zoo();
		zoo.addZone("Bird");
		zoo.addCage("Parrot");
		zoo.addCage("Eagle");
	}
	
	@Test
	public void removeAnimalTest(){
		Zoo zoo=new Zoo();
		zoo.addZone("Bird");
		zoo.addAnimal("SherKhan", "Lion", 120, 10);
		zoo.addAnimal("Sheru", "Lion", 120, 10);
		assertTrue(zoo.removeAnimal("SherKhan", "Lion"));
		assertFalse(zoo.removeAnimal("mithu", "Lion"));
	}
}
