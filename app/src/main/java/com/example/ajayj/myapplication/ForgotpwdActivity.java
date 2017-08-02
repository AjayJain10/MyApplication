package com.example.ajayj.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ForgotpwdActivity extends AppCompatActivity implements View.OnClickListener{

    //    Spinner spinner2;
    ListView lv;
    Button nextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpwd);

//        spinner2= (Spinner) findViewById(R.id.questionspinner2);
        nextbtn = (Button) findViewById(R.id.nextbtn);
        lv = (ListView) findViewById(R.id.questionlist);

        List<String> question = new ArrayList<String>();
        question.add("what is your school name ?");
        question.add("what is your freind name ?");
        question.add("what is your nick name ?");
        question.add("what is your pet name ?");
        question.add("which is your favourite food ?");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, question);
//        dataAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
//        spinner2.setAdapter(dataAdapter);

        lv.setAdapter(dataAdapter);

        nextbtn.setOnClickListener(this);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String abc=parent.getItemAtPosition(position).toString();
                Toast.makeText(ForgotpwdActivity.this, "selected item is "+abc, Toast.LENGTH_SHORT).show();
                Toast.makeText(ForgotpwdActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.nextbtn:  Intent homepage13 = new Intent(ForgotpwdActivity.this, CheckEmailActivity.class);
                                startActivity(homepage13);
                break;


        }

    }
}