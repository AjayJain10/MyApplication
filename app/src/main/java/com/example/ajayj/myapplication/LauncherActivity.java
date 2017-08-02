package com.example.ajayj.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ajayj.myapplication.util.SharedUtils;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        Thread timerthread=new Thread(){
            public void run()
            {
                try{
                    sleep(3000);
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }finally {
                    finish();
                    if(SharedUtils.isFirstTime(LauncherActivity.this))
                    {

                        Intent intent1=new Intent(LauncherActivity.this,LoginActivity.class);
                        startActivity(intent1);
                        SharedUtils.storeFirstTime(LauncherActivity.this,false);

                    }
                    else
                        {
//                             SharedUtils.storeFirstTime(LauncherActivity.this,true);
                            Intent intent=new Intent(LauncherActivity.this,StartActivity.class);
                            startActivity(intent);
                        }
                }
            }
        };
 timerthread.start();
    }
}
