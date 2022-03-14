package org.xjge.demo6.entities;

import java.util.Map;
import org.joml.Vector3f;
import static org.lwjgl.opengl.GL30.*;
import org.lwjgl.system.MemoryStack;
import org.xjge.core.Camera;
import org.xjge.core.Entity;
import org.xjge.core.ErrorUtils;
import org.xjge.core.Light;
import org.xjge.graphics.GLProgram;
import org.xjge.graphics.Graphics;

//Created: Mar 14, 2022

/**
 * @author J Hoffman
 */
public class TestEntity extends Entity {

    private float angle;
    
    private Graphics g = new Graphics();
    
    public TestEntity(float x, float y, float z) {
        super(new Vector3f(x, y, z));
        
        try(MemoryStack stack = MemoryStack.stackPush()) {
            g.vertices = stack.mallocFloat(18);
            
            //(vec3 position), (vec3 color)
            g.vertices.put(-5).put(-5).put(0)   .put(1).put(0).put(0);
            g.vertices .put(0) .put(5).put(0)   .put(0).put(1).put(0);
            g.vertices .put(5).put(-5).put(0)   .put(0).put(0).put(1);
            
            g.vertices.flip();
        }
        
        g.bindBuffers();
        
        glVertexAttribPointer(0, 3, GL_FLOAT, false, (6 * Float.BYTES), 0);
        glVertexAttribPointer(1, 3, GL_FLOAT, false, (6 * Float.BYTES), (3 * Float.BYTES));
        
        glEnableVertexAttribArray(0);
        glEnableVertexAttribArray(1);
    }
    
    @Override
    public void update(double targetDelta, double trueDelta) {
        /*
        Update method that is used to define the entities behavior.
        */
        angle += 1f;
        
        g.modelMatrix.translation(position);
        g.modelMatrix.rotateY((float) Math.toRadians(angle));
    }

    @Override
    public void render(GLProgram glProgram, Camera camera, Light[] lights, int depthTexHandle) {
        /*
        Simplified variant of render that only uses a single GLProgram object.
        */
        
        glEnable(GL_DEPTH_TEST);
        glBindVertexArray(g.vao);
        
        glProgram.use();
        glProgram.setUniform("uModel", false, g.modelMatrix);
        
        glDrawArrays(GL_TRIANGLES, 0, 3);
        glDisable(GL_DEPTH_TEST); //It's generally considered good practice to reset these things.
        
        ErrorUtils.checkGLError();
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
        allocated. You should not attempt to call this manually.
        */
        
        g.freeBuffers();
    }

}
