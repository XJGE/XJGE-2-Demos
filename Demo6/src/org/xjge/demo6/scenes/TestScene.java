package org.xjge.demo6.scenes;

import java.util.Map;
import org.xjge.core.Camera;
import org.xjge.core.Scene;
import org.xjge.core.Skybox;
import org.xjge.graphics.GLProgram;

/**
 * Mar 14, 2022
 */

/**
 * @author J Hoffman
 * @since  
 */
public class TestScene extends Scene {

    float angle;
    
    Skybox skybox;
    
    public TestScene(String name) {
        super(name);
        
        skybox = new Skybox("sky_day_top.png", "sky_day_center.png", "sky_day_bottom.png", true);
        setSkybox(skybox);
    }

    @Override
    public void update(double targetDelta, double trueDelta) {
        angle -= 0.025f;
        skybox.getModelMatrix().rotationY((float) Math.toRadians(angle));
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
