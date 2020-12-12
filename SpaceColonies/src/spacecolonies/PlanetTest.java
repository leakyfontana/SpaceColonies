package spacecolonies;

/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and 
 * integrity at all times. I will not lie, cheat, or 
 * steal, nor will I accept the actions of those who do.
 * -- Xander Dyer (xdyer)
 * 
 * Tests the Planet class.
 * 
 * @author Xander Dyer (xdyer)
 * @version 2020.08.10
 *
 */
public class PlanetTest  extends student.TestCase {
    
    private Planet test;
    private Planet test2;
    private Person tp;
    private Person tp3;
    
    /**
     * Sets up testing conditions
     */
    public void setUp()
    {
        test = new Planet("Namek", 3, 4, 3, 8);
        tp = new Person("Rob", 5, 5, 5, "Earth");
        tp3 = new Person("Carl", 0, 2, 5, "Mars");
    }
    
    /**
     * Tests the setName method
     */
    public void testSetName()
    {
        test.setName("Nam");
        assertEquals("Nam", test.getName());
    }
    
    /**
     * Tests the getName method
     */
    public void testGetName()
    {
        assertEquals("Namek", test.getName());
    }
    
    /**
     * Tests the getName method
     */
    public void testGetSkills()
    {
        assertEquals("A:3 M:4 T:3", test.getSkills().toString());
    }
    
    /**
     * Tests the getCapacity method
     */
    public void testGetCapacity()
    {
        assertEquals(8, test.getCapacity());
    }
    
    /**
     * Tests the getPopulationSize method
     */
    public void testGetPopulationSize()
    {
        assertEquals(0, test.getPopulationSize());
        test.addPerson(tp);
        assertEquals(1, test.getPopulationSize());
    }
    
    /**
     * Tests the getAvailability method
     */
    public void testGetAvailability()
    {
        test.addPerson(tp);
        test.addPerson(tp);
        test.addPerson(tp);
        assertEquals(5, test.getAvailability());
    }
    
    /**
     * Tests the getPopulation method
     */
    public void testGetPopulation()
    {
        test.addPerson(tp);
        test.addPerson(tp);
        test.addPerson(tp);
        Person[] temp = new Person[3];
        temp[0] = tp;
        temp[1] = tp;
        temp[2] = tp;
        for (int i = 0; i < temp.length; i++)
        {
            assertEquals(temp[i], test.getPopulation()[i]);
        }
    }
    
    /**
     * Tests the isQualified method
     */
    public void testIsQualified()
    {
        assertFalse(test.isQualified(tp3));
        assertTrue(test.isQualified(tp));
    }
    
    /**
     * Tests the addPerson method
     */
    public void testAddPerson()
    {
        assertFalse(test.isQualified(tp3));
        assertTrue(test.isQualified(tp));
    }
    
    /**
     * Tests the toString method
     */
    public void testToString()
    {
        assertEquals("Namek , population 0(cap: 8), Requires:"
            + " A >= 3, M >= 4, T >= 3", test.toString());
    }
    
    /**
     * Tests the isFull method
     */
    public void testIsFull()
    {
        test.addPerson(tp);
        test.addPerson(tp);
        test.addPerson(tp);
        test.addPerson(tp);
        test.addPerson(tp);
        test.addPerson(tp);
        test.addPerson(tp);
        test.addPerson(tp);
        assertTrue(test.isFull());
    }
    
    /**
     * Tests the equals method
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals()
    {
        assertTrue(test.equals(test));
        test2 = null;
        assertFalse(test.equals(test2));
        String comp = "";
        assertFalse(test.equals(comp));
        test2 = new Planet("Souvlaki", 3, 4, 3, 8);
        assertFalse(test.equals(test2));
        test2 = new Planet("Namek", 4, 4, 3, 8);
        assertFalse(test.equals(test2));
        test2 = new Planet("Namek", 3, 5, 3, 8);
        assertFalse(test.equals(test2));
        test2 = new Planet("Namek", 3, 4, 6, 8);
        assertFalse(test.equals(test2));
        test2 = new Planet("Namek", 3, 4, 3, 7);
        assertFalse(test.equals(test2));
        test2 = new Planet("Namek", 3, 4, 3, 8);
        test.addPerson(tp);
        assertFalse(test.equals(test2));
        test2.addPerson(tp);
        assertTrue(test.equals(test2));  
    }
    
    /**
     * Tests the compareTo method
     */
    public void testCompareTo()
    {
        test2 = new Planet("Souvlaki", 3, 4, 3, 5);
        assertEquals(1, test.compareTo(test2));
        assertEquals(-1, test2.compareTo(test));
        test2 = new Planet("Namek", 3, 4, 3, 8);
        assertEquals(0, test2.compareTo(test));
    }
    
    

}
