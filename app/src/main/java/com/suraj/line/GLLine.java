package com.suraj.line;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class GLLine
{
     public static float vertices[]=
            {
                    -2f,-2f,
                    2f,2f
            };

    private FloatBuffer vertBuff;

    private short[] pindex = {0,1};

    private ShortBuffer pbuff;
    GLLine()
    {
        //tell how many bytes we want to use
        ByteBuffer bbuff = ByteBuffer.allocateDirect(4* vertices.length);

        //protect it from garbage collector
        bbuff.order(ByteOrder.nativeOrder());

        vertBuff = bbuff.asFloatBuffer();
        vertBuff.put(vertices);

        //tell where to start
        vertBuff.position(0);

        ByteBuffer pbbuff =ByteBuffer.allocateDirect(2*pindex.length);
        pbbuff.order(ByteOrder.nativeOrder());
        pbuff = pbbuff.asShortBuffer();
        pbuff.put(pindex);
        pbuff.position(0);
    }

    public void draw(GL10 gl)
    {
        //set how to connect:clockwise
        gl.glFrontFace(GL10.GL_CW);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        //args 2D/3D, type-float, stride-if we want to skip over a vertex
        gl.glVertexPointer(2,GL10.GL_FLOAT,0,vertBuff);

        //mode-how to draw,type of buffer

        //gl.glDrawElements(GL10.GL_TRIANGLES, pindex.length, GL10.GL_UNSIGNED_SHORT,pbuff);

        gl.glDrawElements(GL10.GL_LINES,pindex.length,GL10.GL_UNSIGNED_SHORT,pbuff);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}