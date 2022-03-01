package org.xjge.demo2.main;

import static org.lwjgl.glfw.GLFW.GLFW_CURSOR;
import static org.lwjgl.glfw.GLFW.GLFW_CURSOR_HIDDEN;
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
        
        /*
        Make sure the image you pass to the setIcon method is located in your
        assets folder!
        */
        
        Window.setIcon("img_window_icon.png");
        Window.setTitle("Demo 2");
        Window.setDimensions(640, 480);
        
        /*
        Altering the size of the window may cause it to become off center.
        We can fix this with the following method call;
        */
        Window.setPositionCentered();
        
        //Window.setMonitor("next");
        //Window.setFullscreen(true);
        
        Window.setInputMode(GLFW_CURSOR, GLFW_CURSOR_HIDDEN);
        
        Game.setScene(new TestScene("test"));
        
        XJGE.start();
        
    }
    
}