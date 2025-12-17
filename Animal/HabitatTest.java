

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class HabitatTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HabitatTest
{
    private Habitat habitat1;
    private Animal animal1;

    
    

    
    

    /**
     * Default constructor for test class HabitatTest
     */
    public HabitatTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        habitat1 = new Habitat("Savana");
        animal1 = new Animal("Lion", 100);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}