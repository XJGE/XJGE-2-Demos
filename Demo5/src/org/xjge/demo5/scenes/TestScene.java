package org.xjge.demo5.scenes;

import java.util.Map;
import org.xjge.core.Camera;
import org.xjge.core.Scene;
import org.xjge.graphics.GLProgram;

//Created: Mar 8, 2022

/**
 * @author J Hoffman
 */
public class TestScene extends Scene {

    public TestScene(String name) {
        super(name);
    }

    @Override
    public void update(double targetDelta, double trueDelta) {
    }

    @Override
    public void render(Map<String, GLProgram> glPrograms, int viewportID, Camera camera, int depthTexHandle) {
        glPrograms.get("example").use(); //Call this to change the current shader program.
    }

    @Override
    public void renderShadows(GLProgram depthProgram) {
    }

    @Override
    public void exit() {
    }

}