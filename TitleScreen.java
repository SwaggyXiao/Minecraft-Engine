import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The opneing page of the Minecraft engine.
 * 
 * @author Xiao Zhang and Delun Sun
 * @version 2021.01.28
 */
public class TitleScreen extends World
{
    // Variable used in the opneing page.
    private GreenfootImage backgroundImage;
    private Button newgame,resume,instruction;
    private MineCraftWorld MC;
    private MineCraftWorld resumeMC;
    private boolean clickable=false;
    private Item[] itemList=new Item[9];
                private GreenfootSound click=new GreenfootSound("Click.mp3");

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 700, 1); 
        // Set the image of opneing page.
        setBackground(new GreenfootImage("background/Title Screen.png"));
        addObject(new Logo(),550,120);

        // Add buttons to the opneing page.
        newgame = new Button("newgame");
        addObject(newgame,550,400);

        resume = new Button("resume");
        addObject(resume,550,470);
        //resumeMC
        instruction = new Button("instruction");
        addObject(instruction,550,540);
        MC=new MineCraftWorld();
        userInfo();
    }

    /**
     * Act method to check if buttons were being clicked.
     */
    public void act(){
        if(Greenfoot.mouseClicked(newgame)){
            click.play();
            Greenfoot.setWorld(MC);
        }   
        else if(Greenfoot.mouseClicked(instruction)){
            click.play();
            addObject(new InstructionPage(),500,350);
        }  
        else if(Greenfoot.mouseClicked(resume)){
            click.play();
            if(clickable)Greenfoot.setWorld(resumeMC);
        }  
    }    

    /**
     * Save user's information.
     */
    private void userInfo(){
        if (UserInfo.isStorageAvailable()) {
            UserInfo myInfo = UserInfo.getMyInfo();

            if (myInfo.getString(0)!="") {
                clickable=true;
                int index=0;
                int indexForUser=0;
                while(myInfo.getString(indexForUser)!=""){
                     String[] string=myInfo.getString(indexForUser).split("&&");
                     itemList[index]=gettingNameWithNumber(string[0]);
                     index++;
                     if(string.length==2){
                     itemList[index]=gettingNameWithNumber(string[1]);
                     index++;
                     }
                    indexForUser++;
                }    
                resumeMC=new MineCraftWorld(itemList);
            }
        }
    }    

    /**
     * Return the item with name and number
     * 
     * @param str The String that reperesent item.
     * 
     * @return The item being returned.
     */
    private Item gettingNameWithNumber(String str){
        String[] arrSplit = str.split("&");
        return new Item(Recipes.getKeyShortToName(arrSplit[0]),Integer.parseInt(arrSplit[1]));

        //Integer.parseInt(arrSplit[1]);
    }    

    /**
     * Return the string array that split a string.
     * 
     * @param str The String being splitted.
     * 
     * @return  The spliited string being returned in array.
     */
    private String[] splitString(String str){
        return str.split("&&");
    }    
}
