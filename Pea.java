
/**
 * Write a description of class Pea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pea extends GardenItem
{
    // instance variables - replace the example below with your own
    public static final int INITIAL_HEALTH = 1;
    
    public static final int DAMAGE = 5;
    
    /**
     * Constructor for objects of class Pea
     */
    public Pea(Garden g, int x, int y)
    {
        // initialise instance variables
        super(g,x,y,INITIAL_HEALTH);
    }
    
    public int getDamage(){
        return DAMAGE;
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
        x += 1;
        if(x > 6)
        {
            super.subHealth(INITIAL_HEALTH);
        }     
        
        
    }
}
