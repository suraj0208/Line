package com.suraj.line;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


public class GLRendererEx implements GLSurfaceView.Renderer {
    private GLLine line;
    GLRendererEx()
    {
        line=new GLLine();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        //called when renderer is created
        //eg: set camera

        //speed up
        gl.glDisable(GL10.GL_DITHER);
        //gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,GL10.GL_FASTEST);

        //set color (r,g,b,alpha(transperancy))
        gl.glClearColor(0.0f,0f,0.0f,1);

        //set depth
        gl.glClearDepthf(1f);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        //for painting
        //refreshes over and over
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        //tell camera to look at particular angle

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
        //eye level -x y z, where to look -origin
        GLU.gluLookAt(gl,0,0,-300,0,0,0,0,2,0);
        line.draw(gl);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        //when we switch from landscape to portrait
        //this method handles it
        //we need to know dimentions of viewport
        gl.glViewport(0,0,width,height);
        float ratio =(float)width/height;
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        //define viewing area

        gl.glFrustumf(-ratio,ratio,-1, 1,1,350);
    }
}
