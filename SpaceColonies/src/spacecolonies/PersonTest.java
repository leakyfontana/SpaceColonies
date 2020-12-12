package spacecolonies;

/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and 
 * integrity at all times. I will not lie, cheat, or 
 * steal, nor will I accept the actions of those who do.
 * -- Xander Dyer (xdyer)
 * 
 * Tests the Person class.
 * 
 * @author Xander Dyer (xdyer)
 * @version 2020.08.10
 *
 */
public class PersonTest extends student.TestCase {

    private Person test;
    private Person test2;
    
    /**
     * Sets up testing conditions
     */
    public void setUp()
    {
        test = new Person("Rob", 3, 3, 3, "Earth");
    }
    
    /**
     * Tests the getter method
     */
    public void testGetName()
    {
        assertEquals("Rob", test.getName());
    }
    
    /**
     * Tests the getter method
     */
    public void testGetSkills()
    {
        assertEquals("A:3 M:3 T:3", test.getSkills().toString());
    }
    
    /**
     * Tests the getter method
     */
    public void testGetPlanetName()
    {
        assertEquals("Earth", test.getPlanetName());
    }
    
    
    /**
     * Tests the toString method
     */
    public void testToString()
    {
        assertEquals("Rob A:3 M:3 T:3 Wants: Earth", test.toString());
        test2 = new Person("Krista", 0, 0, 0, null);
        assertEquals("No-Planet Krista A:0 M:0 T:0", test2.toString());
    }
    
    /**
     * Tests the equals method
     */
    public void testEquals()
    {
        assertTrue(test.equals(test));
        String s = "hello";
        assertFalse(test.equals(s));
        test2 = new Person("Krista", 0, 0, 0, null);
        assertFalse(test.equals(test2));
        test2 = new Person("Rob", 3, 3, 3, "Earth");
        assertTrue(test.equals(test2));
        test2 = null;
        assertFalse(test.equals(test2));
    }
}
