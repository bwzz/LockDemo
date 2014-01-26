package com.bwzz.applockdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class A extends BaseLockableActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);
        TextView t = (TextView) findViewById(R.id.button);
        t.setText("launch B");

        t = (TextView) findViewById(R.id.text);
        t.setText("A");
    }

    public void onAction(View v) {
        call(B.class);
    }
}
