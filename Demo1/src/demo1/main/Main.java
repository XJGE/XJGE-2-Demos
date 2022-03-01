package demo1.main;

import demo1.scenes.TestScene;
import org.xjge.core.Game;
import org.xjge.core.XJGE;

//Created: Feb 23, 2022

/**
 * @author J Hoffman
 */
public class Main {

    public static void main(String args[]) {
        
        //XJGE.init("/demo1/assets/", "demo1.scenes.", null);
        XJGE.init("/demo1/assets/", "demo1.scenes.", null, false, true, true, false, false);
        
        Game.setScene(new TestScene("test")); //Set the starting scene with the Game class.
        
        XJGE.start();
        
    }
    
}