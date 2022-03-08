package org.xjge.demo5.main;

import org.xjge.core.Game;
import org.xjge.core.XJGE;
import org.xjge.demo5.scenes.TestScene;

/**
 * Mar 8, 2022
 */

/**
 * @author J Hoffman
 */
public class Main {

    public static void main(String args[]) {
        
        XJGE.init("/org/xjge/demo5/assets/", "org.xjge.demo5.scenes.", null);
        
        Game.setScene(new TestScene("test"));
        
        XJGE.start();
        
    }
    
}