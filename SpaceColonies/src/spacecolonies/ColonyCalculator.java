package spacecolonies;

import list.AList;

/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and 
 * integrity at all times. I will not lie, cheat, or 
 * steal, nor will I accept the actions of those who do.
 * -- Xander Dyer (xdyer)
 * 
 * Colony Calculator class
 * 
 * @author Xander Dyer (xdyer)
 * @version 2020.08.10
 *
 */
public class ColonyCalculator 
{
    /** 
     * @constant MIN_SKILL_LEVEL
     * holding the minimum skill level 
     * possible
     */
    public static final int MIN_SKILL_LEVEL = 1;
    /**
     * @constant MAX_SKILL_LEVEL 
     * holding the maximum skill level 
     * possible
     */
    public static final int MAX_SKILL_LEVEL = 5;
    /**
     * @constant NUM_PLANETS
     * holding the number of planets
     */
    public static final int NUM_PLANETS = 3;
    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;
    private static Planet[] planets; 
    
 // ~ Constructor ...........................................................
    /**
     * new ColonyCalculator Object
     * @param queue ArrayQueue that holds all
     * the people
     * @param plan Planet array that holds
     * all the planets
     */
    ColonyCalculator(ArrayQueue<Person> queue, Planet[] plan)
    {
        if (queue == null)
        {
            throw new IllegalArgumentException();
        }
        planets = plan;
        applicantQueue = queue;
        rejectBus = new AList<Person>();
    }
    
    /**
     * Returns the planets instance
     * data in array form
     *
     * @return planets array containing
     * the planets 
     */
    public  static Planet[] getPlanets()
    {
        return planets;
    }
    
    /**
     * Returns the applicantQueue instance
     * data in ArrayQueue form
     *
     * @return applicantQueue containing
     * all the Persons
     */
    public ArrayQueue<Person> getQueue()
    {
        return applicantQueue;
    }
    
    /**
     * Returns the planets with that 
     * given index, if it exists
     * @param planet int that holds 
     * the index of the planet
     * @return Planet at the specified
     * index
     */
    public Planet planetByNumber(int planet)
    {
        if (planet < 1 || planet > NUM_PLANETS)
        {
            return null;
        }
        else
        {
            return planets[planet];
        }
    }
    
    
    /**
     * Returns the index of the planet 
     * with the given name if it exists
     * @param planet String that holds 
     * the name of the planet
     * @return index of the planet
     */
    public int getPlanetIndex(String planet)
    {
        int ret = 0;
        for (int i = 1; i < NUM_PLANETS + 1; i++)
        {
            if (planet.equals(planetByNumber(i).getName()))
            {
                ret = i;
            }
        }
        return ret;
    }
    
    /**
     * Returns the preferred planet 
     * of the Person, if it exists, 
     * isn't full, and they qualify
     * @param p Person trying to find
     * preferred planet
     * @param x int containing index 
     * of the planet
     * @return Planet they prefer
     */
    private Planet getPreferredPlanet(Person p, int x)
    {
        Planet temp = planetByNumber(x);
        if (x == 0)
        {
            return null;
        }
        else if (temp.isFull())
        {
            return null;
        }
        else if (temp.isQualified(p))
        {
            return temp;
        }
        return null;
    }
    
    /**
     * Returns the planet with the
     * highest capacity they can
     * get into 
     * @param nextPerson Person 
     * trying to find a planet
     * @return Planet that's available
     */
    private Planet getMostAvailablePlanet(Person nextPerson)
    {
        if (NUM_PLANETS == 0)
        {
            return null;
        }
        Planet p = new Planet("", 1, 1, 1, 0);
        for (int i = 1; i < NUM_PLANETS + 1; i++)
        {
            if (p.getAvailability() <= planetByNumber(i).getAvailability() 
                && planetByNumber(i).isQualified(nextPerson))
            {
                p = planetByNumber(i);
            }
        }
        if (p.getAvailability() == 0)
        {
            return null;
        }
        return p;
    }
    
    /**
     * Returns the preferred planet 
     * for the Person, if it exists,
     * either preferred or most 
     * available depending on circumstances
     * @param nextPerson Person trying to find
     * a planet
     * @return Planet got
     */   
    public Planet getPlanetForPerson(Person nextPerson)
    {
        if (NUM_PLANETS == 0)
        {
            return null;
        }
        if (nextPerson == null)
        {
            return null;
        }
        if (getPreferredPlanet(nextPerson, 
            getPlanetIndex(nextPerson.getPlanetName())) != null)
        {
            return getPreferredPlanet(nextPerson, 
                getPlanetIndex(nextPerson.getPlanetName()));
        }
        else if (getMostAvailablePlanet(nextPerson) != null)
        {
            return getMostAvailablePlanet(nextPerson);
        }
        return null;
    }
    
    /**
     * Returns whether or not
     * the person got into a planet
     * @return Whether or not
     * a Person was accepted into a 
     * planet
     */
    public boolean accept()
    {
        if (applicantQueue.isEmpty())
        {
            return false;
        }
        Planet p = getPlanetForPerson(applicantQueue.getFront());
        if (p == null)
        {
            return false;
        }
        return p.addPerson(applicantQueue.dequeue());
        
    }
    
    /**
     * Rejects the next applicant in the queue 
     * if possible
     */
    public void reject()
    {
        if (!applicantQueue.isEmpty())
        {
            rejectBus.add(applicantQueue.dequeue());
        }
    }

}

