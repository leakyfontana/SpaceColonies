package spacecolonies;

/**
 * Virginia Tech Honor Code Pledge:
 * 
 * As a Hokie, I will conduct myself with honor and 
 * integrity at all times. I will not lie, cheat, or 
 * steal, nor will I accept the actions of those who do.
 * -- Xander Dyer (xdyer)
 * 
 * 
 * 
 * @author Xander Dyer (xdyer)
 * @version 2020.08.10
 *
 */
public class Planet 
{
    private String name;
    private Skills minSkills;
    private Person[] population;
    private int populationSize;
    private int capacity;
 // ~ Constructor ...........................................................
    /**
     * new Planet Object
     * @param planetName String containing the planet name
     * @param planetAgri int containing minimum agriculture
     * score to qualify
     * @param planetMedi int containing minimum medical 
     * score to qualify
     * @param planetTech int containing minimum technology 
     * score to qualify
     * @param planetCap int containing capacity of the planet
     */
    public Planet(String planetName, int planetAgri, 
        int planetMedi, int planetTech, int planetCap)
    {
        name = planetName;
        minSkills = new Skills(planetAgri, planetMedi, planetTech);
        capacity = planetCap;
        population = new Person[capacity];
        populationSize = 0;
    }
    
 
    /**
     * Changes the name of
     * the planet to the specified
     * String
     *
     * @param nam String     you'd like
     * to set the name to
     */
    public void setName(String nam)
    {
        name = nam;
    }
    
    /**
     * Returns the name of the 
     * planet in string form
     * @return String form 
     * of name
     */
    public String getName()
    {
        return name;
    }
    /**
     * Returns the minimum
     * required to get into the planet
     * @return Skills needed to
     * get into planet
     */
    public Skills getSkills()
    {
        return minSkills;
    }
    
    /**
     * Returns current population
     * of the planet as a Person
     * array
     *
     * @return Person[] array with
     * everyone currently on the 
     * planet
     */
    public Person[] getPopulation()
    {
        return population;
    }
    
    /**
     * Returns the population size
     * of the planet in integer 
     * form
     *
     * @return int containing the
     * size of the population
     */
    public int getPopulationSize()
    {
        return populationSize;
    }
    
    /**
     * Returns the capacity of 
     * the planet
     *
     * @return int containing
     * number of people that can
     * fit on the planet
     */
    public int getCapacity()
    {
        return capacity;
    }
    
    /**
     * Returns how much space is left
     * on the planet in in form
     *
     * @return int containing space
     * left on planet
     */
    public int getAvailability()
    {
        return capacity - populationSize;
    }
    
    /**
     * Returns whether or not the planet
     * is full
     *
     * @return boolean of whether
     * the planet is full or not
     */
    public boolean isFull()
    {
        return capacity == populationSize;
    }
    
    /**
     * Adds person to the planet
     * @param newbie Person to be added if they
     * can
     * @return whether or not a Person was successfully 
     * added
     */
    public boolean addPerson(Person newbie)
    {
        if (!isFull() && isQualified(newbie))
        {
            population[populationSize] = newbie;
            populationSize++;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Checks if person is qualified
     * to be added to the planet
     * @param p Person to be checked if they
     * qualify
     * @return boolean showing whether 
     * or not they are qualified
     */
    public boolean isQualified(Person p)
    {
        return !p.getSkills().isBelow(minSkills);
    }
    
    /**
     * Returns the Planet in String form
     *
     * @return String form of the planet
     */
    public String toString()
    {
        String ret = name + ", population " 
            + populationSize + " (cap: " + 
            capacity + "), Requires: A >= "
            + minSkills.getAgriculture() 
            + ", M >= " + minSkills.getMedicine() +
            ", T >= " + minSkills.getTechnology();
        return ret;
    }
    
    /**
     * Returns whether or not
     * two objects are equal
     * @param obj Object to be checked
     * if this is equal to
     * @return boolean of whether
     * or not they are
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        else if (obj == null) 
        {
            return false;
        }
        
        else if (getClass() == obj.getClass())
        {
            Planet temp = (Planet)(obj);
            return name.equals(temp.getName()) && 
                minSkills.equals(temp.getSkills()) &&
                capacity == temp.getCapacity() &&
                populationSize == temp.getPopulationSize();
        }
        return false;
    }
    
    /**
     * Returns a comparison between
     * 2 planets capacities in int
     * for
     * @param other Planet to compare
     * to
     * @return int of how different their 
     * capicities are
     */
    public int compareTo(Planet other)
    {
        return capacity - other.getCapacity();
    }
}
