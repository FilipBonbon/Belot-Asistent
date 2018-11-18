package com.merodyadt.belotasistent;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Hello floating buton", "Test");
            }
        });
    }

    public void StartScoreboard(View view){
        // starts the scoreboard
        // TODO start scoreboard
    }

    public void StartSettings(View view){
        startActivity(new Intent(this, ActivitySettings.class));
    }
}
