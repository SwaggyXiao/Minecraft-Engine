import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Living class contain all moving objects such as animals and Steve.
 * 
 * @author Xiao Zhang
 * @version 2021.01.28
 */
public abstract class Living extends Actor
{
    /**
     * Living thing's vertical speed.
     */
    protected int vertiV=0;
    
    /**
     * Living thing's horizontal speed.
     */
    protected int horiV=0;
    
    /**
     * Living thing's acceleration.
     */
    protected int vertiA=1;
    
    /**
     * Living thing's width.
     */
    protected int imageWidth;
    
    /**
     * Living thing's height.
     */
    protected int imageHeight;
    
    /**
     * Living thing's moving direction, represented by integers.
     */
    protected int movingDirection = 0; // Right is 0, Left is 1
    
    /**
     * Living thing's image.
     */
    protected GreenfootImage image;
    
    /**
     * Whether Living thing is facing right.
     */
    protected boolean facingRight;
    
    /**
     * Living thing's jump speed.
     */
    protected int VertiJumpInitialSpeed=-15;
    
    /**
     * Whether Living thing is jumping.
     */
    protected boolean isJumping=false;
    
    /**
     * Arrays that store key location of x-coordinate.
     */
    protected int[] KeyPointX;//0-->bottom Left x, 1--> bottom Right x, 2--> Left X, 3--> RIght X
    
    /**
     * Arrays that store key location of y-coordinate.
     */
    protected int[] KeyPointY;//0-->Top x, 1--> bottom, 2--> up 1/4, 3--> down 1/4
    
    /**
     * Block's width.
     */
    protected static int blockWidth=MineCraftWorld.getBlockWidth();
    
    /**
     * Verticle motion of living things.
     */
    protected void verticleMotion(){
        if(getOneObjectAtOffset(KeyPointX[0],KeyPointY[1]+vertiV+vertiA,Objects.class)==null&&
        getOneObjectAtOffset(KeyPointX[1],KeyPointY[1]+vertiV+vertiA,Objects.class)==null
        ) {
            if(!isJumping) isJumping=true;
            vertiV+=vertiA;
        }
        else if(isJumping){
            if(getOneObjectAtOffset(KeyPointX[0],KeyPointY[1]+vertiV+vertiA,Objects.class)!=null)
            vertiV= getOneObjectAtOffset(KeyPointX[0],KeyPointY[1]+vertiV+vertiA,Objects.class).getY()-blockWidth/2-this.getY()-KeyPointY[1];
            else if(getOneObjectAtOffset(KeyPointX[1],KeyPointY[1]+vertiV+vertiA,Objects.class)!=null)
            vertiV= getOneObjectAtOffset(KeyPointX[1],KeyPointY[1]+vertiV+vertiA,Objects.class).getY()-blockWidth/2-this.getY()-KeyPointY[1];
            isJumping=false;  
        }
    }    

    /**
     * Return whether living things can move up.
     * 
     * @return  Whether living things can move up.
     */
    protected abstract boolean canMoveUp();

    /**
     * Return whether living things can move right.
     * 
     * @return  Whether living things can move right.
     */
    protected abstract boolean canMoveRight();

    /**
     * Return whether living things can move left.
     * 
     * @return  Whether living things can move left.
     */
    protected abstract boolean canMoveLeft();

}
