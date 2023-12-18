package com.example.reforestapp_r2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.card.MaterialCardView;

public class Consejos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos);

        // referencias a las MaterialCardView
        final MaterialCardView cardNavegable1 = findViewById(R.id.cardNavegable1);
        final MaterialCardView cardNavegable2 = findViewById(R.id.cardNavegable2);
        final MaterialCardView cardNavegable4 = findViewById(R.id.cardNavegable4);

        // OnClickListener para cada MaterialCardView
        cardNavegable1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirige a la actividad correspondiente (RegistroDePlantacion.class)
                Intent intent = new Intent(Consejos.this, RegistroPlantacion.class);
                startActivity(intent);
            }
        });

        cardNavegable2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirige a la actividad correspondiente (Estadisticas.class)
                Intent intent = new Intent(Consejos.this, Estadisticas.class);
                startActivity(intent);
            }
        });


        cardNavegable4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirige a la actividad correspondiente (Recursos.class)
                Intent intent = new Intent(Consejos.this, Recursos.class);
                startActivity(intent);
            }
        });
        //referencia al ImageButton
        ImageButton botonVolver = findViewById(R.id.BotonVolver);

        // Establece un OnClickListener para el ImageButton
        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirOtroActivity();
            }
        });
    }

    // Método para abrir otro Activity
    private void abrirOtroActivity() {
        Intent intent = new Intent(this, Bottom_nav_view.class);
        startActivity(intent);
    }
}