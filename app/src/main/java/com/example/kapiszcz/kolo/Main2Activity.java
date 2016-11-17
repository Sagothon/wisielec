package com.example.kapiszcz.kolo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int counter = getIntent().getIntExtra("counter", 0);
        TextView t = (TextView)findViewById(R.id.textView);

        t.setText("Ilość prób: " + Integer.toString(counter));
    }
}
