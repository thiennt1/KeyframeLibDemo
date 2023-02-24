package com.delfi.keyframelib.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.delfi.keyframelib.keyframe.Keyframe;
import com.delfi.keyframelib.utils.SlotType;

import java.io.File;
import java.util.List;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements Keyframe.KeyframeListenner{


    Keyframe mKeyframe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideSystemUI();
        setupKeyframe();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideSystemUI();
    }

    private void setupKeyframe() {
        try {
            mKeyframe = new Keyframe(this);
            mKeyframe.setDebugInfo("DEMO Keyframelib",this);
            updateRootView();
            mKeyframe.start();
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    @Override
    public void updateRootView() {
        if (mKeyframe != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    setContentView(mKeyframe.getRootView());
                }
            });
        }
    }

    @Override
    public void reloadKeyframe() {

    }

    @Override
    public void logMessage(String message) {

    }

    private void hideSystemUI() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                | View.SYSTEM_UI_FLAG_IMMERSIVE;
        decorView.setSystemUiVisibility(uiOptions);
    }
}