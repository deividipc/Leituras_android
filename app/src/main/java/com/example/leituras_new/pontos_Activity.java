package com.example.leituras_new;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pontos_Activity extends AppCompatActivity {
    Button Bt_quinze;
    Button Bt_neto;
    Button Bt_sergio;
    Button Bt_gar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pontos_);

        Bt_quinze = (Button) findViewById(R.id.bt_quinze);
        Bt_quinze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaquinze();
            }
        });
        Bt_neto = (Button) findViewById(R.id.bt_neto);
        Bt_neto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaneto();
            }
        });
        Bt_sergio = (Button) findViewById(R.id.bt_sergio);
        Bt_sergio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamasergio();
            }
        });
        Bt_gar = (Button) findViewById(R.id.bt_gar);
        Bt_gar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamagar();
            }
        });
    }
    void chamaquinze(){
        Intent intent = new Intent();
        intent.setClass(pontos_Activity.this,quinze_Activity.class);
        startActivity(intent);
        finish();
    }
    void chamaneto(){
        Intent intent = new Intent();
        intent.setClass(pontos_Activity.this,neto_Activity.class);
        startActivity(intent);
        finish();
    }
    void chamasergio(){
        Intent intent = new Intent();
        intent.setClass(pontos_Activity.this,sergio_Activity.class);
        startActivity(intent);
        finish();
    }
    void chamagar(){
        Intent intent = new Intent();
        intent.setClass(pontos_Activity.this,gar_Activity.class);
        startActivity(intent);
        finish();
    }
}
