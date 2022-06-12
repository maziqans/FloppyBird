import greenfoot.*;  

/**
 * The bottom part of the "pipe"
 * 
 * WAN AFIF NAJMUDDIN BIN MOHD SYUKRI 2115737

 * 
 */
public class BottomPipe extends Actor
{
    private GreenfootImage imgBottom;
    
    private int pos; //The midpoint of the gap in the pipes
           
    private boolean isInitialized = false; //Checks if the pipe has been initialized on the screen.
  
    public BottomPipe(int location)
    {
        imgBottom = new GreenfootImage(80, 600 - location - 50); 
        pos = location;
    }
    
    
    public void act() 
    {
        if(!isInitialized) //Checks if the pipe has been initialized. If not, then sets the pipe's location.
        {
            setLocation(500, pos + 100 + (imgBottom.getHeight() / 2));
            isInitialized = true;
        }
        
        if(getX() <= 1)
        {
            getWorld().removeObject(this); //Moves the pipe to the left across the screen and remove it just when it exits the world.
        }
        
        move(-5);
    }    
}
