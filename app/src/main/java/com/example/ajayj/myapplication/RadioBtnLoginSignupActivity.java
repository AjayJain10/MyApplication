package com.example.ajayj.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class RadioBtnLoginSignupActivity extends AppCompatActivity {

    LinearLayout llogin,lsignup;
    RadioButton lradio,sradio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_btn_login_signup);

        llogin= (LinearLayout) findViewById(R.id.loginpage);
        lsignup= (LinearLayout) findViewById(R.id.signuppage);

        lradio= (RadioButton) findViewById(R.id.loginradio);
        sradio= (RadioButton) findViewById(R.id.signupradio);

        if (lradio.isChecked()) {
            llogin.setVisibility(View.VISIBLE);
            lsignup.setVisibility(View.GONE);
        }


        lradio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    llogin.setVisibility(View.VISIBLE);
                    lsignup.setVisibility(View.GONE);
                }
            }
        });

        sradio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    llogin.setVisibility(View.GONE);
                    lsignup.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    }