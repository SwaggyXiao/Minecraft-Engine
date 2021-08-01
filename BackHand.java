import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Subclass of SteveHand, BackHand class contains behaviors for Steve's back hand.
 * 
 * @author Xiao Zhang 
 * @version 2021.01.28
 */
public class BackHand extends SteveHand
{
    private static Integer change=-2;
    /**
     * Constructor for objects of class BackHand.
     *       
     */
    public BackHand(){
      super();
    }    
    
    /**
     * Act method to check is Steve is moving.
     */
    public void act() 
    {
        if(isMoving){
            moving(35,-35);
        } 
    }    
    
    /**
     * Set whether Steve's hand is moving.
     */
    public void setIsMoving(){
        if(isMoving==false){
            isMoving=true;
        }
    }
    
    /**
     * Move Steve's back hand.
     * 
     * @param   starting    The starting position(index).
     * @param   ending    The ending position(index).
     */
    public void moving(int starting, int ending){
        degree+=change;
        if(degree>=starting||degree<=ending) change=-change;
        currentPosition[0]=(int)(Math.sin(Math.toRadians(degree))*foot.getHeight()/2);//X
        currentPosition[1]=(int)(Math.cos(Math.toRadians(degree))*foot.getHeight()/2)-foot.getHeight()/2;//Y
        setLocation(originalPosition[0]+currentPosition[0],originalPosition[1]+currentPosition[1]);
        this.setRotation(-degree);
        if(degree==0)isMoving=false;
    }  
    
    /**
     * Return the change of Steve's back hand motions.
     * 
     * @return The change of Steve's back hand motions.
     */
    public static int getChange(){
        return change;
        
    }    
}
