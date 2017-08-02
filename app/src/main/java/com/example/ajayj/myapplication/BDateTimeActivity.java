package com.example.ajayj.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BDateTimeActivity extends AppCompatActivity {
    @BindView(R.id.sdate)
    EditText sdob;
    @BindView(R.id.edate)
    EditText edob;
    @BindView(R.id.stime)
    EditText stimetxt;
    @BindView(R.id.etime)
    EditText etimetxt;
    @BindView(R.id.dttm)
    Button dttmbtn;
    Calendar cal;
//    Time time;
    String eampm;
    DatePickerDialog.OnDateSetListener sob;
    DatePickerDialog.OnDateSetListener eob;
    TimePickerDialog.OnTimeSetListener stm;
    TimePickerDialog.OnTimeSetListener etm;
    int sy,sm,sd;
    int ey,em,ed;
    int shr,smin,ssec,sap;
    int ehr,emin,esec,eap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bdate_time);

        ButterKnife.bind(this);

        cal= Calendar.getInstance();
        sy=cal.get(Calendar.YEAR);
        sm=cal.get(Calendar.MONTH);
        sd=cal.get(Calendar.DAY_OF_MONTH);
        sdob.setText(sd + "/" + (sm + 1) + "/" + sy);

        ey=cal.get(Calendar.YEAR);
        em=cal.get(Calendar.MONTH);
        ed=cal.get(Calendar.DAY_OF_MONTH);
        edob.setText(ed + "/" + (em + 1) + "/" + ey);

//        SimpleDateFormat formatDate = new SimpleDateFormat("hh:mm a");

        shr=cal.get(Calendar.HOUR_OF_DAY);
        smin=cal.get(Calendar.MINUTE);
        ssec=cal.get(Calendar.SECOND);
        sap=cal.get(Calendar.AM_PM);

        ehr=cal.get(Calendar.HOUR);
        emin=cal.get(Calendar.MINUTE);
        esec=cal.get(Calendar.SECOND);
        eap=cal.get(Calendar.AM_PM);

       /* if(sap==1) {
            sampm = "PM";
        }

        else if(sap==0){
            sampm="AM";
        }*/
/*

        if(shr>12) {
            shr = shr - 12;
        }
        else{
            shr=shr;
        }
*/



        if(eap==1) {
            eampm = "PM";
        }

        else if(eap==0){
            eampm="AM";
        }


        if(ehr>12) {
            ehr = ehr - 12;
        }
        else{
            ehr=ehr;
        }





        stimetxt.setText(shr+":"+smin+":"+ssec);
        etimetxt.setText(ehr+":"+emin+":"+esec+" - "+eampm);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Demo Ticket Booking Page");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        sdob.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                showDialog(1);
                return true;
            }
        });


        edob.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                showDialog(2);
                return true;
            }
        });


        stimetxt.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                showDialog(3);
                return true;
            }
        });

        etimetxt.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                showDialog(4);
                return true;
            }
        });



        sob = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {




                sdob.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }
        };

        eob = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                edob.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }
        };

        stm=new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                stimetxt.setText(hourOfDay+":"+minute);

            }
        };

        etm=new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String a="";
                if(hourOfDay>12) {
                    hourOfDay = hourOfDay - 12;
                     a="PM";
                }
                else{
                    hourOfDay=hourOfDay;
                    a="AM";
                }


                etimetxt.setText(hourOfDay+":"+minute+" - "+a);

            }
        };
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id==1) {
            return new DatePickerDialog(this,sob,sy,sm,sd);
        }
        if (id==2) {
            return new DatePickerDialog(this,eob,ey,em,ed);
        }
        if(id==3) {
            return new TimePickerDialog(this,stm,shr,smin,true);
        }
        if(id==4)
        {
            return new TimePickerDialog(this,etm,ehr,emin,false);
        }
        return super.onCreateDialog(id);
    }

    @OnClick(R.id.dttm)
    public void dttmbtn()
    {
        Toast.makeText(this, "Success...!!!", Toast.LENGTH_SHORT).show();
        Intent homepage2l=new Intent(BDateTimeActivity.this,StartActivity.class);
        startActivity(homepage2l);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case android.R.id.home:
//                finish();
//                Toast.makeText(this, "hahahhaaaaaaaaaa", Toast.LENGTH_SHORT).show();1
                Intent homepage2l=new Intent(BDateTimeActivity.this,StartActivity.class);
                startActivity(homepage2l);
                break;
        }


        return true;
    }


}
