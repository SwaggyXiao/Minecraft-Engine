import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Block class contains all setting objects such as background and objects of map.
 * 
 * @author Xiao Zhang
 * @version 2021.01.28
 */
public abstract class Blocks extends Actor
{
    // Variables used in Blocks class.
    
    /**
     * Images to present the block.
     */
    protected GreenfootImage image;
    
    /**
     * Size length of the block.
     */
    protected static int blockSizeLength=60;
    
    /**
     * Array for X and Y-coordinate of block.
     */
    protected int[] XandY;//x first, y second
    
    /**
     * Whether block is at background.
     */
    protected boolean isBackground=false;
    
    /**
     * Name of the block.
     */
    protected String name;
    
    /**
     * ArrayList that store animals in engine.
     */
    protected ArrayList<Animal> holdAnimalList=new ArrayList<Animal>();
    /**
     * Constructor for objects of class Blocks.
     * 
     * @param   x   X-coordinate blocks will be created.
     * @param   y   Y-coordinate blocks will be created.
     * 
     */
    public Blocks(int x, int y){
        XandY=new int[]{x,y};
    }    
    
    /**
     * Move the blocks.
     * 
     * @param   deltaX  Horizontal distance blocks will be moved.
     * @param   deltaY  Vertical distance blocks will be moved.
     */
    public void move(int deltaX, int deltaY){
        setLocation(getX()-deltaX,getY()-deltaY);
    }
    
    /**
     * Return the size length of blocks.
     * 
     * @return  The size length of blocks.
     */
    public static int blockSizeLength(){
        return blockSizeLength;
    }
    
    /**
     * Returns array for X and Y-coordinate of block.
     * 
     * @return  Array for X and Y-coordinate of block
     */
    public int[] XandY(){
        return XandY;
    }
    
    /**
     * Add animals into the stored ArrayList.
     * 
     * @param   animal  Animal that will be stored.
     */
    public void addInAnimalList(Animal animal){
        holdAnimalList.add(animal);
    }
    
    /**
     * Process the animal list to add animsl to engine.
     * 
     * @param   i   Different cases that animals will be added to engine.
     */
    public void readAnimalList(int i){
        if(holdAnimalList.size()!=0){
        switch(i){
            case 1:
            for (Animal a: holdAnimalList) getWorld().addObject(a, 0-a.getImage().getWidth()/2,getY());
            holdAnimalList.clear();
            break;
            case 2:
            for (Animal a: holdAnimalList) getWorld().addObject(a, 1100+a.getImage().getWidth()/2,getY());
            holdAnimalList.clear();
            break;
            case 3:
            for (Animal a: holdAnimalList) getWorld().addObject(a, getX(),0-a.getImage().getHeight()/2);
            holdAnimalList.clear();
            break;
            case 4:
            for (Animal a: holdAnimalList) getWorld().addObject(a, getX(),700+a.getImage().getHeight()/2);
            holdAnimalList.clear();
            break;
    }
}
    }
    
    /**
     * Return whether block is at the background of engine.
     * 
     * @return  True or false block is at the background of engine
     */
    public boolean isbackground(){
        return isBackground;
    } 
    
    /**
     * Return the name of block.
     * 
     * @return  The name of block.
     */
    public String Name(){
        return name;
    }   
}
