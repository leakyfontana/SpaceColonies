package spacecolonies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import bsh.ParseException;

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
public class ColonyReader 
{
    private Planet[] planets;
    private ArrayQueue<Person> queue;

 // ~ Constructor ...........................................................
    /**
     * new ColonyReader Object
     * @param applicantFileName String that 
     * contains the name of the file to be read for
     * the queue
     * @param planetFileName String that contains 
     * the name of the file to be read for the 
     * Planet array
     * @throws FileNotFoundException
     * @throws SpaceColonyDataException
     * @throws ParseException
     */
    public ColonyReader(String applicantFileName, String planetFileName) throws FileNotFoundException, SpaceColonyDataException, ParseException
    {
        queue = readQueueFile(applicantFileName);
        planets = readPlanetFile(planetFileName);
        
        SpaceWindow sw = new SpaceWindow(new ColonyCalculator(queue, planets));
    }
    
    /**
     * Returns the planets contained
     * in the file in array form
     *
     * @param fileName String that 
     * contains the planet info to
     * be read
     * @return Planet array containing
     * the planets from the file
     *  @throws FileNotFoundException
     * @throws SpaceColonyDataException
     * @throws ParseException
     */
    private Planet[] readPlanetFile(String fileName) throws FileNotFoundException, ParseException, SpaceColonyDataException
    {
        Scanner file = new Scanner(new File(fileName));
        Planet[] plan = new Planet[ColonyCalculator.NUM_PLANETS + 1];
        int i = 1;
        while (file.hasNextLine() || i <= ColonyCalculator.NUM_PLANETS)
        {
            
            String[] spl = file.nextLine().split(", *", 5);
            if (spl.length < 5)
            {
                throw new ParseException();
            }
            else if (!isInSkillRange(Integer.valueOf(spl[1]), Integer.valueOf(spl[2]), Integer.valueOf(spl[3])))
            {
                throw new SpaceColonyDataException("Skills not between 1 and 5");
                
            }
            
            
            plan[i] = new Planet(spl[0], Integer.valueOf(spl[1]),
                Integer.valueOf(spl[2]), Integer.valueOf(spl[3]), Integer.valueOf(spl[4]));
            i++;
        }
        
        if (i < ColonyCalculator.NUM_PLANETS)
        {
            throw new SpaceColonyDataException("Less than 3 Planets ");
        }
        return plan;
        
    }
    
    /**
     * Returns the people contained
     * in the file in ArrayQueue<Person>
     * form
     *
     * @param fileName String that 
     * contains the Person info to
     * be read
     * @return ArrayQueue of Persons
     * to be sorted 
     * @throws FileNotFoundException
     * @throws SpaceColonyDataException
     */
    private ArrayQueue<Person> readQueueFile(String fileName) throws SpaceColonyDataException, FileNotFoundException
    {
        Scanner file = new Scanner(new File(fileName));
        ArrayQueue<Person> ret = new ArrayQueue<Person>();
        
        int i = 0;
        while (file.hasNextLine())
        {
            
            String[] spl = file.nextLine().split(", *", 5);
            
            if (!isInSkillRange(Integer.valueOf(spl[1]), Integer.valueOf(spl[2]), Integer.valueOf(spl[3])))
            {
                throw new SpaceColonyDataException("Skills are not between 1 and 5");
                
            }
            Person ent;
            if (spl.length == 4)
            {
                ent = new Person(spl[0], Integer.valueOf(spl[1]), 
                    Integer.valueOf(spl[2]), Integer.valueOf(spl[3]), 
                    "");
            }
            else
            {
                ent = new Person(spl[0], Integer.valueOf(spl[1]), 
                    Integer.valueOf(spl[2]), Integer.valueOf(spl[3]), 
                    spl[4]); 
            }
             ret.enqueue(ent);
             file.hasNextLine();
           
        }
        return ret;
    }
    
    /**
     * Checks to see if an applicants
     * skills are in the valid
     * range
     *
     * @param num1 representing
     * agricultural skill
     * @param num2 representing
     * medicinal skill
     * @param num3 representing
     * technological skill
     * @return boolean that shows
     * whether or not all
     * 3 skills are in the valid
     * range
     */
    private boolean isInSkillRange(int num1, int num2, int num3)
    {
        return (num1 <= ColonyCalculator.MAX_SKILL_LEVEL && num1 >= ColonyCalculator.MIN_SKILL_LEVEL &&
            num2 <= ColonyCalculator.MAX_SKILL_LEVEL && num2 >= ColonyCalculator.MIN_SKILL_LEVEL 
            && num3 <= ColonyCalculator.MAX_SKILL_LEVEL && num3 >= ColonyCalculator.MIN_SKILL_LEVEL );
    }
    

}

