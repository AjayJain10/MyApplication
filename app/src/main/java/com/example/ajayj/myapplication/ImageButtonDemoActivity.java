package com.example.ajayj.myapplication;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class ImageButtonDemoActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    ImageButton imagebutton;
    private TextToSpeech tts;
    TextView textvoice;
    Button button1;
    int voice;
    EditText etext1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_button_demo);

        imagebutton = (ImageButton) findViewById(R.id.imagebtn);
        etext1 = (EditText) findViewById(R.id.textspeak);
        button1 = (Button) findViewById(R.id.speakbtn);
        textvoice = (TextView) findViewById(R.id.resulttext);
        tts = new TextToSpeech(this, this);

        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voiceintent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                voiceintent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, Locale.getDefault());
                try {
                    startActivityForResult(voiceintent, 0);
                    textvoice.setText("");
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(ImageButtonDemoActivity.this, "your device doesnot support text to speech", Toast.LENGTH_SHORT).show();
                }

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              speakout();

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0:
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> tex = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textvoice.setText(tex.get(0));
                }
                break;
        }

    }

    @Override
    protected void onDestroy() {

        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.ENGLISH);
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This language is not supported");
            } else {
                button1.setEnabled(true);
                speakout();
            }
        } else {
            Log.e("TTS", "Initialization Failed");
        }
    }

    private void speakout() {
        String text = etext1.getText().toString();

        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            voice = tts.getVoice().getQuality();
        }

    }
}
