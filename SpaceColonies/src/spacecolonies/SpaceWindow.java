package spacecolonies;

import java.awt.Color;
import CS2114.Button;
import CS2114.CircleShape;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;


//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal,
//nor will I accept the actions of those who do.
//-- Steven Drake(scdrake19)

/**
 * Creates the SpaceWindow Object
 * which illustrates the Back End of
 * the project
 * @author Xander Dyer
 * @version 2020.08.10
 * 
 */
public class SpaceWindow 
{
    private Window window;
    private ColonyCalculator colonyCalculator;
    private Button accept;
    private Button reject;
    
 // ~ Constructor ...........................................................
    /**
     * new SpaceWindow Object
     * @param c ColonyCalculator actions Object to be illustrated
     */
    SpaceWindow(ColonyCalculator c)
    {
        window = new Window("Space Colony Placement");
        colonyCalculator = c;
        accept = new Button("Accept");
        accept.onClick(this, "clickedAccept");
        reject = new Button("Reject");
        reject.onClick(this, "clickedReject");
        window.addButton(accept, WindowSide.SOUTH);
        window.addButton(reject, WindowSide.SOUTH);
        // if the first person can't be accepted
        if(colonyCalculator.getQueue().isEmpty() ||
            colonyCalculator.getPlanetForPerson(colonyCalculator.getQueue().getFront()) == null) 
        {
            accept.disable();
            
        }
        //if the queue starts out empty
        if (colonyCalculator.getQueue().isEmpty())
        {
            window.removeAllShapes();
            
            TextShape t = new TextShape(0, 0, "All Applicants Processed - Good work!");
            int middleY = (int) (((double)window.getGraphPanelHeight() * 0.5) - ((double)t.getHeight() * (0.5)));
            int middleX = (int)(((double)window.getGraphPanelWidth() * 0.5) - ((double)t.getWidth() * (0.5)));
            t.setX(middleX);
            t.setY(middleY);
            t.setBackgroundColor(Color.WHITE);
            window.addShape(t);
            reject.disable();
        }    
        createPeople();
        createPlanets();
        
        
        
        
    }

 
    /**
     * Method for the accept button.
     * prompts the backEnd to run accept
     * if it can and updates visuals
     * @param a Button that is clicked
     * to run the method
     */
    public void clickedAccept(Button a)
    {
        // accepts opbject
        colonyCalculator.accept();
        window.removeAllShapes();
        createPeople();
        createPlanets();
        if (colonyCalculator.getPlanetForPerson(colonyCalculator.getQueue().getFront()) == null)
        {
            accept.disable();
        }
        // checks to see if queue is empty after accept button push so 
        // extra click isn't need to reveal final message
        if (colonyCalculator.getQueue().isEmpty())
        {
            window.removeAllShapes();
            TextShape t = new TextShape(0, 0, "All Applicants Processed - Good work!");
            int middleY = (int) (((double)window.getGraphPanelHeight() * 0.5) - ((double)t.getHeight() * (0.5)));
            int middleX = (int)(((double)window.getGraphPanelWidth() * 0.5) - ((double)t.getWidth() * (0.5)));
            t.setX(middleX);
            t.setY(middleY);
            t.setBackgroundColor(Color.WHITE);
            window.addShape(t);
            reject.disable();
        }
        
        
        

    }
    
    /**
     * Method for the reject button.
     * prompts the backEnd to run reject
     * if it can and updates vizuals
     * @param a Button that is clicked
     * to run the method
     */
    public void clickedReject(Button a)
    {
        colonyCalculator.reject();
         window.removeAllShapes();
         createPeople(); 
         createPlanets();
         // checks to see if accept can be used after reject button push
         if (!(colonyCalculator.getQueue().isEmpty() ||
         colonyCalculator.getPlanetForPerson(colonyCalculator.getQueue().getFront()) == null)) 
         {
             accept.enable();
         }
            
         // Checks to see if accept cannot be used after reject button push
         if (!colonyCalculator.getQueue().isEmpty() &&
             colonyCalculator.getPlanetForPerson(colonyCalculator.getQueue().getFront()) == null)
         {
             accept.disable();
         }
            
         // checks to see if queue is empty after reject button push so 
         // extra click isn't need to reveal final message
         if (colonyCalculator.getQueue().isEmpty())
         {
             window.removeAllShapes();
                
             TextShape t = new TextShape(0, 0, "All Applicants Processed - Good work!");
             int middleY = (int) (((double)window.getGraphPanelHeight() * 0.5) - ((double)t.getHeight() * (0.5)));
             int middleX = (int)(((double)window.getGraphPanelWidth() * 0.5) - ((double)t.getWidth() * (0.5)));
             t.setX(middleX);
             t.setY(middleY);
             t.setBackgroundColor(Color.WHITE);
             window.addShape(t);
             reject.disable();
         }    
            
            
        
        
        

    }
    
    /**
     * Illustration of the current
     * planet situation
     */
    public void createPlanets()
    {
        double size = 100;
        int yVal = 175;
        Planet[] pla = colonyCalculator.getPlanets();
        Shape[] illus = new Shape[pla.length];
        
        for (int i = 1; i < pla.length; i++)
        {

            // calculate capacity filler height
            double smallHeight = ((double)pla[i].getPopulationSize())/((double)pla[i].getCapacity()) * size;
            
            // planet filler shape
            illus[i] = new Shape((int)(((double)window.getGraphPanelWidth() * ((double)i)/4.0) - (size/2.0)), 
                (int)(yVal + size - smallHeight), (int) (size),
                (int) (smallHeight),
                getColorPlan(i + 3));
            window.addShape(illus[i]);
            
            //planet shape
            illus[i] = new Shape((int)(((double)window.getGraphPanelWidth() * ((double)i)/4.0) - (size/2.0)), 
                yVal,(int) (size), getColorPlan(i));
            window.addShape(illus[i]);
            
            //planet titles and info textShape
            TextShape title = new TextShape((int)(((double)window.getGraphPanelWidth() * ((double)i)/4.0) - (size/2.0)), 
                (int)(yVal + size), pla[i].getName() + ", " + pla[i].getPopulationSize() + "/" + pla[i].getCapacity());
            TextShape skill = new TextShape((int)(((double)window.getGraphPanelWidth() * ((double)i)/4.0) - (size/2.0)), 
                (int)(yVal + size + title.getHeight()), pla[i].getSkills().toString());
            title.setBackgroundColor(Color.WHITE);
            skill.setBackgroundColor(Color.WHITE);
            window.addShape(title);
            window.addShape(skill);
            
            
        }
    }
    
    /**
     * Visuals of people
     */
    public void createPeople()
    {
        int circleY = 50;
        int circleX = 50;
        int circleDiam = 50;
        CircleShape[] ill = new CircleShape[colonyCalculator.getQueue().getSize()];
        if (!colonyCalculator.getQueue().isEmpty())
        {
            // creates the people
            Object[] peep = colonyCalculator.getQueue().toArray();
            for (int i = 0; i < ill.length; i++)
            {
                ill[i] = new CircleShape(circleX + circleDiam * (i), 
                    circleY, circleDiam, getColorPers(((Person)peep[i]).getPlanetName()));
                window.addShape(ill[i]);
            
            
            }
            // displays current front of queues info in textShape
            TextShape current = new TextShape(10, 15, colonyCalculator.getQueue().getFront().toString());
            current.setBackgroundColor(Color.WHITE);
            window.addShape(current);
        }
    }
    
    /**
     * Determines the persons color
     * @param pNam String holidng
     * planet preference
     * @return color of the person
     */
    private Color getColorPers(String pNam)
    {
        // planet 1
        if (pNam.equals(colonyCalculator.planetByNumber(1).getName()))
        {
            return new Color(173, 147, 189);
        }
        // planet 2
        if (pNam.equals(colonyCalculator.planetByNumber(2).getName()))
        {
            return new Color(102, 176, 174);
        }
        // planet 3
        if (pNam.equals(colonyCalculator.planetByNumber(3).getName()))
        {
            return new Color(112, 148, 180);
        }
        // no preference or not one of 3
        else
        {
            return new Color(165, 209, 232);
        }
        
    }
    
    /**
     * Determines color of Planet and filler
     * @param pInd int for color conditionals
     * @return color of planet/ planetfiller
     */
    private Color getColorPlan(int pInd)
    {
        // planet 1
        if (pInd == 1)
        {
            return new Color(173, 147, 189);
        }
        // planet 2
        if (pInd == 2)
        {
            return new Color(102, 176, 174);
        }
        // planet filler 1
        if (pInd == 4)
        {
            return new Color(127, 96, 147);
        }
        // planet filler 2
        if (pInd == 5)
        {
            return new Color(58, 124, 122);
        }
        // planet filler 3
        if (pInd == 6)
        {
            return new Color(49, 86, 119);
        }
        // planet 3
        else
        {
            return new Color(112, 148, 180);
        }
    }
    
    
}
