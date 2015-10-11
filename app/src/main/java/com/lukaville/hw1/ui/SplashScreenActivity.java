package com.lukaville.hw1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lukaville.hw1.R;

public class SplashScreenActivity extends AppCompatActivity
        implements SplashScreenFragment.OnSplashScreenEndListener {
    private boolean visible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    @Override
    public void onSplashScreenEnd() {
        // Don't open second activity
        // if current activity not visible
        if (!visible) {
            finish();
            return;
        }

        Intent i = new Intent(SplashScreenActivity.this, ListActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        visible = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        visible = true;
    }
}
