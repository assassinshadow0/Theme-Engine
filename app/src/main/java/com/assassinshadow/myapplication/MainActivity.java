package com.assassinshadow.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.assassinshadow.themeengine.ThemeEngine;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.t0);
        TextView textView2 = findViewById(R.id.t1);
        LinearLayout background = findViewById(R.id.bg);
        LinearLayout card = findViewById(R.id.card);

        //Set Up


        //Option #1
        new ThemeEngine(this)
                .AccentViewTheme(textView)
                .AccentViewTheme(textView2)
                .BackgroundTheme(background)
                .CardView(card);

        //Option #2

        ThemeEngine themeEngine = new ThemeEngine(this);

        themeEngine.AccentViewTheme(textView);
        themeEngine.AccentViewTheme(textView2);
        themeEngine.CardView(card);
        themeEngine.BackgroundTheme(card);


    }
}
