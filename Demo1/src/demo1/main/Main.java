package demo1.main;

// Created: Feb 23, 2022

import org.xjge.core.XJGE;


/**
 * @author J Hoffman
 */
public class Main {

    public static void main(String args[]) {
        
        XJGE.init("/demo1/assets/", "demo1.scenes.", null);
        
        XJGE.start();
        
    }
    
}
