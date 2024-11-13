package com.example.examenfinal_doncurrulo.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.examenfinal_doncurrulo.Adapter.CategoryAdapter;
import com.example.examenfinal_doncurrulo.Adapter.RecomendedAdapter;
import com.example.examenfinal_doncurrulo.Domain.CategoryDomain;
import com.example.examenfinal_doncurrulo.Domain.FoodDomain;
import com.example.examenfinal_doncurrulo.R;

import java.util.ArrayList;

public class Pagina2 extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private RecyclerView.Adapter adapter;
    RecomendedAdapter adapter2;
    private RecyclerView recyclerViewCategotyList,recyclerViewPopularList;
    private SearchView svSerach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina2);

        recyclerViewCategoty();
        recyclerViewPopular();
        bottomNavigation();

        svSerach= findViewById(R.id.svSerach);

        svSerach.setOnQueryTextListener(this);

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
                startActivity(new Intent(Pagina2.this,Pagina2.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Pagina2.this,CartActivity.class));
            }
        });

        nosotrosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Pagina2.this, NosotrosActivity.class));
            }
        });

        comentariosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Pagina2.this, ComentariosActivity.class));
            }
        });

        ajustesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Pagina2.this, AjustesActivity.class));
            }
        });
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList=findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist= new ArrayList<>();

        foodlist.add(new FoodDomain("Pizza Hawaiana","pizza3","Salsa pomodoro, queso mozzarella fundido , jamón y piña",18.0,5,20,1000));
        foodlist.add(new FoodDomain("Burger angus","burger6","Pura carne Angus  con huevo frito, salsa Benedict, queso cheddar, tocino, tomate y lechuga.",15.0,5,7,300));
        foodlist.add(new FoodDomain("Pizza Chicken BBQ","pizza2","Queso mozzarella, Salsa barbacoa, Pollo a la parrilla, Tocino y Cebolla blanca.",36.0,5,20,1000));
        foodlist.add(new FoodDomain("Bebida de limonada","bebida1","Tenemos personal y Jarra",7.0,5,7,30));
        foodlist.add(new FoodDomain("Parrilla Personal","parrillax","Carne,chorizo,2 brochetas de anticucho y 1 porcion de papas",32.0,5,7,300));
        foodlist.add(new FoodDomain("Pizza Super Suprema","pizza1","Pepperoni americano, carne de res, carne de cerdo, Jamón, salchicha italiana, champiñones, pimientos verdes, cebolla roja, aceitunas verdes y queso mozzarella.",32.0,8,20,1000));
        foodlist.add(new FoodDomain("Burger black","burger1","Pan al vapor con tinta de calamar, hamburguesa de entraña Angus, queso cheddar, kimchi y encurtido de kyuri.",15.0,5,7,300));
        foodlist.add(new FoodDomain("Bebida de Chicha","bebida2","Tenemos personal y Jarra",7.0,5,7,30));
        foodlist.add(new FoodDomain("Ensalada Griega","ensalada5","Lleva tomate, cebolla, pepino, pimiento, queso feta y aceitunas negras",28.0,5,7,30));
        foodlist.add(new FoodDomain("Burger kobe","burger5"," Molienda e Wagyu, alioli de Trufa, cheddar blanco y cebolla caramelizada.",15.0,5,7,300));
        foodlist.add(new FoodDomain("Pizza Vegetariana","pizza4","Champiñones, aceitunas verdes, pimientos verdes, cebolla roja y queso mozzarella.",34.0,5,20,1000));
        foodlist.add(new FoodDomain("Parrilla para Dos","parrillay","Carne, 2 chorizo ,4 brochetas de anticucho y 2 porcion de papas",39.0,5,7,300));
        foodlist.add(new FoodDomain("Ensalada Waldorf","ensalada4","Contiene manzana, nueces, apio, lechuga, pasas y mayonesa",23.0,5,7,30));
        foodlist.add(new FoodDomain("Burger surf","burger4",", carne Americana acompañada de langostino jumbo, champiñones, tocino y queso crema.",15.0,5,7,300));
        foodlist.add(new FoodDomain("Bebida Agua Mineral","bebida4","Solo Tenemos personal",3.0,5,7,0));
        foodlist.add(new FoodDomain("Ensalada Caprese","ensalada3","Mozzarella de bufala con el tomate fresco y jugoso y el aroma de las hojas de albahaca.",18.0,5,7,30));
        foodlist.add(new FoodDomain("Burger artesanal","burger3"," Queso, acompañada de tomate y lechuga.",15.0,5,7,300));
        foodlist.add(new FoodDomain("Pizza Pepperoni","pizza5","Salsa, pepperoni americano y queso mozzarella.",16.0,5,20,1000));
        foodlist.add(new FoodDomain("Bebida Coca Cola","bebida5","Solo Tenemos personal",4.5,5,7,30));
        foodlist.add(new FoodDomain("Parrilla para Cuatro","parrillaz","Carne,pollo, 4 chorizo ,8 brochetas de anticucho y 4 porcion de papas y ensalada",43.0,5,7,300));
        foodlist.add(new FoodDomain("Ensalada de Pasta","ensalada1","Zanahoria,Pastay Brocli",12.0,5,7,30));
        foodlist.add(new FoodDomain("Burger italiana","burger2"," Carne de res Angus, tomates, arúgula, queso gorgonzola, cebolla confitada.",15.0,5,7,300));
        foodlist.add(new FoodDomain("Ensalada Olivier","ensalada2","Patata, zanahoria, guisantes, atún, aceitunas y mayonesa o salsa rosa",26.0,5,7,30));
        foodlist.add(new FoodDomain("Bebida Inca kola","bebida6","Solo Tenemos personal",4.5,5,7,30));
        foodlist.add(new FoodDomain("Burger angus","burger6","Pura carne Angus  con huevo frito, salsa Benedict, queso cheddar, tocino, tomate y lechuga.",15.0,5,7,300));

        adapter2= new RecomendedAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategoty(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategotyList=findViewById(R.id.view1);
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza","cat_1"));
        categoryList.add(new CategoryDomain("Burger","cat_2"));
        categoryList.add(new CategoryDomain("Bebidas","cat_4"));
        categoryList.add(new CategoryDomain("Parrillas","cat_7"));
        categoryList.add(new CategoryDomain("Ensaladas","cat_6"));

        adapter = new CategoryAdapter(categoryList, new CategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(CategoryDomain item) {
                // Aquí puedes llamar a la actividad deseada, dependiendo del elemento del RecyclerView que se hizo clic
                if (item.getTitle().equals("Pizza")) {
                    Intent intent = new Intent(Pagina2.this, PizzaActivity.class);
                    startActivity(intent);
                } else if (item.getTitle().equals("Burger")) {
                    Intent intent = new Intent(Pagina2.this, BurgerActivity.class);
                    startActivity(intent);
                } else if (item.getTitle().equals("Bebidas")) {
                    Intent intent = new Intent(Pagina2.this, BebidasActivity.class);
                    startActivity(intent);
                } else if (item.getTitle().equals("Ensaladas")) {
                    Intent intent = new Intent(Pagina2.this, EnsaladasActivity.class);
                    startActivity(intent);
                } else if (item.getTitle().equals("Parrillas")) {
                    Intent intent = new Intent(Pagina2.this, ParrillasActivity.class);
                    startActivity(intent);
                }

                // y así sucesivamente para los demás elementos del RecyclerView
            }
        });
        recyclerViewCategotyList.setAdapter(adapter);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter2.filtrado(newText);
        return false;
    }
}