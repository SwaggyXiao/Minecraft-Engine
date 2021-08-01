
import java.util.HashMap;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Subclass of Blocks, Objects class contains all setting object in the map.
 * 
 * @author Xiao Zhang 
 * @version 2021.01.28
 */

//digable
public class Objects extends Blocks
{
    // Hashmap to store information of objects into the engine.
    private static HashMap<String,Integer>  objectsHp=new HashMap<String,Integer>();
    private static HashMap<String,GreenfootImage>  objectsImage=new HashMap<String,GreenfootImage>();
    
    // Variable for block length.
    private static final int BlocksLength=MineCraftWorld.getBlockWidth();
    static{
        addObjectsImage();
        addObjectsHp();
    }
    
    /**
     * Add object's image to hashmap.
     */
    private static void addObjectsImage(){
        objectsImage.put("diamond_ore", new GreenfootImage("blocks/diamond_ore.png"));
        objectsImage.put("gold_ore", new GreenfootImage("blocks/gold_ore.png"));
        objectsImage.put("dirt", new GreenfootImage("blocks/dirt.png"));
        objectsImage.put("coal_ore", new GreenfootImage("blocks/coal_ore.png"));
        objectsImage.put("iron_ore", new GreenfootImage("blocks/iron_ore.png"));
        objectsImage.put("stone_ore", new GreenfootImage("blocks/stone_ore.png"));
        objectsImage.put("stone", new GreenfootImage("blocks/stone.png"));
        objectsImage.put("grass_side", new GreenfootImage("blocks/grass_side.png"));
        objectsImage.put("bedrock", new GreenfootImage("blocks/bedrock.png"));
        objectsImage.put("log_spruce", new GreenfootImage("blocks/log_spruce.png"));
        objectsImage.put("tree 1 part 1", new GreenfootImage("blocks/tree 1 part 1.png"));
    }

    /**
     * Add object's hp to hashmap.
     */
    private static void addObjectsHp(){
        objectsHp.put("diamond_ore", 300);
        objectsHp.put("gold_ore", 250);
        objectsHp.put("dirt", 50);
        objectsHp.put("coal_ore", 150);
        objectsHp.put("iron_ore", 150);
        objectsHp.put("stone_ore", 100);
        objectsHp.put("stone", 100);
        objectsHp.put("grass_side",50);
        objectsHp.put("bedrock",10000);
        objectsHp.put("log_spruce", 60);
        objectsHp.put("tree 1 part 1", 10);
    }

    // Variable used in Objects class.
    protected int life;
    protected boolean hasGift=false;
    protected ArrayList<Living> ObjectsStandingUponIt=new ArrayList<Living>();
    private SelectingSide selectingSide;
    /**
     * Constructor for objects of class Background.
     * 
     * @param   objectName   The name of the objects.
     * @param   x   X-coordinate objects will be created.
     * @param   y   Y-coordinate objects will be created.
     * 
     */
    public Objects(String objectName,int x, int y){ 
        super(x,y);
        this.life=objectsHp.get(objectName).intValue();;
        this.name=objectName;
        this.setImage(objectsImage.get(objectName));
        hasGift=true;
    }  
    
    /**
     * Constructor for objects of class Background.
     * 
     * @param   objectName   The name of the objects.
     * @param   x   X-coordinate objects will be created.
     * @param   y   Y-coordinate objects will be created.
     * @param   CannotDig   Whether object can be digged.
     */
    public Objects(String objectName,int x, int y,boolean CannotDig){ 
        super(x,y);
        this.life=objectsHp.get(objectName).intValue();
        this.name=objectName;
        this.setImage(objectsImage.get(objectName));
    }
    
    /**
     * Objects that would be mined.
     * 
     * @param   demage  How much life objects decreased.
     * @param   mc  The MinecraftWorld objects showing at.
     */
    public void mining(int demage, MineCraftWorld mc){
        life-=demage;
        // If there is no life for objects add background to engine.
        if(life<=0){
            Background background=null;
            // Different cases will add different backgrounds.
            switch(mc.getBackground2D()[XandY[1]][XandY[0]]){
                case 0:
                    background=new Background("sky background",XandY[0], XandY[1]);
                    mc.addObject(background, getX(), getY());
                break;
                case 1:
                background=new Background("soil background",XandY[0], XandY[1]);
                    mc.addObject(background, getX(), getY());
                break;
                case 2:
                background=new Background("stone background",XandY[0], XandY[1]);
                    mc.addObject(background, getX(), getY());
                break;
            }    
            if(!name.equals("tree 1 part 1"))mc.getChoiceBox().addObject(Name(),1);
            mc.blocks()[XandY[1]][XandY[0]]=background;
            getWorld().removeObject(this);  
        }
    }    
    
    /**
     * Add object into the stored ArrayList.
     * 
     * @param   object  The object that will be stored.
     */
    public void addObjectIntoList(Living object){ //use when the object is remove from world, its location will be stored in this list
        ObjectsStandingUponIt.add(object);
    }   
    
    /**
     * Return the object stored in the ArrayList.
     * 
     * @return  The object in the ArrayList that will be returned.
     */
    public Living[] getObjectWithinList(){ //use when the object is remove from world, its location will be stored in this list
        return (Living[])ObjectsStandingUponIt.toArray();
    }    
    
    /**
     * Add the selecting slide in the world.
     * 
     * @param   i   Different cases selecting slide will be added.
     * @param   mc  The MinecraftWorld selecting slide will be added.
     */
    public void addSelectingSide(int i,MineCraftWorld mc){
        selectingSide=new SelectingSide(i);
        // Different cases will add selecting slide at different positions.
        switch(i){
            case 1:
                mc.addObject(selectingSide, getX(),getY()-BlocksLength/2+5);
            break;
            case 2:
                mc.addObject(selectingSide, getX()-BlocksLength/2+5,getY());
            break;
            case 3:
                mc.addObject(selectingSide, getX(),getY()+BlocksLength/2-5);
            break;
            case 4:
                mc.addObject(selectingSide, getX()+BlocksLength/2-5,getY());
            break;
        }    
    }
    
    /**
     * Remove the selecting slide in the world.
     * 
     * @param   mc  The MinecraftWorld selecting slide will be removed.
     */
    public void removeSelectingSide(MineCraftWorld mc){
        if(selectingSide!=null){
            mc.removeObject(selectingSide);
        }
    }
    
    /**
     * Return the selecting slide in the world.
     * 
     * @return  The selecting slide in the world.
     */
    public SelectingSide getSelectingSide(){
        return selectingSide;
    }    
}
