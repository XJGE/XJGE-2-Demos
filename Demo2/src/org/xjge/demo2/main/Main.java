package org.xjge.demo2.main;

import org.xjge.core.Game;
import org.xjge.core.Window;
import org.xjge.core.XJGE;
import org.xjge.demo2.scenes.TestScene;

//Created: Mar 1, 2022

/**
 * @author J Hoffman
 */
public class Main {

    public static void main(String args[]) {
        
        XJGE.init("/org/xjge/demo2/assets/", "org.xjge.demo2.scenes.", null);
        
        Window.setIcon("img_window_icon.png");
        Window.setTitle("Demo 2");
        
        Game.setScene(new TestScene("test"));
        
        XJGE.start();
        
    }
    
}