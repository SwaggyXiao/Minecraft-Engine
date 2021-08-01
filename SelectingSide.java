import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Display the selecting slide when mining.
 * 
 * @author Xiao Zhang
 * @version 2021.01.28
 */
public class SelectingSide extends Actor
{
    // Variables used in SteveBody class.
    private static GreenfootImage imageHori;
    private static GreenfootImage imageVerti;
    private static int widthOfBlock=MineCraftWorld.getBlockWidth();
    // Fill the image of selecting slide.
    static{
        imageHori=new GreenfootImage(widthOfBlock,10);
        imageHori.setColor(Color.WHITE);
        imageHori.fillRect(0,0, widthOfBlock-1, 9);
        imageHori.setTransparency(140);
        
        imageVerti=new GreenfootImage(10,widthOfBlock);
        imageVerti.setColor(Color.WHITE);
        imageVerti.fillRect(0,0, 9, widthOfBlock-1);
        imageVerti.setTransparency(140);
    }    
    /**
     * Constructor for objects of class SelectingSlide.
     * 
     * @param i The cases for filling the selecting slide.
     *       
     */
    public SelectingSide(int i){
        update(i);
    } 
    
    /**
     * Update the selecting slide.
     * 
     * @param i The cases for filling the selecting slide.
     */
    private void update(int i) 
    {
        if(i==1||i==3) setImage(imageHori);
        else setImage(imageVerti);
    }    
    
    /**
     * Move the selecting slide
     * 
     * @param x Horizontal distance
     * @param y Vertical distance
     */
    public void moveSelectingSide(int x, int y){
        setLocation(getX()+x, getY()+y);
    }    
}
