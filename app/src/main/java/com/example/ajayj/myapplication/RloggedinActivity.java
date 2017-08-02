package com.example.ajayj.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RloggedinActivity extends AppCompatActivity {
    Button rlogouttxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rloggedin);

        rlogouttxt= (Button) findViewById(R.id.rlogout);


        rlogouttxt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent rhomepage2=new Intent(RloggedinActivity.this,RloginActivity.class);
                startActivity(rhomepage2);
            }
        });

    }
}
