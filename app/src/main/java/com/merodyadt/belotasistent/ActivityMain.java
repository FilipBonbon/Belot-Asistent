package com.merodyadt.belotasistent;

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    private Toolbar mActivityToolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup toolbar
        mActivityToolbar = findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(mActivityToolbar);

        // setup title in toolbar
        mActivityToolbar.setTitle(R.string.app_name);

    }

    public void StartScoreboard(View view){
        // start the scoreboard
        startActivity(new Intent(this, ActivityScoreboard.class));
    }

    public void StartSettings(View view){
        // start settings activity
        startActivity(new Intent(this, ActivitySettings.class));
    }
}
