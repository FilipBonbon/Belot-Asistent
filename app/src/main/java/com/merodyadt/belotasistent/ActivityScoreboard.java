package com.merodyadt.belotasistent;

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

        ImageView figure = findViewById(R.id.toast_figure_1);
        figure.setImageResource(R.drawable.figure_red);

        Animation blinking = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_pulse);
        figure.startAnimation(blinking);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Hello floating buton", "Test");

                View toastView = getLayoutInflater().inflate(R.layout.toast_current_hand_dealer, null);
                ImageView figure = toastView.findViewById(R.id.figure_to_animate);

                Animation blinking = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_pulse);
                figure.startAnimation(blinking);

                Toast t = new Toast(getApplicationContext());

                t.setView(toastView);
                t.setDuration(Toast.LENGTH_LONG);
                t.setGravity(Gravity.BOTTOM, 0, 20);
                t.show();

            }
        });

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
