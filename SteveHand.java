import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Subclass of SteveBody, the class of Steve's hand.
 * 
 * @author Xiao Zhang
 * @version 2021.01.28
 */
public abstract class SteveHand extends SteveBody
{
    // Variables used in SteveHand class.
    protected GreenfootImage foot;
    protected int degree=0;
    protected boolean isMoving=false;
    protected int[] originalPosition=new int[2];
    protected int[] currentPosition=new int[2];
    protected boolean isMining=false;
    protected MineCraftWorld mc;
    /**
     * Constructor for objects of class SteveHand.
     *       
     */
    public SteveHand(){
        foot=new GreenfootImage("Character/steve hand.png");
        setImage(foot);
    }    
    /**
     * Called by Greenfoot when an object of this class is added to 
     * the World.
     * 
     * @param w The World being added to.
     */
    public void addedToWorld(World w){
        mc=(MineCraftWorld) w;
        originalPosition[0]=getX();
        originalPosition[1]=getY();
    }    
    
    /**
     * Set whether Steve's hand is moving.
     */
    protected abstract void setIsMoving();
}
