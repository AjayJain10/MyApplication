package com.example.ajayj.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajayj.myapplication.util.LoginDetails;
import com.example.ajayj.myapplication.webservices.ApiClient;
import com.example.ajayj.myapplication.webservices.ApiInterface;
import com.example.ajayj.myapplication.webservices.LoginRequest;
import com.example.ajayj.myapplication.webservices.LoginResponse;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    CheckBox rmndcheck;
    Button loginbtn;
    TextView forgotpwd, signupbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.usertext2);
        password = (EditText) findViewById(R.id.passwordtext2);
        rmndcheck = (CheckBox) findViewById(R.id.rmndchecktext);
        forgotpwd = (TextView) findViewById(R.id.forgotpwdtext);
        loginbtn = (Button) findViewById(R.id.loginbtn2);
        signupbtn = (TextView) findViewById(R.id.signuptext);

        if(LoginDetails.isChecked(this))
        {
            username.setText(LoginDetails.isUser(this));
            password.setText(LoginDetails.isPwd(this));
            rmndcheck.setChecked(LoginDetails.isChecked(this));
        }


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String un = username.getText().toString();
                String pw = password.getText().toString();

                if (rmndcheck.isChecked()) {


                    LoginDetails.storeUserDetails(LoginActivity.this, un);
                    LoginDetails.storePasswordDetails(LoginActivity.this, pw);
                    LoginDetails.storeRemindmeDetails(LoginActivity.this, true);
                }else
                    LoginDetails.storeRemindmeDetails(LoginActivity.this,false);


                if((un.isEmpty())&&(pw.isEmpty()))
                {
                    AlertDialog.Builder ad = new AlertDialog.Builder(LoginActivity.this);
                    ad.setMessage("Username And Password cannot be empty");

                    ad.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog ald=ad.create();
                    ald.show();
                }
                else if(un.isEmpty())
                {
                    AlertDialog.Builder ad = new AlertDialog.Builder(LoginActivity.this);
                    ad.setMessage("Enter the Username");

                    ad.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog ald=ad.create();
                    ald.show();
                }
                else if (pw.isEmpty())
                {
                    AlertDialog.Builder ad = new AlertDialog.Builder(LoginActivity.this);
                    ad.setMessage("Enter the Password");

                    ad.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog ald=ad.create();
                    ald.show();
                }
                else {

                    Toast.makeText(LoginActivity.this, "Welcome " + un, Toast.LENGTH_SHORT).show();

                    LoginRequest loginRequest=new LoginRequest();
                    loginRequest.setUsername(un);
                    loginRequest.setPassword(pw);
                    authenticateUser(loginRequest);

                    myown dbhelper=new myown(LoginActivity.this);
                    SQLiteDatabase database=dbhelper.getWritableDatabase();
                    dbhelper.saveUSerDetails(un,pw,database);
                    dbhelper.close();


                    Intent homepage1 = new Intent(LoginActivity.this, LoggedinActivity.class);
                    startActivity(homepage1);
                }


            }
        });

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homepage5 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(homepage5);
            }
        });

        forgotpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homepage4 = new Intent(LoginActivity.this, ForgotpwdActivity.class);
                startActivity(homepage4);
            }
        });


    }

    private void authenticateUser(LoginRequest login) {
        //connections bn apiclient and apiinterface
        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
        Call<LoginResponse> call=apiInterface.login(login);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.code()== HttpURLConnection.HTTP_OK)
                {

                    LoginResponse obj=response.body();
                    String ssid=obj.getSessId();
                    String ssname=obj.getSessionName();
                    String acctoken=obj.getAccessToken();
                    Toast.makeText(LoginActivity.this, "Login Successfull..!!"+"\n Session id is "+ssid+ "\n session name is "+ssname+"\n access token is "+acctoken, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                Log.e("API not found",t.toString());
            }
        });
    }


}


