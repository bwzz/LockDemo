package com.bwzz.applockdemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Guard extends Activity {

    private int count = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);
        TextView t = (TextView) findViewById(R.id.button);
        t.setText("Click me to unlock it");

        t = (TextView) findViewById(R.id.text);
        t.setText("This is the lock page");
        t.setTextColor(Color.RED);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Lock.lock();
    }

    public void onAction(View v) {
        if (count <= 1) {
            unlock();
        } else {
            --count;
            TextView t = (TextView) findViewById(R.id.button);
            t.setText(String.valueOf(count));
            t.setTextSize(30);
        }
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
