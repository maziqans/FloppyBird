import greenfoot.*;  

/**
 * This is a line between two pipes that is not visible. When a bird lands on it, it understands that it is signaling the world to add a point.
 * 
 * @author Nureen Batrisyia Balqis Binti Karimudin 2112830
 * 
 */
public class Boundary extends Actor
{
    private GreenfootImage imgBoundary;
    private boolean isPipeInitialized = false; //Checks if pipe in the world has been initialised.
    private int pos;
    public Boundary(int location)
    {
        imgBoundary = new GreenfootImage(1, 180); //This is the line's image. This remains undetectable.
        pos = location;
        setImage(imgBoundary);
    }
 
    public void act() 
    {
        if(!isPipeInitialized)
        {
            setLocation(500, pos);
            isPipeInitialized = true;
        }
        
        move(-5);
    }    
}
