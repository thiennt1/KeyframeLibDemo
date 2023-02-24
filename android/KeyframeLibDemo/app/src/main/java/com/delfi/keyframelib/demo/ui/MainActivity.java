package com.delfi.keyframelib.demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;

import com.delfi.keyframelib.demo.R;
import com.delfi.keyframelib.demo.utils.KeyEventManager;
import com.delfi.keyframelib.keyframe.Keyframe;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements Keyframe.KeyframeListenner, KeyEventManager.View {


    private KeyEventManager mKeyEventManager;
    private Keyframe mKeyframe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideSystemUI();
        mKeyEventManager = new KeyEventManager(this);
        setupKeyframe();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideSystemUI();
    }

    public void setupKeyframe() {
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


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return mKeyEventManager.dispatchKeyEvent(event);
    }
}