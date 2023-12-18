package com.example.reforestapp_r2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class Estadisticas extends AppCompatActivity {

    private EditText edtextCantidadSembrada;
    private EditText edtextPrecioEsp;
    private EditText edtextArea;
    private TextView txtTotalCosto;
    private TextView txtPromedio;

    private TextView txt_DensidadArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        // referencias a las MaterialCardView
        final MaterialCardView cardNavegable1 = findViewById(R.id.cardNavegable1);
        final MaterialCardView cardNavegable3 = findViewById(R.id.cardNavegable3);
        final MaterialCardView cardNavegable4 = findViewById(R.id.cardNavegable4);

        // OnClickListener para cada MaterialCardView
        cardNavegable1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirige a la actividad correspondiente (RegistroDePlantacion.class)
                Intent intent = new Intent(Estadisticas.this, RegistroPlantacion.class);
                startActivity(intent);
            }
        });


        cardNavegable3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirige a la actividad correspondiente (Consejos.class)
                Intent intent = new Intent(Estadisticas.this, Consejos.class);
                startActivity(intent);
            }
        });

        cardNavegable4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirige a la actividad correspondiente (Recursos.class)
                Intent intent = new Intent(Estadisticas.this, Recursos.class);
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

        //Spinner para mostrar lista desplegable del mes

        Spinner spinner = findViewById(R.id.Spin_Meses);

        //arreglo desde el strings.xml
        String[] opcionesMeses = getResources().getStringArray(R.array.MesOpciones);

        //Adaptador para el spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,opcionesMeses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //Configuración del SetOnItemSelectedListener

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String seleccion = opcionesMeses[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // Referencias a los EditText y TextView
        edtextCantidadSembrada = findViewById(R.id.Edtext_CantidadSembrada);
        edtextPrecioEsp = findViewById(R.id.Edtext_PrecioEsp);
        edtextArea = findViewById(R.id.Edtext_Area);
        txtTotalCosto = findViewById(R.id.txt_TotalCosto);
        txtPromedio = findViewById(R.id.txt_PromedioCosto);
        txt_DensidadArea = findViewById(R.id.txt_DensidadArea);

        // Referencia al botón Costo
        Button btnTotalCosto = findViewById(R.id.btn_TotalCosto);

        // Configuración del OnClickListener para el botón
        btnTotalCosto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Realiza el cálculo del costo de siembra
                calcularCostoSiembra();
            }
        });

        // Referencia al botón de promedio
        Button btnPromedio = findViewById(R.id.btn_Promedio);

        // Configuración del OnClickListener para el botón de promedio
        btnPromedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Realiza el cálculo del promedio
                calcularPromedio();
            }
        });

        // Referencia al botón de densidad
        Button btnDensidad = findViewById(R.id.btn_Densidad);

        // Configuración del OnClickListener para el botón de densidad
        btnDensidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Realiza el cálculo de la densidad
                calcularDensidad();
            }
        });


    }

    // Método para abrir otro Activity
    private void abrirOtroActivity() {
        Intent intent = new Intent(this, Bottom_nav_view.class);
        startActivity(intent);
    }

    // Método para calcular el costo de siembra
    private void calcularCostoSiembra() {
        try {
            // Obtener los valores de los EditText
            double precioUnitario = Double.parseDouble(edtextPrecioEsp.getText().toString());
            double cantidadSembrada = Double.parseDouble(edtextCantidadSembrada.getText().toString());

            // Realizar el cálculo
            double totalCosto = precioUnitario * cantidadSembrada;

            // Mostrar el resultado en el TextView
            txtTotalCosto.setText(String.valueOf(totalCosto));
        } catch (NumberFormatException e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Error");
            builder.setMessage("Por favor, ingrese números válidos.");
            builder.setPositiveButton("Aceptar", null);
            builder.show();
            e.printStackTrace();
        }
    }

    // Método para calcular el promedio
    private void calcularPromedio() {
        try {
            // Obtener el costo total de siembra
            double costoTotalSiembra = Double.parseDouble(txtTotalCosto.getText().toString());

            // Obtener el tamaño del área
            double tamanoArea = Double.parseDouble(edtextArea.getText().toString());

            // Calcular el promedio
            double promedioCostoArboles = costoTotalSiembra / tamanoArea;

            // Mostrar el resultado en el TextView del promedio
            txtPromedio.setText(String.valueOf(promedioCostoArboles));
        } catch (NumberFormatException e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Error");
            builder.setMessage("Por favor, ingrese números válidos.");
            builder.setPositiveButton("Aceptar", null);
            builder.show();
            e.printStackTrace();
        }
    }
    // Método para calcular la densidad de árboles por área
    private void calcularDensidad() {
        try {
            // Obtener el número total de especies
            double numTotalEspecies = Double.parseDouble(edtextCantidadSembrada.getText().toString());

            // Obtener el tamaño del área
            double tamanoArea = Double.parseDouble(edtextArea.getText().toString());

            // Calcular la densidad
            double densidadArea = numTotalEspecies / tamanoArea;

            // Mostrar el resultado en el TextView de densidad por área
            txt_DensidadArea.setText(String.valueOf(densidadArea));
        } catch (NumberFormatException e) {
            // Mostrar un AlertDialog en caso de valores no válidos
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Error");
            builder.setMessage("Por favor, ingrese números válidos.");
            builder.setPositiveButton("Aceptar", null);
            builder.show();
            e.printStackTrace();
        }
    }
}