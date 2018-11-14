package com.merodyadt.belotasistent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void StartScoreboard(View view){
        // starts the scoreboard
        Toast.makeText(getApplicationContext(), "Hello world", Toast.LENGTH_LONG);
        Log.i("TAG", "StartScoreboard: !!!!");
    }
}
