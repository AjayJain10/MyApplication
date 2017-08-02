package com.example.ajayj.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class Toggle_Activity extends AppCompatActivity {
    Switch sw;
    TextView switchstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_);

        sw= (Switch) findViewById(R.id.switchbtn);
        switchstatus= (TextView) findViewById(R.id.switchstatus);




//        sw.setChecked(false);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    switchstatus.setText("Switch is on");
                }
                else
                {
                    switchstatus.setText("switch is off");
                }
            }

        });
        if(sw.isChecked())
        {
            switchstatus.setText("Switch is onn");
            sw.setChecked(true);
        }
        else
        {
            switchstatus.setText("switch is off");
            sw.setChecked(false);
        }
    }
}
