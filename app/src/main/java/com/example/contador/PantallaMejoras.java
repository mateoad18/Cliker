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
        tiempoIncremento();
        Intent i =  getIntent();
        variable=getIntent().getIntExtra("VariableV",0);
        num = getIntent().getDoubleExtra("contador", 0.0);
        contador.setText(String.valueOf(num));
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PantallaMejoras.this,MainActivity.class);
                i.putExtra("contadorV",num);
                i.putExtra("Variable",variable);
                startActivity(i);
            }
        });
    }
    public void aumTiempo(View v){
        if(num>=coste2){
            num = num-coste2;
            incremento++;
            contador.setText(""+num);
            coste2= coste2+20;
            boton2.setText(coste2+"coins");
        }
    }
    public void mejora1 (View v){

        if(num>=coste){
            num = num-coste;
            variable++;
            contador.setText(""+num);
            coste= coste+20;
            boton.setText(coste+"coins");
        }
    }public void tiempoIncremento(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            //Background work here
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                num += incremento;
                handler.post(() -> {
                    //UI Thread work here
                    contador.setText(String.valueOf(num));
                });
            }
        });
    }
}