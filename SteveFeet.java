import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Subclass of SteveBody, the class of Steve's feet.
 * 
 * @author Xiao Zhang
 * @version 2021.01.28
 */
public class SteveFeet extends SteveBody
{
    // Variables used in SteveFeet class.
    private GreenfootImage foot;
    private int degree=0;
    private int change;
    private boolean isMoving=false;
    private int[] originalPosition=new int[2];
    private int[] currentPosition=new int[2];
    /**
     * Constructor for objects of class SteveFeet.
     *       
     */
    public SteveFeet(int change/*one is -1, one is 1*/){
        this.change=change*2;
        foot=new GreenfootImage("Character/steve foot.png");
        setImage(foot);
    }    

    /**
     * Called by Greenfoot when an object of this class is added to 
     * the World.
     * 
     * @param w The World being added to.
     */
    public void addedToWorld(World w){
        //mc=(MineCraftWorld) w;
        originalPosition[0]=getX();
        originalPosition[1]=getY();
    }    

    /**
     * Act method to check if Steve is moving.
     */
    public void act() 
    {

        if(isMoving){
            moving();
        }    
    }    

    /**
     * Move Steve's feet.
     */
    public void moving(){
        degree+=change;
        if(degree>=35||degree<=-35) change=-change;

        currentPosition[0]=(int)(Math.sin(Math.toRadians(degree))*foot.getHeight()/2);//X
        currentPosition[1]=(int)(Math.cos(Math.toRadians(degree))*foot.getHeight()/2)-foot.getHeight()/2;//Y
        setLocation(originalPosition[0]+currentPosition[0],originalPosition[1]+currentPosition[1]);
        this.setRotation(-degree);
        if(degree==0)isMoving=false;
    } 

    /**
     * Set whether Steve is moving.
     */
    public void setIsMoving(){
        if(isMoving==false)isMoving=true;
    }
}
