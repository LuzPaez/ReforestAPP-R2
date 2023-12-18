package com.example.reforestapp_r2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
public class RecuperarContrasena1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contrasena1);

        //El boton redirigira a la siguiente vista: RecuperarContrasena2

        Button btn_EnviarCodigo = findViewById(R.id.btn_EnviarCod);
        btn_EnviarCodigo.setOnClickListener(view -> {
            //intent para ir a la segunda pantalla de recuperación
            Intent intent = new Intent(RecuperarContrasena1.this,RecuperarContrasena2.class);
            startActivity(intent);
        });

        //Elementos

        // Redirige a la página de Inicio
        TextView InicioLink = findViewById(R.id.Link_IrInicio);
        InicioLink.setOnClickListener(view -> {
            // Redirigir a la página de inicio
            Intent intent = new Intent(RecuperarContrasena1.this, MainActivity.class);
            startActivity(intent);
        });
        // Redirige a la página de registro
        TextView crearCuentaLink = findViewById(R.id.Link_CrearCuenta);
        crearCuentaLink.setOnClickListener(view -> {

            Intent intent = new Intent(RecuperarContrasena1.this, RegistroUsuario.class);
            startActivity(intent);
        });

    }
}