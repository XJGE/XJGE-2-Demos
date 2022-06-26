package org.xjge.demo7.entities;

import java.util.Map;
import org.joml.Vector3f;
import static org.lwjgl.opengl.GL30.*;
import org.lwjgl.system.MemoryStack;
import org.xjge.core.Camera;
import org.xjge.core.Control;
import org.xjge.core.Entity;
import org.xjge.core.ErrorUtils;
import org.xjge.core.Light;
import org.xjge.core.Puppet;
import org.xjge.graphics.GLProgram;
import org.xjge.graphics.Graphics;

//Created: Jun 18, 2022

/**
 * @author J Hoffman
 */
public class TestEntity extends Entity {
    
    private Graphics g   = new Graphics();
    public Puppet puppet = new Puppet(this);
    
    public TestEntity(float x, float y, float z) {
        super(new Vector3f(x, y, z));
        
        puppet.commands.put(Control.DPAD_UP,    new CommandMove("up", this));
        puppet.commands.put(Control.DPAD_DOWN,  new CommandMove("down", this));
        puppet.commands.put(Control.DPAD_LEFT,  new CommandMove("left", this));
        puppet.commands.put(Control.DPAD_RIGHT, new CommandMove("right", this));
        
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
        g.modelMatrix.translation(position);
    }

    @Override
    public void render(GLProgram glProgram, Camera camera, Light[] lights, int depthTexHandle) {
        if(!removalRequested()) {
            glEnable(GL_DEPTH_TEST);
            glBindVertexArray(g.vao);

            glProgram.use();
            glProgram.setUniform("uModel", false, g.modelMatrix);

            glDrawArrays(GL_TRIANGLES, 0, 3);
            glDisable(GL_DEPTH_TEST);

            ErrorUtils.checkGLError();
        }
    }

    @Override
    public void render(Map<String, GLProgram> glPrograms, Camera camera, Light[] lights, int depthTexHandle) {
        //Unused.
    }

    @Override
    public void renderShadow(GLProgram depthProgram) {
        //Unused.
    }

    @Override
    protected void destroy() {
        g.freeBuffers();
    }

}
