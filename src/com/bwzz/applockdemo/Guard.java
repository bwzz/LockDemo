package com.bwzz.applockdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Guard extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);
        TextView t = (TextView) findViewById(R.id.button);
        t.setText("Tap to uanlock");

        t = (TextView) findViewById(R.id.text);
        t.setText("Guard");
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Lock.lock();
    }

    public void onAction(View v) {
        unlock();
    }

    private void unlock() {
        Lock.unlock();
        finish();
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        Lock.exit(this, null);
        super.onBackPressed();
    }

}
