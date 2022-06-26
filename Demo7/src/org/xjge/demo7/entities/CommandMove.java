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
            switch(direction) {
                //The default view of the scene has -Z is facing away from the camera.
                case "up"    -> entity.position.z--;
                case "down"  -> entity.position.z++;
                case "left"  -> entity.position.x--;
                case "right" -> entity.position.x++;
            }
        }
    }

}