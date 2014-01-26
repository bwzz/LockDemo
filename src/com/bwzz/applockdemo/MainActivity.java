package com.bwzz.applockdemo;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseLockableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);
        TextView t = (TextView) findViewById(R.id.button);
        t.setText("launch A");
        t = (TextView) findViewById(R.id.text);
        t.setText("Page Main Entry\n\n\nClik a hyperlink in other app to launch the Page NotMain Entry");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onAction(View v) {
        call(A.class);
    }
}
