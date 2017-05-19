package com.virendra.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.virendra.shapes.R;

public class ActivityShape extends AppCompatActivity {

    private View viewHexagon;
    private View viewTrapezoid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes);

        viewHexagon = findViewById(R.id.hexagon);
        viewTrapezoid = findViewById(R.id.trapezoid);

        String value = getIntent().getStringExtra("NAME");
        if (value.equalsIgnoreCase("HEXAGON")) {
            viewHexagon.setVisibility(View.VISIBLE);
        } else if (value.equalsIgnoreCase("TRAPEZOID")) {
            viewTrapezoid.setVisibility(View.VISIBLE);
        }
    }
}
