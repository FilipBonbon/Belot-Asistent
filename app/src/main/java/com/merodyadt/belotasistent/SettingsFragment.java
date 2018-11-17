package com.merodyadt.belotasistent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;

public class SettingsFragment extends PreferenceFragmentCompat  {

    // summary preferences which are dynamic
    private final String PREF_KEY_ROUND_POINTS = "pref_round_points";
    private final String PREF_KEY_NAME_TEAM_US = "pref_name_team_us";
    private final String PREF_KEY_NAME_TEAM_YOU = "pref_name_team_you";


    private SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener;

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.preferences);

        preferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                if (key.equals(PREF_KEY_ROUND_POINTS)){
                    Preference pref = findPreference(key);
                    pref.setSummary(sharedPreferences.getString(key, ""));
                }

                if(key.equals(PREF_KEY_NAME_TEAM_US)){
                    Preference pref = findPreference(key);
                    pref.setSummary(sharedPreferences.getString(key, ""));
                }

                if(key.equals(PREF_KEY_NAME_TEAM_YOU)){
                    Preference pref = findPreference(key);
                    pref.setSummary(sharedPreferences.getString(key, ""));
                }
            }
        };


        // about button
        findPreference("pref_about").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                // TODO open about activity
                return false;
            }
        });

    }

    @Override
    public void onResume(){
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(preferenceChangeListener);


        // update summary descriptions
        findPreference(PREF_KEY_ROUND_POINTS).setSummary(getPreferenceScreen().getSharedPreferences().getString(PREF_KEY_ROUND_POINTS, ""));
        findPreference(PREF_KEY_NAME_TEAM_US).setSummary(getPreferenceScreen().getSharedPreferences().getString(PREF_KEY_NAME_TEAM_US, ""));
        findPreference(PREF_KEY_NAME_TEAM_YOU).setSummary(getPreferenceScreen().getSharedPreferences().getString(PREF_KEY_NAME_TEAM_YOU, ""));
    }

    @Override
    public void onPause(){
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(preferenceChangeListener);
    }
}
