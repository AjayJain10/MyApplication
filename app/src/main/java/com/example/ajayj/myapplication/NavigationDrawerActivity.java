package com.example.ajayj.myapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.ajayj.myapplication.fragments.BlankFragment;
import com.example.ajayj.myapplication.fragments.LoginFragment;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private boolean isAppReadyToFinish;
    FragmentManager fmm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fmm = getSupportFragmentManager();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onResume() {
        if (fmm.getBackStackEntryCount() > 0) {
            fmm.popBackStack();
        }
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (isAppReadyToFinish) {
                try {
                    super.onBackPressed();
                    ;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                Toast.makeText(this, "Another click to close", Toast.LENGTH_SHORT).show();
                isAppReadyToFinish = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isAppReadyToFinish = false;
                    }
                }, 2000);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Setting has been clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentTransaction ft = fmm.beginTransaction();
        BlankFragment bf = new BlankFragment();
        LoginFragment lf = new LoginFragment();


        if (id == R.id.nav_camera) {
            Toast.makeText(this, "Camera has been clicked..!!", Toast.LENGTH_SHORT).show();
            Intent cam = new Intent(this, LoginActivity.class);
            startActivity(cam);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this, "gallery has been clicked..!!", Toast.LENGTH_SHORT).show();


            ft.replace(R.id.cont, bf, "Login1");
            ft.addToBackStack("login1");
            ft.commit();


        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(this, "slideshow has been clicked..!!", Toast.LENGTH_SHORT).show();

            ft.replace(R.id.cont, lf, "Login2");
            ft.addToBackStack("login2");
            ft.commit();

        } else if (id == R.id.nav_manage) {
            Toast.makeText(this, "manage has been clicked..!!", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_share) {
            Toast.makeText(this, "share has been clicked..!!", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_send) {
            Toast.makeText(this, "send has been clicked..!!", Toast.LENGTH_SHORT).show();
        }
             else if (id == R.id.nav_notify) {
                Toast.makeText(this, "notification has been clicked..!!", Toast.LENGTH_SHORT).show();


            NotificationCompat.Builder builder=(NotificationCompat.Builder) new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_menu_slideshow)
                    .setContentTitle("Notification Example")
                    .setAutoCancel(true)
                    .setContentText("This is a test Notification....Booom...!!!");

            Intent notificationIntent =new Intent(this, StartActivity.class);
            PendingIntent contentIntent=PendingIntent.getActivity(this,0,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(contentIntent);


            //Add as Notification
            NotificationManager manager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(0,builder.build());

             }


         else if (id == R.id.nav_logout) {
            Toast.makeText(this, "logout has been clicked..!!", Toast.LENGTH_SHORT).show();

            //Alert dialog
            AlertDialog.Builder abc = new AlertDialog.Builder(this);
            abc.setMessage("Do you wanna Exit/Logout ?");
            abc.setCancelable(false);
            abc.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(NavigationDrawerActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                    /*Intent hai=new Intent(NavigationDrawerActivity.this,StartActivity.class);
                    startActivity(hai);
*/
                    //to close the present activity
//                   finish();

//                    finishAndRemoveTask();
//                    finishAfterTransition();
                finishAffinity();
//                    System.exit(1);

//                   moveTaskToBack(true);
//                    android.os.Process.killProcess(android.os.Process.myPid());
//                    System.exit(0);
                }
            });
            abc.setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(NavigationDrawerActivity.this, "No", Toast.LENGTH_SHORT).show();

                }
            });
            AlertDialog al = abc.create();
            al.show();


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}