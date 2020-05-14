package com.example.transitionexperiment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

public class SecondaryAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        getSupportActionBar().hide();
    }

    public void fadeActivity(View view){
        startActivity(new Intent(SecondaryAct.this,SecondaryAct.class));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void explodeActivity(View view){
        ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation(this);
        startActivity(new Intent(SecondaryAct.this,SecondaryAct.class), options.toBundle());
    }

    public void rotateView(View view){
        RotateAnimation rotate= new RotateAnimation(0, 360, view.getPivotX(), view.getPivotY());
        rotate.setDuration(1000);
        rotate.setRepeatCount(2);
        rotate.setInterpolator(new LinearInterpolator());
        view.startAnimation(rotate);

    }

    public void sharedTransmition(View view){
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
        startActivity(new Intent(SecondaryAct.this,thirdAct.class), options.toBundle());
    }
}
