package com.suraj.line;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


public class MainActivity extends Activity {

    GLSurfaceView ourSurface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ourSurface = new GLSurfaceView(this);
        ourSurface.setRenderer(new GLRendererEx());
        setContentView(ourSurface);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ourSurface.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ourSurface.onResume();
    }
}
