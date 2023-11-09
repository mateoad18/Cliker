package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PantallaMejoras extends AppCompatActivity {
    Button volver;
    Button boton;
    Button boton2;
    int variable=1;
    int coste = 100;
    int coste2=200;
    double num;
    int incremento =0;
    TextView contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_mejoras);
        boton = (Button) findViewById(R.id.comprar);
        boton2 = (Button) findViewById(R.id.tiempo);
        volver=(Button) findViewById(R.id.Volver);
        contador=(TextView) findViewById(R.id.contador);
        coste = getIntent().getIntExtra("costev",coste);
        coste2=getIntent().getIntExtra("coste2V",coste2);
        variable=getIntent().getIntExtra("VariableV",0);
        num = getIntent().getDoubleExtra("contador", 0.0);
        incremento=getIntent().getIntExtra("incV",0);
        contador.setText(String.valueOf(num));
        boton2.setText(coste2 + " coins");
        boton.setText(coste + " coins");
        tiempoIncremento();
    }
    public void aumTiempo(View v){
        if(num>=coste2){
            num -= coste2;
            coste2 += 20;
            boton2.setText(coste2+"coins");
            incremento++;
        }
    }
    public void mejora1 (View v){

        if(num>=coste){
            num = num-coste;
            variable++;
            contador.setText(""+num);
            coste += 20;
            boton.setText(coste+"coins");
        }
    }
    public void tiempoIncremento(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                num += incremento;
                handler.post(() -> {

                    contador.setText(String.valueOf(num));
                });
            }
        });
    }

    public void atras(View view) {
        Intent i = new Intent(PantallaMejoras.this,MainActivity.class);
        i.putExtra("contadorV",num);
        i.putExtra("Variable",variable);
        i.putExtra("coste",coste);
        i.putExtra("coste2",coste2);
        i.putExtra("inc",incremento);
        startActivity(i);
    }
}