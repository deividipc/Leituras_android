package com.example.leituras_new;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import static java.sql.DriverManager.println;


public class quinze_Activity extends AppCompatActivity {
    float saldo,com,liq;
    Button bt_voltar, bt_det, bt_total;
    EditText et_370e, et_370s, et_372e, et_372s, et_377e, et_377s, et_378e, et_378s, et_385e, et_385s, et_461e, et_461s, et_489e, et_489s, et_490e, et_490s;
    private DBHelper dh;
    ArrayList<String> contadores = new ArrayList();
    //ArrayList<String> anteriores = new ArrayList();
    SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy");
    Date data = new Date();
    String dataFormatada = formataData.format(data);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quinze_);
        println("AQUI VAI SER IMPRESSO!!!!!!");
        this.dh = new DBHelper(this);
        //################################################Edit text
        et_370e = (EditText) findViewById(R.id.et_370e);
        et_370s = (EditText) findViewById(R.id.et_370s);
        et_372e = (EditText) findViewById(R.id.et_372e);
        et_372s = (EditText) findViewById(R.id.et_372s);
        et_377e = (EditText) findViewById(R.id.et_377e);
        et_377s = (EditText) findViewById(R.id.et_377s);
        et_378e = (EditText) findViewById(R.id.et_378e);
        et_378s = (EditText) findViewById(R.id.et_378s);
        et_385e = (EditText) findViewById(R.id.et_385e);
        et_385s = (EditText) findViewById(R.id.et_385s);
        et_461e = (EditText) findViewById(R.id.et_461e);
        et_461s = (EditText) findViewById(R.id.et_461s);
        et_489e = (EditText) findViewById(R.id.et_489e);
        et_489s = (EditText) findViewById(R.id.et_489s);
        et_490e = (EditText) findViewById(R.id.et_490e);
        et_490s = (EditText) findViewById(R.id.et_490s);
        //###############################################Button
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
        //#######################################################################
    }

    void Voltar() {
        Intent intent = new Intent();
        intent.setClass(quinze_Activity.this, pontos_Activity.class);
        startActivity(intent);
        finish();
    }

    void detalhar() {
        AlertDialog.Builder adb = new AlertDialog.Builder(quinze_Activity.this);
        adb.setTitle("Leitura_");                           //
        adb.setMessage("Bruto: " + saldo +"\nComissão: "+com+"\nLíquido: "+liq);
        adb.show();

    }
    void total() {
        List<Maquinas> anteriores = dh.queryGetAll();
        if (anteriores==null){                                    //
            dh.insert("0","0","0","0","0","0","0","0","0","0","0",
                    "0","0","0","0","0");
           anteriores = dh.queryGetAll();
       }

        Maquinas maquina = (Maquinas) anteriores.get(anteriores.size() - 1);
        //println (maquina.getEt_370e()+"/"+maquina.getEt_370s());
        float p370_e = Float.parseFloat(maquina.getEt_370e().toString());
        float p370_s = Float.parseFloat(maquina.getEt_370s().toString());
        float p372_e = Float.parseFloat(maquina.getEt_372e().toString());
        float p372_s = Float.parseFloat(maquina.getEt_372s().toString());
        float p377_e = Float.parseFloat(maquina.getEt_377e().toString());
        float p377_s = Float.parseFloat(maquina.getEt_377s().toString());
        float p378_e = Float.parseFloat(maquina.getEt_378e().toString());
        float p378_s = Float.parseFloat(maquina.getEt_378s().toString());
        float p385_e = Float.parseFloat(maquina.getEt_385e().toString());
        float p385_s = Float.parseFloat(maquina.getEt_385s().toString());
        float p461_e = Float.parseFloat(maquina.getEt_461e().toString());
        float p461_s = Float.parseFloat(maquina.getEt_461s().toString());
        float p489_e = Float.parseFloat(maquina.getEt_489e().toString());
        float p489_s = Float.parseFloat(maquina.getEt_489s().toString());
        float p490_e = Float.parseFloat(maquina.getEt_490e().toString());
        float p490_s = Float.parseFloat(maquina.getEt_490s().toString());

        //List<String> teste = et_370e.getText().toString();
        //contadores = new ArrayList<String>(this,R.id.);
        //String[] contadores = {et_370e.getText().toString()};  essa da certo
        //String[] contadores = {?,et_370s.getText().toString()};

        if((et_370e.getText().length()<=0)||(et_370s.getText().length()<=0)){
            contadores.add(0,(String.valueOf(p370_e)));
            contadores.add(1,(String.valueOf(p370_s)));
        }else{
            contadores.add(0,(et_370e.getText().toString()));
            contadores.add(1,(et_370s.getText().toString()));
        }
        if((et_372e.getText().length()<=0)||(et_372s.getText().length()<=0)){
            contadores.add(2,(String.valueOf(p372_e)));
            contadores.add(3,(String.valueOf(p372_s)));
        }else{
            contadores.add(2,(et_372e.getText().toString()));
            contadores.add(3,(et_372s.getText().toString()));
        }
        if((et_377e.getText().length()<=0)||(et_377s.getText().length()<=0)){
            contadores.add(4,(String.valueOf(p377_e)));
            contadores.add(5,(String.valueOf(p377_s)));
        }else{
            contadores.add(4,(et_377e.getText().toString()));
            contadores.add(5,(et_377s.getText().toString()));
        }
        if((et_378e.getText().length()<=0)||(et_378s.getText().length()<=0)){
            contadores.add(6,(String.valueOf(p378_e)));
            contadores.add(7,(String.valueOf(p378_s)));
        }else{
            contadores.add(6,(et_378e.getText().toString()));
            contadores.add(7,(et_378s.getText().toString()));
        }
        if((et_385e.getText().length()<=0)||(et_385s.getText().length()<=0)){
            contadores.add(8,(String.valueOf(p385_e)));
            contadores.add(9,(String.valueOf(p385_s)));
        }else{
            contadores.add(8,(et_385e.getText().toString()));
            contadores.add(9,(et_385s.getText().toString()));
        }
        if((et_461e.getText().length()<=0)||(et_461s.getText().length()<=0)){
            contadores.add(10,(String.valueOf(p461_e)));
            contadores.add(11,(String.valueOf(p461_s)));
        }else{
            contadores.add(10,(et_461e.getText().toString()));
            contadores.add(11,(et_461s.getText().toString()));
        }
        if((et_489e.getText().length()<=0)||(et_489s.getText().length()<=0)){
            contadores.add(12,(String.valueOf(p489_e)));
            contadores.add(13,(String.valueOf(p489_s)));
        }else{
            contadores.add(12,(et_489e.getText().toString()));
            contadores.add(13,(et_489s.getText().toString()));
        }
        if((et_490e.getText().length()<=0)||(et_490s.getText().length()<=0)){
            contadores.add(14,(String.valueOf(p490_e)));
            contadores.add(15,(String.valueOf(p490_s)));
        }else{
            contadores.add(14,(et_490e.getText().toString()));
            contadores.add(15,(et_490s.getText().toString()));
        }


        dh.insert(contadores.get(0),contadores.get(1),contadores.get(2),contadores.get(3),contadores.get(4),contadores.get(5),contadores.get(6),
                  contadores.get(7),contadores.get(8),contadores.get(9),contadores.get(10),contadores.get(11),contadores.get(12),contadores.get(13),
                  contadores.get(14),contadores.get(15));

        float a370e = Float.parseFloat(contadores.get(0).toString());
        float a370s = Float.parseFloat(contadores.get(1).toString());
        float a372e = Float.parseFloat(contadores.get(2).toString());
        float a372s = Float.parseFloat(contadores.get(3).toString());
        float a377e = Float.parseFloat(contadores.get(4).toString());
        float a377s = Float.parseFloat(contadores.get(5).toString());
        float a378e = Float.parseFloat(contadores.get(6).toString());
        float a378s = Float.parseFloat(contadores.get(7).toString());
        float a385e = Float.parseFloat(contadores.get(8).toString());
        float a385s = Float.parseFloat(contadores.get(9).toString());
        float a461e = Float.parseFloat(contadores.get(10).toString());
        float a461s = Float.parseFloat(contadores.get(11).toString());
        float a489e = Float.parseFloat(contadores.get(12).toString());
        float a489s = Float.parseFloat(contadores.get(13).toString());
        float a490e = Float.parseFloat(contadores.get(14).toString());
        float a490s = Float.parseFloat(contadores.get(15).toString());

        saldo=0;

        Toast.makeText(getApplicationContext(), "Registro gravado com sucesso!/", Toast.LENGTH_SHORT).show();

        saldo = ((a370e-p370_e) - (a370s-p370_s))/20;
        saldo = saldo +(((a372e-p372_e)-(a372s-p372_s))/20);
        saldo = saldo +(((a377e-p377_e)-(a377s-p377_s))/100);
        saldo = saldo +(((a378e-p378_e)-(a378s-p378_s))/20);
        saldo = saldo +(((a385e-p385_e)-(a385s-p385_s))/100);
        saldo = saldo +(((a461e-p461_e)-(a461s-p461_s))/100);
        saldo = saldo +(((a489e-p489_e)-(a489s-p489_s))/20);
        saldo = saldo +(((a490e-p490_e)-(a490s-p490_s))/100);
        com=saldo/5;
        liq=saldo-com;
        contadores.clear();
    }
}
