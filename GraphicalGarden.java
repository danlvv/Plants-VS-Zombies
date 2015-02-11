import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.IOException;
/**
 * Write a description of class GraphicalGarden here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GraphicalGarden extends Garden implements ActionListener
{
    // instance variables - replace the example below with your own
    private JFrame gameFrame;
    private JPanel gardenPanel;
    
    private JButton[][] grid;
    
    public String temp = "";    
    
    /**
     * Constructor for objects of class GraphicalGarden
     */
    public GraphicalGarden() 
    {
        gameFrame = new JFrame("Plants vs Zombies");        
        Container contentPane = gameFrame.getContentPane();        
        contentPane.setLayout(new BorderLayout());
                                
        gardenPanel = new JPanel(new GridLayout(3,6));
        contentPane.add(gardenPanel, BorderLayout.CENTER); 
        
        JPanel actionPanel = new JPanel(new GridLayout(1,3));
        contentPane.add(actionPanel, BorderLayout.SOUTH);
        
        String sunn = String.valueOf(suns);
        JLabel suns = new JLabel(sunn);
        JLabel suncount = new JLabel("Sun Count: ");
        JLabel space = new JLabel("                                  ");
        JPanel wordPanel = new JPanel(new FlowLayout());        
        JLabel instruc = new JLabel("To play, choose plant type, the location, and then pass.");
        wordPanel.add(instruc);
        wordPanel.add(space);
        wordPanel.add(suncount);
        wordPanel.add(suns);
        contentPane.add(wordPanel, BorderLayout.NORTH);
        
        JButton Sunflower = new JButton("Sunflower");
        Sunflower.addActionListener(this);
        JButton PeaShooter = new JButton("PeaShooter");
        PeaShooter.addActionListener(this);
        JButton Pass = new JButton("pass");
        Pass.addActionListener(this);
        
        actionPanel.add(Sunflower);
        actionPanel.add(PeaShooter);
        actionPanel.add(Pass);
        
        grid = new JButton[6][3];
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 6; j++){
                grid[j][i] = new JButton(".");
                gardenPanel.add(grid[j][i]);
                
                grid[j][i].addActionListener(this);
                grid[j][i].setActionCommand("" + j + i);
            }
        }
                        
        contentPane.setPreferredSize(new Dimension(800,400));
                               
        gameFrame.pack();
        gameFrame.setVisible(true);        
    }
    
    public void actionPerformed(ActionEvent event)
    {
        JButton button = (JButton) event.getSource();        
        String command = button.getActionCommand();
                             
        if(command.equals("Sunflower")){
            temp = command;
            //System.out.println(temp);
        }else if(command.equals("PeaShooter")){
            temp = command;
            //System.out.println(temp);
        }else if(command.equals("pass")){
            //LALALALALAL next turn.
            increment();
            print();
        }else if(command != null){
            //System.out.println(command);
            //System.out.println(temp);
            int row = Integer.parseInt(command.substring(0,1));
            int col = Integer.parseInt(command.substring(1,2));
                    
            if(temp.equals("Sunflower")){
                //System.out.println("IM IN SUNFLOWER");
                Plant p = new Sunflower(this,row,col);
                addPlant(p);
                temp = "";
            }else if(temp.equals("PeaShooter")){
                //System.out.println("IM IN PEASHOOTER");
                Plant pl = new PeaShooter(this,row,col);
                addPlant(pl);
                temp = "";
            }           
        }
        
        if(lost){
            JOptionPane.showMessageDialog(null,"You Lose - You have let the zombies take the garden.");
        }else if(win){
            JOptionPane.showMessageDialog(null,"You Win - The zombies have been destroyed.");
        }
        
        //increment();
        //print();
    }


    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void main(java.lang.String[] args)
    {
        // put your code here
        GraphicalGarden gg = new GraphicalGarden();
    }
    
    @Override
    public void print()
    {
        int i,j;
        for(i = 0; i < DEFAULT_GARDEN_LENGTH; i++)
        {
            for(j = 0; j < DEFAULT_GARDEN_WIDTH; j++)
            {
                if(super.hasPlantAt(i,j))
                {
                    grid[i][j].setText(getPlantAt(i,j).toString());                    
                    //grid[j][i].setIcon(new ImageIcon("resources/Sunflower.jpg"));
                }else if(super.hasPeaAt(i,j))
                {
                    grid[i][j].setText("O");
                }else if(super.hasZombieAt(i,j))
                {
                    grid[i][j].setText("Z");
                }else{
                    grid[i][j].setText(".");
                }                
            }
        }
    }
}
