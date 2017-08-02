package com.example.ajayj.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButterknifeDemoActivity extends AppCompatActivity {
    @BindView(R.id.bkusername)
    EditText username;
    @BindView(R.id.bkpassword)
    EditText password;
    @BindView(R.id.bklogin)
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife_demo);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.bklogin)
    public void login() {
        Toast.makeText(this, "Username is " + username.getText().toString() + "\n Password is "+password.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
