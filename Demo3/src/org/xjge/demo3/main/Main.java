package org.xjge.demo3.main;

import java.util.Map;
import org.lwjgl.glfw.GLFWVidMode;
import org.xjge.core.Game;
import org.xjge.core.Hardware;
import org.xjge.core.Logger;
import org.xjge.core.Monitor;
import org.xjge.core.XJGE;
import org.xjge.demo3.scenes.TestScene;

//Created: Mar 1, 2022

/**
 * @author J Hoffman
 */
public class Main {

    public static void main(String args[]) {
        
        XJGE.init("/org/xjge/demo3/assets/", "org.xjge.demo3.scenes.", null);
        
        Monitor monitor = Hardware.getCurrentMonitor();
        
        Map<String, GLFWVidMode> videoModes = monitor.getVideoModes();
        
        videoModes.forEach((desc, mode) -> {
            Logger.logInfo(desc);
        });
        
        Game.setScene(new TestScene("test"));
        
        XJGE.start();
        
    }
    
}