package com.example.leituras_new;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sergio_Activity extends AppCompatActivity {
    Button bt_voltar;
    Button bt_det, bt_total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sergio_);
        bt_voltar = (Button) findViewById(R.id.bt_voltar);
        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Voltar();
            }
        });
        bt_det = (Button) findViewById(R.id.bt_det);
        bt_det.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detalhar();
            }
        });
        bt_total = (Button) findViewById(R.id.bt_total);
        bt_total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total();
            }
        });
    }
    void Voltar(){
        Intent intent = new Intent();
        intent.setClass(sergio_Activity.this,pontos_Activity.class);
        startActivity(intent);
        finish();
    }
    void detalhar(){

    }
    void total(){

    }
}

