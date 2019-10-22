package com.firstopenglproject.android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.widget.Toast;

public class AirHockeyActivity extends AppCompatActivity {

    private GLSurfaceView glSurfaceView;
    private boolean rendererSet = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurfaceView = new GLSurfaceView(this);
        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        final boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0X20000;
        if(supportsEs2){
            glSurfaceView.setEGLContextClientVersion(3);
            glSurfaceView.setRenderer(new AirHockeyRenderer(this));
            rendererSet = true;
        }else{
            Toast.makeText(this, "this device does not support ES2", Toast.LENGTH_SHORT).show();
            return;
        }
        setContentView(glSurfaceView);
    }
}
