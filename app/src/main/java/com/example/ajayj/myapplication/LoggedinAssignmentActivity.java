package com.example.ajayj.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoggedinAssignmentActivity extends AppCompatActivity {
    @BindView(R.id.bsignoutuser)
    Button busersignout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggedin_assignment);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.bsignoutuser)
    public void busersignout()
    {
        Intent homepage21=new Intent(LoggedinAssignmentActivity.this,BLoginAssignmentActivity.class);
        startActivity(homepage21);
    }

}
