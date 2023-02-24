package com.delfi.keyframelib.demo.utils;

import android.view.KeyEvent;

import timber.log.Timber;

public class KeyEventManager{

    private View mView;

    public KeyEventManager(View view) {
        mView = view;
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_UP) {
            Timber.e("Key up, code " + event.getKeyCode());
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_0:
                    break;
                case KeyEvent.KEYCODE_1:
                    break;
                case KeyEvent.KEYCODE_2:
                    break;
                case KeyEvent.KEYCODE_3:
                    break;
                case KeyEvent.KEYCODE_I:
                    setupKeyframe();
                    break;
            }
        }
        return true;
    }

    public void setupKeyframe() {
        if (mView != null) {
            mView.setupKeyframe();
        }
    }

    public static interface View {
        void setupKeyframe();
    }

}
