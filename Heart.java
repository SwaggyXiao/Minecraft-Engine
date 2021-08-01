import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Heart class is used to display the health status of Steve.
 * 
 * @author Xiao Zhang and Delun Sun
 * @version 2021.01.28
 */
public class Heart extends Actor
{
    // Variables used in Heart class.
    private GreenfootImage heart;
    private GreenfootImage halfHeart;
    private GreenfootImage image;
    
    /**
     * Constructor for objects of class Heart.
     * 
     * @param num   The number of hearts being created.
     *       
     */
    public Heart(double num)
    {
        heart = new GreenfootImage("Hearts/full heart.png");
        halfHeart = new GreenfootImage("Hearts/half heart.png");
        image = new GreenfootImage((int)num*heart.getWidth(),heart.getHeight());
        for(int i=0;i<num;i++)
        {            
            image.drawImage(heart,i*heart.getWidth(),0);
        }    
        setImage(image);
    }
    
    /**
     * Update the number of hearts.
     * 
     * @param num   The updated number of hearts.
     */
    public void update(double num)
    {
        int j = 0;
        int numOfFullHeart = (int)num;
        image.clear();
        for(int i=0;i<numOfFullHeart;i++)
        {            
            image.drawImage(heart,i*heart.getWidth(),0);
            j = i;
        }  
        if(num-1 != j)
        {
            image.drawImage(halfHeart,(j+1)*heart.getWidth(),0);
        }
        setImage(image);
    }
    
    
}