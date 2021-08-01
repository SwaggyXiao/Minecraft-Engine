import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ChoiceBox class is used to create box that display images for owned items.
 * 
 * @author Xiao Zhang 
 * @version 2021.01.28
 */
public class ChoiceBox extends Actor
{
    // Variables used in ChoiceBox class.
    private GreenfootImage choiceBox;
    private MouseInfo mouse;
    private  MineCraftWorld MC;
    private Item[] itemArray=new Item[9];
    private int selectingIndex=0;
    private SelectingBox selectBox;
    private int halfLengthOfBox;
    /**
     * Constructor for objects of class ChoiceBox.
     *       
     */
    public ChoiceBox(){
        choiceBox=new GreenfootImage("BackPack/Choice Box.png");
        setImage(choiceBox);
        halfLengthOfBox=(choiceBox.getWidth()/9)/2;
        
    }  
    /**
     * Constructor for objects of class ChoiceBox.
     *       
     */
    public ChoiceBox(Item[] itemList){
        choiceBox=new GreenfootImage("BackPack/Choice Box.png");
        setImage(choiceBox);
        halfLengthOfBox=(choiceBox.getWidth()/9)/2;
        itemArray=itemList;
    } 
    /**
     * Called by Greenfoot when an object of this class is added to 
     * the World.
     * 
     * @param w The World being added to.
     */
    public void addedToWorld(World w){
        // Add select box into the world.
        MC=(MineCraftWorld)w;
        selectBox=new SelectingBox();
        MC.addObject(selectBox,getX()-choiceBox.getWidth()/2+halfLengthOfBox*(1+selectingIndex),getY());
        int index=0;
        while(itemArray[index]!=null){
            MC.addObject(itemArray[index],getX()-choiceBox.getWidth()/2+halfLengthOfBox+index*(halfLengthOfBox*2),getY());
            index++;
        }    
    }
    
    /**
     * Act method to always get the information of mouse and check if mouse is clicking.
     */
    public void act() 
    {
        mouse=MC.getMouseInfo();
        checkClicking();
    } 
    
    /**
     * Check if mouse is clicking choicebox.
     */
    private void checkClicking(){
        //if(mouse.getActor()==this){
            if(Greenfoot.mouseClicked(this)){
                selectingIndex=(mouse.getX()-getX()+choiceBox.getWidth()/2)/(halfLengthOfBox*2);
                putSelectingBoxInCorrectPosition();
            }  
            else if(Greenfoot.mouseClicked(Item.class)){
                selectingIndex=(mouse.getX()-getX()+choiceBox.getWidth()/2)/(halfLengthOfBox*2);
                putSelectingBoxInCorrectPosition();
            }    
            if(Greenfoot.isKeyDown("right")){
                if(selectingIndex!=0) selectingIndex--;
            }  
            if(Greenfoot.isKeyDown("left")){
                if(selectingIndex!=8) selectingIndex++;
            }    
        //}    
    } 
    
    /**
     * Put the selected box in correct position.
     */
    private void putSelectingBoxInCorrectPosition(){
        selectBox.setLocation(getX()-choiceBox.getWidth()/2+halfLengthOfBox*(1+2*selectingIndex),getY());
    }   
    
    /**
     * Add items into choicebox.
     * 
     * @param   item    The name of the item being added.
     * @param   amount  The number that the item is being added.
     */
    public void addObject(String item, int amount){
        if(item.equals("grass_side")) item="dirt";
        for(int i=0;i<itemArray.length;i++){
            // Check if the item added is being first time added to choice box.
            if(itemArray[i]==null){
                Item newItem=new Item(item,1);
                itemArray[i]=newItem;
                MC.addObject(newItem,getX()-choiceBox.getWidth()/2+halfLengthOfBox+i*(halfLengthOfBox*2),getY());
                break;
            }
            else if(itemArray[i].getName().equals(item)){
                itemArray[i].addNumber(amount);
                break;
            }
           
        }
    }
    public Item[] getItemList(){
        return itemArray;
    }    
}
