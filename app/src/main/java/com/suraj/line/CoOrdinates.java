package com.suraj.line;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class CoOrdinates extends ActionBarActivity {
    Button btndraw;
    EditText etx1,ety1,etx2,ety2;
    SensorManager sm;
    Sensor mysensor;
    boolean se;
    static float old, newval;
    boolean start=true,running=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_ordinates);
        btndraw=(Button)findViewById(R.id.btndraw);
        etx1=(EditText)findViewById(R.id.etx1);
        ety1=(EditText)findViewById(R.id.ety1);
        etx2=(EditText)findViewById(R.id.etx2);
        ety2=(EditText)findViewById(R.id.ety2);


        btndraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GLLine.vertices[0]=Float.parseFloat(etx1.getText().toString());
                GLLine.vertices[1]=Float.parseFloat(ety1.getText().toString());
                GLLine.vertices[2]=Float.parseFloat(etx2.getText().toString());
                GLLine.vertices[3]=Float.parseFloat(ety2.getText().toString());

                startActivity(new Intent(CoOrdinates.this, MainActivity.class));
            }
        });
    }


}
