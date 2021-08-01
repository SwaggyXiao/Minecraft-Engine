import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Subclass of SteveHand, FrontHand class contains behaviors for Steve's front hand.
 * 
 * @author Xiao Zhang
 * @version 2021.01.28
 */
public class FrontHand extends SteveHand
{
    // Variables used in FrontHand class.
    private int startingDegree=50;
    private int endingDegree=35;
    private int changeDuringMining=2;
    private static Integer change=2;
    private MouseInfo mouse;
    /**
     * Constructor for objects of class FrontHand.
     *       
     */
    public FrontHand(){
        super();
        //halfHeight
    }    

    /**
     * Act method to check for Steve's front hand mostions.
     */
    public void act() 
    {
        mouse=mc.getMouseInfo();
        checkMousePressing();
        if(isMining){
            movingForMining(startingDegree,endingDegree);
        } 
        else if(isMoving){
            moving(35,-35);
        } 
        else if(degree!=0) isMoving=true;

    }    

    /**
     * Move Steve's front hand.
     * 
     * @param   starting    The starting position(index).
     * @param   ending    The ending position(index).
     */
    public void moving(int starting, int ending){
        degree+=change;
        if(degree/(double)starting>=1) {
            if(degree<0) change=2;
                else change=-2;
        }
            else if(degree/(double)ending>=1){
                if(degree<0) change=2;
                else change=-2;
        }        
        currentPosition[0]=(int)(Math.sin(Math.toRadians(degree))*foot.getHeight()/2);//X
        currentPosition[1]=(int)(Math.cos(Math.toRadians(degree))*foot.getHeight()/2)-foot.getHeight()/2;//Y
        setLocation(originalPosition[0]+currentPosition[0],originalPosition[1]+currentPosition[1]);
        this.setRotation(-degree);
        if(degree==0)isMoving=false;
    }  
    
    /**
     * Move Steve's front hand for mining.
     * 
     * @param   starting    The starting position(index).
     * @param   ending    The ending position(index).
     */
    public void movingForMining(int starting, int ending){
        degree+=changeDuringMining;
        if(starting>0){
            if(degree>=starting&&changeDuringMining>0) changeDuringMining=-changeDuringMining;
            else if(degree<=ending&&changeDuringMining<0) changeDuringMining=-changeDuringMining;
        }
        else {
            if(degree>=ending&&changeDuringMining>0) changeDuringMining=-changeDuringMining;
            else if(degree<=starting&&changeDuringMining<0) changeDuringMining=-changeDuringMining;
        }
        currentPosition[0]=(int)(Math.sin(Math.toRadians(degree))*foot.getHeight()/2);//X
        currentPosition[1]=(int)(Math.cos(Math.toRadians(degree))*foot.getHeight()/2)-foot.getHeight()/2;//Y
        setLocation(originalPosition[0]+currentPosition[0],originalPosition[1]+currentPosition[1]);
        this.setRotation(-degree);
    }  

    /**
     * Check if mouse is pressing.
     */
    private void checkMousePressing(){
        if (isMining && (Greenfoot.mouseDragEnded(null) || Greenfoot.mouseClicked(null))) isMining = false;
        else if (!isMining && Greenfoot.mousePressed(null)) isMining = true;
    } 
    
    /**
     * Set whether Steve is moving.
     */
    public void setIsMoving(){
        if(isMoving==false){
            isMoving=true;
            change=-1*BackHand.getChange();
        }
    }
    
    /**
     * Reverse the direction of Steve's front hand.
     */
    public void reverse(){
        getImage().mirrorHorizontally();
        startingDegree*=-1;
        endingDegree*=-1;
        changeDuringMining*=-1;
    }    
}
