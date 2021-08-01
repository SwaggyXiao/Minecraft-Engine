import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * InstructionPage class is used to display information of game.
 * 
 * @author Xiao Zhang and Delun Sun 
 * @version 2021.01.28
 */
public class InstructionPage extends Actor
{
    // Variables used in InstructionPage class.
    private GreenfootImage image;
    private TitleScreen TS;
    private Button close;
    
    /**
     * Constructor for objects of class InstructionPage.
     * 
     * @param num   The number of hearts being created.
     *       
     */
    public InstructionPage()
    {
        image = new GreenfootImage("instruction.png");
        image.scale(891,500);
        setImage(image);
    }
    
    /**
     * Called by Greenfoot when an object of this class is added to 
     * the World.
     * 
     * @param w The World being added to.
     */
    public void addedToWorld(World w){
        // Add a close button on instruction page.
        TS=(TitleScreen) w;
        // Add next buttom and wrong buttom to instruction page.
        close=new Button("close");
        close.reScale(50,50);
        TS.addObject(close,900,130);
        
    }
    /**
     * Act method to check is mouse is clicked on close button.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(close))
        {
            TS.removeObject(close);
            TS.removeObject(this);
        }
    }
}
