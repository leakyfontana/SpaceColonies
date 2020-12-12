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
public class Skills {
    
    private int agriculture;
    private int medicine;
    private int technology;
    
    /**
     * Constructor that takes three integers and sets field equal
     * to parameters.
     * @param ag agriculture field
     * @param med medicine filed
     * @param tech technology field
     */
    public Skills(int ag, int med, int tech)
    {
        agriculture = ag;
        medicine = med;
        technology = tech;
    }
    
    /**
     * Agriculture getter method.
     * @return agriculture field
     */
    public int getAgriculture()
    {
        return agriculture;
    }
    
    /**
     * Medicine getter method.
     * @return medicine field
     */
    public int getMedicine()
    {
        return medicine;
    }
    
    /**
     * Technology getter method.
     * @return technology field
     */
    public int getTechnology()
    {
        return technology;
    }
    
    /**
     * Compares two Skills objects
     * @param other Skills to be compared
     * @return true if all skills of this are equal or 
     * below the skills of other.
     */
    public boolean isBelow(Skills other)
    {
        return (this.agriculture <= other.agriculture &&
            this.medicine <= other.medicine &&
            this.technology <= other.technology);
    }
    
    /**
     * Returns a string of skill sets in this format: 
     * A:2 M:5 T:4
     * @return String string form of skills
     */
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        string.append("A:" + this.agriculture + " ");
        string.append("M:" + this.medicine + " ");
        string.append("T:" + this.technology);
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
            != Skills.class)) {
            return false;
        }
        Skills object = (Skills) obj;
        return (this.agriculture == object.agriculture &&
            this.medicine == object.medicine &&
            this.technology == object.technology);
    }

}
