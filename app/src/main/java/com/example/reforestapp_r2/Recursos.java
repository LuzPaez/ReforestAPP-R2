package com.example.reforestapp_r2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

import com.google.android.material.card.MaterialCardView;

public class Recursos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recursos);

        // referencias a las MaterialCardView
        final MaterialCardView cardNavegable1 = findViewById(R.id.cardNavegable1);
        final MaterialCardView cardNavegable2 = findViewById(R.id.cardNavegable2);
        final MaterialCardView cardNavegable3 = findViewById(R.id.cardNavegable3);

        // OnClickListener para cada MaterialCardView
        cardNavegable1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirige a la actividad correspondiente (RegistroDePlantacion.class)
                Intent intent = new Intent(Recursos.this, RegistroPlantacion.class);
                startActivity(intent);
            }
        });

        cardNavegable2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirige a la actividad correspondiente (Estadisticas.class)
                Intent intent = new Intent(Recursos.this, Estadisticas.class);
                startActivity(intent);
            }
        });

        cardNavegable3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirige a la actividad correspondiente (Consejos.class)
                Intent intent = new Intent(Recursos.this, Consejos.class);
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

        // Referencias a los elementos en tus CardView: ENLACES
        CardView cardViewPag1 = findViewById(R.id.card_view_pag1);
        CardView cardViewPag2 = findViewById(R.id.card_view_pag2);
        CardView cardViewPag3 = findViewById(R.id.card_view_pag3);
        CardView cardViewPag4 = findViewById(R.id.card_view_pag4);
        CardView cardViewPag5 = findViewById(R.id.card_view_pag5);
        CardView cardViewPag6 = findViewById(R.id.card_view_pag6);

        // Configura OnClickListener para cada CardView
        cardViewPag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPaginaWeb("https://es.educaplay.com/recursos-educativos/7199844-la_deforestacion.html");
            }
        });

        cardViewPag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPaginaWeb("https://colombiaverde.com.co/medio-ambiente/cambio-climatico/deforestacion-y-cambio-climatico/#:~:text=En%20resumen%2C%20la%20reforestaci%C3%B3n%20es%20una%20herramienta%20crucial,atm%C3%B3sfera%2C%20regular%20el%20clima%20y%20conservar%20la%20biodiversidad.");
            }
        });

        cardViewPag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPaginaWeb("https://cambio.com.co/articulo/efectos-del-cambio-climatico-en-colombia-un-desafio-urgente/");
            }
        });

        cardViewPag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPaginaWeb("https://www.minambiente.gov.co/direccion-de-bosques-biodiversidad-y-servicios-ecosistemicos/control-a-la-deforestacion-2/");
            }
        });

        cardViewPag5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPaginaWeb("https://www.minambiente.gov.co/se-reduce-y-se-contiene-la-deforestacion-en-colombia-durante-los-ultimos-cuatro-anos/");
            }
        });

        cardViewPag6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPaginaWeb("https://www.un.org/es/desa/reforestation-the-easiest");
            }
        });

        WebView webView;

        // Configuración del WebView
        webView = findViewById(R.id.VistaWEB);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        // URL del mapa web
        String url = "https://storymaps.arcgis.com/stories/3aa66f71bbf246bfbbcda39091bf8292";
        webView.loadUrl(url);

        // Hacer visible el WebView
        webView.setVisibility(View.VISIBLE);
    }

    // Método para abrir otro Activity
    private void abrirOtroActivity() {
        Intent intent = new Intent(this, Bottom_nav_view.class);
        startActivity(intent);
    }
    // Método para abrir la página web
    private void abrirPaginaWeb(String url) {
        // Crea un Intent para abrir el navegador web
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        // Inicia la actividad del navegador
        startActivity(intent);
    }


}