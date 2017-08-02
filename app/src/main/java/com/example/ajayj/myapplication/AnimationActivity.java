package com.example.ajayj.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationActivity extends AppCompatActivity {

    @BindView(R.id.image1sample)
    ImageView sampleimage;

    @BindView(R.id.animbtn1)
    Button animbutton1;

    @BindView(R.id.animbtn2)
    Button animbutton2;

    @BindView(R.id.animbtn3)
    Button animbutton3;

    @BindView(R.id.animbtn4)
    Button animbutton4;

    @BindView(R.id.animbtn5)
    Button animbutton5;

    @BindView(R.id.animbtn6)
    Button animbutton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);


        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Animation page");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @OnClick(R.id.animbtn1)
    public void animbutton1()
    {
        ImageView image = (ImageView) findViewById(R.id.image1sample);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.blink);
        image.startAnimation(animation);
    }

    @OnClick(R.id.animbtn2)
    public void animbutton2()
    {
        ImageView image = (ImageView) findViewById(R.id.image1sample);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide);
        image.startAnimation(animation);
    }

    @OnClick(R.id.animbtn3)
    public void animbutton3()
    {
        ImageView image = (ImageView) findViewById(R.id.image1sample);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.clockwise);
        image.startAnimation(animation);
    }

    @OnClick(R.id.animbtn4)
    public void animbutton4()
    {
        ImageView image = (ImageView) findViewById(R.id.image1sample);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade);
        image.startAnimation(animation);
    }

    @OnClick(R.id.animbtn5)
    public void animbutton5()
    {
        ImageView image = (ImageView) findViewById(R.id.image1sample);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move);
        image.startAnimation(animation);
    }

    @OnClick(R.id.animbtn6)
    public void animbutton6()
    {
        ImageView image = (ImageView) findViewById(R.id.image1sample);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.myanimation);
        image.startAnimation(animation);
    }


}
