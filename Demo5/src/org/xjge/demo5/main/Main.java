package org.xjge.demo5.main;

import java.util.LinkedList;
import static org.lwjgl.opengl.GL20.*;
import org.xjge.core.Game;
import org.xjge.core.XJGE;
import org.xjge.demo5.scenes.TestScene;
import org.xjge.graphics.BufferType;
import org.xjge.graphics.GLProgram;
import org.xjge.graphics.Shader;

//Created: Mar 8, 2022

/**
 * @author J Hoffman
 */
public class Main {

    public static void main(String args[]) {
        
        XJGE.init("/org/xjge/demo5/assets/", "org.xjge.demo5.scenes.", null);
        
        //Initialize our example shader program.
        {
            var shaderSourceFiles = new LinkedList<Shader>() {{
                add(new Shader("exampleVertex.glsl",   GL_VERTEX_SHADER));
                add(new Shader("exampleFragment.glsl", GL_FRAGMENT_SHADER));
            }};
            
            GLProgram exampleProgram = new GLProgram(shaderSourceFiles, "example");
            
            exampleProgram.use();
            exampleProgram.addUniform(BufferType.MAT4, "uModel");
            exampleProgram.addUniform(BufferType.MAT4, "uView");
            exampleProgram.addUniform(BufferType.MAT4, "uProjection");
            
            XJGE.addGLProgram("example", exampleProgram);
        }
        
        Game.setScene(new TestScene("test"));
        XJGE.start();
        
    }
    
}