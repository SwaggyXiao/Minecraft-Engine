import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button class is used to create different buttons.
 * 
 * @author Xiao Zhang and Delun Sun
 * @version 2021.01.28
 */
public class Button extends Actor
{
    // Variables used in Button class.
    protected MouseInfo m;
    protected GreenfootImage idleImage;
    protected GreenfootImage mouseOverImage;
    String image;
    protected boolean mouseOver;
    protected boolean clicked;
    
    /**
     * Constructor for objects of class Button.
     * 
     * @param   image   The name of the image. 
     * 
     */
    public Button (String image)
    {
        mouseOver = false;
        //see if mouse is on top of the buttom
        clicked = false;//see if it is been clicked
        this.image=image;//get which image it is
        initImages();//set the image
        
    }
    
    /**
     * Act method to call checkMouse() method.
     */
    public void act(){
        checkMouse();
    } 
    
    /**
     * Check if mouse is over the button.
     */
    protected void checkMouse()
    {
        m = Greenfoot.getMouseInfo();
        if (m != null){
            // MouseOver State
            if (!mouseOver && Greenfoot.mouseMoved(this)){
                mouseOver = true;
            }
            if (mouseOver && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
                mouseOver = false;
            }
            //assign the boolean mouseOver
            if (mouseOver)
            {
                this.setImage(mouseOverImage);
                //the larger image when the mouse is on it
            } 
            else 
            {
                this.setImage(idleImage);
                //original small image if the mouse is not on it
            }
        }
    }
    
    /**
     * Set the initial and mouseover images for button.
     */
    protected void initImages()
    {
        idleImage = new GreenfootImage ("buttons/"+image+".png");
        //the scale for the original icon
        mouseOverImage = new GreenfootImage("buttons/"+image+"_mouseover.png");
        //the scale for the larger icon
        setImage(idleImage);
        //the beginning image
    }   
    
    /**
     * Rescale the size of image.
     * 
     * @param   width   The new width of image.
     * @param   height  The new height of image.
     */
    public void reScale(int width, int height)
    {
        idleImage.scale(width,height);
        mouseOverImage.scale(width,height);
    }
}
