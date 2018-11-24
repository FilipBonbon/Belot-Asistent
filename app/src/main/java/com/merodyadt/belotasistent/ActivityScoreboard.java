package com.merodyadt.belotasistent;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ActivityScoreboard extends AppCompatActivity {

    private Toolbar mActivityToolbar = null;
    private DrawerLayout mDrawerLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        mActivityToolbar = findViewById(R.id.scoreboard_toolbar);
        setSupportActionBar(mActivityToolbar);
        ActionBar ab = getSupportActionBar();

        ab.setTitle(R.string.app_name);

        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);

        // set up drawer
        mDrawerLayout = findViewById(R.id.drawer_layout);

        ImageView figure = findViewById(R.id.nav_drawer_player_figure_2);
        figure.setImageResource(R.drawable.figure_red);

        Animation blinking = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_pulse);
        figure.startAnimation(blinking);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View toastView = getLayoutInflater().inflate(R.layout.toast_current_hand_dealer, null);
                ImageView figure = toastView.findViewById(R.id.toast_figure_1);

                Animation blinking = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_pulse);
                figure.startAnimation(blinking);

                Toast t = new Toast(getApplicationContext());

                t.setView(toastView);
                t.setDuration(Toast.LENGTH_LONG);
                t.setGravity(Gravity.BOTTOM, 0, 20);
                t.show();

            }
        });



        /*String filename = "myfile.txt";
        String fileContents = "Hello world!";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*
        File directory = getApplicationContext().getFilesDir();
        File file = new File(directory, filename);


        String data = "";

        try {
            FileInputStream fs = openFileInput(filename);
            InputStreamReader sr = new InputStreamReader(fs);

            BufferedReader br = new BufferedReader(sr);
            String line = null;
            while((line = br.readLine()) != null){
                data += line + "\n";
            }

            Log.d("FILES", "Read data: " + data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
       */

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
