package com.merodyadt.belotasistent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void StartScoreboard(View view){
        // starts the scoreboard
        // TODO start scoreboard
    }

    public void StartSettings(View view){
        startActivity(new Intent(this, ActivitySettings.class));
    }
}
