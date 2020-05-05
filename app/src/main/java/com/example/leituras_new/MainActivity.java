package com.example.leituras_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyTimerTask myTask = new MyTimerTask();
        Timer myTimer = new Timer();
        myTimer.schedule(myTask, 300);

    }
    class MyTimerTask extends TimerTask {
        public void run() {
            chamasenha();

        }
    }
    void chamasenha(){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,senha_Activity.class);
        startActivity(intent);
        finish();
    }
}
