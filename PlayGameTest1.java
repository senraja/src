package playgame;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.InputStreamReader;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


public class PlayGameTest1 {
    private ByteArrayInputStream in = null;
    private String s = null;
    
    public PlayGameTest1() {
    }
    
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * @see PlayGame#main(java.lang.String[])
     */
    @Test
    public void testMain() {
        String[] args =null;
        s = "0" + System.getProperty("line.separator") + "100" + System.getProperty("line.separator") +
                   "lower" + System.getProperty("line.separator") + "lower" + System.getProperty("line.separator") + "lower" + System.getProperty("line.separator")
            + "lower" +System.getProperty("line.separator") + "lower" + System.getProperty("line.separator") + "yes";     
        in = new ByteArrayInputStream(s.getBytes());
        PlayGame pg = new PlayGame(in, new MyGame(100,0));
        pg.main(args);
        Assert.assertEquals("yes", pg.getMg().getCompleted());
        Assert.assertEquals(1, pg.getMg().getCurrentValue()); 

        try {
            in.close();
        } catch (IOException e) {
        }
        
        s = "0" + System.getProperty("line.separator") + "100" + System.getProperty("line.separator") +
                   "higher" + System.getProperty("line.separator") + "higher" + System.getProperty("line.separator") + "higher" + System.getProperty("line.separator")
            + "lower" +System.getProperty("line.separator") + "yes"; 
        in = new ByteArrayInputStream(s.getBytes());
        pg.setIr(new InputStreamReader(in)); 
        pg.setMg(new MyGame(100,0));
        pg.main(args);
        Assert.assertEquals("yes", pg.getMg().getCompleted());    
        Assert.assertEquals(90, pg.getMg().getCurrentValue());    
        try {
            in.close();
        } catch (IOException e) {
        }
        
        //Exit function is difficult to test        
//        s = "0" + System.getProperty("line.separator") + "100" + System.getProperty("line.separator") +
//                   "end" + System.getProperty("line.separator") + "higher" + System.getProperty("line.separator") + "higher" + System.getProperty("line.separator")
//            + "lower" +System.getProperty("line.separator") + "yes"; 
//        in = new ByteArrayInputStream(s.getBytes());
//        pg.setIr(new InputStreamReader(in)); 
//        pg.setMg(new MyGame(100,0));
//        pg.main(args);
//        System.out.println("Hello");
//        try {
//            in.close();
//        } catch (IOException e) {
//        }
    }
    
    
    @Test
    public void testgetValidInteger() {
        Assert.assertEquals(-1, PlayGame.getValidInteger("NAN"));
        Assert.assertFalse(PlayGame.getValidInteger("1")==-1);
        
    }
}
