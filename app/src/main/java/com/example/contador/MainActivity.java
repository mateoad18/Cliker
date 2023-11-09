package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    TextView contador;
    ImageView moneda;
    Button boton;
    Button tienda;
    double num;
    int variable=1;
    double miles;
    double millones;
    int incremento =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tienda=(Button) findViewById(R.id.Tienda);
        contador=(TextView) findViewById(R.id.textocontador);
        boton = (Button) findViewById(R.id.comprar);
        moneda = (ImageView) findViewById(R.id.coin2);
        tiempoIncremento();
        Intent i = new Intent(MainActivity.this,PantallaMejoras.class);
        i.putExtra("coins",num);
    }

    public void sumar (View v) {

        num = num + variable;
        if (num >= 1000000) {
            millones = num / 1000000;

            String texto = String.format(Locale.getDefault(), "%.1f Millones", millones);

            contador.setText(texto);
        } else if (num >= 1000) {
            miles = num / 1000;
            String texto = String.format(Locale.getDefault(), "%.1f mil", miles);

            contador.setText(texto);
        } else {
            contador.setText(String.valueOf(num));
        }
        ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        fade_in.setDuration(100);
        moneda.startAnimation(fade_in);
    }





    public void mejora3(View v){
        variable++;
    }
    public void tiempoIncremento(){
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

    public void volver(View v){
        Intent i = new Intent(MainActivity.this,PantallaInicio.class);
        startActivity(i);
    }
    public void Tienda(View v){
        Intent i = new Intent(MainActivity.this,PantallaMejoras.class);
        startActivity(i);
    }
}
