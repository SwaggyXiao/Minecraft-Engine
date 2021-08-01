import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Subclass of Steve, SteveBody class contains body of Steve.
 * 
 * @author Xiao Zhang
 * @version 2021.01.28
 */
public class SteveBody extends Steve
{
    // Variables used in SteveBody class.
            private GreenfootSound walk=new GreenfootSound("Walk on grass.mp3");
            private GreenfootSound mining=new GreenfootSound("Mining.mp3");

        
    private BackHand SHBack;
    private FrontHand SHFront;
    private SteveFeet SFFront,SFBack;
    private GreenfootImage body;
    private MineCraftWorld mc;
    private int safeDistanceFromRockForHori=10;
    private MouseInfo mouse;
    private Objects temp;
    private Objects newHolder=null;
    private boolean havingSelectingSide=false;
    private LinearPointer LP=new LinearPointer();
    private boolean isMining=false;
    private int miningDemage=1;
    private  Item[] intermediateItems=new Item[9];
    private  Item[][] backupItems=new Item[3][9];
    private  Item[] armor=new Item[4];
    
    /**
     * Constructor for objects of class SteveBody.
     *       
     */
    public SteveBody(){
        facingRight=true;
        body=new GreenfootImage("Character/steve body.png");
        setImage(body);
    }

    /**
     * Called by Greenfoot when an object of this class is added to 
     * the World.
     * 
     * @param w The World being added to.
     */
    public void addedToWorld(World w){
        // Add Steve's hand and foot onto Steve's body.
        mc=(MineCraftWorld)w;
        SHFront=new FrontHand();
        SHBack=new BackHand();
        SFFront=new FrontFoot();
        SFBack=new BackFoot();
        mc.addObject(SHFront,getX(),getY()+4*5);
        mc.addObject(SHBack,getX(),getY()+4*5);
        mc.addObject(SFFront,getX(),getY()+16*5);
        mc.addObject(SFBack,getX(),getY()+16*5);
        mc.addObject(LP,300,400);
    } 

    /**
     * Act method to check the motion of Steve.
     */
    public void act(){
        mouse=mc.getMouseInfo();
        if(mouse!=null){
            changeFacing(mouse.getX()>=getX());
            getObjectsOnLine();
        }
        checkMousePressing();
        if(isMining&&newHolder!=null){
            newHolder.mining(miningDemage,mc);
            mining.play();
        }    
        
        if(Greenfoot.isKeyDown("d")&&canMoveRight()) {
            horiV=speed;
            walk.play();
        }
        else if(Greenfoot.isKeyDown("a")&&canMoveLeft()) {
            horiV=-speed;
            walk.play();
        }
        verticleMotion();
        
        if(vertiV!=0||horiV!=0) {
            mc.moveBlocks(-horiV,-vertiV);
            horiV=0;
            if(!isJumping){
                vertiV=0;
            }
        }
    }    

    /**
     * Move the selecting slide of Steve's body.
     * 
     * @param   X   The x-coordinate of Steve.
     * @param   Y   The y-coordinate of Steve.
     */
    public void moveSelectingSide(int X,int Y){
          if(havingSelectingSide) newHolder.getSelectingSide().moveSelectingSide(X,Y);

    }    
    
    /**
     * Verticle motion of SteveBody.
     */
    protected void verticleMotion(){
        if(Greenfoot.isKeyDown("w")&&canMoveUp()){
            isJumping=true;
            vertiV=VertiJumpInitialSpeed;
        }
        else if(getOneObjectAtOffset(0,110+vertiV+vertiA,Objects.class)==null) {
            moveHandAndFeet();
            if(!isJumping) isJumping=true;
            vertiV+=vertiA;
            if(blockUp()) vertiV=3;
        }
        else if(isJumping){
            vertiV= getOneObjectAtOffset(0,110+vertiV+vertiA,Objects.class).getY()-blockWidth/2-this.getY()-110;
            isJumping=false;  
        }
    }    

    /**
     * Return whether Steve can move right.
     * 
     * @return  Whether Steve can move right.
     */
    protected boolean canMoveRight(){
        moveHandAndFeet();
        return getOneObjectAtOffset(20+speed-1,-50+1,Objects.class)==null
        &&getOneObjectAtOffset(10+speed-1+safeDistanceFromRockForHori,0,Objects.class)==null
        &&getOneObjectAtOffset(10+speed-1+safeDistanceFromRockForHori,55+1,Objects.class)==null
        &&getOneObjectAtOffset(10-1+safeDistanceFromRockForHori,110-1,Objects.class)==null;
    } 

    /**
     * Return whether Steve can move left.
     * 
     * @return  Whether Steve can move left.
     */
    protected boolean canMoveLeft(){
        moveHandAndFeet();
        return getOneObjectAtOffset(-20-speed+1,-50+1,Objects.class)==null
        &&getOneObjectAtOffset(-10-speed+1-safeDistanceFromRockForHori,0,Objects.class)==null
        &&getOneObjectAtOffset(-10-speed+1-safeDistanceFromRockForHori,56,Objects.class)==null
        &&getOneObjectAtOffset(-10-speed+1-safeDistanceFromRockForHori,110-1,Objects.class)==null;
    } 

    /**
     * See if there are things on top during jumping. if yes, then the person will be bounced back.
     * 
     * @return  Whether there are things block up during jumping.
     */
    private boolean blockUp(){
        return getOneObjectAtOffset(-19,-50+vertiV,Objects.class)!=null||getOneObjectAtOffset(19,-50+vertiV,Objects.class)!=null;
    }

    /**
     * Return whether Steve can move up.
     * 
     * @return  Whether Steve can move up.
     */
    protected boolean canMoveUp(){
        return getOneObjectAtOffset(0,-50,Objects.class)==null&&!isJumping&&vertiV==0;
    } 

    /**
     * Move Steve's hand and feet.
     */
    private void moveHandAndFeet(){
        SHFront.setIsMoving();
        SHBack.setIsMoving();
        SFFront.setIsMoving();
        SFBack.setIsMoving();
    }   

    /**
     * Change the facing direction of Steve.
     * 
     * @param isRight   Whether Steve is facing right.
     */
    protected void changeFacing(boolean isRight){
        if(!facingRight&&isRight){
            getImage().mirrorHorizontally();
            SHFront.reverse();
            SHBack.getImage().mirrorHorizontally();
            SFFront.getImage().mirrorHorizontally();
            SFBack.getImage().mirrorHorizontally();
            facingRight=true;
        }    
        else if(facingRight&&!isRight){
            getImage().mirrorHorizontally();
            SHFront.reverse();
            SHBack.getImage().mirrorHorizontally();
            SFFront.getImage().mirrorHorizontally();
            SFBack.getImage().mirrorHorizontally();
            facingRight=false;
        }    
    }    

    /**
     * Return the movement of Steve.
     */
    public  int[] movement(){
        return new int[]{-horiV,-vertiV};
    }   

    /**
     * Get whether objects are on line.
     */
    //https://www.greenfoot.org/topics/1526
    public void getObjectsOnLine()
    {
        
        //setRotation(i_Rot);
        //setLocation(i_AX,i_AY);
        //setImage(i);
        temp=LP.update(getX(),getY(), mouse.getX(), mouse.getY());
        if(temp==null) {
            if(newHolder!=null) newHolder.removeSelectingSide(mc);
            newHolder=null;
            havingSelectingSide=false;
            return;
        }
        double distance=getDistance(temp.getX(),getX(),temp.getY(),getY());
        
        if(distance>200) {
            if(newHolder!=null) newHolder.removeSelectingSide(mc);
            newHolder=null;
            havingSelectingSide=false;
            return;
        }
        
        int side=0;
        
        int deltaX=getX()-temp.getX();
        int deltaY=getY()-temp.getY();
        if(deltaY>0&&Math.abs(deltaX)<deltaY) side= 3;
        else if(deltaY<=0&&Math.abs(deltaX)<-deltaY) side= 1;
        else if(deltaX>0&&Math.abs(deltaY)<deltaX) side= 4;
        else if(deltaX<=0&&Math.abs(deltaY)<-deltaX) side= 2;
        else return;
       
        
        if(!temp.equals(newHolder)){
            if(newHolder!=null) newHolder.removeSelectingSide(mc);
            newHolder=temp;
            newHolder.addSelectingSide(side,mc);
            havingSelectingSide=true;
        }    
        
        //1 top 2 right 3 bottom 4 left
    }

    /**
     * Return the distances between two things.
     * 
     * @param x1    X-coordinate of location1.
     * @param x2    X-coordinate of location2.
     * @param y1    Y-coordinate of location1.
     * @param y2    Y-coordinate of location2.
     * 
     * @return The distances between two objects.
     */
    public static double getDistance(double x1,double x2, double y1,double y2)
    {
        return Math.hypot(x2-x1,y2-y1);
    }

    /**
     * Return the degrees between two objects.
     * 
     * @param x1    X-coordinate of location1.
     * @param x     X-coordinate of location2.
     * @param y1    Y-coordinate of location1.
     * @param y     Y-coordinate of location2.
     * 
     * @return The degrees between two objects.
     */
    public double getDegreesToFrom(double x1, double y1,double x,double y)
    {
        return Math.toDegrees(Math.atan2(y1-y,x1-x));
    }
    
    /**
     * Check if mouse is pressing to mine.
     */
    private void checkMousePressing(){
        if (isMining && (Greenfoot.mouseDragEnded(null) || Greenfoot.mouseClicked(null))) isMining = false;
        else if (!isMining && Greenfoot.mousePressed(null)) isMining = true;
    }    
    
    
    /**
     * 
    private static Item[] intermediateItems=new Item[9];
    private static Item[][] backupItems=new Item[3][9];
    private static Item[] armor=new Item[4];
     * **/
     
     /**
      * Return the intermidiate items in an array.
      * 
      * @return The array that store intermidiate items.
      */
     public  Item[] getIntermediateItems(){
         return intermediateItems;
        }    
      /**
      * Return the back up items in a 2Darray.
      * 
      * @return The 2Darray that store back up items.
      */
        public  Item[][] getBackupItems(){
         return backupItems;
        }    
        /**
      * Return the armor items in an array.
      * 
      * @return The array that store armor items.
      */
        public  Item[] getArmor(){
         return armor;
        }    
}
