package com.example.examenfinal_doncurrulo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.examenfinal_doncurrulo.Adapter.BurgerAdapter;
import com.example.examenfinal_doncurrulo.Adapter.PizzaAdapter;
import com.example.examenfinal_doncurrulo.Domain.FoodDomain;
import com.example.examenfinal_doncurrulo.R;

import java.util.ArrayList;

public class BurgerActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter4;
    private RecyclerView recyclerViewBurgerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger);

        bottomNavigation();
        recyclerViewBurger();
    }

    private void recyclerViewBurger() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerViewBurgerList=findViewById(R.id.viewb);
        recyclerViewBurgerList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> burgerlist= new ArrayList<>();

        burgerlist.add(new FoodDomain("Burger angus","burger6","Pura carne Angus  con huevo frito, salsa Benedict, queso cheddar, tocino, tomate y lechuga.",15.0,5,7,300));
        burgerlist.add(new FoodDomain("Burger black","burger1","Pan al vapor con tinta de calamar, hamburguesa de entraña Angus, queso cheddar, kimchi y encurtido de kyuri.",15.0,5,7,400));
        burgerlist.add(new FoodDomain("Burger kobe","burger5"," Molienda e Wagyu, alioli de Trufa, cheddar blanco y cebolla caramelizada.",15.0,5,7,500));
        burgerlist.add(new FoodDomain("Burger surf","burger4",", Carne Americana acompañada de langostino jumbo, champiñones, tocino y queso crema.",15.0,5,7,600));
        burgerlist.add(new FoodDomain("Burger artesanal","burger3"," Queso, acompañada de tomate y lechuga.",15.0,5,7,300));
        burgerlist.add(new FoodDomain("Burger italiana","burger2"," Carne de res Angus, tomates, arúgula, queso gorgonzola, cebolla confitada.",15.0,5,7,500));

        adapter4= new BurgerAdapter(burgerlist);
        recyclerViewBurgerList.setAdapter(adapter4);

    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BurgerActivity.this, Pagina2.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BurgerActivity.this,CartActivity.class));
            }
        });
    }
}