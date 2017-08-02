package com.example.ajayj.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class RadioandCheckboxDemoActivity extends AppCompatActivity {
    RadioButton top,bottom;
    CheckBox selectall,a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radioand_checkbox_demo);

        top= (RadioButton) findViewById(R.id.top1);
        bottom= (RadioButton) findViewById(R.id.bottom1);
        selectall= (CheckBox) findViewById(R.id.selectall);
        a= (CheckBox) findViewById(R.id.a);
        b= (CheckBox) findViewById(R.id.b);
        c= (CheckBox) findViewById(R.id.c);

        bottom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    top.setChecked(false);
                }
            }
        });
        top.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    bottom.setChecked(false);
                }
            }
        });
        selectall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    a.setChecked(true);
                    b.setChecked(true);
                    c.setChecked(true);
                }
                else
                {
                    a.setChecked(false);
                    b.setChecked(false);
                    c.setChecked(false);
                }
            }
        });
    }
}
