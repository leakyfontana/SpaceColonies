package spacecolonies;

import list.AList;
import student.TestCase;

/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and 
 * integrity at all times. I will not lie, cheat, or 
 * steal, nor will I accept the actions of those who do.
 * -- Xander Dyer (xdyer)
 * 
 * Tests the ColonyCalculator class.
 * 
 * @author Xander Dyer (xdyer)
 * @version 2020.08.10
 *
 */
public class ColonyCalculatorTest extends TestCase
{
    private ColonyCalculator col;
    
    /**
     * Sets up each of the test methods
     */
    public void setUp()
    {
        ArrayQueue<Person> ent = new ArrayQueue();
        Planet plan = new Planet("Lit", 3, 3, 3, 3);
        Planet plan2 = new Planet("Hype", 4, 4, 4, 20);
        Planet plan3 = new Planet("Dope", 2, 2, 2, 21);
        Planet[] plane = {null, plan, plan2, plan3};
        col = new ColonyCalculator(ent, plane);
    }
    
    /**
     * testGetters()
     * Tests the ColonyCalculators's get() methods to
     * ensure they work as intended
     */
    public void testGetters()
    {
        assertFalse(col.accept());
        col.getQueue().enqueue(null);
        assertFalse(col.accept());
        col.getQueue().clear();
        col.reject();
        Planet[] p = col.getPlanets();
        col.getQueue();
        new Planet("Lit", 3, 3, 3, 10);
        assertEquals(col.planetByNumber(0),
            col.planetByNumber(ColonyCalculator.NUM_PLANETS + 1));
        
        Exception ed = null;
        try
        {
            new ColonyCalculator(null, p);
        }
        catch (Exception e)
        {
            ed = e;
        }
        assertNotNull(ed);
        Person pete = new Person("Pete", 3, 3, 3, "Lit");
        col.getPlanetForPerson(pete);
        Person perc = null;
        assertNull(col.getPlanetForPerson(perc));
        Person pet = new Person("Pet", 3, 3, 3, "hop");
        col.getPlanetForPerson(pet);
        Person under = new Person("Pete", 3, 3, 2, "Hype");
        col.getPlanetForPerson(under);
        for (int i = 0; i < 3; i++)
        {   
            col.getQueue().enqueue(pete);
            col.accept();
        }
        col.getPlanetForPerson(pete);
        
        Person pref = new Person("profess", 4, 4, 4, "");
        for (int i = 0; i < 41; i++)
        {
            col.getQueue().enqueue(pref);
            col.accept();
        }
        col.getPlanetForPerson(pete);
        
        col.getQueue().enqueue(pete);
        col.reject();
        
    }
}

