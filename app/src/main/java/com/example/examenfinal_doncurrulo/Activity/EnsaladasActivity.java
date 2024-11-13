package com.example.examenfinal_doncurrulo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.examenfinal_doncurrulo.Adapter.EnsaladaAdapter;
import com.example.examenfinal_doncurrulo.Adapter.PizzaAdapter;
import com.example.examenfinal_doncurrulo.Domain.FoodDomain;
import com.example.examenfinal_doncurrulo.R;

import java.util.ArrayList;

public class EnsaladasActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter5;
    private RecyclerView recyclerViewEnsaladaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ensaladas);
        bottomNavigation();
        recyclerViewEnsalada();
    }

    private void recyclerViewEnsalada() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerViewEnsaladaList=findViewById(R.id.viewe);
        recyclerViewEnsaladaList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> ensaladalist= new ArrayList<>();

        ensaladalist.add(new FoodDomain("Ensalada Griega","ensalada5","Lleva tomate, cebolla, pepino, pimiento, queso feta y aceitunas negras",28.0,5,7,30));
        ensaladalist.add(new FoodDomain("Ensalada Waldorf","ensalada4","Contiene manzana, nueces, apio, lechuga, pasas y mayonesa",23.0,5,7,40));
        ensaladalist.add(new FoodDomain("Ensalada Caprese","ensalada3","Mozzarella de bufala con el tomate fresco y jugoso y el aroma de las hojas de albahaca.",18.0,5,7,50));
        ensaladalist.add(new FoodDomain("Ensalada de Pasta","ensalada1","Zanahoria,Pastay Brocli",12.0,5,7,60));
        ensaladalist.add(new FoodDomain("Ensalada Olivier","ensalada2","Patata, zanahoria, guisantes, atún, aceitunas y mayonesa o salsa rosa",26.0,5,7,70));

        adapter5= new EnsaladaAdapter(ensaladalist);
        recyclerViewEnsaladaList.setAdapter(adapter5);
    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);


        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EnsaladasActivity.this, Pagina2.class));
            }
        });
    }
}