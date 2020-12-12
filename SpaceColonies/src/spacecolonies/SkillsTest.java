package spacecolonies;

/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and 
 * integrity at all times. I will not lie, cheat, or 
 * steal, nor will I accept the actions of those who do.
 * -- Xander Dyer (xdyer)
 * 
 * Tests the skills class.
 * 
 * @author Xander Dyer (xdyer)
 * @version 2020.08.10
 *
 */
public class SkillsTest extends student.TestCase {
    
    private Skills test;
    private Skills test2;
    
    /**
     * Sets up testing conditions
     */
    public void setUp()
    {
        test = new Skills(4, 3, 0);
    }
    
    /**
     * Tests the getter method
     */
    public void testGetAgriculture()
    {
        assertEquals(4, test.getAgriculture());
    }
    
    /**
     * Tests the getter method
     */
    public void testGetMedicine()
    {
        assertEquals(3, test.getMedicine());
    }
    
    /**
     * Tests the getter method
     */
    public void testGetTechnology()
    {
        assertEquals(0, test.getTechnology());
    }
    
    /**
     * Tests the isBelow method
     */
    public void testIsBelow()
    {
        test2 = new Skills(5, 5, 0);
        assertTrue(test.isBelow(test2));
        test2 = new Skills(4, 3, 0);
        assertTrue(test.isBelow(test2));
        test2 = new Skills(0, 0, 0);
        assertFalse(test.isBelow(test2));
    }
    
    /**
     * Tests the toString method
     */
    public void testToString()
    {
        assertEquals("A:4 M:3 T:0", test.toString());
    }
    
    /**
     * Tests the equals method
     */
    public void testEquals()
    {
        assertTrue(test.equals(test));
        String s = "hello";
        assertFalse(test.equals(s));
        test2 = new Skills(5, 5, 0);
        assertFalse(test.equals(test2));
        test2 = new Skills(4, 3, 0);
        assertTrue(test.equals(test2));
        test2 = null;
        assertFalse(test.equals(test2));
    }

}
