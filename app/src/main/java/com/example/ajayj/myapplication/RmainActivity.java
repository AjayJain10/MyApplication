package com.example.ajayj.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class RmainActivity extends AppCompatActivity {
    EditText rfirstname,rlastname,rusername,rpassword,rcnfrmpassword,rcode,rmobilenumber,remailaddress,rdate,rsecurityanstxt,raddress;
    Button rregbutton;
    CheckBox racceptchk;
    TextView rlogintxt;
    RadioButton rmale,rfemale;
    Spinner rspinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rmain);

        rfirstname= (EditText) findViewById(R.id.rfirstnametext1);
        rlastname= (EditText) findViewById(R.id.rlastnametext1);
       rpassword= (EditText) findViewById(R.id.rpasswordtext30);
       rusername= (EditText) findViewById(R.id.rusertext3);
        raddress= (EditText) findViewById(R.id.raddresstext1);
        rsecurityanstxt= (EditText) findViewById(R.id.rsecurityanstext1);
        rcnfrmpassword= (EditText) findViewById(R.id.rcnfrmpasswordtext40);
        rcode= (EditText) findViewById(R.id.rcodetext1);
        rmobilenumber= (EditText) findViewById(R.id.rmobiletext1);
        remailaddress= (EditText) findViewById(R.id.remailtext1);
        rdate= (EditText) findViewById(R.id.rdatetext1);
        rregbutton= (Button) findViewById(R.id.rregistertext);
        rmale= (RadioButton) findViewById(R.id.rmalerdbtn);
        rfemale= (RadioButton) findViewById(R.id.rfemalerdbtn);
        racceptchk= (CheckBox) findViewById(R.id.rchecktext);
        rlogintxt= (TextView) findViewById(R.id.rlogintext2);
        rspinner1= (Spinner) findViewById(R.id.rquestionspinner1);


        List<String> rquestion=new ArrayList<String>();
        rquestion.add("what is your school name ?");
        rquestion.add("what is your freind name ?");
        rquestion.add("what is your nick name ?");
        rquestion.add("what is your pet name ?");
        rquestion.add("which is your favourite food ?");


        ArrayAdapter<String> rdataAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,rquestion);
        rdataAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);

        rspinner1.setAdapter(rdataAdapter);

        //mobilenumber.setText("9482192967");

        rregbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rfn=rfirstname.getText().toString();
                String rln=rlastname.getText().toString();
                String run=rusername.getText().toString();
                String rpw=rpassword.getText().toString();
                String rcd=rcode.getText().toString();
                String rmn=rmobilenumber.getText().toString();
                String rea=remailaddress.getText().toString();

                Toast.makeText(RmainActivity.this, "Fullname is "+rfn+"\n username is "+run+"\n mobilenumber is "+rmn+"\n emailaddress is "+rea, Toast.LENGTH_SHORT).show();
                Intent rhomepage=new Intent(RmainActivity.this,RhomeActivity.class);
                startActivity(rhomepage);
            }

        });
        rlogintxt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent rhomepage11=new Intent(RmainActivity.this,RloginActivity.class);
                startActivity(rhomepage11);
            }
        });

    }
}