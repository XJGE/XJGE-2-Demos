package dev.theskidster.xjge2demos.chapter1;

//Created: Jul 24, 2021

import dev.theskidster.xjge2demos.scenes.Scene1;
import org.xjge.core.Game;
import org.xjge.core.XJGE;


/**
 * @author J Hoffman
 */
public class Main {

    public static void main(String args[]) {
        
        XJGE.init("/dev/theskidster/xjge2demos/assets/", "dev.theskidster.xjge2demo.scenes", true, null, true, false);
        
        Game.setScene(new Scene1());
        
        XJGE.start();
        
    }
    
}