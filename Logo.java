import greenfoot.*;  

/**
 * Logo that will appear when launching the game
 * AKMAL NAZIM BIN MOHD NAUFAL 2117515
 */
public class Logo extends Actor
{
    /**
     * Button 'Act' will display the logo. This method is called whenever
     * the 'Act' or 'Run' button gets clicked.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("up")||Greenfoot.mouseClicked(null)||Greenfoot.isKeyDown("space")) {
            World world;
            world = getWorld();
            world.removeObject(this);
            
        }
    }    
}
