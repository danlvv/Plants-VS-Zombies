
/**
 * Write a description of class Plant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Plant extends GardenItem
{
    // instance variables - replace the example below with your own
    public static final int COST = 0;

    /**
     * Constructor for objects of class Plant
     */
    public Plant(Garden g, int x, int y, int health)
    {
        // initialise instance variables
        super(g,x,y,health);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    abstract public int getCost();
           
    
    public void increment()
    {
        //
    }
}
