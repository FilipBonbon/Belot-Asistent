package com.merodyadt.belotasistent;

import android.content.Context;
import android.content.SharedPreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


public class ActivitySettings extends AppCompatActivity {

    private Toolbar mActivityToolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // initialize toolbar
        mActivityToolbar = findViewById(R.id.settings_toolbar);
        setSupportActionBar(mActivityToolbar);

        // set activity title
        getSupportActionBar().setTitle(R.string.settings_toolbar_name);

        if (findViewById(R.id.settingsContainer) != null){
            if(savedInstanceState != null){
                return;
            }
            getSupportFragmentManager().beginTransaction().add(R.id.settingsContainer, new SettingsFragment()).commit();
        }

    }

}
