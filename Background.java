import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;

/**
 * Subclass of Blocks, Background class contains all object of backgrounds.
 * 
 * @author Xiao Zhang 
 * @version 2021.01.28
 */

public class Background extends Blocks
{
    // Hashmap to store objects of background into the engine.
    private static HashMap<String,GreenfootImage>  objectsBackground=new HashMap<String,GreenfootImage>();
    // Add backgrounds to hashmap.
    static{
        objectsBackground.put("sky background", new GreenfootImage("background/sky background.png"));
        objectsBackground.put("soil background", new GreenfootImage("background/soil background.png"));
        objectsBackground.put("stone background", new GreenfootImage("background/stone background.png"));
    }
    
    /**
     * Constructor for objects of class Background.
     * 
     * @param   imageName   The name of the background image.
     * @param   x   X-coordinate background will be created.
     * @param   y   Y-coordinate background will be created.
     * 
     */
    public Background(String imageName,int x, int y){
        super(x,y);
        name=imageName;
        setImage(objectsBackground.get(imageName));
        isBackground=true;
    }  
}
