
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Subclass of Living, Animal class contains all animal objects.
 * 
 * @author Xiao Zhang
 * @version 2021.01.28
 */
public class Animal extends Living
{
    // Variables used in Animal class.
    private int speed = 3;
      private MineCraftWorld mc;
 private int blockWidth;
    
    /**
     * Constructor for objects of class Animal.
     * 
     * @param Type   The animal type.
     *       
     */
    public Animal(String Type){
        facingRight= Greenfoot.getRandomNumber(100)<50;
        image=new GreenfootImage("Character/"+Type+".png");
        imageWidth = image.getWidth();
        imageHeight = image.getHeight();
        setImage(image);
        if(facingRight)  getImage().mirrorHorizontally();
        constructKeyPoints();
    }    
    
    /**
     * Called by Greenfoot when an object of this class is added to 
     * the World.
     * 
     * @param w The World being added to.
     */
    public void addedToWorld(World w){
       mc=(MineCraftWorld)w;
       blockWidth=mc.getBlockWidth();
    }
    
    /**
     * Act method to always check direction and move horizontally and vertically.
     */
    public void act(){
        changeDirection();
        moving(speed);
        verticleMotion();
        setLocation(getX()+horiV,getY()+vertiV);
        if(vertiV!=0&&!isJumping){
           vertiV=0;
        }
        //leave();
    } 
    
    /**
     * Animal's moving method.
     * 
     * @param distance  The distance animal will move.
     */
    protected void moving(int distance/**left is negative, rigth is positive**/)
    {
        if(facingRight)
        {
            horiV = distance;
            if(!canMoveRight()&&canMoveUp()){
                isJumping=true;
                vertiV=VertiJumpInitialSpeed;
            }    
        }
        else if(!facingRight)
        {
            horiV = -distance;
            if(!canMoveLeft()&&canMoveUp()){
                isJumping=true;
                vertiV=VertiJumpInitialSpeed;
            } 

        }   
    }
    
    /**
     * Return whether animals can move left.
     * 
     * @return  Whether animals can move left.
     */
    protected boolean canMoveLeft(){
        return getOneObjectAtOffset(KeyPointX[2]+horiV-1,KeyPointY[2]+1,Objects.class)==null
        &&getOneObjectAtOffset(KeyPointX[2]+horiV-1,0,Objects.class)==null
        &&getOneObjectAtOffset(KeyPointX[2]+horiV-1,KeyPointY[3]+1,Objects.class)==null;
        
    }  
    
    /**
     * Return whether animals can move right.
     * 
     * @return  Whether animals can move right.
     */
    protected boolean canMoveRight(){
        return getOneObjectAtOffset(KeyPointX[3]+horiV+1,KeyPointY[2]+1,Objects.class)==null
        &&getOneObjectAtOffset(KeyPointX[3]+horiV+1,0,Objects.class)==null
        &&getOneObjectAtOffset(KeyPointX[3]+horiV+1,KeyPointY[3]+1,Objects.class)==null;
    }  
    
    /**
     * Return whether living things can move up.
     * 
     * @return  Whether living things can move up.
     */
    protected boolean canMoveUp(){
        return getOneObjectAtOffset(0,KeyPointY[0],Objects.class)==null&&!isJumping;
    }
    
    /**
     * Change the moving direction of animals.
     */
    protected void changeDirection()
    {
        if(Greenfoot.getRandomNumber(100)==0&&facingRight)
        {
            facingRight = false;
                        getImage().mirrorHorizontally();

        }
        else if(Greenfoot.getRandomNumber(100)==0&&!facingRight)
        {
            facingRight = true;
           getImage().mirrorHorizontally();

        }
    }
    
    /**
     * Construct key locations of animals
     */
    private void constructKeyPoints(){
        KeyPointX=new int[]{-imageWidth/2,imageWidth/2,-imageWidth/2,imageWidth/2};
        KeyPointY=new int[]{-imageHeight/2,imageHeight/2,-imageHeight/4,imageHeight/4};
    } 
    
    /**
     * Check animals are leaving the world.
     */
    private void leave(){
        if(this.getX()+KeyPointX[1]+10<=0||this.getX()+KeyPointX[0]-10>=1100){//10 is just an index
            ((Blocks)getOneObjectAtOffset(0, 0, Blocks.class)).addInAnimalList(this);
            mc.removeObject(this);
        }     
        else if(this.getY()+KeyPointY[1]+10<=0||this.getY()+KeyPointX[0]-10>=700){
            ((Blocks)getOneObjectAtOffset(0, 0, Blocks.class)).addInAnimalList(this);
            mc.removeObject(this);
        }    
        
    }    
    
    
}
