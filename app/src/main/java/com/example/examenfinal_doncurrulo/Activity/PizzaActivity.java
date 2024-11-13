package com.example.examenfinal_doncurrulo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.examenfinal_doncurrulo.Adapter.PizzaAdapter;
import com.example.examenfinal_doncurrulo.Adapter.RecomendedAdapter;
import com.example.examenfinal_doncurrulo.Domain.FoodDomain;
import com.example.examenfinal_doncurrulo.R;

import java.util.ArrayList;

public class PizzaActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter3;
    private RecyclerView recyclerViewPizzaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        bottomNavigation();
        recyclerViewPizza();
        
    }

    private void recyclerViewPizza() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerViewPizzaList=findViewById(R.id.viewp);
        recyclerViewPizzaList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> pizzalist= new ArrayList<>();

        pizzalist.add(new FoodDomain("Pizza Hawaiana","pizza3","Salsa pomodoro, queso mozzarella fundido , jamón y piña",18.0,5,20,1000));
        pizzalist.add(new FoodDomain("Pizza Pepperoni","pizza5","Salsa, pepperoni americano y queso mozzarella.",16.0,5,20,1000));
        pizzalist.add(new FoodDomain("Pizza Chicken BBQ","pizza2","Queso mozzarella, Salsa barbacoa, Pollo a la parrilla, Tocino y Cebolla blanca.",36.0,5,20,1000));
        pizzalist.add(new FoodDomain("Pizza Super Suprema","pizza1","Pepperoni americano, carne de res, carne de cerdo, Jamón, salchicha italiana, champiñones, pimientos verdes, cebolla roja, aceitunas verdes y queso mozzarella.",32.0,8,20,1000));
        pizzalist.add(new FoodDomain("Pizza Vegetariana","pizza4","Champiñones, aceitunas verdes, pimientos verdes, cebolla roja y queso mozzarella.",34.0,5,20,1000));

        adapter3= new PizzaAdapter(pizzalist);
        recyclerViewPizzaList.setAdapter(adapter3);
    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);


        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PizzaActivity.this, Pagina2.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PizzaActivity.this,CartActivity.class));
            }
        });
    }
}