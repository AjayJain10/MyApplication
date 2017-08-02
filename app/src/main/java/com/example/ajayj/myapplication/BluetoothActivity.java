package com.example.ajayj.myapplication;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

import static com.example.ajayj.myapplication.R.id.blueon;

public class BluetoothActivity extends AppCompatActivity {

    Button bluethon,bluethoff,bluethvisibility,bluethdevices;
    TextView bluethontxt,bluethofftxt,bluethvisibilitytxt,bluethdevicestxt;

    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        bluethon= (Button) findViewById(blueon);
        bluethoff= (Button) findViewById(R.id.blueoff);
        bluethvisibility= (Button) findViewById(R.id.bluevisibility);
        bluethdevices= (Button) findViewById(R.id.bluedevices);

        bluethontxt= (TextView) findViewById(R.id.blueontext);
        bluethofftxt= (TextView) findViewById(R.id.blueofftext);
        bluethvisibilitytxt= (TextView) findViewById(R.id.bluevisibilitytext);
        bluethdevicestxt= (TextView) findViewById(R.id.bluedevicestext);

        BA = BluetoothAdapter.getDefaultAdapter();
        lv = (ListView) findViewById(R.id.listview);

        if (BA.isEnabled())
        {
            bluethontxt.setVisibility(View.VISIBLE);
            bluethontxt.setText("Bluetooth turned ON");
            bluethofftxt.setVisibility(View.GONE);
        }
        else{
            bluethofftxt.setVisibility(View.VISIBLE);
            bluethofftxt.setText("Bluetooth turned OFF");

        }


        bluethon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!BA.isEnabled()) {
                    Toast.makeText(BluetoothActivity.this, "Give permission to turn on bluetooth", Toast.LENGTH_SHORT).show();

                    Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(turnOn, 0);


                        bluethontxt.setText("Bluetooth turned ON");
                        bluethofftxt.setVisibility(View.GONE);
                        bluethontxt.setVisibility(View.VISIBLE);


                } else {
                    Toast.makeText(getApplicationContext(), "Already on", Toast.LENGTH_LONG).show();
                }
            }
        });

        bluethoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (BA.isEnabled()) {
                    BA.disable();
                    lv.setVisibility(View.GONE);
                    bluethontxt.setVisibility(View.GONE);
                    bluethofftxt.setVisibility(View.VISIBLE);
                    bluethofftxt.setText("Bluetooth turned OFF");
                    bluethvisibilitytxt.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "Turning off...", Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(BluetoothActivity.this, "Bluetooth  is already off", Toast.LENGTH_SHORT).show();

                }


            }
        });

        bluethvisibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluethvisibilitytxt.setText("Visibility set for 120 seconds");
                bluethofftxt.setVisibility(View.GONE);
                bluethvisibilitytxt.setVisibility(View.VISIBLE);
                bluethontxt.setVisibility(View.VISIBLE);
                Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                startActivityForResult(getVisible, 0);
            }
        });


    }
}
