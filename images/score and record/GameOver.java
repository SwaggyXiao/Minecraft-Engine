import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
import java.util.Arrays;
import javax.swing.JOptionPane;
/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    private static int highestScore;
    private static HashMap<String, Arrays> record = new HashMap<String, Arrays>();
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        String name = JOptionPane.showInputDialog("Enter your name: ");
        record.put(name,BackPack.getElement());
        if(MyWorld.getScore() > highestScore)
        {
            highestScore = MyWorld.getScore();
            showText("New High Score!",400,300);
        }
        else
        {
            showText("Your Score was: "+ MyWorld.getScore(),400,325);
        }
        showText("Your High Score is: " + highestScore,400,350);
    }
    
    
}
