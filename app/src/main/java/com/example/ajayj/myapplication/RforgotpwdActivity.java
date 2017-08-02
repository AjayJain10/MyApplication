package com.example.ajayj.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class RforgotpwdActivity extends AppCompatActivity {

    Spinner rspinner2;
    Button rnextbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rforgotpwd);


        rspinner2= (Spinner) findViewById(R.id.rquestionspinner2);
        rnextbtn= (Button) findViewById(R.id.rnextbutton);

        List<String> rquestion2=new ArrayList<String>();
        rquestion2.add("what is your school name ?");
        rquestion2.add("what is your freind name ?");
        rquestion2.add("what is your nick name ?");
        rquestion2.add("what is your pet name ?");
        rquestion2.add("which is your favourite food ?");


        ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,rquestion2);
        dataAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);
        rspinner2.setAdapter(dataAdapter);

        rnextbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent rhomepage13=new Intent(RforgotpwdActivity.this,RcheckEmailActivity.class);
                startActivity(rhomepage13);
            }
        });


    }
}