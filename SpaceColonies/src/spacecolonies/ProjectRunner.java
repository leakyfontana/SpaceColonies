package spacecolonies;

import java.io.FileNotFoundException;
import bsh.ParseException;

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
public class ProjectRunner 
{

    /**
     * Main Method, runs the project
     * @param args 
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException, SpaceColonyDataException
    {
        
        if(args.length == 2)
        {
            ColonyReader colon = new ColonyReader(args[0], args[1]);
        }
        else
        {
            ColonyReader colon = new ColonyReader("input.txt", "planets.txt");
        }
    }


}

