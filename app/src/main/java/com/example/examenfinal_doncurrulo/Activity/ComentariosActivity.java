package com.example.examenfinal_doncurrulo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.examenfinal_doncurrulo.Adapter.ComentAdapter;
import com.example.examenfinal_doncurrulo.Domain.ComentDomain;
import com.example.examenfinal_doncurrulo.R;

import java.util.ArrayList;

public class ComentariosActivity extends AppCompatActivity {

    private RecyclerView reciclerViewComentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios);

        recyclerViewComentarios();
        bottomNavigation();

    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);
        LinearLayout nosotrosBtn = findViewById(R.id.nosotrosBtn);
        LinearLayout comentariosBtn = findViewById(R.id.comentBtn);
        LinearLayout ajustesBtn = findViewById(R.id.ajustesBtn);

        comentariosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ComentariosActivity.this,ComentariosActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ComentariosActivity.this,CartActivity.class));
            }
        });

        nosotrosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ComentariosActivity.this, NosotrosActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ComentariosActivity.this, Pagina2.class));
            }
        });

        ajustesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ComentariosActivity.this, AjustesActivity.class));
            }
        });
    }

    private void recyclerViewComentarios() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        reciclerViewComentList=findViewById(R.id.view3);
        reciclerViewComentList.setLayoutManager(linearLayoutManager);

        ArrayList<ComentDomain> comentlist= new ArrayList<>();
        comentlist.add(new ComentDomain("Carlos Carrasco Borda", "user1", "¡Qué deliciosas hamburguesas! El pan estaba fresco y la carne estaba jugosa. Definitivamente volveré a este restaurante.", "14", 4.5f));
        comentlist.add(new ComentDomain("Joseph Falcon Sac", "user2", "El restaurante tiene un ambiente cálido y acogedor, y la parrilla es una de las mejores que he probado.", "15", 3.2f));
        comentlist.add(new ComentDomain("Rosmery Quintanilla Araujo", "user3", "Los cortes de carne eran tiernos y bien sazonados. ¡Muy recomendado!Este lugar", "16", 5.0f));
        comentlist.add(new ComentDomain("Flor Candia Ramirez", "user4", "El sabor de la carne a la parrilla es espectacular. Las porciones son generosas y el precio es razonable.", "17", 3.5f));
        comentlist.add(new ComentDomain("Alonso Vasquez Tapia", "user5", "Acabo de probar la hamburguesa de queso azul y fue increíble.Es el mejor lugar sin duda", "18", 5.0f));
        ComentAdapter adapter = new ComentAdapter(comentlist);
        reciclerViewComentList.setAdapter(adapter);
    }
}