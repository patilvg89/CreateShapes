package com.virendra.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.virendra.shapes.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showHexagon(View view) {
        startActivity(new Intent(this, ActivityShape.class).putExtra("NAME", "HEXAGON"));
    }

    public void showTrapezoid(View view) {
        startActivity(new Intent(this, ActivityShape.class).putExtra("NAME", "TRAPEZOID"));
    }
}
