package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button startStop,reset;
    Chronometer chronometer;
    Boolean running=false;
    String state="play";
    private long prev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startStop= findViewById(R.id.start_stop);
        reset= findViewById(R.id.reset);
        chronometer= findViewById(R.id.time);
        startStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startStop.getText().equals("start")){
                    if(!running){
                        startStop.setText("stop");
                        chronometer.start();
                        chronometer.setBase(SystemClock.elapsedRealtime()-prev);
                        running=true;
                    }
                }
                else if(startStop.getText().equals("stop")){
                    if(running){
                        startStop.setText("start");
                        chronometer.stop();
                        prev= SystemClock.elapsedRealtime()-chronometer.getBase();
                        running=false;
                    }
                }

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                prev=0;
            }
        });
    }
}