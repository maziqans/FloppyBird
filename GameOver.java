import greenfoot.*;


/**
 * When the user loses the game, this is the Game Over screen that appears.
 * 
 * @author Nureen Batrisyia Balqis Binti Karimudin 2112830
 * 
 */
public class GameOver extends Actor
{        
    public GameOver(int score)
    {
        GreenfootImage img1 = new GreenfootImage("world2.jpg");
        GreenfootImage img2 = new GreenfootImage("game_over.png");
        img2.scale(300,60);
                
        GreenfootImage text1 = new GreenfootImage("Press ENTER to try again!", 30, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage text2 = new GreenfootImage("SCORE: "+ score, 60, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage text3 = new GreenfootImage("BEST: " + getBestScore(score), 40, Color.WHITE, new Color(0, 0, 0, 0));
        
        img1.drawImage(img2, 250 - (img2.getWidth() / 2), 75);
        img1.drawImage(text1, 250 - (text1.getWidth() / 2), 380);
        img1.drawImage(text2, 250 - (text2.getWidth() / 2), 200);
        img1.drawImage(text3, 250 - (text3.getWidth() / 2), 250);
        
        setImage(img1);
    }
    
    /**
     * Returns the player's highest score and checks to see if it's a new highscore.
     * If yes, the value is returned and set as the high score.
     */
    private int getBestScore(int score)
    {
        UserInfo usrObject = UserInfo.getMyInfo();
        if(usrObject != null)
        {
            int currentHigh = usrObject.getInt(1);
                       
            if(score > currentHigh)
            {
                usrObject.setInt(1, score);
                usrObject.store();
                return score;
            }
            else
            {
                return currentHigh;
            }
            
        }
        else return 0;
    }
    
    /**
     * When users press Enter to start a new game, the world is reset.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new WorldClass());
        }
    }    
}
