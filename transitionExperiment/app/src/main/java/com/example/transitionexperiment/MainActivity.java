package com.example.transitionexperiment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hide Action Bar
        getSupportActionBar().hide();


    }

    public void fadeActivity(View view) {
        //Restart the MainActivity using a fade animation
        startActivity(new Intent(MainActivity.this, MainActivity.class));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void explodeActivity(View view) {
        //Restart the MainActivity using an explode animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        startActivity(new Intent(MainActivity.this, MainActivity.class), options.toBundle());

    }

    public void rotateView(View view) {
        //Rotate the android logo view twice for 1 second
        RotateAnimation rotate = new RotateAnimation(0, 360, view.getPivotX(), view.getPivotY());
        rotate.setDuration(1000 /*milliseconds*/);
        rotate.setRepeatCount(2);
        rotate.setInterpolator(new LinearInterpolator());
        view.startAnimation(rotate);
    }

    public void sharedTransmition(View view) {
        //Start the nextActivity using a shared transaction animation
        ActivityOptions options = ActivityOptions
                .makeSceneTransitionAnimation(this,
                        Pair.create(view,
                                getString(R.string.rectangle)),
                        Pair.create(findViewById(R.id.android),
                                getString(R.string.android)),
                        Pair.create(findViewById(R.id.circle),
                                getString(R.string.circle)),
                        Pair.create(findViewById(R.id.square),
                                getString(R.string.square)));
        startActivity(new Intent(MainActivity.this, SecondaryAct.class), options.toBundle());
    }
}
