package org.xjge.demo6.scenes;

import java.util.Map;
import org.xjge.core.Camera;
import org.xjge.core.Game;
import org.xjge.core.Scene;
import org.xjge.core.Skybox;
import org.xjge.demo6.entities.TestEntity;
import org.xjge.graphics.GLProgram;

//Created: Mar 14, 2022

/**
 * @author J Hoffman
 */
public class TestScene extends Scene {

    private int count;
    
    private float angle;
    
    private Skybox skybox;
    private TestEntity triangle;
    
    public TestScene(String name) {
        super(name);
        
        skybox = new Skybox("sky_day_top.png", "sky_day_center.png", "sky_day_bottom.png", true);
        setSkybox(skybox);
        
        triangle = new TestEntity(0, 0, -20);
        entities.put("triangle", triangle);
    }

    @Override
    public void update(double targetDelta, double trueDelta) {
        angle -= 0.025f;
        skybox.getModelMatrix().rotationY((float) Math.toRadians(angle));
        
        entities.values().forEach(entity -> entity.update(targetDelta, trueDelta));
        
        if(Game.tick(60)) {
            count++;
            
            if(count == 5) {
                if(entities.containsKey("triangle")) {
                    triangle.remove();
                } else {
                    triangle = new TestEntity(0, 0, -20);
                    entities.put("triangle", triangle);
                }
                
                count = 0;
            }
        }
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