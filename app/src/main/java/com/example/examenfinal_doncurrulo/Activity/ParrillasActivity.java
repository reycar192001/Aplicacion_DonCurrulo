package com.example.examenfinal_doncurrulo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.examenfinal_doncurrulo.Adapter.ParrillasAdapter;
import com.example.examenfinal_doncurrulo.Domain.FoodDomain;
import com.example.examenfinal_doncurrulo.R;

import java.util.ArrayList;

public class ParrillasActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter6;
    private RecyclerView recyclerViewParrillaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parrillas);
        bottomNavigation();
        recyclerViewParrilla();
    }

    private void recyclerViewParrilla() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerViewParrillaList=findViewById(R.id.viewpa);
        recyclerViewParrillaList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> parrillalist= new ArrayList<>();

        parrillalist.add(new FoodDomain("Parrilla Personal","parrillax","Carne,chorizo,2 brochetas de anticucho y 1 porcion de papas",32.0,5,17,900));
        parrillalist.add(new FoodDomain("Parrilla para Dos","parrillay","Carne, 2 chorizo ,4 brochetas de anticucho y 2 porcion de papas",39.0,5,17,800));
        parrillalist.add(new FoodDomain("Parrilla para Cuatro","parrillaz","Carne,pollo, 4 chorizo ,8 brochetas de anticucho y 4 porcion de papas y ensalada",43.0,5,27,700));
        parrillalist.add(new FoodDomain("Parrilla Mixta","parrilla","Lomo de res, filete de pollo bbq, lomo fino de cerdo. AcompaÃ±ado con chistorra, papas fritas y ensalada.",25.0,5,17,600));
        parrillalist.add(new FoodDomain("Parrilla Barbacoa","parrillac","Lomo de res, filete de pollo bbq, lomo fino de cerdo.",33.0,5,17,500));
        adapter6= new ParrillasAdapter(parrillalist);
        recyclerViewParrillaList.setAdapter(adapter6);
    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);


        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ParrillasActivity.this, Pagina2.class));
            }
        });
    }
}