package com.bwzz.applockdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class B extends BaseLockableActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);
        TextView t = (TextView) findViewById(R.id.button);
        t.setText("launch Guard");

        t = (TextView) findViewById(R.id.text);
        t.setText("B");
    }

    public void onAction(View v) {
        call(Guard.class);
    }

}
