package com.bwzz.applockdemo;

import android.app.Activity;
import android.content.Intent;

public class BaseLockableActivity extends Activity {

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Lock.onResume(this);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        Lock.onPause(this);
    }

    /*
     * Replace startActivity as startActivityForResult
     */
    @Override
    public void startActivity(Intent intent) {
        // TODO Auto-generated method stub
        Lock.startActivity(this, intent);
    }

    @Override
    protected final void onActivityResult(int requestCode, int resultCode,
            Intent data) {
        // TODO Auto-generated method stub
        if (!Lock.testResult(this, requestCode, resultCode, data)) {
            handleActivityResult(requestCode, resultCode, data);
        }
    }

    /*
     * Subclass override this method instead of onActivityResult
     */
    protected void handleActivityResult(int requestCode, int resultCode,
            Intent data) {

    }

    protected void call(Class<? extends Activity> clazz) {
        Intent i = new Intent(this, clazz);
        startActivity(i);
    }
}
