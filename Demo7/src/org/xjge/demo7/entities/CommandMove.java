package org.xjge.demo7.entities;

import org.xjge.core.Command;

//Created: Jun 20, 2022

/**
 * @author J Hoffman
 */
class CommandMove extends Command {

    final String direction;
    final TestEntity entity;
    
    CommandMove(String direction, TestEntity entity) {
        this.direction = direction;
        this.entity    = entity;
    }
    
    @Override
    public void execute() {
        if(buttonPressed()) {
            System.out.println(direction + " pressed.");
        }
    }

}