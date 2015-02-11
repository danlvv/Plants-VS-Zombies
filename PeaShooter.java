
/**
 * Write a description of class PeaShooter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PeaShooter extends Plant
{
    // instance variables - replace the example below with your own
    public static final int COST = 100;
    
    public static final int SHOT_PERIODICITY = 2;
    
    public static final int INITIAL_HEALTH = 20;
    
    private int positionInCycle;
   
    /**
     * Constructor for objects of class PeaShooter
     */
    public PeaShooter(Garden g, int x, int y)
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
        if(positionInCycle == SHOT_PERIODICITY)
        {
            positionInCycle = 0;
            this.shoot();
        }else{
            positionInCycle += 1;
        }
    }
    
    private void shoot()
    {
        Pea pe = new Pea(garden,super.getX() + 1,super.getY());
        garden.addPea(pe);
    }
    
    public int getCost()
    {
        return COST;
    }
    
    public String toString()
    {
        return "P";
    }
    
}
