package com.example.reforestapp_r2;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class Principal extends Fragment {

    private ImageView imagenCarrusel;
    private TextView textoCarruselTitulo, textoCarruselDescripcion;
    private int[] images = {R.drawable.arbol1, R.drawable.arbol2, R.drawable.arbol3, R.drawable.arbol4};
    private String[] titles = {
            "Colombia es un país megadiverso",
            "Algunos de los resultados positivos",
            "Las especies de árboles amenazados",
            "Proyectos para reforestar"
    };
    private String[] descriptions = {
            "Con el 10% de la biodiversidad mundial y el 52,1% de su superficie cubierta por bosques naturales. Sin embargo, también es uno de los países más afectados por la deforestación, que en el 2021 alcanzó las 174.103 hectáreas.",
            "Según el Ministerio de Ambiente y Desarrollo Sostenible, en el 2023 se logró reducir la deforestación en un 29% en comparación con el 2022, pasando de 174.103 hectáreas a 123.517 hectáreas",
            "Se encuentran la ceiba barrigona, que sufre por la deforestación y la minería; el oreopanax, que se encuentra en los páramos y está afectado por el cambio climático;la palma de cera, que es el árbol nacional y símbolo del Quindío, pero está en riesgo por el turismo. Entre otros muchos más",
            "En Colombia, existen proyectos para reforestar en diferentes regiones del país, especialmente en la Amazonía, el Pacífico, los Andes y el Caribe, donde se concentra la mayor biodiversidad y los mayores desafíos ambientales de Colombia."
    };
    private int currentPosition = 0;

    private Handler handler = new Handler();
    private Runnable runnable;

    private RelativeLayout animDesplazamiento;

    //----------------------------------------------------

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_principal, container, false);

        //Carrusel
        MaterialCardView cardNavegable1 = view.findViewById(R.id.cardNavegable1);
        MaterialCardView cardNavegable2 = view.findViewById(R.id.cardNavegable2);
        MaterialCardView cardNavegable3 = view.findViewById(R.id.cardNavegable3);
        MaterialCardView cardNavegable4 = view.findViewById(R.id.cardNavegable4);

        cardNavegable1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirigir a la actividad correspondiente (RegistroDePlantacion.class)
                Intent intent = new Intent(getActivity(), RegistroPlantacion.class);
                startActivity(intent);
            }

        });

        cardNavegable2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirigir a la actividad correspondiente (Estadisticas.class)
                Intent intent = new Intent(getActivity(), Estadisticas.class);
                startActivity(intent);
            }
        });

        cardNavegable3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirigir a la actividad correspondiente (Consejos.class)
                Intent intent = new Intent(getActivity(), Consejos.class);
                startActivity(intent);
            }
        });

        cardNavegable4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirigir a la actividad correspondiente (Recursos.class)
                Intent intent = new Intent(getActivity(), Recursos.class);
                startActivity(intent);
            }
        });

        CardView cardView = view.findViewById(R.id.Carrusel);
        imagenCarrusel = view.findViewById(R.id.imagenCarrusel);
        textoCarruselTitulo = view.findViewById(R.id.textoCarruselTitulo);
        textoCarruselDescripcion = view.findViewById(R.id.textoCarruselDescripcion);

        // Inicia el carrusel automático
        startCarousel();

        //Boton para salir
        ImageButton botonSalir = view.findViewById(R.id.BotonSalir);
        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoSalir();
            }
        });

        //animacion Dezplazamiento
        animDesplazamiento = view.findViewById(R.id.Anim_desplazamiento);
        // Llama a la función para iniciar la animación
        iniciarAnimacion();

        // Animacion Fade in
        TextView mensajeFinal= view.findViewById(R.id.mensajeFinal);
        //animación de fade in
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(5000); // Duración de la animación en milisegundos

        // Inicia la animación
        mensajeFinal.startAnimation(fadeIn);

        // Animacion de imagenView
        ImageView tuImageView = view.findViewById(R.id.imagenPequeñalogo);

        // Configura una animación de desplazamiento y fade in
        AnimationSet animationSet = new AnimationSet(true);

        // Animación de desplazamiento
        TranslateAnimation translateAnimation = new TranslateAnimation(320f, 0f, 40f, 0f);
        translateAnimation.setDuration(1000); // Duración de la animación en ms

        // Animación de fade in
        AlphaAnimation fadeIn_img = new AlphaAnimation(0.0f, 1.0f);
        fadeIn_img.setDuration(3000); // Duración de la animación en ms

        // Ambas animaciones al conjunto
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(fadeIn);

        // Inicia la animación en el ImageView
        tuImageView.startAnimation(animationSet);

        return view;
    }

    private void mostrarDialogoSalir() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Estas apunto de salir de la aplicación");
        builder.setMessage("¿Estás seguro de que deseas salir?");
        builder.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Crear un Intent para iniciar la nueva Activity
                Intent intent = new Intent(getActivity(), MainActivity.class);
                // Iniciar la nueva Activity
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancelar", null);
        builder.show();
    }

    private void startCarousel() {
        runnable = new Runnable() {
            public void run() {
                if (currentPosition == images.length) {
                    currentPosition = 0;
                }

                // Actualiza la imagen y los textos
                imagenCarrusel.setImageResource(images[currentPosition]);
                textoCarruselTitulo.setText(titles[currentPosition]);
                textoCarruselDescripcion.setText(descriptions[currentPosition]);

                currentPosition++;

                // Repite la acción cada 7 milisegundos
                handler.postDelayed(this, 7000);
            }
        };

        // Inicia el carrusel automáticamente
        handler.postDelayed(runnable, 7000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Para el carrusel
        handler.removeCallbacks(runnable);
    }

    private void iniciarAnimacion() {
        // desplazamiento en píxeles
        int desplazamiento = 500;
        //Animación para el RelativeLayout
        ObjectAnimator animacionDesplazamiento = ObjectAnimator.ofFloat(animDesplazamiento, "translationX", -desplazamiento, 0);
        // Duración de la animación en milisegundos
        int duracionAnimacion = 2000;
        animacionDesplazamiento.setDuration(duracionAnimacion);
        // Interpolador para suavizar la animación
        animacionDesplazamiento.setInterpolator(new AccelerateDecelerateInterpolator());
        animacionDesplazamiento.start();
    }

}