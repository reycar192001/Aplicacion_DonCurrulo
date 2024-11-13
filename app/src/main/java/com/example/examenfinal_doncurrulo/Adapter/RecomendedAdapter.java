package com.example.examenfinal_doncurrulo.Adapter;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.examenfinal_doncurrulo.Activity.ShowDetailActivity;
import com.example.examenfinal_doncurrulo.Domain.FoodDomain;
import com.example.examenfinal_doncurrulo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecomendedAdapter extends RecyclerView.Adapter<RecomendedAdapter.ViewHolder> {
    ArrayList<FoodDomain> RecomendedDomains;
    ArrayList<FoodDomain> listaOriginal;
    private List<FoodDomain> foodlist;

    public RecomendedAdapter(ArrayList<FoodDomain> RecomendedDomains) {
        this.RecomendedDomains = RecomendedDomains;
        this.foodlist = new ArrayList<>();
        foodlist.addAll(RecomendedDomains);

        listaOriginal=new ArrayList<>();
        listaOriginal.addAll(RecomendedDomains);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_recomended,parent,false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(RecomendedDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(RecomendedDomains.get(position).getFee()));

        int drawableReourceId=holder.itemView.getContext().getResources()
                .getIdentifier(RecomendedDomains.get(position).getPic(),"drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.pic);

        holder.addBtn.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
            intent.putExtra("object", RecomendedDomains.get(position));
            holder.itemView.getContext().startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {return RecomendedDomains.size();}

    public void filtrado(String svSearch){
        if (svSearch.length() == 0) {
            RecomendedDomains.clear();
            RecomendedDomains.addAll(listaOriginal);

        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                RecomendedDomains.clear();
                List<FoodDomain> collecion = listaOriginal.stream()
                        .filter(i -> i.getTitle().toLowerCase().contains(svSearch.toLowerCase()))
                        .collect(Collectors.toList());


                RecomendedDomains.addAll(collecion);
            }else{
                RecomendedDomains.clear();
                for(FoodDomain c: listaOriginal){
                    if(c.getTitle().toLowerCase().contains(svSearch.toLowerCase())){
                        RecomendedDomains.add(c);
                    }

                }
            }
        }
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,fee;
        ImageView pic;
        ImageView addBtn;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title=itemView.findViewById(R.id.title);
            pic=itemView.findViewById(R.id.pic);
            fee=itemView.findViewById(R.id.fee);
            addBtn=itemView.findViewById(R.id.addBtn);
        }
    }
}