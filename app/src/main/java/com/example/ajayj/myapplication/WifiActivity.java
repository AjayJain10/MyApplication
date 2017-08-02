package com.example.ajayj.myapplication;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WifiActivity extends AppCompatActivity {
    Button enableButton, disableButton;
    TextView enabletxt, disabletxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        enableButton = (Button) findViewById(R.id.wifion);
        disableButton = (Button) findViewById(R.id.wifioff);

        enabletxt = (TextView) findViewById(R.id.wifiontext);
        disabletxt = (TextView) findViewById(R.id.wifiofftext);

        WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (wifi.isWifiEnabled()) {
            enabletxt.setText("Wifi turned ON");
            disabletxt.setVisibility(View.GONE);
        }
        else
        {
            disabletxt.setText("Wifi turned OFF");
            enabletxt.setVisibility(View.GONE);
        }


        enableButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

                if (wifi.isWifiEnabled()) {
                    Toast.makeText(WifiActivity.this, "Already on", Toast.LENGTH_SHORT).show();
                } else {
                    wifi.setWifiEnabled(true);
                    Toast.makeText(WifiActivity.this, "Turning wifi on...", Toast.LENGTH_SHORT).show();

                    enabletxt.setVisibility(View.VISIBLE);
                    enabletxt.setText("Wifi turned ON");
                    disabletxt.setVisibility(View.GONE);
                }
            }
        });

        disableButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

                if (!wifi.isWifiEnabled()) {
                    Toast.makeText(WifiActivity.this, "Already off", Toast.LENGTH_SHORT).show();
                } else {
                    wifi.setWifiEnabled(false);
                    Toast.makeText(WifiActivity.this, "Turning wifi off...", Toast.LENGTH_SHORT).show();

                    disabletxt.setVisibility(View.VISIBLE);
                    disabletxt.setText("Wifi turned OFF");
                    enabletxt.setVisibility(View.GONE);

                }
            }
        });


    }
}
