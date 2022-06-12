import greenfoot.*;  


/**
 * A text that will display the score in integer.
 * AKMAL NAZIM BIN MOHD NAUFAL 2117515
 */
public class ScoreDisplay extends Actor
{
    public int integerScore; 
    
    /**
     * This function will create a display with the value is set to zero.
     */
    public ScoreDisplay()
    {
        setToValue(0);
        updateScore();
    }

    /**
     * Sets the score to be displayed on the screen to equal the score that user get.
     */
    private void setToValue(int num)
    {
        integerScore = num;
        updateScore();
    }

    /**
     * Add the integer by one to the score display.
     */
    public void add(int num)
    {
        integerScore += num;
        updateScore();
    }

    /**
     * Update the screen to display the score.
     */
    private void updateScore()
    {
        //Create an image with the current score
        GreenfootImage text = new GreenfootImage(""+integerScore, 60, Color.WHITE, new Color(0, 0, 0, 0));
        
        setImage(text);
    }
}
