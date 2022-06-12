import greenfoot.*;  
import java.util.concurrent.TimeUnit;

/**
 * This is the class that the player controls. 
 * Contains code for the bird's movement and animation.
 *  
 * @author Siti Munizaiyanah binti Bahaman 2116492
 * 
 */
public class Bird extends Actor
{
    private WorldClass w;
    
    private int moveY = 5;  //Simulates gravity by defining the amount by which the bird will descend each time
                            //When the bird leaps, a negative value is assigned to the moveY variable, and the bird goes upward
                            //To return to the starting state, moveY is incremented by 1 kn every act until it reaches 5 kn
                            
    private int imageNumber = 1; //Used for animating the bird's wings

    private GreenfootImage img1; //The first picture that is presented in a sequence for the animation effect

        public Bird()
    {
        img1 = new GreenfootImage(getImage()); 
        setImage(img1);
    }

    public void addedToWorld(World world)
    {
        w = (WorldClass) world; 
    }

    public void act() 
    {
        flapUp();

        if(isTouching(Boundary.class)) 
        {
            w.score();
            w.removeObject(getOneIntersectingObject(Boundary.class)); //The invisible border is removed hence making it impossible to score on the same pipe more than once

            Greenfoot.playSound("ping.mp3");
        }

        if(isTouching(TopPipe.class) || isTouching(BottomPipe.class) || getY() >= 599)
        {
            w.lost();
            try
            {
            TimeUnit.SECONDS.sleep(1);
            }
            catch(InterruptedException ex)
            {
               ex.printStackTrace(); 
            }
            Greenfoot.playSound("dedheli.mp3");
        }
    }   

    /**
     * To animate the bird's wings.
     */
    private void animate()
    {
        if(Greenfoot.getRandomNumber(3) == 0)
        {
            if(imageNumber == 3)
            {
                imageNumber = 1;
            }
            else {
                imageNumber++;
            }
            setImage("flappybird"+imageNumber+".png");
        }
    }    

    /**
     * Flap up either on mouse click or keyboard input.
     */
    private void flapUp()
    {
        final int jumpDist = -18;
        if(Greenfoot.mouseClicked(null))
        {
            moveY = jumpDist;
            Greenfoot.playSound("watdadogdoin.mp3");
        }

        else if(Greenfoot.isKeyDown("space")||Greenfoot.isKeyDown("up"))
        {
            moveY = jumpDist/2; //Keyboard input is prioritised in the control scheme

            Greenfoot.playSound("watdadogdoin.mp3");
        }
        if(moveY != 5) 
        {
            moveY++; 
        }
        setLocation(getX(), getY() + moveY);
        animate();
    }
}

