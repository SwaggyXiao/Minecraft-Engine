
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * The engine of Minecraft, also the main world of the engie where players play with it.
 * The world is in the size of 200*200, and when at edge, the player will not able to pass and will be stuck
 * The player's face will follow the mouse, and when the user is pressing the mouse, the person will start digging
 * if the mouse is in a specific direction, and the closest block in that rage will be showing with a white border, 
 * which mean how the person is selecting this block, and if he starts to dig, he will dig this rock.
 * the world will have the situation where the person may be created back behind the Steve, so just dig out.
 * 
 * User info:
 * Each user are able to save there progress and click resuem next time if they want. In this way,
 * they will store everything in their backpack and having then next time when they resume the game. (Unless they clicked new game)
 * 
 * Each type of rock has a max numbe of 64 and over if will not be picked up
 * 
 * 
 * 
 * @author Xiao Zhang
 * @version 2021.01.28
 */
public class MineCraftWorld extends World
{
    // Variables used in the opneing page.
    private GreenfootSound bgm=new GreenfootSound("BGM.mp3");
                private GreenfootSound click=new GreenfootSound("Click.mp3");

    private Blocks[][] blocks2D;
    private static int[][] background2D;
    private int[] originPoint;
    private int[] heightAndWidth=new int[]{0,0};//0-->width, 1-->height
    private SteveBody steve;
    private double initialBlood=5;
    private Heart hpBar;
    private MouseInfo mouse;
    private ChoiceBox choiceBox;
    private static int blockWidth=80;
    private static final int startingY=300;
    private Blocks temp;
    private boolean[] canBlockMove=new boolean[]{true,true,true,true};//1--> up, 2--> right, 3-->down, 4--> left
    private Button saveButton;
    /**
     * Constructor for objects of class MineCraftWorld.
     * 
     */
    public MineCraftWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 700, 1,false); //actual 1320 (22*60) * 900 (15*60)
        
        // Create the map of the engine.
        setPaintOrder(SelectingBox.class,Item.class,ChoiceBox.class,Heart.class,Button.class,FrontHand.class,FrontFoot.class,SteveBody.class,BackFoot.class,BackHand.class,Living.class);
        constructTheMap();
        addInitializedMap();
        
        // Add Objects such as Steve, choice boxes and healthbar to the game.
        steve=new SteveBody();
        //cow = new Animal("zombie");
        addObject(steve,getWidth()/2,startingY+blockWidth/2-22*5);
        //addObject(cow,getWidth()/2,startingY+blockWidth/2-22*5);
        hpBar=new Heart(initialBlood);
        addObject(hpBar, 1100-hpBar.getImage().getWidth()/2,hpBar.getImage().getHeight()/2);
        choiceBox=new ChoiceBox();
        addObject(choiceBox, 10+choiceBox.getImage().getWidth()/2,10+choiceBox.getImage().getHeight()/2);
        saveButton=new Button("save");
        addObject(saveButton,1100-saveButton.getImage().getWidth()/2-20,70);
        
        bgm.playLoop();
    }

    
    /**
     * Save user's information.
     */
    private void clickedSave(){
        if(Greenfoot.mouseClicked(saveButton)){
            click.play();
            if (UserInfo.isStorageAvailable()) {
         UserInfo myInfo = UserInfo.getMyInfo();
         
         int indexForArray=0;
         int indexForUser=0;
         while(choiceBox.getItemList()[indexForArray]!=null){
             Item item=choiceBox.getItemList()[indexForArray];
             String name=Recipes.getKeyNameToShort(item.getName());
             int amount=item.getNumber();
             String str=name+"&"+amount+"&&";
             indexForArray++;
             if(choiceBox.getItemList()[indexForArray]==null) {
                 myInfo.setString(indexForUser,str);
                 break;
             }
             item=choiceBox.getItemList()[indexForArray];
             name=Recipes.getKeyNameToShort(item.getName());
             amount=item.getNumber();
             String string=str+name+"&"+amount;
             	myInfo.setString(indexForUser,string);
             indexForUser++;
             indexForArray++;
            }    
     }
        Greenfoot.setWorld(new TitleScreen());
        }    
    }    
    
    
    /**
     * Constructor for objects of class MineCraftWorld.
     * 
     */
    public MineCraftWorld(Item[] itemList)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 700, 1,false); //actual 1320 (22*60) * 900 (15*60)
        
        // Create the map of the engine.
        setPaintOrder(SelectingBox.class,Item.class,ChoiceBox.class,Heart.class,Button.class,FrontHand.class,FrontFoot.class,SteveBody.class,BackFoot.class,BackHand.class,Living.class);
        constructTheMap();
        addInitializedMap();
        
        // Add Objects such as Steve, choice boxes and healthbar to the game.
        steve=new SteveBody();
        //cow = new Animal("zombie");
        addObject(steve,getWidth()/2,startingY+blockWidth/2-22*5);
        //addObject(cow,getWidth()/2,startingY+blockWidth/2-22*5);
        hpBar=new Heart(initialBlood);
        addObject(hpBar, 1100-hpBar.getImage().getWidth()/2,hpBar.getImage().getHeight()/2);
        choiceBox=new ChoiceBox(itemList);
        addObject(choiceBox, 10+choiceBox.getImage().getWidth()/2,10+choiceBox.getImage().getHeight()/2);
        saveButton=new Button("save");
        addObject(saveButton,1100-saveButton.getImage().getWidth()/2-20,70);
    }
    
    
    /**
     * Act method to always get the information of mouse.
     */
    public void act(){
        mouse = Greenfoot.getMouseInfo();
        clickedSave();
    }   

    /**
     * Construct the initial map of the world!! including air, soil, blocks
     * has a size of 500*1000
     */
    private void addInitializedMap()
    {
        boolean unfinish=true;
        int xInc=-1;
        // Lots of while loops to check if the initial map is finished constructed
        while(unfinish){
            xInc++;
            
            addObject(blocks2D[originPoint[0]][originPoint[1]+xInc],getWidth()/2+xInc*blockWidth,startingY+blockWidth);
            boolean UnFinishVerti=true;
            int yInc=0;
            // While loops to check if vertical part of the map is finished constructed.
            while(UnFinishVerti){
                yInc++;
                addObject(blocks2D[originPoint[0]-yInc][originPoint[1]+xInc],getWidth()/2+xInc*blockWidth,startingY+blockWidth-yInc*blockWidth);
                if(startingY+blockWidth-yInc*blockWidth-blockWidth/2<0-2*blockWidth) {
                    UnFinishVerti=false;
                }
                heightAndWidth[1]++;
            }   
            yInc=0;
            while(!UnFinishVerti){
                yInc++;
                addObject(blocks2D[originPoint[0]+yInc][originPoint[1]+xInc],getWidth()/2+xInc*blockWidth,startingY+blockWidth+yInc*blockWidth);
                if(startingY+blockWidth+yInc*blockWidth+blockWidth/2>getHeight()+2*blockWidth){
                    UnFinishVerti=true;
                }
                heightAndWidth[1]++;
            }
            heightAndWidth[0]++;
            if(getWidth()/2+xInc*blockWidth+blockWidth/2>getWidth()+2*blockWidth){
                unfinish=false;
            }
        }    
        xInc=0;
        while(!unfinish){
            xInc++;
            addObject(blocks2D[originPoint[0]][originPoint[1]-xInc],getWidth()/2-xInc*blockWidth,startingY+blockWidth);
            boolean UnFinishVerti=true;
            int yInc=0;
            while(UnFinishVerti){
                yInc++;
                addObject(blocks2D[originPoint[0]-yInc][originPoint[1]-xInc],getWidth()/2-xInc*blockWidth,startingY+blockWidth-yInc*blockWidth);
                if(startingY+blockWidth-yInc*blockWidth-blockWidth/2<0-2*blockWidth) {
                    UnFinishVerti=false;
                }
                heightAndWidth[1]++;
            }   
            yInc=0;
            while(!UnFinishVerti){
                yInc++;
                addObject(blocks2D[originPoint[0]+yInc][originPoint[1]-xInc],getWidth()/2-xInc*blockWidth,startingY+blockWidth+yInc*blockWidth);
                if(startingY+blockWidth+yInc*blockWidth+blockWidth/2>getHeight()+2*blockWidth){
                    UnFinishVerti = true;
                }
                heightAndWidth[1]++;
            }
            heightAndWidth[0]++;
            if(getWidth()/2-xInc*blockWidth-blockWidth/2<0-2*blockWidth){
                unfinish=true;
            }
        }    
        heightAndWidth[1]=heightAndWidth[1]/heightAndWidth[0]+1;        

    }    

    /**
     * Construct the map when Steve is moving in the engine.
     */
    private void constructTheMap(){
        blocks2D= new Blocks[200][200];
        background2D=new int[200][200];
        int basicSoilLevel=50;
        int random=0;
        int randomizer;
        int basicBlockLevel=20;
        // Construct backgrounds.
        for(int i=0;i<blocks2D[0].length;i++){
            basicSoilLevel+=random;
            if(basicSoilLevel<=30||basicSoilLevel>=50)basicSoilLevel-=random*2;
            if(Greenfoot.getRandomNumber(10)==1&&i>5&&i<145) addTrees(basicSoilLevel,i);
            blocks2D[basicSoilLevel][i]=new Objects("grass_side",i,basicSoilLevel);
            background2D[basicSoilLevel][i]=1;
            if(i==(blocks2D[0].length)/2)  
                originPoint=new int[]{basicSoilLevel,i};
            randomizer=(int)(Math.random() * 100);
            if(randomizer<8) 
                random=-2;
            else if(randomizer<30) 
                random =-1;
            else if(randomizer<70)
                random =0;
            else if(randomizer<92)
                random =1;
            else if(randomizer<100)
                random =2;

            basicBlockLevel+=random;
            if(basicBlockLevel<=10||basicBlockLevel>=30) basicBlockLevel-=random*2;
            blocks2D[basicBlockLevel+basicSoilLevel][i]=addRandomBlock(i,basicBlockLevel+basicSoilLevel);
            background2D[basicBlockLevel+basicSoilLevel][i]=2;
            randomizer=(int)(Math.random() * 100);
            if(randomizer<8) 
                random=-2;
            else if(randomizer<30) 
                random =-1;
            else if(randomizer<70)
                random =0;
            else if(randomizer<92)
                random =1;
            else if(randomizer<100)
                random =2;
        }   
        // Construct backgrounds.
        for(int i=0;i<blocks2D[0].length;i++){
            int station=0;
            for(int j=0;j<blocks2D.length-1;j++){
                if(blocks2D[j][i]==null){
                    if(station==0) {
                    blocks2D[j][i]=new Background("sky background",i,j);
                    background2D[j][i]=0;
                }
                    else if(station==1) {
                        blocks2D[j][i]=new Objects("dirt",i,j);
                        background2D[j][i]=1;
                    }
                    else if (station==2) {
                        blocks2D[j][i]=addRandomBlock(i,j);
                        background2D[j][i]=2;
                    }
                }    
                else if(!blocks2D[j][i].Name().equals("tree 1 part 1")&&!blocks2D[j][i].Name().equals("log_spruce")) station++;
            }    
        }    
        for(int i=0;i<blocks2D[0].length;i++){
            blocks2D[blocks2D.length-1][i]=new Objects("bedrock",i,blocks2D.length-1,false);
        }    
    }    

    /**
     *  Added the block randomly to the game.
     *  
     *  @param  x   X-coordinate of engine the added block being at.
     *  @param  y   Y-coordinate of engine the added block being at.
     *  
     *  @return The block that is being added.
     */
    private Objects addRandomBlock(int x, int y){
        int random=(int)(Math.random() * 1000);
        if(random<2) return new Objects("diamond_ore",x,y);
        else if(random<10) return new Objects("gold_ore",x,y);
        else if(random<70) return new Objects("iron_ore",x,y);
        else if(random<150) return new Objects("coal_ore",x,y);
        else return new Objects("stone",x,y);
    }   

    /**
     * Return the coordinate of blocks.
     * 
     * @return  The coordinate of block in the engine.
     */
    public Blocks[][] blocks(){
        return blocks2D;
    }   

    /**
     * Move blocks in the engine by add and remove blocks in different locations.
     * 
     * @param Xinc  Horiztontal distance that block will move.
     * @param Yinc  Vertical distance that block will move.
     */
    public void moveBlocks(int Xinc,int Yinc){
        // Make sure horitontal and vertical distance is not out of bound.
        if(!canBlockMove[0]&&Yinc<0)  Yinc=0;
        else if(!canBlockMove[2]&&Yinc>0)  Yinc=0;
        if(!canBlockMove[1]&&Xinc<0)  Xinc=0;
        else if(!canBlockMove[3]&&Xinc>0)  Xinc=0;
        steve.moveSelectingSide(Xinc,Yinc);
        // Move all blocks in engine.
        for(Blocks b:getObjects(Blocks.class)){
            b.setLocation (Xinc+b.getX(),Yinc+b.getY());
            int type=isAtEdge(b);
            if(type!=0){
                // Switch different cases to check how much each block will move.
                switch (type){
                    case 1: 
                    temp=blocks2D[b.XandY[1]][b.XandY[0]+heightAndWidth[0]];
                    if(b.XandY[0]+heightAndWidth[0]==blocks2D[0].length-1){
                        canBlockMove[1]=false;
                    }    
                    else if(canBlockMove[3]==false){
                        canBlockMove[3]=true;
                    }    
                    addObject(temp, b.getX()+heightAndWidth[0]*blockWidth,b.getY());
                    //temp.readAnimalList(1);
                    removeObject(b);
                    break;
                    case 2: 
                    temp=blocks2D[b.XandY[1]][b.XandY[0]-heightAndWidth[0]];
                    addObject(temp,b.getX()-heightAndWidth[0]*blockWidth,b.getY());
                    //temp.readAnimalList(2);
                    if(b.XandY[0]-heightAndWidth[0]==0){
                        canBlockMove[3]=false;
                    }    
                    else if(canBlockMove[1]==false){
                        canBlockMove[1]=true;
                    }    
                    removeObject(b);
                    break;
                    case 3: 
                    temp=blocks2D[b.XandY[1]+heightAndWidth[1]][b.XandY[0]];
                    addObject(temp,b.getX(),b.getY()+heightAndWidth[1]*blockWidth);
                    //temp.readAnimalList(3);
                     if(b.XandY[1]+heightAndWidth[1]==blocks2D.length-1){
                        canBlockMove[0]=false;
                    }    
                    else if(canBlockMove[2]==false){
                        canBlockMove[2]=true;
                    }    
                    removeObject(b);
                    break;
                    case 4: 
                    temp=blocks2D[b.XandY[1]-heightAndWidth[1]][b.XandY[0]];
                    addObject(temp,b.getX(),b.getY()-heightAndWidth[1]*blockWidth);
                    if(b.XandY[1]-heightAndWidth[1]==0){
                        canBlockMove[2]=false;
                    }    
                    else if(canBlockMove[1]==false){
                        canBlockMove[1]=true;
                    }    
                    removeObject(b);
                    break;
                }
            }    
        }

    } 

    /**
     * Check if Living things are at edge of the engine.
     * 
     * @param a The actor to be checked if he is at edge.
     * 
     * @return  The index to represent which edge the actor is at.
     */
    private int isAtEdge(Actor a){
        if(a.getX()+blockWidth/2<0-3*blockWidth){
            //at left border
            return 1;
        }
        if(a.getX()-blockWidth/2>getWidth()+blockWidth*3){
            //at right border

            return 2;
        }
        if(a.getY()+blockWidth/2<0-3*blockWidth){
            //at top border

            return 3;
        }
        if(a.getY()-blockWidth/2>getHeight()+3*blockWidth){
            //at down border
            return 4;
        } 
        return 0;
    } 

    /**
     * Return the information of mouse.
     * 
     * @return  The information of mouse.
     */
    public MouseInfo getMouseInfo(){
        return mouse;
    }    

    /**
     * Return the width of the block.
     * 
     * @return  The width of the block.
     */
    public static int getBlockWidth(){
        return blockWidth;
    }

    /**
     * Add trees to the engine.
     * 
     * @param   Y Y-coordinate of the ground blocks 
     * @param   X X-coordinate of the ground blocks 
     */
    private void addTrees(int Y, int X){//the coordinate of the ground blocks
        // Check at which specific location trees should be added in different situations.
        for(int i=-2;i<3;i++) if(blocks2D[Y-4][X-i]==null||blocks2D[Y-4][X-i].isbackground()) {
            blocks2D[Y-4][X-i]=new  Objects("tree 1 part 1",X-i,Y-4);
            background2D[Y-4][X-i]=0;
        }
        for(int i=-2;i<3;i++) if(blocks2D[Y-5][X-i]==null||blocks2D[Y-5][X-i].isbackground()) {
            blocks2D[Y-5][X-i]=new  Objects("tree 1 part 1",X-i,Y-5);
            background2D[Y-5][X-i]=0;
        }
        for(int i=-1;i<2;i++) if(blocks2D[Y-6][X-i]==null||blocks2D[Y-6][X-i].isbackground()) {
            blocks2D[Y-6][X-i]=new  Objects("tree 1 part 1",X-i,Y-6);
            background2D[Y-6][X-i]=0;
        }
        if(blocks2D[Y-7][X]==null||blocks2D[Y-7][X].isbackground()) {
            blocks2D[Y-7][X]=new Objects("tree 1 part 1",X,Y-7);
            background2D[Y-7][X]=0;
        }
        for(int i=1;i<7;i++) {
            blocks2D[Y-i][X]=new Objects("log_spruce",X,Y-i);
            background2D[Y-i][X]=0;
        }
    }    //if(Greenfoot.getRandomNumber(10)==1&&i>5&&i<195) addTrees(basicSoilLevel,i);

    /**
     * Return the coordinate of background.
     * 
     * @return  The coordinate of background in the engine.
     */
    public static int[][] getBackground2D(){
        return background2D;
    }    
    
    /**
     * Return the body of Steve.
     * 
     * @return  The Steve in the engine.
     */
    public SteveBody getSteve(){
        return steve;
    }
    
    /**
     * Return the choice box.
     * 
     * @return  The choice box in the engine.
     */
    public ChoiceBox getChoiceBox(){
        return choiceBox;
    }    
}
