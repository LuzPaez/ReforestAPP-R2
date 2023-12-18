package com.example.reforestapp_r2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.reforestapp_r2.databinding.ActivityBottomNavViewBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Bottom_nav_view extends AppCompatActivity {

    ActivityBottomNavViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBottomNavViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtener el fragment manager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Crear una instancia del fragment del principal
        Principal principal = new Principal();

        // Reemplazar el contenedor con el fragment del principal
        fragmentManager.beginTransaction().replace(R.id.framelayout_nav, principal).commit();

        // Obtener el bottom navigation view
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.BottomNav);

        // Establecer el id del elemento seleccionado por defecto
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        binding.BottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.navigation_opciones) {
                    Opciones opciones1 = new Opciones();
                    replaceFragment(opciones1);
                    Toast.makeText(Bottom_nav_view.this,"Estás en la vista de:  "+ item.getTitle(), Toast.LENGTH_SHORT).show();
                    return true;
                } else if (id == R.id.navigation_home) {
                    Principal principal = new Principal();
                    replaceFragment(principal);
                    Toast.makeText(Bottom_nav_view.this, "Estás en la vista de:  "+ item.getTitle(), Toast.LENGTH_SHORT).show();
                } else {
                    Configuracion configuracion = new Configuracion();
                    replaceFragment(configuracion);
                    Toast.makeText(Bottom_nav_view.this, "Estás en la vista de:  "+ item.getTitle(), Toast.LENGTH_SHORT).show();
                }

                return true;
            }

            public void replaceFragment(Fragment fragment) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framelayout_nav, fragment);
                fragmentTransaction.commit();
            }
        });
    }
}