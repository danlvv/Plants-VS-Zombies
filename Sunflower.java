
/**
 * Write a description of class Sunflower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sunflower extends Plant
{
    // instance variables - replace the example below with your own
    public static final int COST = 50;
    
    public static final int DEFAULT_PRODUCTION_CYCLE = 3;
    
    public static final int YIELD = 20;
    
    public static final int INITIAL_HEALTH = 20;
        
    private int positionInCycle;

    /**
     * Constructor for objects of class Sunflower
     */
    public Sunflower(Garden g, int x, int y)
    {
        // initialise instance variables
        super(g,x,y,INITIAL_HEALTH);
        positionInCycle = 0;        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
    public void increment()
    {
        //
        if(positionInCycle == DEFAULT_PRODUCTION_CYCLE)
        {
            positionInCycle = 0;
            garden.addSuns(YIELD);
        }else{
            positionInCycle += 1;
        }
    }
    
    public void produceSun()
    {
        garden.addSuns(YIELD);
    }
    
    public int getCost()
    {
        return COST;
    }
    
    public String toString()
    {
        return "S";
    }
}
