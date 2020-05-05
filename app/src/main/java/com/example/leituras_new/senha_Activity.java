package com.example.leituras_new;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.view.KeyEvent;

import androidx.appcompat.app.AppCompatActivity;

import static androidx.core.content.ContextCompat.startActivity;

public class senha_Activity extends AppCompatActivity {
    String conf = "12345";
    EditText et_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senha_);
        et_senha = (EditText) findViewById(R.id.et_senha);
        et_senha.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String digit = et_senha.getText().toString();
                    if (digit.equals(conf)) {
                        Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_SHORT).show();
                        chamamenu();
                    } else {
                        Toast.makeText(getApplicationContext(), "Senha inválida! Tente novamente.", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
                return false;
            }
        });
    }

    void chamamenu() {
        Intent intent = new Intent();
        intent.setClass(senha_Activity.this, pontos_Activity.class);
        startActivity(intent);
        finish();
    }
}

