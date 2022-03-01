package org.xjge.demo3.main;

import org.xjge.core.Game;
import org.xjge.core.XJGE;
import org.xjge.demo3.scenes.TestScene;

//Created: Mar 1, 2022

/**
 * @author J Hoffman
 */
public class Main {

    public static void main(String args[]) {
        
        XJGE.init("/org/xjge/demo3/assets/", "org.xjge.demo3.scenes.", null);
        
        Game.setScene(new TestScene("test"));
        
        XJGE.start();
        
    }
    
}