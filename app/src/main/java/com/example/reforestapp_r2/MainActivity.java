package com.example.reforestapp_r2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText correoEditText = findViewById(R.id.EdText_Correo);
        final EditText contraseñaEditText = findViewById(R.id.EdText_Contrasena);
        Button iniciarSesionButton = findViewById(R.id.btn_Ingresar);

        iniciarSesionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener los datos ingresados
                String correoIngresado = correoEditText.getText().toString();
                String contraseñaIngresada = contraseñaEditText.getText().toString();

                // Obtener los datos guardados en SharedPreferences
                SharedPreferences preferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
                String correoGuardado = preferences.getString("correo", "");
                String contraseñaGuardada = preferences.getString("contraseña", "");

                // Validar los datos
                if (correoIngresado.equals(correoGuardado) && contraseñaIngresada.equals(contraseñaGuardada)) {
                    // Inicio de sesión exitoso
                    // Redirigir a otro layout
                    Intent intent = new Intent(MainActivity.this, Bottom_nav_view.class);
                    startActivity(intent);
                    finish(); // Esto evita que el usuario pueda volver atrás con el botón de retroceso
                } else {
                    // Datos incorrectos
                    mostrarMensajeError();
                }
            }
        });


        // ELEMENTOS: links, mensaje
        // Redirige a la página de registro
        TextView crearCuentaLink = findViewById(R.id.Link_CrearCuenta);
        crearCuentaLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirigir a la página de registro (RegistroUsuario)
                Intent intent = new Intent(MainActivity.this, RegistroUsuario.class);
                startActivity(intent);
            }
        });

        // Redirige a la página de recuperar contraseña
        TextView OlvidoContrasenaLink = findViewById(R.id.Link_OlvidoContrasena);
        OlvidoContrasenaLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirigir a la página de registro (RegistroUsuario)
                Intent intent = new Intent(MainActivity.this, RecuperarContrasena1.class);
                startActivity(intent);
            }
        });
    }
    //mensaje de error:
    private void mostrarMensajeError() {
        Toast.makeText(this, "Credenciales incorrectas. Por favor, inténtalo de nuevo.", Toast.LENGTH_SHORT).show();
    }
}
