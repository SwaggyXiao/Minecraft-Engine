import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Display the selected box in choice box.
 * 
 * @author Xiao Zhang
 * @version 2021.01.28
 */
public class SelectingBox extends Actor
{
    // Image of selecting box.
    private GreenfootImage selectingBox;

    /**
     * Constructor for objects of class SelectingBox.
     *       
     */
    public SelectingBox(){
        selectingBox=new GreenfootImage("BackPack/selectingbox.png");
        setImage(selectingBox);
    }  
    /**
     * Constructor for objects of class SelectingBox.
     *       
     * @param   bool    Whether selecting box will be created. 
     */
    public SelectingBox(boolean bool){
        selectingBox=new GreenfootImage("BackPack/selectingbox.png");
        selectingBox.scale(120,120);
        setImage(selectingBox);
    }    
    public void act() 
    {
        // Add your action code here.
    }    
}
