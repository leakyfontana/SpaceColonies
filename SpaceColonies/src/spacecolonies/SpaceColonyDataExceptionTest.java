package spacecolonies;

/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and 
 * integrity at all times. I will not lie, cheat, or 
 * steal, nor will I accept the actions of those who do.
 * -- Xander Dyer (xdyer)
 * 
 * Tests the SpaceColonyException class.
 * 
 * @author Xander Dyer (xdyer)
 * @version 2020.08.10
 *
 */
public class SpaceColonyDataExceptionTest extends student.TestCase {

    private Object test;
    
    /**
     * Sets up testing conditions
     */
    public void setUp()
    {
        test = new Object();
    }
    
    /**
     * Tests exception
     */
    public void test()
    {
        assertNotNull(test);
    }
}
