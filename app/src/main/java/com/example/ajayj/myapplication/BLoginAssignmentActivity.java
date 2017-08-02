package com.example.ajayj.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BLoginAssignmentActivity extends AppCompatActivity {
    @BindView(R.id.bnumberuser)
    EditText busernumber;
    @BindView(R.id.bpassworduser)
    EditText buserpassword;
    @BindView(R.id.busersigninbtn)
    Button bsigninuserbtn;
    @BindView(R.id.button123)
    Button buttonmenu;
    @BindView(R.id.buserforgotpwdtext)
    TextView bforgotuserpwdtext;
    @BindView(R.id.btextview1)
    TextView bsignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogin_assignment);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Ajay Login Page");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        buttonmenu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                PopupMenu popup=new PopupMenu(BLoginAssignmentActivity.this,busernumber);

                popup.getMenuInflater().inflate(R.menu.menu1,popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId())
                        {
                            case R.id.menu1a:
                                Toast.makeText(BLoginAssignmentActivity.this, "About us selected", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.menu1b:
                                Toast.makeText(BLoginAssignmentActivity.this, "settings selected", Toast.LENGTH_SHORT).show();
                                break;
                        }


                        return true;
                    }
                });
                popup.show();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
    }

    @OnClick(R.id.busersigninbtn)
    public void bsigninuserbtn()
    {
        Intent homepage20=new Intent(BLoginAssignmentActivity.this,LoggedinAssignmentActivity.class);
        startActivity(homepage20);
    }

    @OnClick(R.id.buserforgotpwdtext)
    public void bforgotuserpwdtext()
    {
        Intent homepageh=new Intent(BLoginAssignmentActivity.this,ForgotpwdAssignmentActivity.class);
        startActivity(homepageh);
    }

    @OnClick(R.id.btextview1)
    public void bsignup()
    {
        Intent homepagek=new Intent(BLoginAssignmentActivity.this,BSignupActivity.class);
        startActivity(homepagek);
    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch(item.getItemId())
//        {
//            case android.R.id.home:
//                finish();
//                Toast.makeText(this, "hahahhaaaaaaaaaa", Toast.LENGTH_SHORT).show();1
//                Intent homepage2l=new Intent(BLoginAssignmentActivity.this,StartActivity.class);
//                startActivity(homepage2l);
//                break;
//        }
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.menu1a:
                Toast.makeText(this, "About us selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu1b:
                Toast.makeText(this, "settings selected", Toast.LENGTH_SHORT).show();
                break;

            case android.R.id.home:
//                finish();
//                Toast.makeText(this, "hahahhaaaaaaaaaa", Toast.LENGTH_SHORT).show();1
                Intent homepage2l=new Intent(BLoginAssignmentActivity.this,StartActivity.class);
                startActivity(homepage2l);
                break;

            case R.id.icon1:
                Intent homepage2b=new Intent(BLoginAssignmentActivity.this,StartActivity.class);
                startActivity(homepage2b);
                break;

        }


        return true;
    }


}







