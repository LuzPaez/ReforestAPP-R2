package com.example.reforestapp_r2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        final EditText correoEditText = findViewById(R.id.EdText_Correo);
        final EditText usuarioEditText = findViewById(R.id.EdText_NomUsuario);
        final EditText contraseñaEditText = findViewById(R.id.EdText_Contraseña);
        final CheckBox condicionesCheckBox = findViewById(R.id.CheckBox_Condiciones);
        Button registrarseButton = findViewById(R.id.btn_Registrarse);

        registrarseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verificar si se aceptaron las condiciones
                if (!condicionesCheckBox.isChecked()) {
                    // Mostrar mensaje de error
                    mostrarMensajeErrorCheck();
                    return;
                }

                // Obtener los datos ingresados
                String correo = correoEditText.getText().toString();
                String usuario = usuarioEditText.getText().toString();
                String contraseña = contraseñaEditText.getText().toString();

                // Guardar datos en SharedPreferences
                SharedPreferences preferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("correo", correo);
                editor.putString("usuario", usuario);
                editor.putString("contraseña", contraseña);
                editor.apply();

                // Mostrar mensaje de éxito
                mostrarMensajeExito();
            }
        });

        // ELEMENTOS: links, mensaje
        // Redirige a la página de Inicio
        TextView InicioLink = findViewById(R.id.Link_IrInicio);
        InicioLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirigir a la página de inicio
                Intent intent = new Intent(RegistroUsuario.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void mostrarMensajeErrorCheck() {
        Toast.makeText(this, "Debes aceptar las condiciones para continuar ", Toast.LENGTH_SHORT).show();
    }
    private void mostrarMensajeExito() {
        Toast.makeText(this, "¡Registro exitoso! Tus datos se han guardado correctamente.", Toast.LENGTH_SHORT).show();
    }
}
