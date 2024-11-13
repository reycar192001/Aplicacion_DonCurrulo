package com.example.examenfinal_doncurrulo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.examenfinal_doncurrulo.Adapter.BebidasAdapter;
import com.example.examenfinal_doncurrulo.Adapter.PizzaAdapter;
import com.example.examenfinal_doncurrulo.Domain.FoodDomain;
import com.example.examenfinal_doncurrulo.R;

import java.util.ArrayList;

public class BebidasActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter7;
    private RecyclerView recyclerViewBebidaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);
        bottomNavigation();
        recyclerViewBebida();
    }

    private void recyclerViewBebida() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerViewBebidaList=findViewById(R.id.viewbe);
        recyclerViewBebidaList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> bebidaslist= new ArrayList<>();

        bebidaslist.add(new FoodDomain("Bebida de limonada","bebida1","Tenemos personal y Jarra",7.0,5,7,30));
        bebidaslist.add(new FoodDomain("Bebida de Chicha","bebida2","Tenemos personal y Jarra",7.0,5,7,30));
        bebidaslist.add(new FoodDomain("Bebida Agua Mineral","bebida4","Solo Tenemos personal",3.0,5,7,0));
        bebidaslist.add(new FoodDomain("Bebida Coca Cola","bebida5","Solo Tenemos personal",4.5,5,7,30));
        bebidaslist.add(new FoodDomain("Bebida Inca kola","bebida6","Solo Tenemos personal",4.5,5,7,30));

        adapter7= new BebidasAdapter(bebidaslist);
        recyclerViewBebidaList.setAdapter(adapter7);
    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);


        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BebidasActivity.this, Pagina2.class));
            }
        });
    }
}