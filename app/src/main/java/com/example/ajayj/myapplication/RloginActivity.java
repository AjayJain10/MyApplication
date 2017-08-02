package com.example.ajayj.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class RloginActivity extends AppCompatActivity {
    EditText rusername, rpassword;
    CheckBox rrmndcheck;
    Button rloginbtn;
    TextView rforgotpwd,rsignupbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rlogin);

        rusername= (EditText) findViewById(R.id.rusertext20);
        rpassword= (EditText) findViewById(R.id.rpasswordtext20);
        rrmndcheck= (CheckBox) findViewById(R.id.rrmndchecktext);
        rforgotpwd= (TextView) findViewById(R.id.rforgotpwdtext);
        rloginbtn= (Button) findViewById(R.id.rloginbtn2);
        rsignupbtn= (TextView) findViewById(R.id.rsignuptext);


        rloginbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent rhomepage1=new Intent(RloginActivity.this,RloggedinActivity.class);
                startActivity(rhomepage1);
            }
        });

        rsignupbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent rhomepager5=new Intent(RloginActivity.this,RmainActivity.class);
                startActivity(rhomepager5);
            }
        });

        rforgotpwd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent rhomepager4=new Intent(RloginActivity.this,RforgotpwdActivity.class);
                startActivity(rhomepager4);
            }
        });


    }
}
