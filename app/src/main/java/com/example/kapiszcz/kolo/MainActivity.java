package com.example.kapiszcz.kolo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String haslo = "";
    StringBuilder hash = new StringBuilder();
    TextView t;
    EditText e;
    int fail_counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String [] tab = {"lekkoatletyka", "interpunkcja", "telekomunikacja", "metamorfoza", "zwierzchnictwo", "prześladowanie", "antyterrorysta", "dźwiękonaśladownictwo", "antykoncepcja", "kolorowanka", "konstantynopolitański", "lumpenproletariat", "luminescencja", "magnetoelektryczny", "malkontenctwo", "primaaprilisowy", "pięćdziesięciogroszówka", "anatomopatologiczny", "deoksyrybonukleinowy" };



        Random rand = new Random();
        int randomNum = rand.nextInt(tab.length );

        haslo = tab[randomNum];

        t = (TextView)findViewById(R.id.txt);
        e = (EditText)findViewById(R.id.editText);
        e.setText("");
        for (int i = 0; i<haslo.length(); i++) {
            hash.append("_");
            t.setText(hash);
        }

    }


    public void start_activity(){
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("counter", fail_counter);
        startActivity(i);

    }


    public void btn1Click(View view) {
        EditText ed = (EditText)findViewById(R.id.editText);

        if (!ed.getText().toString().matches("")) {
            char ch = ed.getText().toString().charAt(0);

            for (int i = 0; i < haslo.length(); i++) {
                if (haslo.charAt(i) == ch) {
                    hash.setCharAt(i, ch);
                    t.setText(hash);
                }
            }
            if (haslo.equalsIgnoreCase(hash.toString())) {
                fail_counter += 1;
                start_activity();
            } else {
                ed.setText("");
                fail_counter += 1;
            }
        }
    }

    public void btn2Click(View view) {

        EditText ed = (EditText)findViewById(R.id.editText);
        if (ed.getText().toString().equals(haslo)) {
            start_activity();
        } else {
            ed.setText("");
            fail_counter += 1;
        }

    }
}
