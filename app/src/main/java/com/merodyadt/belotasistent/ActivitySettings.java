package com.merodyadt.belotasistent;

import android.content.Context;
import android.content.SharedPreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class ActivitySettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getSupportActionBar().setTitle(R.string.settings_toolbar_name);

        if (findViewById(R.id.settingsContainer) != null){
            if(savedInstanceState != null){
                return;
            }
            SettingsFragment s = new SettingsFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.settingsContainer, s).commit();
        }

    }

}
