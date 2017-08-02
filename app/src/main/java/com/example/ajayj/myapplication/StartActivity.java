package com.example.ajayj.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {
    Button linearbtn,relativebtn,tabbtn,demobtn,rdls,bluetoothbtn,bkbtn,webview,toggle,image,loginassignment,radchk,dttm,rebtn,phoneopbtn,animationbutton,fragmentbutton,navbtn,mapsbtn,barcode;
//    int count;
    private boolean isAppReadyToFinish;
    private static final int BARCODE_REQUEST =1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        linearbtn= (Button) findViewById(R.id.linearlayout);
        phoneopbtn= (Button) findViewById(R.id.phonebtn);
        relativebtn= (Button) findViewById(R.id.relativelayout);
        demobtn= (Button) findViewById(R.id.demo);
        bkbtn= (Button) findViewById(R.id.bk);
        rebtn= (Button) findViewById(R.id.recyleid);
        toggle= (Button) findViewById(R.id.togglebtntxt);
        image= (Button) findViewById(R.id.imagebtntxt);
        loginassignment= (Button) findViewById(R.id.loginassign);
        radchk= (Button) findViewById(R.id.radchkbtn);
        dttm= (Button) findViewById(R.id.datetime);
        animationbutton= (Button) findViewById(R.id.animationbtn);
        fragmentbutton= (Button) findViewById(R.id.fragmentbtn);
        navbtn= (Button) findViewById(R.id.navdrawact);
        mapsbtn= (Button) findViewById(R.id.mapsact);
        barcode= (Button) findViewById(R.id.barcodebtn);
        webview= (Button) findViewById(R.id.web);
        bluetoothbtn= (Button) findViewById(R.id.bluetoothop);
        rdls= (Button) findViewById(R.id.radloginsignup);
        tabbtn= (Button) findViewById(R.id.tab);


        linearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homepage10=new Intent(StartActivity.this,LoginActivity.class);
                startActivity(homepage10);
            }
        });

        relativebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homepage11=new Intent(StartActivity.this,RloginActivity.class);
                startActivity(homepage11);
            }
        });

        demobtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent homepagec=new Intent(StartActivity.this,DemoActivity.class);
                startActivity(homepagec);

            }
        });

        bkbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent homepaged=new Intent(StartActivity.this,ButterknifeDemoActivity.class);
                startActivity(homepaged);
            }
        });
        rebtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent homepagehg=new Intent(StartActivity.this,RecyclerActivity.class);
                startActivity(homepagehg);
            }
        });

        toggle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent homepagee=new Intent(StartActivity.this,Toggle_Activity.class);
                startActivity(homepagee);
            }
        });

        image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent homepagef=new Intent(StartActivity.this,ImageButtonDemoActivity.class);
                startActivity(homepagef);
            }
        });

        loginassignment.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent homepageg=new Intent(StartActivity.this,BLoginAssignmentActivity.class);
                startActivity(homepageg);

            }
        });

        radchk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent homepagej=new Intent(StartActivity.this,RadioandCheckboxDemoActivity.class);
                startActivity(homepagej);

            }
        });


        dttm.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent homepagel=new Intent(StartActivity.this,BDateTimeActivity.class);
                startActivity(homepagel);

            }
        });

        animationbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent homepage30=new Intent(StartActivity.this,AnimationActivity.class);
                startActivity(homepage30);

            }
        });

        fragmentbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent homepage30=new Intent(StartActivity.this,FragmentsActivity.class);
                startActivity(homepage30);

            }
        });


        navbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent homepage40=new Intent(StartActivity.this,NavigationDrawerActivity.class);
                startActivity(homepage40);

            }
        });

        mapsbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent homepage40na=new Intent(StartActivity.this,MapsActivity.class);
                startActivity(homepage40na);

            }
        });

        phoneopbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent homepage40naa=new Intent(StartActivity.this,PhoneActivity.class);
                startActivity(homepage40naa);

            }
        });



        barcode.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startActivityForResult((new Intent(StartActivity.this, BarCodeActivity.class)), BARCODE_REQUEST);
            }
        });

        webview.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent homepage40nac=new Intent(StartActivity.this,WebViewActivity.class);
                startActivity(homepage40nac);

            }
        });

        bluetoothbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent homepage40nacc=new Intent(StartActivity.this,LinkingActivity.class);
                startActivity(homepage40nacc);

            }
        });

        rdls.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent homepage40nacv=new Intent(StartActivity.this,RadioBtnLoginSignupActivity.class);
                startActivity(homepage40nacv);

            }
        });

        tabbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent homepage40nacv=new Intent(StartActivity.this,TabsActivity.class);
                startActivity(homepage40nacv);

            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == BARCODE_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                String mProductBarcode = data.getStringExtra("barcode");
                Toast.makeText(this, "Barcode is "+mProductBarcode, Toast.LENGTH_SHORT).show();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (isAppReadyToFinish){
            try {
                super.onBackPressed();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }else
        {
            Toast.makeText(this, "Another click to close", Toast.LENGTH_SHORT).show();
            isAppReadyToFinish=true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    isAppReadyToFinish=false;
                }
            },2000);
        }


       /*count++;
        if(count==1)
        {
            Toast.makeText(this, "Press once again to EXIT", Toast.LENGTH_SHORT).show();
        }

        else if(count==2)
        {
            super.onBackPressed();
        }*/

    }
}
