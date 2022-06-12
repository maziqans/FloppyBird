/**
 * A timer that will counts the milliseconds since its last set point.
 * AKMAL NAZIM BIN MOHD NAUFAL 2117515
 */
public class Timer  
{
    private long start;

    /**
     * Start the timer
     */
    public Timer()
    {
        setNow();
    }

    /**
     * Reset the timer
     */
    public void setNow()
    {
        start = System.currentTimeMillis();
    }

    /**
     * Return the amount of milliseconds that have passed since the last set point.
     */
    public int elapsedTime()
    {
        return(int) (System.currentTimeMillis() - start);
    }
}
