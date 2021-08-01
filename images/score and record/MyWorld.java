import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private Userinfo use;
    private Money money;
    private static int score = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        use = new Userinfo();
        addObject(use,100,100);
        money = new Money();
        addObject(money,200,200);
    }
    public void act()
    {
        score = Userinfo.getScore();
        if(Greenfoot.getRandomNumber(900)==1)
        {
            Greenfoot.setWorld(new GameOver());
        }
    }
    public static int getScore()
    {
        return score;
    }
}
