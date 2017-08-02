package com.example.ajayj.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignedupActivity extends AppCompatActivity {
    @BindView(R.id.busersigninbtn2)
    Button bsigninuserbtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signedup);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.busersigninbtn2)
    public void bsigninuserbtn2()
    {
        Intent homepage212=new Intent(SignedupActivity.this,BLoginAssignmentActivity.class);
        startActivity(homepage212);
    }

}
