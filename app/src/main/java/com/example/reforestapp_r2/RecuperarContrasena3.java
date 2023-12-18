package com.example.reforestapp_r2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class RecuperarContrasena3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contrasena3);

        //El boton redirigira a la siguiente vista: RecuperarContrasena3

        Button btn_Confirmar = findViewById(R.id.btn_Confirmar);
        btn_Confirmar.setOnClickListener(view -> {
            //intent para ir a la siguiente pantalla de Inicio de sesión
            Intent intent = new Intent(RecuperarContrasena3.this,MainActivity.class);
            startActivity(intent);
        });

        // Redirige a la página de Inicio
        TextView InicioLink = findViewById(R.id.Link_IrInicio);
        InicioLink.setOnClickListener(view -> {
            // Redirigir a la página de inicio
            Intent intent = new Intent(RecuperarContrasena3.this, MainActivity.class);
            startActivity(intent);
        });

    }
}