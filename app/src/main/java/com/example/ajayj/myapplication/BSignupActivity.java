package com.example.ajayj.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BSignupActivity extends AppCompatActivity {
    @BindView(R.id.busersignup)
    EditText bsignupuser;
    @BindView(R.id.bemailsignup)
    EditText bsignupemail;
    @BindView(R.id.bpwdusersignup)
    EditText buserpwdsignup;
    @BindView(R.id.dob2)
    EditText mdob;
    @BindView(R.id.bcnfrmpwdusersignup)
    EditText busercnfrmpwdsignup;
    @BindView(R.id.busermobnum)
    EditText bmobnumuser;
    @BindView(R.id.busersignupbtn)
    Button bsignupuserbtn;
    @BindView(R.id.btextview1)
    TextView bviewtext1;
    Calendar cal;
    DatePickerDialog.OnDateSetListener ob;
    int y,m,d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bsignup);

        ButterKnife.bind(this);

        cal=Calendar.getInstance();
        y=cal.get(Calendar.YEAR);
        m=cal.get(Calendar.MONTH);
        d=cal.get(Calendar.DAY_OF_MONTH);
        mdob.setText(d + "/" + (m + 1) + "/" + y);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Sign Up");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });


        mdob.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                showDialog(1);
                return true;
            }
        });

        ob = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                mdob.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }
        };


    }

    @OnClick(R.id.busersignupbtn)
    public void bsignupuserbtn()
    {
        Intent homepage23=new Intent(BSignupActivity.this,SignedupActivity.class);
        startActivity(homepage23);
    }

    @OnClick(R.id.btextview1)
    public void bviewtext1()
    {
        Intent homepage22=new Intent(BSignupActivity.this,BLoginAssignmentActivity.class);
        startActivity(homepage22);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id==1) {
            return new DatePickerDialog(this,ob,y,m,d);
        }
        return super.onCreateDialog(id);
    }


}