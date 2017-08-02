package com.example.ajayj.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class DemoActivity extends AppCompatActivity {
    RatingBar rating1;
    Button submitbtn;

    private ProgressBar progressBar;
    private int progressStatus = 0;
    private TextView textView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        rating1= (RatingBar) findViewById(R.id.ratingbar1);
        submitbtn= (Button) findViewById(R.id.submitbtn);

        progressBar = (ProgressBar) findViewById(R.id.Progress1);
        textView = (TextView) findViewById(R.id.progressbartext);

        // Start long running operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < progressBar.getMax()) {
                    progressStatus += 2;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            textView.setText(progressStatus + "/" + progressBar.getMax());
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        //Just to display the progress slowly
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        rating1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()
        {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser)
            {
                Toast.makeText(DemoActivity.this, "Rating is"+rating, Toast.LENGTH_SHORT).show();
            }
        });

        submitbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(DemoActivity.this, "Rating is" + rating1.getRating(), Toast.LENGTH_SHORT).show();
            }
        });


        SeekBar sk = (SeekBar) findViewById(R.id.simpleseekbar);
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressChangedValue = i;
                Toast.makeText(DemoActivity.this, "Seek Bar Progress is : " + progressChangedValue, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(DemoActivity.this, "Seek Bar Progress Started at : " + progressChangedValue, Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(DemoActivity.this, "Seek Bar Progress Stopped at : " + progressChangedValue, Toast.LENGTH_SHORT).show();

            }
        });

    }

}
