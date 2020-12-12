package spacecolonies;

import queue.EmptyQueueException;

/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and 
 * integrity at all times. I will not lie, cheat, or 
 * steal, nor will I accept the actions of those who do.
 * -- Xander Dyer (xdyer)
 * 
 * Tests the ArrayQueue class.
 * 
 * @author Xander Dyer (xdyer)
 * @version 2020.08.10
 *
 */
public class ArrayQueueTest extends student.TestCase {
    
    private ArrayQueue<Person> test;
    private ArrayQueue<Person> test2;
    private Person tp;
    private Person tp2;
    private Person tp3;
    private Person tp4;
    private Person tp5;
    
    /**
     * Sets up testing conditions
     */
    public void setUp()
    {
        test = new ArrayQueue<Person>();
        test2 = new ArrayQueue<Person>();
        tp = new Person("Rob", 3, 3, 3, "Earth");
        tp2 = new Person("Carly", 3, 2, 4, "Earth");
        tp3 = new Person("Carl", 0, 2, 5, "Mars");
        tp4 = new Person("Patty", 4, 4, 4, "Pluto");
        tp5 = new Person("Sara", 0, 1, 0, "Saturn");
    }
    
    /**
     * Tests the getLength method
     */
    public void testGetLength()
    {
        assertEquals(11, test.getLength());
    }
    
    /**
     * Tests the getSize method
     */
    public void testGetSize()
    {
        assertEquals(0, test.getSize());
        test.enqueue(tp);
        assertEquals(1, test.getSize());
    }
    
    /**
     * Tests the isEmpty method
     */
    public void testIsEmpty()
    {
        assertTrue(test.isEmpty());
        test.enqueue(tp);
        assertFalse(test.isEmpty());
    }
    
    /**
     * Tests the clear method
     */
    public void testClear()
    {
        test.enqueue(tp);
        test.enqueue(tp2);
        test.enqueue(tp3);
        test.enqueue(tp4);
        test.enqueue(tp5);
        test.clear();
        assertTrue(test.isEmpty());
    }
    
    /**
     * Tests the enqueue method
     */
    public void testEnqueue()
    {
        assertTrue(test.isEmpty());
        test.enqueue(tp);
        assertFalse(test.isEmpty());
        assertEquals(1, test.getSize());
        for (int i = 0; i < 99; i++)
        {
            test.enqueue(tp);
        }
        assertEquals(100, test.getSize());
        Exception exception = null;
        try {
            test.enqueue(tp);
        }
        catch (IllegalStateException e) {
            exception = e;
        }
        assertNotNull(exception);
    }
    
    /**
     * Tests the dequeue method
     */
    public void testDequeue()
    {
        Exception exception = null;
        try {
            test.dequeue();
        }
        catch (EmptyQueueException e) {
            exception = e;
        }
        assertNotNull(exception);
        test.enqueue(tp);
        test.enqueue(tp2);
        test.enqueue(tp3);
        test.enqueue(tp4);
        test.enqueue(tp5);
        assertEquals(tp, test.dequeue());
        assertEquals(4, test.getSize());
    }
    
    /**
     * Tests the getFront method
     */
    public void testGetFront()
    {
        test.enqueue(tp);
        test.enqueue(tp2);
        test.enqueue(tp3);
        test.enqueue(tp4);
        test.enqueue(tp5);
        assertEquals(tp, test.getFront());
    }
    
    /**
     * Tests the toString method
     */
    public void testToString()
    {
        test.enqueue(tp);
        test.enqueue(tp2);
        test.enqueue(tp3);
        test.enqueue(tp4);
        test.enqueue(tp5);
        assertEquals("[Rob A:3 M:3 T:3 Wants: Earth, Carly A:3 "
            + "M:2 T:4 Wants: Earth, Carl A:0 M:2 T:5 Wants: Mars,"
            + " Patty A:4 M:4 T:4 Wants: Pluto, Sara A:0 M:1 T:0 "
            + "Wants: Saturn]", test.toString());
    }
    
    /**
     * Tests the toArray method
     */
    public void testToArray()
    {
        Person[] temp = new Person[4];
        temp[0] = tp;
        temp[1] = tp2;
        temp[2] = tp3;
        temp[3] = tp4;
        test.enqueue(tp);
        test.enqueue(tp2);
        test.enqueue(tp3);
        test.enqueue(tp4);
        for (int i = 0; i < temp.length; i++)
        {
            assertEquals(temp[i], test.toArray()[i]);
        }

    }

    /**
     * Tests the equals method
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals()
    {
        assertTrue(test.equals(test));
        String temp = "";
        assertFalse(test.equals(temp));
        test.enqueue(tp);
        test.enqueue(tp2);
        test.enqueue(tp3);
        test.enqueue(tp4);
        test.enqueue(tp5);
        test2.enqueue(tp);
        test2.enqueue(tp2);
        test2.enqueue(tp3);
        test2.enqueue(tp4);
        assertFalse(test.equals(test2));
        test2.enqueue(tp5);
        assertTrue(test.equals(test2));
        test2.dequeue();
        test2.enqueue(tp);
        assertFalse(test.equals(test2));
        test2 = null;
        assertFalse(test.equals(test2));
    }
}
