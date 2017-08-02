package com.example.ajayj.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ajayj.myapplication.fragments.Blank2Fragment;
import com.example.ajayj.myapplication.fragments.BlankFragment;
import com.example.ajayj.myapplication.fragments.Login2Fragment;
import com.example.ajayj.myapplication.fragments.LoginFragment;

public class FragmentsActivity extends AppCompatActivity implements View.OnClickListener {

    Button addsu, addsi, rsu, rsi, replace, replacea, replaceb, replace1a, replace1b, replace2a, replace2b, addsu2, addsi2, rsu2, rsi2, rsi22, rsu22;
    FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        addsi = (Button) findViewById(R.id.fsignin);
        addsi2 = (Button) findViewById(R.id.fsignin2);
        addsu = (Button) findViewById(R.id.fsignup);
        addsu2 = (Button) findViewById(R.id.fsignup2);
        rsi = (Button) findViewById(R.id.frsignin);
        rsi2 = (Button) findViewById(R.id.frsignin2);
        rsi22 = (Button) findViewById(R.id.rsibtn22);
        rsu = (Button) findViewById(R.id.frsignup);
        rsu2 = (Button) findViewById(R.id.frsignup2);
        rsu22 = (Button) findViewById(R.id.rsubtn22);

        replace = (Button) findViewById(R.id.freplace);
        replacea = (Button) findViewById(R.id.rsibtn);
        replace1a = (Button) findViewById(R.id.rsibtn2);
        replace2a = (Button) findViewById(R.id.rsibtn22);
        replaceb = (Button) findViewById(R.id.rsubtn);
        replace1b = (Button) findViewById(R.id.rsubtn2);
        replace2b = (Button) findViewById(R.id.rsubtn22);


        addsu.setOnClickListener(this);
        addsu2.setOnClickListener(this);
        addsi.setOnClickListener(this);
        addsi2.setOnClickListener(this);
        rsu.setOnClickListener(this);
        rsu2.setOnClickListener(this);
        rsu22.setOnClickListener(this);
        rsi.setOnClickListener(this);
        rsi2.setOnClickListener(this);
        rsi22.setOnClickListener(this);
        replace.setOnClickListener(this);
        replacea.setOnClickListener(this);
        replace1a.setOnClickListener(this);
        replace2a.setOnClickListener(this);
        replaceb.setOnClickListener(this);
        replace1b.setOnClickListener(this);
        replace2b.setOnClickListener(this);

        fm = getSupportFragmentManager();

    }

    @Override
    public void onClick(View v) {

        FragmentTransaction ft = fm.beginTransaction();

        BlankFragment bf = new BlankFragment();
        Blank2Fragment bf12 = new Blank2Fragment();
        LoginFragment lf = new LoginFragment();
        Login2Fragment lf12 = new Login2Fragment();

        switch (v.getId()) {
            case R.id.fsignin:
                ft.add(R.id.fragmentid, bf, "Login1");
                ft.commit();
                //To add the fragment to stack and made back button working to the previous fragment
//                ft.addToBackStack("Login1");
                break;

            case R.id.fsignup:
                ft.add(R.id.fragmentid, lf, "Login2");
                ft.commit();
                //To add the fragment to stack and made back button working to the previous fragment
//                ft.addToBackStack("Login2");
                break;


            case R.id.fsignin2:
                ft.add(R.id.fragmentid, bf12, "Login3");
                ft.commit();
                //To add the fragment to stack and made back button working to the previous fragment
//                ft.addToBackStack("Login3");
                break;

            case R.id.fsignup2:
                ft.add(R.id.fragmentid, lf12, "Login4");
                ft.commit();
                //To add the fragment to stack and made back button working to the previous fragment
//                ft.addToBackStack("Login4");
                break;


            case R.id.frsignin:
                BlankFragment bf1 = (BlankFragment) fm.findFragmentByTag("Login1");
                if (bf1 != null) {
                    ft.remove(bf1);
                    ft.commit();

                } else if (bf1 == null) {
                    Toast.makeText(this, "No Existing Sign in page", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.frsignup:
                LoginFragment lf1 = (LoginFragment) fm.findFragmentByTag("Login2");
                if (lf1 != null) {
                    ft.remove(lf1);
                    ft.commit();
                } else if (lf1 == null) {
                    Toast.makeText(this, "No Existing Sign up page", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.frsignin2:
                Blank2Fragment bf121 = (Blank2Fragment) fm.findFragmentByTag("Login3");
                if (bf121 != null) {
                    ft.remove(bf121);
                    ft.commit();
                } else if (bf121 == null) {
                    Toast.makeText(this, "No Existing Sign in2 page", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.frsignup2:
                Login2Fragment lf121 = (Login2Fragment) fm.findFragmentByTag("Login4");
                if (lf121 != null) {
                    ft.remove(lf121);
                    ft.commit();
                } else if (lf121 == null) {
                    Toast.makeText(this, "No Existing Sign up2 page", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.freplace:
                BlankFragment bf2 = (BlankFragment) fm.findFragmentByTag("Login1");
                LoginFragment lf2 = (LoginFragment) fm.findFragmentByTag("Login2");

                if ((bf2 != null) || (lf2 != null)) {
                    if (bf2 != null) {
                        ft.replace(R.id.fragmentid, lf, "Login2");
                        ft.commit();
                    } else if (lf2 != null) {
                        ft.replace(R.id.fragmentid, bf, "Login1");
                        ft.commit();
                    }
                } else {
                    Toast.makeText(this, "No existing fragments..to replace", Toast.LENGTH_SHORT).show();
//                    Intent ide=new Intent(this,StartActivity.class);
//                    startActivity(ide);
                    break;
                }
                break;

            case R.id.rsibtn:
                BlankFragment bf3 = (BlankFragment) fm.findFragmentByTag("Login1");
                LoginFragment lf3 = (LoginFragment) fm.findFragmentByTag("Login2");

                if ((bf3 == null) && (lf3 == null))
                    Toast.makeText(this, "No existing fragment..to replace", Toast.LENGTH_SHORT).show();
                else if (bf3 != null || (lf3 != null)) {
                    if (lf3 != null) {
                        ft.replace(R.id.fragmentid, bf, "Login1");
                        ft.commit();
                        //To add the fragment to stack and made back button working to the previous fragment
//                        ft.addToBackStack("rLogin1");
                    } else if (lf3 == null)
                        Toast.makeText(this, "No existing sign up..to replace", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.rsubtn:
                BlankFragment bf4 = (BlankFragment) fm.findFragmentByTag("Login1");
                LoginFragment lf4 = (LoginFragment) fm.findFragmentByTag("Login2");

                if ((bf4 == null) && (lf4 == null))
                    Toast.makeText(this, "No existing fragment..to replace", Toast.LENGTH_SHORT).show();
                else if ((bf4 == null) || (lf4 == null)) {
                    if (bf4 != null) {
                        ft.replace(R.id.fragmentid, lf, "Login2");
                        ft.commit();
                        //To add the fragment to stack and made back button working to the previous fragment
//                        ft.addToBackStack("rLogin2");
                    } else if (bf4 == null)
                        Toast.makeText(this, "No existing sign in..to replace", Toast.LENGTH_SHORT).show();
                }
                break;


            case R.id.rsibtn2:
                BlankFragment bf32 = (BlankFragment) fm.findFragmentByTag("Login1");
                Blank2Fragment bf322 = (Blank2Fragment) fm.findFragmentByTag("Login3");
                LoginFragment lf32 = (LoginFragment) fm.findFragmentByTag("Login2");
                Login2Fragment lf322 = (Login2Fragment) fm.findFragmentByTag("Login4");

                if ((lf32 != null) || (bf322 != null) || (lf322 != null)) {
                    ft.replace(R.id.fragmentid, bf, "Login1");
                    ft.commit();
                    //To add the fragment to stack and made back button working to the previous fragment
//                        ft.addToBackStack("rLogin11");
                } else {
                    Toast.makeText(this, "No new Fragment..to replace", Toast.LENGTH_SHORT).show();
                }


                break;

            case R.id.rsubtn2:
                BlankFragment bf42 = (BlankFragment) fm.findFragmentByTag("Login1");
                Blank2Fragment bf422 = (Blank2Fragment) fm.findFragmentByTag("Login3");
                LoginFragment lf42 = (LoginFragment) fm.findFragmentByTag("Login2");
                Login2Fragment lf422 = (Login2Fragment) fm.findFragmentByTag("Login4");

                if ((bf42 != null) || (bf422 != null) || (lf422 != null)) {
                    ft.replace(R.id.fragmentid, lf, "Login2");
                    ft.commit();
                    //To add the fragment to stack and made back button working to the previous fragment
//                        ft.addToBackStack("rLogin22");
                } else {
                    Toast.makeText(this, "No new Fragment...to replace", Toast.LENGTH_SHORT).show();
                }


                break;

            case R.id.rsibtn22:
                BlankFragment bf43 = (BlankFragment) fm.findFragmentByTag("Login1");
                Blank2Fragment bf423 = (Blank2Fragment) fm.findFragmentByTag("Login3");
                LoginFragment lf43 = (LoginFragment) fm.findFragmentByTag("Login2");
                Login2Fragment lf423 = (Login2Fragment) fm.findFragmentByTag("Login4");

                if ((lf423 != null) || (bf43 != null) || (lf43 != null)) {
                    ft.replace(R.id.fragmentid, bf12, "Login3");
                    ft.commit();
                    //To add the fragment to stack and made back button working to the previous fragment
//                        ft.addToBackStack("rLogin33");
                } else {
                    Toast.makeText(this, "No new Fragment..to replace", Toast.LENGTH_SHORT).show();
                }


                break;

            case R.id.rsubtn22:
                BlankFragment bf435 = (BlankFragment) fm.findFragmentByTag("Login1");
                Blank2Fragment bf4235 = (Blank2Fragment) fm.findFragmentByTag("Login3");
                LoginFragment lf435 = (LoginFragment) fm.findFragmentByTag("Login2");
                Login2Fragment lf4235 = (Login2Fragment) fm.findFragmentByTag("Login4");

                if ((bf4235 != null) || (bf435 != null) || (lf435 != null)) {
                    ft.replace(R.id.fragmentid, lf12, "Login4");
                    ft.commit();
                    //To add the fragment to stack and made back button working to the previous fragment
//                        ft.addToBackStack("rLogin44");
                } else {
                    Toast.makeText(this, "No new Fragment..to replace", Toast.LENGTH_SHORT).show();
                }


                break;

        }

    }


}