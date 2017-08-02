package com.example.ajayj.myapplication;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhoneActivity extends AppCompatActivity {
    static final Integer CAMERA = 1;
    static final Integer SMS = 2;
    static final Integer PHONE = 3;

    @BindView(R.id.camera)
    Button cam;
    @BindView(R.id.sms)
    Button sms;
    @BindView(R.id.sms2)
    Button smsbtn2;
    @BindView(R.id.call)
    Button phone;
    @BindView(R.id.dialpad)
    Button phonedial;
    @BindView(R.id.internetbtn)
    Button internetbutton;
    @BindView(R.id.photos)
    Button photosbtn;
    @BindView(R.id.contacts)
    Button contactsbtn;
    @BindView(R.id.contacts2)
    Button contactsbtn2;
    @BindView(R.id.webpage)
    Button webpagebtn;
    @BindView(R.id.searchmap)
    Button searchmapbtn;
    @BindView(R.id.streetview)
    Button streetview2;
    @BindView(R.id.musicplayer)
    Button musicplayerbtn;
    @BindView(R.id.musicplayer2)
    Button musicplayerbtn2;
    @BindView(R.id.mail)
    Button sendmail;
    @BindView(R.id.settings)
    Button opensettings;
    @BindView(R.id.lsettings)
    Button openlsettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        ButterKnife.bind(this);


    }


    private void askForPermission(String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(PhoneActivity.this, permission) != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(PhoneActivity.this, permission)) {

                //This is called if user has denied the permission before
                //In this case I am just asking the permission again
                ActivityCompat.requestPermissions(PhoneActivity.this, new String[]{permission}, requestCode);

            } else {

                ActivityCompat.requestPermissions(PhoneActivity.this, new String[]{permission}, requestCode);
            }
        } else {
            Toast.makeText(this, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(PhoneActivity.this, new String[]{permission}, requestCode);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (ActivityCompat.checkSelfPermission(this, permissions[0]) == PackageManager.PERMISSION_GRANTED) {
            switch (requestCode) {
                //Location
                case 1:
                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(takePictureIntent, 1);
                    }
                    break;
                case 2:
                    SmsManager sendsms = SmsManager.getDefault();

                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                        sendsms.sendTextMessage("9482192967", null, "hA iiiii ", null, null);
                    }
                    break;

                case 3:
                    Intent my = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:"));
                    my.putExtra("address", "7829620070");
                    my.putExtra("sms_body", "This is a sample message.....BOOM!!!");

                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                        startActivity(my);
                    }
                    break;

                case 4:

                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + "7829620070"));

                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                        startActivity(callIntent);
                    }
                    break;
                case 5:
                    Intent myActivity2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7829620070"));

                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                        startActivity(myActivity2);
                    }
                    break;
                case 6:
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, "Android");

                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {
                        startActivity(intent);
                    }
                    break;
                case 7:
                    Intent mmyIntent = new Intent();
                    mmyIntent.setType("image/pictures/*");
                    mmyIntent.setAction(Intent.ACTION_GET_CONTENT);
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

                        startActivity(mmyIntent);
                    }
                    break;

                case 8:
                    String myData = "content://contacts/people/";
                    Intent intent1new = new Intent(Intent.ACTION_VIEW, Uri.parse(myData));
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {

                        startActivity(intent1new);
                    }
                    break;

                case 9:
                    String myData2 = "content://contacts/people/2";
//                    Intent myActivity22 = new Intent(Intent.ACTION_VIEW,
//                            Uri.parse(myData2));

                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:" + myData2));

                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {

                        startActivity(callIntent1);
                    }
                    break;

                case 10:
                    String myData3 = "http://www.youtube.com";
                    Intent myActivity23 = new Intent(Intent.ACTION_VIEW, Uri.parse(myData3));
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {

                        startActivity(myActivity23);
                    }
                    break;

                case 11:

                    String geoCode = "geo:0,0?q=1860+east+18th+street+cleveland+oh";
                    Intent intent12 = new Intent(Intent.ACTION_VIEW, Uri.parse(geoCode));
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {

                        startActivity(intent12);
                    }

                    break;

                case 12:

                    String geoCode2 = "google.streetview:cbll=41.5020952,-81.6789717&cbp=1,270,,45,1&mz=1";
                    Intent intent13 = new Intent(Intent.ACTION_VIEW, Uri.parse(geoCode2));
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                        startActivity(intent13);
                    }
                    break;

                case 13:

                    Intent myActivity24 = new Intent("android.intent.action.MUSIC_PLAYER");
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WAKE_LOCK) == PackageManager.PERMISSION_GRANTED) {

                        startActivity(myActivity24);
                    }
                    break;

                case 14:

                    Intent myActivity25 = new Intent(android.content.Intent.ACTION_VIEW);
                    Uri data = Uri.parse("file:/Internal storage/Gamanisu.mp3");
                    String type = "audio/mp3";
                    myActivity25.setDataAndType(data, type);
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

                        startActivity(myActivity25);
                    }

                    break;



                case 15:


                    Uri uri1 = Uri.parse("mailto:ajayjain9832@gmail.com");
                    Intent myActivity26 = new Intent(Intent.ACTION_SENDTO, uri1);
                    myActivity26.putExtra(Intent.EXTRA_SUBJECT,
                            "subject is here");
                    myActivity26.putExtra(Intent.EXTRA_TEXT,
                            "The email's body is here");
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {

                        startActivity(myActivity26);
                    }
                    break;

            }

            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
        }

    }

    @OnClick(R.id.camera)
    public void cameraopen() {
        askForPermission(Manifest.permission.CAMERA, 1);
    }

    @OnClick(R.id.sms)
    public void sendsms() {
        askForPermission(Manifest.permission.SEND_SMS, 2);
    }

    @OnClick(R.id.sms2)
    public void smsbtn2() {
        askForPermission(Manifest.permission.SEND_SMS, 3);
    }

    @OnClick(R.id.call)
    public void makecall() {
        askForPermission(Manifest.permission.CALL_PHONE, 4);
    }

    @OnClick(R.id.dialpad)
    public void phonedial() {
        askForPermission(Manifest.permission.CALL_PHONE, 5);
    }

    @OnClick(R.id.internetbtn)
    public void internetbutton() {
        askForPermission(Manifest.permission.INTERNET, 6);
    }

    @OnClick(R.id.photos)
    public void photosbtn() {
        askForPermission(Manifest.permission.READ_EXTERNAL_STORAGE, 7);
    }

    @OnClick(R.id.contacts)
    public void contactsbtn() {
        askForPermission(Manifest.permission.READ_CONTACTS, 8);
    }

    @OnClick(R.id.contacts2)
    public void contactsbtn2() {
        askForPermission(Manifest.permission.READ_CONTACTS, 9);
    }

    @OnClick(R.id.webpage)
    public void webpagebtn() {
        askForPermission(Manifest.permission.INTERNET, 10);
    }

    @OnClick(R.id.searchmap)
    public void searchmapbtn() {
        askForPermission(Manifest.permission.INTERNET, 11);
    }

    @OnClick(R.id.streetview)
    public void streetviewbtn() {
        askForPermission(Manifest.permission.ACCESS_FINE_LOCATION, 12);
    }

    @OnClick(R.id.musicplayer)
    public void musicplayerbtn() {
        askForPermission(Manifest.permission.WAKE_LOCK, 13);
    }


    @OnClick(R.id.musicplayer2)
    public void musicplayerbtn2() {
        askForPermission(Manifest.permission.READ_EXTERNAL_STORAGE, 14);
    }

    @OnClick(R.id.mail)
    public void sendmail() {
        askForPermission(Manifest.permission.INTERNET, 15);
    }

    @OnClick(R.id.settings)
    public void opensettings() {
        Intent intent123 = new Intent(android.provider.Settings.ACTION_SETTINGS);
        startActivity(intent123);
    }

    @OnClick(R.id.lsettings)
    public void openlsettings() {
        Intent intent124 = new Intent(Settings.ACTION_LOCALE_SETTINGS);
        startActivity(intent124);
    }

}