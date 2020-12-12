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
public class Person {
    
    private String name;
    private Skills skills;
    private String planetPreference;
    
    /**
     * Class Constructor
     * @param name of person object
     * @param agri skill level
     * @param medi skill level
     * @param tech skill level
     * @param planet preferred planet choice
     */
    public Person(String name, int agri, int medi, int tech, String planet)
    {
        this.name = name;
        skills = new Skills(agri, medi, tech);
        planetPreference = planet;
    }
    
    /**
     * Getter method for name
     * @return String of name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Getter method for skills
     * @return Skills object
     */
    public Skills getSkills()
    {
        return skills;
    }
    
    /**
     * Getter method for planetPreference
     * @return String of preferred planet
     */
    public String getPlanetName()
    {
        return planetPreference;
    }
    
    /**
     * Returns a string of the person object's information
     * ex: Jane Doe A:3 M:2 T:1 Wants: Nars
     * @return string of person's info
     */
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        if (planetPreference == null)
        {
            string.append("No-Planet ");
        }
        string.append(name + " " + skills.toString());
        if (planetPreference != null)
        {
            string.append(" Wants: " + planetPreference);
        }
        return string.toString();
    }
    
    /**
     * Compares an object with this
     * @param obj the object to be compared
     * @return true if referencing the same object or
     * all fields are equal. false for all other outcomes
     */
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if ((obj == null) || (obj.getClass()
            != Person.class)) {
            return false;
        }
        Person object = (Person) obj;
        return (this.name == object.name &&
            this.skills.equals(object.skills) &&
            this.planetPreference == object.planetPreference);
    }

}
