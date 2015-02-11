
/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends GardenItem
{
    // instance variables - replace the example below with your own
    public static final int INITIAL_HEALTH = 9;

    /**
     * Constructor for objects of class Zombie
     */
    public Zombie(Garden g, int x, int y)
    {
        // initialise instance variables
        super(g,x,y,INITIAL_HEALTH);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void increment()
    {
        // put your code here        
        x -= 1;
    }
    
}
