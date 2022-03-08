package org.xjge.demo4.main;

import org.xjge.core.Game;
import org.xjge.core.XJGE;
import org.xjge.demo4.scenes.StartScene;

//Created: Mar 7, 2022

/**
 * @author J Hoffman
 */
public class Main {

    public static void main(String args[]) {
        
        XJGE.init("/org/xjge/demo4/assets/", "org.xjge.demo4.scenes.", null);
        
        Game.setScene(new StartScene("start"));
        
        XJGE.start();
        
    }
    
}