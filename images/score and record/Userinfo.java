import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Userinfo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Userinfo extends Actor
{
    private static int score=0;
    private GreenfootImage image;
    /**
     * Act - do whatever the Userinfo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Userinfo()
    {
        score = 0;
        image = new GreenfootImage("Score:0",40,Color.GREEN,Color.WHITE);
        setImage(image);
    }
    public void act() 
    {
        score = Money.getMoney();
        update();
    }    
    
    
    public void update()
    {
        GreenfootImage img = getImage();
        img.clear();
        img = new GreenfootImage("Score:"+score,40,Color.GREEN,Color.WHITE);
        setImage(img);
    }
    public static int getScore()
    {
        return score;
    }
}
