	
/**
 * Write a description of class GardenItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class GardenItem
{
    // instance variables - replace the example below with your own
        
    protected int x;
    
    protected int y;
    
    protected Garden garden;
    
    protected int health;    
    
    protected int damage;

    /**
     * Constructor for objects of class GardenItem
     */
    public GardenItem(Garden g, int x, int y, int health)
    {
        // initialise instance variables
        this.garden = g;
        this.x = x;
        this.y = y;
        this.health = health;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getX()
    {
        // put your code here
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void subHealth(int health)
    {
        this.health -= health;
    }
    
    abstract public void increment();
}
