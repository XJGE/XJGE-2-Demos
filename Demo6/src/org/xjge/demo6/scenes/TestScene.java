package org.xjge.demo6.scenes;

import java.util.Map;
import org.xjge.core.Camera;
import org.xjge.core.Scene;
import org.xjge.core.Skybox;
import org.xjge.demo6.entities.TestEntity;
import org.xjge.graphics.GLProgram;

//Created: Mar 14, 2022

/**
 * @author J Hoffman
 */
public class TestScene extends Scene {

    float angle;
    
    Skybox skybox;
    
    public TestScene(String name) {
        super(name);
        
        skybox = new Skybox("sky_day_top.png", "sky_day_center.png", "sky_day_bottom.png", true);
        setSkybox(skybox);
        
        entities.put("triangle", new TestEntity(0, 0, -20));
    }

    @Override
    public void update(double targetDelta, double trueDelta) {
        angle -= 0.025f;
        skybox.getModelMatrix().rotationY((float) Math.toRadians(angle));
        
        entities.values().forEach(entity -> entity.update(targetDelta, trueDelta));
    }

    @Override
    public void render(Map<String, GLProgram> glPrograms, int viewportID, Camera camera, int depthTexHandle) {
        entities.values().forEach(entity -> entity.render(glPrograms.get("example"), camera, lights, depthTexHandle));
    }

    @Override
    public void renderShadows(GLProgram depthProgram) {
    }

    @Override
    public void exit() {
    }

}
