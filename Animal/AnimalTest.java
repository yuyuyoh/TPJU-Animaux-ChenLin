import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AnimalTest {
    private Habitat habitat1;
    private Animal animal1;

    @Before
    public void setUp() {
        habitat1 = new Habitat("Savanna");
        animal1 = new Animal("Lion", 100);
        
        // Établir l'association entre l'animal et l'habitat
        animal1.setHabitat(habitat1);
    }
    
    @Test
    public void testEatIncreasesEnergy() {
        Animal lion = new Animal("Lion", 100);
        lion.eat(50);
        assertEquals(150, lion.getEnergy());
    }
    
    @Test
    public void testGrowOldIncreasesAge() {
        Animal tiger = new Animal("Tiger", 80);
        tiger.growOld();
        assertEquals(1, tiger.getAge());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testEatNegativeThrowsException() {
        Animal zebra = new Animal("Zebra", 60);
        zebra.eat(-10);
    }
    
    @Test
    public void testCalculateDailyNeeds() {
        // animal1 est associé à "Savanna" dans setUp()
        int needs = animal1.calculateDailyNeeds();
        assertEquals("Un lion en savane a besoin de 30 unités", 30, needs);
    }

    @Test
    public void testCanSurvive() {
        // animal1 a 100 énergie, besoins = 30 → doit survivre
        boolean survival = animal1.canSurvive();
        assertTrue("Le lion devrait survivre", survival);
        
        // Test supplémentaire: animal avec peu d'énergie
        Animal weakAnimal = new Animal("WeakLion", 10);
        weakAnimal.setHabitat(habitat1);
        assertFalse("Animal avec 10 énergie ne devrait pas survivre", weakAnimal.canSurvive());
    }

    @Test
    public void testDescribeWithHabitat() {
        String description = animal1.describe();
        // Format attendu: "Lion (100 energy) lives in Savanna"
        assertTrue("La description doit mentionner la savane", 
                   description.contains("Savanna"));
        assertTrue("La description doit montrer l'énergie", 
                   description.contains("100 energy"));
    }
    
    // Tests supplémentaires optionnels
    @Test
    public void testCalculateDailyNeedsWithoutHabitat() {
        Animal homeless = new Animal("Homeless", 100);
        assertEquals(20, homeless.calculateDailyNeeds());
    }
    
    @Test
    public void testDescribeWithoutHabitat() {
        Animal homeless = new Animal("Homeless", 50);
        String description = homeless.describe();
        assertTrue("Devrait indiquer 'homeless'", description.contains("homeless"));
        assertTrue("Devrait montrer l'énergie", description.contains("50 energy"));
    }
    
    @Test
    public void testMoveToHabitat() {
        Animal animal = new Animal("Elephant", 100);
        Habitat forest = new Habitat("Forest");
        
        animal.moveTo(forest);
        assertEquals(forest, animal.getHabitat());
        assertEquals(90, animal.getEnergy()); // 10 énergie dépensée pour le déplacement
    }

    @Test
    public void testMoveToDecreasesEnergy()
    {
    }
}
