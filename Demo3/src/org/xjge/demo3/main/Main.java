package org.xjge.demo3.main;

import java.util.Map;
import org.xjge.core.Game;
import org.xjge.core.Hardware;
import org.xjge.core.Logger;
import org.xjge.core.Monitor;
import org.xjge.core.Speaker;
import org.xjge.core.XJGE;
import org.xjge.demo3.scenes.TestScene;

//Created: Mar 1, 2022

/**
 * @author J Hoffman
 */
public class Main {

    public static void main(String args[]) {
        
        XJGE.init("/org/xjge/demo3/assets/", "org.xjge.demo3.scenes.", null);
        
        Map<Integer, Monitor> monitors = Hardware.findMonitors();
        Map<Integer, Speaker> speakers = Hardware.findSpeakers();
        
        monitors.values().forEach(monitor -> {
            Logger.logInfo(monitor.name + ", " + monitor.getInfo());
        });
        
        System.out.println(); //Added to make console ouput more legible
        
        speakers.values().forEach(speaker -> {
            Logger.logInfo(speaker.name);
        });
        
        System.out.println();
        
        Logger.logInfo("Vsync enabled: " + Hardware.getVSyncEnabled());
        
        System.out.println();
        
        Game.setScene(new TestScene("test"));
        
        XJGE.start();
        
    }
    
}