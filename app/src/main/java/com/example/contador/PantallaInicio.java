package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PantallaInicio extends AppCompatActivity {
    Button jugar;
    Button salir;
    Button ajustes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
        jugar = (Button) findViewById(R.id.button);
        salir= (Button) findViewById(R.id.botonSalir);
        ajustes= (Button) findViewById(R.id.Ajustes);
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un Intent para cambiar a la ActividadDestino
                Intent intent = new Intent(PantallaInicio.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    public void cerrarApp(View view){
        this.finishAffinity();
    }


}