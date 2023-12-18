package com.example.reforestapp_r2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.google.android.material.card.MaterialCardView;

public class RegistroPlantacion extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_plantacion);
        // referencias a las MaterialCardView
        final MaterialCardView cardNavegable2 = findViewById(R.id.cardNavegable2);
        final MaterialCardView cardNavegable3 = findViewById(R.id.cardNavegable3);
        final MaterialCardView cardNavegable4 = findViewById(R.id.cardNavegable4);

        // OnClickListener para cada MaterialCardView

        cardNavegable2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirige a la actividad correspondiente (Estadisticas.class)
                Intent intent = new Intent(RegistroPlantacion.this, Estadisticas.class);
                startActivity(intent);
            }
        });

        cardNavegable3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirige a la actividad correspondiente (Consejos.class)
                Intent intent = new Intent(RegistroPlantacion.this, Consejos.class);
                startActivity(intent);
            }
        });

        cardNavegable4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirige a la actividad correspondiente (Recursos.class)
                Intent intent = new Intent(RegistroPlantacion.this, Recursos.class);
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

        //Spinner para mostrar lista desplegable de departamento

        Spinner spinner = findViewById(R.id.Spin_Departamento);

        //Arreglo de strings desde strings.xml
        String[] opcionesDepartamento =  getResources().getStringArray(R.array.DepartamentoOpciones);

        //Adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,opcionesDepartamento);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //Configuración del selectlistener para manejar los eventos de selección

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String seleccion = opcionesDepartamento[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Spinner para mostrar lista desplegable del mes

        Spinner spinner2 = findViewById(R.id.Spin_Meses);

        //arreglo desde el strings.xml
        String[] opcionesMeses = getResources().getStringArray(R.array.MesOpciones);

        //Adaotador para el spinner
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,opcionesMeses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        //Configuración del SetOnItemSelectedListener

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String seleccion = opcionesMeses[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    // Método para abrir otro Activity
    private void abrirOtroActivity() {
        Intent intent = new Intent(this, Bottom_nav_view.class);
        startActivity(intent);
    }
}