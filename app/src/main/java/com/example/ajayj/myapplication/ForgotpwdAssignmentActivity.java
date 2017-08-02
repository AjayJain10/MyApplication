package com.example.ajayj.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotpwdAssignmentActivity extends AppCompatActivity {
    @BindView(R.id.otpbn)
    Button btnotp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpwd_assignment);

        ButterKnife.bind(this);

    }


    @OnClick(R.id.otpbn)
    public void btnotp()
    {
        Intent homepagei=new Intent(ForgotpwdAssignmentActivity.this,OtpSentActivity.class);
        startActivity(homepagei);
    }

}
