package com.example.ajayj.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LinkingActivity extends AppCompatActivity {
    Button btbtn,wifibtn,sensorbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linking);

        btbtn= (Button) findViewById(R.id.bt);
        wifibtn= (Button) findViewById(R.id.wifi);
        sensorbtn= (Button) findViewById(R.id.sensor);

        btbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(LinkingActivity.this,BluetoothActivity.class);
                startActivity(intent1);
            }
        });

        wifibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(LinkingActivity.this,WifiActivity.class);
                startActivity(intent2);

            }
        });


        sensorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(LinkingActivity.this,SensorActivity.class);
                startActivity(intent3);

            }
        });    }
}
