 import java.util.ArrayList;
 import java.util.Scanner;
 import java.util.Random;
 import java.lang.reflect.Array;
 import javax.swing.*;
/**
 * Write a description of class Garden here.
 * 
 * @author Daniel VanderVeen 
 * @version Assignment 4
 */
public class Garden
{
    // instance variables - replace the example below with your own
    public static final int DEFAULT_GARDEN_LENGTH = 6;    
    public static final int DEFAULT_GARDEN_WIDTH = 3;    
    public static final int DEFAULT_INITIAL_SUNS = 400;
    public static final int MAX_ZOMBIES = 5;
    public static final int DAMAGE = 10;
    
    public int suns;
    
    private ArrayList<Plant> plants;    
    private ArrayList<Pea> peas;    
    private ArrayList<Plant> plant;    
    private ArrayList<Pea> pea;     
    private ArrayList<Zombie> zombie;    
    private ArrayList<Zombie> zombies;
    private ArrayList<Zombie> zombiee;
    private Random randomGenerator;
    
    public boolean finished = false;
    public boolean lost = false;
    public boolean win = false;
    public int gamecount = 1;
    public int x1;
    public int y1;
    
    /**
     * Constructor for objects of class Garden
     */
     public Garden()
    {
        // initialise instance variables        
        suns = DEFAULT_INITIAL_SUNS;        
        plants = new ArrayList<Plant>();
        plant = new ArrayList<Plant>();
        peas = new ArrayList<Pea>();
        pea = new ArrayList<Pea>();
        zombie = new ArrayList<Zombie>();
        zombies = new ArrayList<Zombie>();
        zombiee = new ArrayList<Zombie>();
        randomGenerator = new Random();        
    }
    
    public void addPlant(Plant pl)
    {        
        if((this.suns >= pl.getCost()) && (hasPlantAt(pl.getX(), pl.getY())) == false)
        {
            plants.add(pl);
            subtractSuns(pl.getCost());
        }else{
            JOptionPane.showMessageDialog(null,"Cannot place Plant");
            //System.out.println("\nCannot place Plant\n");
        }        
    }
    
    public Plant getPlantAt(int x, int y)
    {
        Plant plan = null;
        for(Plant plant: plants)
        {
            if(plant.getX() == x && plant.getY() == y)
            {
                plan = plant;
            }
        }
        return plan;
    }
    
    // I added getPeaAt here so that I could find the specific pea 
    // that is related to the zombie being destroyed.
    
    public Pea getPeaAt(int x, int y)
    {
        Pea pa = null;
        for(Pea p: peas)
        {
            if(p.getX() == x && p.getY() == y)
            {
                pa = p; 
            }
        }
        return pa;
    }
    
    public void addZombie(Zombie z)
    {
        zombie.add(z);
    }
    
    public void addPea(Pea p)
    {
        peas.add(p);
    }
    
    public void addSuns(int suns)
    {
        // adding suns to the total count for when the sunflower produces
        this.suns += suns;
    }
    
    // The instructions werent very secific on the damage from objects that were not 
    // zombies. Therefore I assigned all damage to 10, so peas could kill zombies in time.
    
    public void increment()
    {
        //
        gamecount++;
        for(Plant plan: plants)
        {
            if(hasZombieAt((plan.getX() + 1),(plan.getY())))
            {
                plan.subHealth(DAMAGE);
            }else{
                plan.increment();     
            }
        }
                
        for(Pea dealss: peas)
        {           
            dealss.increment();            
        }
        Pea peao = null;
        Pea pe = null;  // This is used to store the pea that I find in relation to zombie.
        for(Zombie z: zombie)
        {
            if((hasPlantAt((z.getX() - 1),(z.getY()))) || (hasZombieAt((z.getX() - 1),(z.getY()))))
            {
                //Do nothing
            }else{
                z.increment();
            }
            if(hasPeaAt((z.getX()),(z.getY())) || hasPeaAt((z.getX() + 1),(z.getY())))
            {
                z.subHealth(DAMAGE);
                pe = getPeaAt((z.getX()),(z.getY()));
                peao = getPeaAt((z.getX() + 1),(z.getY()));
                // Here we copy the pea that is destroying the zombie to a new Pea object.
            }
                     
        }
        
        // Here I go through the arraylist again and check to see a pea is equal to
        // the one from before that we saved to the new object.
        // If found that pea is then destroyed.
        
        for(Pea p: peas)
        {
            if(p.equals(pe))
            {
                p.subHealth(DAMAGE);
            }else if(p.equals(peao)){
                p.subHealth(DAMAGE);
            }
        }
        
        for(Pea q: peas)
            {
                if(q.getHealth() > 0)
                {
                    pea.add(q);
                }
            }
            peas.clear();
            for(Pea r: pea)
            {
                peas.add(r);
            }
            pea.clear();
            
            // PLANT:   Here we must move the alive plants into a new ArrayList 
            // and clear the old one. Then move everything back to the origional for next cycle.
            
            for(Plant plan: plants)
            {
                if(plan.getHealth() > 0)
                {
                    plant.add(plan);
                }
            }
            plants.clear();
            for(Plant pl: plant)
            {
                plants.add(pl);
            }
            plant.clear();  
            
            // ZOMBIE:  Here we have 3 zombie ArrayLists, one that holds the alive list,
            // one that holds the dead list, and one that is the origional. We seperate the
            // alive and dead ones into their seperate thier list and then clear the origional
            // and then put the alive list back into the origional.
            
            for(Zombie z: zombie)
            {
                if(z.getX() < 0)
                {
                    //System.out.println("You Lose!");
                    //System.out.println(zombies.size());
                    lost = true;
                }
                if(z.getHealth() <= 0)
                {
                    zombies.add(z); 
                }else{
                    zombiee.add(z);
                }
            }
            
            // Here we could not directly remove the zombies that are dead while iterating
            // so we move dead to one list, alive to another and clear the origional.
            // We then put alive back in the origional and keep the dead ones as an 
            // end game count.
            
            zombie.clear();
            for(Zombie z: zombiee)
            {
                zombie.add(z);
            }
            zombiee.clear();
            
            // Here zombies.size() is the amount of dead zombies aka the end game count.
            if(zombies.size() == MAX_ZOMBIES){
                //System.out.println("You Win!");
                win = true;
            }
                 
            // There is a gamecount here to give sufficient time to be able to aquire the 
            // resources to survive the incoming zombie attack.
            
            if(gamecount > 10){
                if((randomGenerator.nextInt(3) == 1) && (zombie.size() < 5))
                {
                    int y2 = randomGenerator.nextInt(3);
                    Zombie z = new Zombie(this,DEFAULT_GARDEN_LENGTH,y2);
                    addZombie(z);
                }
            }
        
    }
    
    public void print()
    {
        System.out.println("Plants vs Zombies!");
        System.out.println("----------------------");
        System.out.println(toString());    
    }
    
    public void subtractSuns(int suns)
    {
        // Subtracting suns to account for the amount of suns spent.
        this.suns -= suns;
    }
    
    public java.lang.String toString()
    {
        // The toString class preprogrammed is overridden.
        String s = "";
        int i,j;
        for(j = 0; j <= DEFAULT_GARDEN_WIDTH; j++)
        {
            for(i = 0; i <= DEFAULT_GARDEN_LENGTH; i++)
            {
                if(hasPlantAt(i,j))
                {
                    s += getPlantAt(i,j).toString();
                }else if(hasPeaAt(i,j))
                {
                    s += "o";
                }else if(hasZombieAt(i,j))
                {
                    s += "z";
                }else{
                    s += ".";
                }                
            }
            s += "\n";
        }
        return s;
    }
       
    public boolean hasPlantAt(int x, int y)
    {
        for(Plant plan: plants)
        {
            if((plan.getX() == x) && (plan.getY() == y))
            {
                return true;
            }
        }
        return false;
    }
        
    public boolean hasPeaAt(int x, int y)
    {
        //
        
        for(Pea dealss: peas)
        {
            if((dealss.getX() == x) && (dealss.getY() == y))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasZombieAt(int x, int y)
    {
        for(Zombie dealsss: zombie)
        {
            if((dealsss.getX() == x) && (dealsss.getY() == y))
            {
                return true;
            }
        }
        return false;
    }
    
}
    
    

