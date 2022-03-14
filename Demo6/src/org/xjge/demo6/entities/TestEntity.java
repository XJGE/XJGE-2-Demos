package org.xjge.demo6.entities;

import java.util.Map;
import org.joml.Vector3f;
import org.xjge.core.Camera;
import org.xjge.core.Entity;
import org.xjge.core.Light;
import org.xjge.graphics.GLProgram;

//Created: Mar 14, 2022

/**
 * @author J Hoffman
 */
public class TestEntity extends Entity {

    public TestEntity(float x, float y, float z) {
        super(new Vector3f(x, y, z));
    }
    
    @Override
    public void update(double targetDelta, double trueDelta) {
        /*
        Update method that is used to define the entities behavior.
        */
    }

    @Override
    public void render(GLProgram glProgram, Camera camera, Light[] lights, int depthTexHandle) {
        /*
        Simplified variant of render that only uses a single GLProgram object.
        */
    }

    @Override
    public void render(Map<String, GLProgram> glPrograms, Camera camera, Light[] lights, int depthTexHandle) {
        /*
        Overloaded variant of the render method that can make use of multiple 
        GLProgram objects.
        */
    }

    @Override
    public void renderShadow(GLProgram depthProgram) {
        /*
        Used to generate the entities shadow information with a specialized 
        GLProgram if a ShadowMap object has been added to the current scene.
        */
    }

    @Override
    protected void destroy() {
        /*
        Called after an entity has been removed from the Entities collection in
        the current scene to free whatever memory and resources it may have 
        allocated.
        */
    }

}
