import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Money here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Money extends Actor
{
    private GreenfootImage image;
    private static int money = 0;
    public Money()
    {
        money = 0;
        image = new GreenfootImage("Money:0",40,Color.GREEN,Color.WHITE);
        setImage(image);
    }
    /**
     * Act - do whatever the Money wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        money++;
        update();
    }   
    public void add()
    {
        money++;
        update();
    }
    public static int getMoney()
    {
        return money;
    }
    public void update()
    {
        image.clear();
        image = new GreenfootImage("Money:"+money,40,Color.GREEN,Color.WHITE);
        setImage(image);
    }
}
