import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * LinearPointer class is used to create and return distance or angles between two things.
 * 
 * @author Xiao Zhang
 * @version 2021.01.28
 */
public class LinearPointer extends Actor
{
    /**
     * Constructor for objects of class LinearPointer.
     *          
     */
    public LinearPointer(){
        setImage(new GreenfootImage(10,10));
    }    
    
    /**
     * Return the updated object.
     * 
     * @param x1    X-coordinate of location1.
     * @param x2    X-coordinate of location2.
     * @param y1    Y-coordinate of location1.
     * @param y2    Y-coordinate of location2.
     * 
     * @return  The updated object.
     */
    public Objects update(int x1,int y1, int x2, int y2){
            double mouse_distance = getDistance(x1,x2,y1,y2);
            GreenfootImage ColImage = new GreenfootImage((int)(mouse_distance+1.5),1);
            setImage(ColImage);
            setLocation((int)((x1+x2)/2),(int)((y1+y2)/2));
            
        // Aligns it in the direction of the mouse
        setRotation((int)getDegreesToFrom(x1,y1,x2,y2));
        
            List<Objects> List_Class_ = getIntersectingObjects(Objects.class);
            if(List_Class_.isEmpty())return  null;
            else {
                Objects obj=null;
                int i=-1;
                for(Objects o:List_Class_){
                    int j=(int)getDistance(x1,o.getX(),y1,o.getY());

                    if(i==-1){
                        i=j;
                        obj=o;
                    }    
                    else if(j<i){
                        i=j;//find the 
                        obj=o;
                    }    
                }    
                return obj;
            }
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

   
}
