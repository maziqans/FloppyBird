import greenfoot.*; 

/**
 * 
 * Ammar Haziq Bin Annas
 * 2116043
 * Group 6
 */
public class WorldClass extends World
{
    private int lastPipe = 300;
    private boolean isLost; 
    private Timer pipeTimer = new Timer();
    private ScoreDisplay score = new ScoreDisplay();

    private static GreenfootImage bgImage = new GreenfootImage("world2.jpg");
    private static final int SCROLL_SPEED = 5;
    private GreenfootImage scrollingImage;
    private int scrollPosition = 0;

    public WorldClass()
    {
        super(500, 600, 1);
        Logo logoObject = new Logo();
        addObject (logoObject, getWidth()/2, getHeight()*1/3);
        addObject(new Bird(), 200, 300);
        addObject(score, 50, 50); 

        setPaintOrder(GameOver.class, Bird.class, ScoreDisplay.class, TopPipe.class, BottomPipe.class, Boundary.class);
        GreenfootImage background = new GreenfootImage(500, 600);
        scrollingImage = getScrollingImage(500, 600);
        background.drawImage(scrollingImage, 0, 0);
        setBackground(background);
    }

    /**
     * Scroll the world.
     * Check if it needs to add a new pipe.
     */
    public void act()
    {
        if(!isLost)
        {
            if(SCROLL_SPEED > 0 && scrollPosition <= 0) {
                scrollPosition = getWidth();
            }
            if(SCROLL_SPEED < 0 && scrollPosition >= getWidth()) {
                scrollPosition = 0;
            }
            scrollPosition -= SCROLL_SPEED;
            paint(scrollPosition);

            //After the given amount of milliseconds, add a new pipe.
            if(pipeTimer.elapsedTime() >= 1000)
            {
                newPipe();
            }
        }
    }

    /**
     * Create a new pipe along with a Boundary object at the intervals and locations given.
     */
    private void newPipe()
    {
        int newPipe = lastPipe + Greenfoot.getRandomNumber(300) - 100;
        if(newPipe < 100) newPipe = 100 + Greenfoot.getRandomNumber(150);
        if(newPipe > 400) newPipe = 400 - Greenfoot.getRandomNumber(150); 

        addObject(new TopPipe(newPipe), 0, 0);
        addObject(new BottomPipe(newPipe), 0, 0);
        addObject(new Boundary(newPipe), 0, 0);

        lastPipe = newPipe;
        pipeTimer.setNow(); 
    }

    public void score()
    {
        score.add(1);
    }

    /**
     * End the game and show the GameOver screen
     */
    public void lost()
    {
        removeObjects(getObjects(null));
        isLost = true;
        addObject(new GameOver(score.integerScore), 250, 300);
    }

    /**
     * Scrolls the background at given position and make it fill the screen.
     */
    private void paint(int position)
    {
        GreenfootImage bg = getBackground();

        bg.drawImage(scrollingImage, position, 0);
        bg.drawImage(scrollingImage, position - scrollingImage.getWidth(), 0);
    }

    private GreenfootImage getScrollingImage(int width, int height)
    {
        GreenfootImage image = new GreenfootImage(width, height);
        for(int x = 0; x < width; x += bgImage.getWidth()) {
            for(int y = 0; y < height; y += bgImage.getHeight()) {
                image.drawImage(bgImage, x, y);
            }
        }
        return image;
    } 
}
