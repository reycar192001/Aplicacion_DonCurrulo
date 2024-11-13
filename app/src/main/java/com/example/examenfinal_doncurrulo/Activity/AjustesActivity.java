package com.example.examenfinal_doncurrulo.Activity;

import static com.example.examenfinal_doncurrulo.R.id.cerrarsesion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.examenfinal_doncurrulo.R;

public class AjustesActivity extends AppCompatActivity {

    ConstraintLayout regreso;
    ConstraintLayout cerrarsesion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        bottomNavigation();
        regreso = findViewById(R.id.regreso);
        cerrarsesion = findViewById(R.id.cerrarsesion);

        regreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AjustesActivity.this,Pagina2.class));
            }
        });
        cerrarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AjustesActivity.this,LoginActivity.class));
            }
        });
    }

    public void Seleccion(View view){
        switch (view.getId()){
            case R.id.ajustes:
                Toast.makeText(this,"Session iniciada", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ventas:
                Toast.makeText(this,"Ventas realizadas: 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.informaciones:
                Toast.makeText(this,"Usuario: carlos@gmail.com", Toast.LENGTH_SHORT).show();
                break;
            case R.id.notificaciones:
                Toast.makeText(this,"0 notificaciones", Toast.LENGTH_SHORT).show();
                break;
            case R.id.auntenticacion:
                Toast.makeText(this,"Carlos Carrasco", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);
        LinearLayout nosotrosBtn = findViewById(R.id.nosotrosBtn);
        LinearLayout comentariosBtn = findViewById(R.id.comentBtn);
        LinearLayout ajustesBtn = findViewById(R.id.ajustesBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AjustesActivity.this,Pagina2.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AjustesActivity.this,CartActivity.class));
            }
        });

        nosotrosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AjustesActivity.this, NosotrosActivity.class));
            }
        });

        comentariosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AjustesActivity.this, ComentariosActivity.class));
            }
        });

        ajustesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AjustesActivity.this, AjustesActivity.class));
            }
        });
    }
}