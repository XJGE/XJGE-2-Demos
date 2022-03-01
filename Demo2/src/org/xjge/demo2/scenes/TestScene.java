package org.xjge.demo2.scenes;

import java.util.Map;
import org.xjge.core.Camera;
import org.xjge.core.Game;
import org.xjge.core.Scene;
import org.xjge.core.Window;
import org.xjge.graphics.GLProgram;

//Created: Mar 1, 2022

/**
 * @author J Hoffman
 */
public class TestScene extends Scene {
    
    public TestScene(String name) {
        super(name);
    }

    @Override
    public void update(double targetDelta, double trueDelta) {
        //Executes every second.
        if(Game.tick(60)) {
            Window.setPosition(Window.getPositionX() + 5, Window.getPositionY());
        }
    }

    @Override
    public void render(Map<String, GLProgram> glPrograms, int viewportID, Camera camera, int depthTexHandle) {
    }

    @Override
    public void renderShadows(GLProgram depthProgram) {
    }

    @Override
    public void exit() {
    }

}
