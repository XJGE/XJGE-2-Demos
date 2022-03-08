package org.xjge.demo4.scenes;

import java.util.Map;
import org.xjge.core.Camera;
import org.xjge.core.Scene;
import org.xjge.core.Skybox;
import org.xjge.graphics.GLProgram;

//Created: Mar 7, 2022

/**
 * @author J Hoffman
 */
public class StartScene extends Scene {
    
    float angle;
    
    Skybox skybox;

    public StartScene(String name) {
        super(name);
        /*
        Called initially when the scene is first entered, you should load your
        assets here.
        */
        
        //Game.setClearColor(Color.RED); //Remember to import org.xjge.graphics.Color NOT java.awt!
        
        
        skybox = new Skybox(
                "sky_grid_right.png",  //Side #1 - right side
                "sky_grid_left.png",   //Side #2 - left side
                "sky_grid_top.png",    //Side #3 - above
                "sky_grid_bottom.png", //Side #4 - below
                "sky_grid_front.png",  //Side #5 - in front
                "sky_grid_back.png",   //Side #6 - behind
                false);
        
        
        //skybox = new Skybox("sky_day_top.png", "sky_day_center.png", "sky_day_bottom.png", true);
        
        setSkybox(skybox);
    }

    @Override
    public void update(double targetDelta, double trueDelta) {
        /*
        Organizes game logic, called continuously until this scene is left.
        NOTE: unlike the render methods listed below, the update method is called
        from within the games main loop- it tends to run at a more predictable 
        speed as a result- making it ideal for physics and gameplay features.
        */
        
        //angle -= 0.025f;
        //skybox.getModelMatrix().rotationY((float) Math.toRadians(angle));
    }

    @Override
    public void render(Map<String, GLProgram> glPrograms, int viewportID, Camera camera, int depthTexHandle) {
        /*
        Organizes calls to the graphics pipeline, called continuously until this
        scene is left.
        */
        
        
    }

    @Override
    public void renderShadows(GLProgram depthProgram) {
        /*
        Called continuously but only while a shadow map is present.
        Used to organize calls to the graphics pipeline by objects that want to 
        cast shadows using their vertex/mesh data.
        */
        
        
    }

    @Override
    public void exit() {
        /*
        Called once when we leave the scene. Used to free the allocated memory 
        of assets and other resources (such as textures, models, etc.)
        */
    }

}