package com.example.ajayj.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText firstname, lastname, username, password, cnfrmpassword, code, mobilenumber, emailaddress, date, securityanstxt, address;
    Button regbutton;
    CheckBox acceptchk;
    TextView logintxt;
    RadioButton male, female;
    Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstname = (EditText) findViewById(R.id.firstnametext);
        lastname = (EditText) findViewById(R.id.lastnametext);
        password = (EditText) findViewById(R.id.passwordtext);
        username = (EditText) findViewById(R.id.usertext);
        address = (EditText) findViewById(R.id.addresstext);
        securityanstxt = (EditText) findViewById(R.id.securityanstext);
        cnfrmpassword = (EditText) findViewById(R.id.passwordtext);
        code = (EditText) findViewById(R.id.codetext);
        mobilenumber = (EditText) findViewById(R.id.mobiletext);
        emailaddress = (EditText) findViewById(R.id.emailtext);
        date = (EditText) findViewById(R.id.datetext);
        regbutton = (Button) findViewById(R.id.registertext);
        male = (RadioButton) findViewById(R.id.malerdbtn);
        female = (RadioButton) findViewById(R.id.femalerdbtn);
        acceptchk = (CheckBox) findViewById(R.id.checktext);
        logintxt = (TextView) findViewById(R.id.logintext2);
        spinner1 = (Spinner) findViewById(R.id.questionspinner1);

        List<String> question = new ArrayList<String>();
        question.add("what is your school name ?");
        question.add("what is your freind name ?");
        question.add("what is your nick name ?");
        question.add("what is your pet name ?");
        question.add("which is your favourite food ?");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, question);
        dataAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        spinner1.setAdapter(dataAdapter);
        //mobilenumber.setText("9482192967");





            regbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String fn = firstname.getText().toString();
                    String ln = lastname.getText().toString();
                    String un = username.getText().toString();
                    String pw = password.getText().toString();
                    String cpw = cnfrmpassword.getText().toString();
                    String cd = code.getText().toString();
                    String mn = mobilenumber.getText().toString();
                    String ea = emailaddress.getText().toString();
                    String dt = date.getText().toString();
                    String sa = securityanstxt.getText().toString();
                    String add = address.getText().toString();

                    Toast.makeText(MainActivity.this, "Welcome " + un, Toast.LENGTH_SHORT).show();

                    dbsignup dbhelper1=new dbsignup(MainActivity.this);
                    SQLiteDatabase database1=dbhelper1.getWritableDatabase();
                    dbhelper1.savenewUSerDetails(fn,ln,un,pw,cpw,cd,mn,ea,dt,sa,add,database1);
                    dbhelper1.close();



//                Toast.makeText(MainActivity.this, "Fullname is "+fn+"\n username is "+un+"\n mobilenumber is "+mn+"\n emailaddress is "+ea, Toast.LENGTH_SHORT).show();
                    Intent homepage = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(homepage);
                }

            });

            logintxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent homepage11 = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(homepage11);
                }
            });
        }
    }